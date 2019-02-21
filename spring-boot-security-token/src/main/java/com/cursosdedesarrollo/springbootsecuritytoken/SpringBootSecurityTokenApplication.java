package com.cursosdedesarrollo.springbootsecuritytoken;

import com.cursosdedesarrollo.springbootsecuritytoken.security.*;
import org.apache.catalina.mbeans.RoleMBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityTokenApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserRepository userRepository, RoleRepository roleRepository) {
        return (args) -> {
            roleRepository.save(new Role(RoleName.ROLE_USER));
            roleRepository.save(new Role(RoleName.ROLE_ADMIN));
            roleRepository.save(new Role(RoleName.ROLE_PM));
            User adminUser= new User("admin","admin","admin@local","admin1234");
            List<Role> listRoles= roleRepository.findAll();
            Set<Role> setRoles=new HashSet<Role>();
            for (Role role:listRoles){
                if (role.getName().equals(RoleName.ROLE_ADMIN) || role.getName().equals(RoleName.ROLE_USER)){
                    setRoles.add(role);
                }
            }
            adminUser.setRoles(setRoles);
            userRepository.save(adminUser);
            System.out.println(userRepository.findAll());
            System.out.println(userRepository.findByUsername("admin"));
        };
    }
}

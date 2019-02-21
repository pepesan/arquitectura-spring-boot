package com.cursosdedesarrollo.apitoken;

import com.cursosdedesarrollo.apitoken.model.Role;
import com.cursosdedesarrollo.apitoken.model.RoleName;
import com.cursosdedesarrollo.apitoken.repository.RoleRepository;
import com.cursosdedesarrollo.apitoken.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJwtAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthenticationApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, RoleRepository roleRepository) {
		return (args) -> {
			roleRepository.save(new Role(RoleName.ROLE_USER));
			roleRepository.save(new Role(RoleName.ROLE_ADMIN));
			roleRepository.save(new Role(RoleName.ROLE_PM));
		};
	}
}

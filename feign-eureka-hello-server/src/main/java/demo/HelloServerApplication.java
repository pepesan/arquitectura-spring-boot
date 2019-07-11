package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloServerApplication {
	@Autowired
	DiscoveryClient client;

	@RequestMapping("/")
	public String hello() {
		List<String> localInstance = client.getServices();
		// listado de servicios activos
		StringBuffer sb= new StringBuffer();
		for (String s: localInstance) {
			sb.append(s+":");

		}
		//return sb.toString();
		List<ServiceInstance> instancias = client.getInstances("helloserver");
		for (ServiceInstance i: instancias) {
			System.out.println(i.getInstanceId());
			System.out.println(i.getHost());
			System.out.println(i.getServiceId());
		}

		return sb.toString();
		//return client.getInstances("helloserver").toString();
		//return "Hello World: "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloServerApplication.class, args);
	}
}

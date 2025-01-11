package tn.iit.micro.service.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("tn.iit.micro.service.student.proxy")
public class StudentServiceApplication {

	private String adressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class);
		System.out.println("Student server started successfully!");
	}

}

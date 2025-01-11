package tn.iit.micro.service.student.proxy;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

@LoadBalancerClient(value = "address-service", configuration = CustomLoadBalancerConfiguration.class)
public class AdrSerLoadBalConfig {
	@LoadBalanced
	@Bean
	Feign.Builder feignBuilder() {
		return Feign.builder();
	}
}
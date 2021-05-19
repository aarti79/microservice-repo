package com.example.client2;

import java.net.URI;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ClientApplication {
	
	//private static Logger log = LoggerFactory.getLogger(ClientApplication.class);
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
	return new RestTemplate();
	}

	 @Autowired
	private LoadBalancerClient loadBalancer;

	 @RequestMapping("/clients")
	public ResponseEntity<?> client() {
	ServiceInstance serviceInstance = loadBalancer.choose("Eureka-client1");
	URI uri = serviceInstance.getUri();
	String message = restTemplate.getForObject(uri + "/client1", String.class);
	//log.info("GET /Client2/");
	return new ResponseEntity<String>(message, HttpStatus.OK);

	 }


}

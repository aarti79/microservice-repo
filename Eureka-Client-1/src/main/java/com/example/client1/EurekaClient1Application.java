package com.example.client1;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClient1Application {

	//private static Logger log = LoggerFactory.getLogger(EurekaClient1Application.class);
	public static void main(String[] args) {
		SpringApplication.run(EurekaClient1Application.class, args);
	}
	@RequestMapping("/client1")
	public String client1() {
		//log.info("GET /Client1/");
		return "client-1 called from client";
	}

}

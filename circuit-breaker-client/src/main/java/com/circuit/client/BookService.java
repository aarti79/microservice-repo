package com.circuit.client;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class BookService {

	private final RestTemplate restTemplate;

	public BookService(RestTemplate rest) {
		this.restTemplate = rest;
	}

	// @HystrixCommand(fallbackMethod = "reliable")
	@HystrixCommand(fallbackMethod = "reliable", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2") })

	public String readingList() {
		URI uri = URI.create("http://localhost:8090/recommended");

		return this.restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		return "Cloud Native Java (O'Reilly)";
	}

}
/*
@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50"),
@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),
@HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "20000"),
@HystrixProperty(name = "metrics.rollingPercentile.timeInMilliseconds", value = "20000"),
@HystrixProperty(name = "metrics.healthSnapshot.intervalInMilliseconds", value = "5000"),
@HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "100")
},
threadPoolProperties = {
@HystrixProperty(name = "coreSize", value = "30"),
@HystrixProperty(name = "maxQueueSize", value = "-1"),
}
)*/
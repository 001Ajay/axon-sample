package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class DiscoveryClientSample implements CommandLineRunner {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public void run(String... strings) throws Exception {
		// print the Discovery Client Description
		System.out.println(discoveryClient.description());
		// Get restaurant-service instances and prints its info
		discoveryClient.getInstances("SAMPLE-CONFIG-CLIENT").forEach((ServiceInstance serviceInstance) -> {
			System.out.println(
					new StringBuilder("Instance --> ").append(serviceInstance.getServiceId()).append("\nServer: ")
							.append(serviceInstance.getHost()).append(":").append(serviceInstance.getPort())
							.append("\nURI: ").append(serviceInstance.getUri()).append("\n\n\n"));
		});
	}
}

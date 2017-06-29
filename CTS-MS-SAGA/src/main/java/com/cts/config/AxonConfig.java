package com.cts.config;

import org.axonframework.serialization.json.JacksonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
	
	
	
	@Bean(name="eventSerializer")
	public JacksonSerializer eventSerializer()
	{
		return new JacksonSerializer();
	}
	
}

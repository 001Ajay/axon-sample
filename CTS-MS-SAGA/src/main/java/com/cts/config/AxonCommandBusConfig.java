package com.cts.config;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.serialization.xml.XStreamSerializer;
import org.axonframework.spring.commandhandling.gateway.CommandGatewayFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonCommandBusConfig {

	@Autowired
	@Qualifier("distributedCommandBus")
	private CommandBus distributedCommandBus;
	

	
	@Bean(name="serializer")
	public XStreamSerializer serializer()
	{
		return new XStreamSerializer();
	}
	
	@Bean("commandGateway")
	public CommandGatewayFactoryBean commandGateway(){
		
		CommandGatewayFactoryBean commandGatewayFactoryBean=new CommandGatewayFactoryBean<>();
		commandGatewayFactoryBean.setCommandBus(distributedCommandBus);
		return new CommandGatewayFactoryBean();
	}
	
	
}

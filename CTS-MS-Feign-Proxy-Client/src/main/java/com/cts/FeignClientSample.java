package com.cts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Component;

import com.cts.bo.TestBO;
import com.cts.proxy.ITestProxy;
import com.netflix.hystrix.exception.HystrixRuntimeException;

import feign.FeignException;

@EnableFeignClients
@Component
public class FeignClientSample implements CommandLineRunner {

	@Autowired
	private ITestProxy testProxy;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------------------------------------");
		try{
		System.out.println(testProxy.showName().getStatusCodeValue());

		System.out.println(((TestBO) testProxy.showName().getBody()).getGreetings());
		}
		catch(HystrixRuntimeException  ex){
			
			ex.printStackTrace();
		}

		System.out.println("---------------------------------------------");

	}

}

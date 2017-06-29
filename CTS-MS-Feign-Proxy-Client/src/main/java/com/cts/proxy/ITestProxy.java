package com.cts.proxy;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.bo.TestBO;

@FeignClient("SAMPLE-CONFIG-CLIENT")
public interface ITestProxy {

	@RequestMapping(value = "/test/showname", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<TestBO> showName();

}

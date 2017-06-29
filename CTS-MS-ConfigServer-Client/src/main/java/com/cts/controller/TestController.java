package com.cts.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bo.ExceptionBO;
import com.cts.bo.TestBO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RefreshScope
@RestController
@RequestMapping("/test")
@Api(value = "APITest", description = "Operations pertaining to Online Store")
public class TestController {

	@Value("${test-word}")
	private String testName;

	@CrossOrigin
	@ApiOperation(value = "View Something the Specific info of the product", response = TestBO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Name Fetched Successfully", response = TestBO.class),
			@ApiResponse(code = 500, message = "Error Fetching", response = ExceptionBO.class) })
	@RequestMapping(value = "/showname", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> showName() {
		TestBO test = new TestBO();
		test.setId(UUID.randomUUID().toString());
		test.setName(testName);
		return new ResponseEntity<TestBO>(test, HttpStatus.OK);
	}

	@CrossOrigin
	@ApiOperation(value = "View Error Response", response = TestBO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Name Fetched Successfully", response = TestBO.class),
			@ApiResponse(code = 500, message = "Error Fetching", response = ExceptionBO.class) })
	@RequestMapping(value = "/showerror", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> showError() {

		int i = 1 / 0;
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
	
	@CrossOrigin
	@ApiOperation(value = "A very slow service", response = TestBO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Name Fetched Successfully", response = TestBO.class),
			@ApiResponse(code = 500, message = "Error Fetching", response = ExceptionBO.class) })
	@RequestMapping(value = "/slow", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> slowService() throws InterruptedException {
		Thread.sleep(80000);
		return new ResponseEntity<Object>("timeout", HttpStatus.OK);
	}
}

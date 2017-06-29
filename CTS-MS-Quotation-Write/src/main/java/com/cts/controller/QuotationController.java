package com.cts.controller;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bo.QuotaionBO;
import com.cts.command.CreateQuotationCommand;

@RestController
public class QuotationController {

	@Autowired
	private CommandGateway commandGateway;

	@PostMapping(value = "/quotation", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public CompletableFuture<Object> InsertQuotation(@RequestBody QuotaionBO quotation) {
        quotation.setId(UUID.randomUUID().toString());
		return commandGateway.send(new CreateQuotationCommand(quotation));

	}

}

package com.cts.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bo.ReservationBO;
import com.cts.command.ReserveCommand;

@RestController
public class ReservationController {

	@Autowired	
	private CommandGateway commandGateway;

	@PostMapping(value = "/reserve", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public CompletableFuture<Object> reserve(@RequestBody ReservationBO reservation) {
		reservation.setIternaryId(UUID.randomUUID().toString());
		ReserveCommand reserveCommand = new ReserveCommand();
		reserveCommand.setReservationBO(reservation);
		
		return commandGateway.send(reserveCommand);
	}
	
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public CompletableFuture<Object> start() {
		ReservationBO reservation = new ReservationBO();
		reservation.setName("ajay");
		reservation.setTo("kolkata");
		reservation.setForm("bombay");
		reservation.setIternaryId(UUID.randomUUID().toString());
		ReserveCommand reserveCommand = new ReserveCommand();
		reserveCommand.setReservationBO(reservation);
		
		return commandGateway.send(reserveCommand);
	}

	@RequestMapping(value="/check", method=RequestMethod.GET)
	public String check(){
		System.out.println("check check...");
		return "Hello testing 123...";
	}
}

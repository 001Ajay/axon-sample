package com.cts.saga;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.saga.EndSaga;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cts.bo.CABReservationBO;
import com.cts.bo.FlightReservationBO;
import com.cts.bo.HotelReservationBO;
import com.cts.command.CABBookOrCancelCommand;
import com.cts.command.FlightBookOrCancelCommand;
import com.cts.command.HotelBookOrCancelCommand;
import com.cts.event.CABReservationDoneEvent;
import com.cts.event.FlightReservationDoneEvent;
import com.cts.event.HotelReservationDoneEvent;
import com.cts.event.ReservationEvent;

@ProcessingGroup("ReservationSAGA")
@Saga
public class ReservationSAGA {

	@Autowired
	private transient CommandGateway commandGateway;

	private String iternaryId;
	

	@StartSaga
	@SagaEventHandler(associationProperty = "iternaryId")
	public void on(ReservationEvent event) {
		System.out.println("Start Saga..");
		this.iternaryId = event.getResevationBO().getIternaryId();
		// First Reserve The Flight
		FlightBookOrCancelCommand flight_command = new FlightBookOrCancelCommand();
		flight_command.setIsBook(true);
		FlightReservationBO flightReservationBO = new FlightReservationBO();
		BeanUtils.copyProperties(event.getResevationBO(), flightReservationBO);
		flightReservationBO.setFlightNumber("PHOENIX-714");
		flightReservationBO.setFlightBookingReferenceNumber(UUID.randomUUID().toString());
		flight_command.setReservationBO(flightReservationBO);
		flight_command.setFlightBookingReferenceNumber(flightReservationBO.getFlightBookingReferenceNumber());
		commandGateway.send(flight_command);
	}
	
	@SagaEventHandler(associationProperty = "iternaryId")
	public void on(FlightReservationDoneEvent event) {
		// Now book hotel
		HotelBookOrCancelCommand hotel_command = new HotelBookOrCancelCommand();
		hotel_command.setIsBook(true);
		HotelReservationBO hotelReservationBO = new HotelReservationBO();
		BeanUtils.copyProperties(event.getReservationBO(), hotelReservationBO);
		hotelReservationBO.setReservationId(UUID.randomUUID().toString());
		hotelReservationBO.setHotelName("HYATT");		
		hotel_command.setReservationBO(hotelReservationBO);
		hotel_command.setHotelBookingReferenceNumber(hotelReservationBO.getReservationId());
		commandGateway.send(hotel_command);
	}
	
	@SagaEventHandler(associationProperty = "iternaryId")
	public void on(HotelReservationDoneEvent event) {		
		// Now book CAB
		CABBookOrCancelCommand cab_command = new CABBookOrCancelCommand();
		cab_command.setIsBook(true);
		CABReservationBO cabReservationBO = new CABReservationBO();
		BeanUtils.copyProperties(event.getReservationBO(), cabReservationBO);
		cabReservationBO.setReservationId(UUID.randomUUID().toString());
		cabReservationBO.setCabNumber("VIPER-007");		
		cabReservationBO.setDriverName("Pierce Brosnan");
		cab_command.setReservationBO(cabReservationBO);
		cab_command.setCabBookingReferenceNumber(cabReservationBO.getReservationId());
		commandGateway.send(cab_command);
	}
	
	@EndSaga
	@SagaEventHandler(associationProperty = "iternaryId")
	public void on(CABReservationDoneEvent event) {
		
	}

}

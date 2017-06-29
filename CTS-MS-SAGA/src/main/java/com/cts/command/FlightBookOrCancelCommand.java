package com.cts.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.cts.bo.ReservationBO;

public class FlightBookOrCancelCommand {
	@TargetAggregateIdentifier
	private String flightBookingReferenceNumber;
	
private ReservationBO reservationBO;
	
	private Boolean isBook=true;


	public String getFlightBookingReferenceNumber() {
		return flightBookingReferenceNumber;
	}

	public void setFlightBookingReferenceNumber(String flightBookingReferenceNumber) {
		this.flightBookingReferenceNumber = flightBookingReferenceNumber;
	}

	public ReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(ReservationBO reservationBO) {
		this.reservationBO = reservationBO;
	}

	public Boolean getIsBook() {
		return isBook;
	}

	public void setIsBook(Boolean isBook) {
		this.isBook = isBook;
	}
	
	
	
}

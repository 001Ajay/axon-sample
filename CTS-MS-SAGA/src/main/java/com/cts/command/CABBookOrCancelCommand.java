package com.cts.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.cts.bo.ReservationBO;

public class CABBookOrCancelCommand  {
	@TargetAggregateIdentifier
	private String cabBookingReferenceNumber;
	

	private ReservationBO reservationBO;
	
	private Boolean isBook=true;

	public String getCabBookingReferenceNumber() {
		return cabBookingReferenceNumber;
	}

	public void setCabBookingReferenceNumber(String cabBookingReferenceNumber) {
		this.cabBookingReferenceNumber = cabBookingReferenceNumber;
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

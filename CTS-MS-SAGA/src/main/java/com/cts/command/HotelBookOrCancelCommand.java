package com.cts.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.cts.bo.ReservationBO;

public class HotelBookOrCancelCommand {
	@TargetAggregateIdentifier
	private String hotelBookingReferenceNumber;

	private ReservationBO reservationBO;

	private Boolean isBook = true;

	public String getHotelBookingReferenceNumber() {
		return hotelBookingReferenceNumber;
	}

	public void setHotelBookingReferenceNumber(String hotelBookingReferenceNumber) {
		this.hotelBookingReferenceNumber = hotelBookingReferenceNumber;
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

package com.cts.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import com.cts.bo.ReservationBO;



public class ReserveCommand {
	
	@TargetAggregateIdentifier
	private String iternaryId;
	
	private ReservationBO reservationBO;

	public ReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(ReservationBO reservationBO) {
		this.reservationBO = reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
	}

	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}
	
	
	
	

}

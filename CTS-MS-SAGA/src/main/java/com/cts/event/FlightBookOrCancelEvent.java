package com.cts.event;

import com.cts.bo.FlightReservationBO;


public class FlightBookOrCancelEvent {

	
	private FlightReservationBO reservationBO;
	private String iternaryId;
	
	public FlightBookOrCancelEvent(FlightReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
	}
	
	public FlightBookOrCancelEvent(){
	}

	public FlightReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(FlightReservationBO reservationBO) {
		this.reservationBO = reservationBO;
	}

	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}
     
	
}

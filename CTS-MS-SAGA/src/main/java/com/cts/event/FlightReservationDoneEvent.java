package com.cts.event;

import com.cts.bo.FlightReservationBO;


public class FlightReservationDoneEvent {

	private FlightReservationBO reservationBO;
	private String iternaryId;
	
	public FlightReservationDoneEvent(FlightReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
	}
	
	public FlightReservationDoneEvent(){
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

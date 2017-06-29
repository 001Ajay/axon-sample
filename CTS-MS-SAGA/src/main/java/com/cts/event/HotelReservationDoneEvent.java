package com.cts.event;

import com.cts.bo.HotelReservationBO;


public class HotelReservationDoneEvent {

	private HotelReservationBO reservationBO;
	private String iternaryId;
	
	public HotelReservationDoneEvent(HotelReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
	}
	
	public HotelReservationDoneEvent(){
    }

	public HotelReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(HotelReservationBO reservationBO) {
		this.reservationBO = reservationBO;
	}

	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}
     
	

}

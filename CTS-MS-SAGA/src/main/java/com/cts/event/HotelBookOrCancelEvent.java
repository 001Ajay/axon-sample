package com.cts.event;

import com.cts.bo.HotelReservationBO;


public class HotelBookOrCancelEvent  {

	private HotelReservationBO reservationBO;
	private String iternaryId;
	
	public HotelBookOrCancelEvent(HotelReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
	}
	
	public HotelBookOrCancelEvent(){
    	
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

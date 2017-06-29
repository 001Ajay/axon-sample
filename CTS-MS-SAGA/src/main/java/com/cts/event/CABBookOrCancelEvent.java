package com.cts.event;

import com.cts.bo.CABReservationBO;


public class CABBookOrCancelEvent{

	private CABReservationBO reservationBO;
	private String iternaryId;
	
	public CABBookOrCancelEvent(CABReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
	}
	
    public CABBookOrCancelEvent(){
    }

	public CABReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(CABReservationBO reservationBO) {
		this.reservationBO = reservationBO;
	}

	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}
    
    
    

}

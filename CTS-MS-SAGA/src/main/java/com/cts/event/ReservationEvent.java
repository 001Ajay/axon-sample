package com.cts.event;

import com.cts.bo.ReservationBO;


public class ReservationEvent {
	
	private String iternaryId;
	
	private ReservationBO resevationBO;

	public ReservationBO getResevationBO() {
		return resevationBO;
	}

	public void setResevationBO(ReservationBO resevationBO) {
		this.resevationBO = resevationBO;
	}

	public ReservationEvent(ReservationBO resevationBO) {
		super();
		this.resevationBO = resevationBO;
		this.iternaryId=resevationBO.getIternaryId();
	}
	
	
	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}

	public ReservationEvent(){
		
	}
}

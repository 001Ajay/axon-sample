package com.cts.bo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CABReservationBO extends ReservationBO {
	
	private String cabNumber;
	private  String driverName;
	private String reservationId;
	public String getCabNumber() {
		return cabNumber;
	}
	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	
	

}

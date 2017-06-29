package com.cts.bo;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HotelReservationBO extends ReservationBO {
	
	private String hotelName;
	private String reservationId;
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	
	

}

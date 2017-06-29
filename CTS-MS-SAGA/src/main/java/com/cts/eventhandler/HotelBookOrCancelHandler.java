package com.cts.eventhandler;

import org.apache.log4j.Logger;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.cts.bo.HotelReservationBO;
import com.cts.event.HotelBookOrCancelEvent;

@ProcessingGroup("HotelBookOrCancel")
@Component("springManagedHotelBookOrCancelHandler")
public class HotelBookOrCancelHandler {
	private static Logger log = Logger.getLogger(HotelBookOrCancelHandler.class);
	@EventHandler
	public void on(HotelBookOrCancelEvent item) {
		HotelReservationBO hotelReservationBO = (HotelReservationBO) item.getReservationBO();
		log.info("The Hotel Is Booked: " + hotelReservationBO);
	}

}

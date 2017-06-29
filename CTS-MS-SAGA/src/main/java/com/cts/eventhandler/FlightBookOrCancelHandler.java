package com.cts.eventhandler;

import org.apache.log4j.Logger;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.cts.bo.FlightReservationBO;
import com.cts.event.FlightBookOrCancelEvent;

@ProcessingGroup("FlightBookOrCancel")
@Component("springManagedFlightBookOrCancelHandler")
public class FlightBookOrCancelHandler {
	private static Logger log = Logger.getLogger(FlightBookOrCancelHandler.class);
	@EventHandler
	public void on(FlightBookOrCancelEvent item) {
		FlightReservationBO flightReservationBO = (FlightReservationBO) item.getReservationBO();
		log.info("The Flight Is Booked: " + flightReservationBO);
	}

}

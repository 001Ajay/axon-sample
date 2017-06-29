package com.cts.eventhandler;

import org.apache.log4j.Logger;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.cts.bo.CABReservationBO;
import com.cts.event.CABBookOrCancelEvent;



@ProcessingGroup("CABBookOrCancel")
@Component("springManagedCABBookOrCancelHandler")
public class CABBookOrCancelHandler {
	
	private static Logger log = Logger.getLogger(CABBookOrCancelHandler.class);

	@EventHandler
	public void on(CABBookOrCancelEvent item) {
		CABReservationBO cabReservationBO = (CABReservationBO) item.getReservationBO();
		log.info("The CAB Is Booked: " + cabReservationBO);
	}

}

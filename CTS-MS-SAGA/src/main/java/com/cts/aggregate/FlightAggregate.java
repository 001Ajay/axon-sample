package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.bo.FlightReservationBO;
import com.cts.command.FlightBookOrCancelCommand;
import com.cts.event.FlightBookOrCancelEvent;
import com.cts.event.FlightReservationDoneEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class FlightAggregate {

	@AggregateIdentifier
	private String flightBookingReferenceNumber;

	@CommandHandler
	public FlightAggregate(FlightBookOrCancelCommand command) {
		apply(new FlightBookOrCancelEvent((FlightReservationBO)command.getReservationBO()));
		apply(new FlightReservationDoneEvent((FlightReservationBO)command.getReservationBO()));// Notify
																			// the
																			// saga
																			// to
																			// move
																			// ahead
	}

	@EventSourcingHandler
	protected void on(FlightBookOrCancelEvent event) {
		try{
			@SuppressWarnings("unused")
			String test=new ObjectMapper().writeValueAsString(event);
			}
			catch(Exception ex){
				
			}
		this.flightBookingReferenceNumber = ((FlightReservationBO) event.getReservationBO())
				.getFlightBookingReferenceNumber();
		

	}

	@EventSourcingHandler
	protected void on(FlightReservationDoneEvent event) {
		try{
		@SuppressWarnings("unused")
		String test=new ObjectMapper().writeValueAsString(event);
		}
		catch(Exception ex){
			
		}
		this.flightBookingReferenceNumber = event.getReservationBO().getFlightBookingReferenceNumber();

	}

}

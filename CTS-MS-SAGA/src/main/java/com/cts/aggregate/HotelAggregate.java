package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.bo.HotelReservationBO;
import com.cts.command.HotelBookOrCancelCommand;
import com.cts.event.HotelBookOrCancelEvent;
import com.cts.event.HotelReservationDoneEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class HotelAggregate {

	@AggregateIdentifier
	private String hotelBookingReferenceNumber;

	@CommandHandler
	public HotelAggregate(HotelBookOrCancelCommand command) {
		apply(new HotelBookOrCancelEvent((HotelReservationBO)command.getReservationBO()));
		apply(new HotelReservationDoneEvent((HotelReservationBO)command.getReservationBO()));// Notify
																			// the
																			// saga
																			// to
																			// move
																			// ahead
	}

	@EventSourcingHandler
	protected void on(HotelBookOrCancelEvent event) {
		this.hotelBookingReferenceNumber = ((HotelReservationBO) event.getReservationBO())
				.getReservationId();

	}

	@EventSourcingHandler
	protected void on(HotelReservationDoneEvent event) {
		this.hotelBookingReferenceNumber = event.getReservationBO().getReservationId();

	}

}

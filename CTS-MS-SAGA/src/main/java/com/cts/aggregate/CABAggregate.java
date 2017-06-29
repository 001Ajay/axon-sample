package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.bo.CABReservationBO;
import com.cts.command.CABBookOrCancelCommand;
import com.cts.event.CABBookOrCancelEvent;
import com.cts.event.CABReservationDoneEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class CABAggregate {
	
	@AggregateIdentifier
	private String cabBookingReferenceNumber;
	
	@CommandHandler
	public CABAggregate(CABBookOrCancelCommand command) {
		apply(new CABBookOrCancelEvent((CABReservationBO)command.getReservationBO()));
		apply(new CABReservationDoneEvent((CABReservationBO)command.getReservationBO()));// Notify
																			// the
																			// saga
																			// to
																			// move
																			// ahead
	}

	@EventSourcingHandler
	protected void on(CABBookOrCancelEvent event) {
		this.cabBookingReferenceNumber = ((CABReservationBO) event.getReservationBO())
				.getReservationId();

	}

	@EventSourcingHandler
	protected void on(CABReservationDoneEvent event) {
		this.cabBookingReferenceNumber = event.getReservationBO().getReservationId();

	}

}

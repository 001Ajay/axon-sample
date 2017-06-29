package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.command.ReserveCommand;
import com.cts.event.ReservationEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class ReservationAggregate {

	@AggregateIdentifier
	private String iternaryId;

	@CommandHandler
	public ReservationAggregate(ReserveCommand reserveCommand) {
		apply(new ReservationEvent(reserveCommand.getReservationBO()));
	}

	@EventSourcingHandler
	protected void on(ReservationEvent event) {
		this.iternaryId = event.getResevationBO().getIternaryId();
	}

}

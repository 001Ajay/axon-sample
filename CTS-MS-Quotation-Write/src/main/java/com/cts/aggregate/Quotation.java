package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.command.CreateQuotationCommand;
import com.cts.event.CreateQuotationEvent;

@Aggregate
public class Quotation {

	@AggregateIdentifier
	private String quotationId;

	public Quotation() {

	}

	@CommandHandler
	public Quotation(CreateQuotationCommand createQuotationCommand) {
		// quotationId=createQuotationCommand.getQuotaionBO().getId();
		apply(new CreateQuotationEvent(createQuotationCommand.getQuotaionBO()));
	}

	@EventSourcingHandler
	protected void on(CreateQuotationEvent event) {
		this.quotationId = event.getQuotaionBO().getId();
	}

}

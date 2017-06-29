package com.cts.eventhandler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cts.dto.QuotationDTO;
import com.cts.event.CreateQuotationEvent;
import com.cts.jpa.repo.QuotationRepository;

@ProcessingGroup("CreateQuotation")
@Component("springManagedCreateQuotationEventHandler")
public class CreateQuotationEventHandler {

	@Autowired
	@Qualifier(value = "springManagedQuotationRepository")
	private QuotationRepository quotationRepository;

	/*@EventHandler
	public void on(CreateQuotationEvent event) {
		quotationRepository.save(new QuotationDTO(event.getQuotaionBO().getId(), event.getQuotaionBO().getPolicyType(),
				event.getQuotaionBO().getProductType(), event.getQuotaionBO().getPlanCode()));

	}*/
	
	@EventHandler
	public void on(Object item) {
		CreateQuotationEvent event=(CreateQuotationEvent)item;
		quotationRepository.save(new QuotationDTO(event.getQuotaionBO().getId(), event.getQuotaionBO().getPolicyType(),
				event.getQuotaionBO().getProductType(), event.getQuotaionBO().getPlanCode()));

	}

}

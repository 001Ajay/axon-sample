package com.cts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bo.QuotaionBO;
import com.cts.dto.QuotationDTO;
import com.cts.jpa.repo.QuotationRepository;

@RestController
public class QuotationReadController {

	@Autowired
	@Qualifier(value = "springManagedQuotationRepository")
	private QuotationRepository quotationRepository;

	@GetMapping(path = "/quote")
	public List<QuotaionBO> getQuotations() {
		ArrayList<QuotaionBO> quotations = new ArrayList<>();
		quotationRepository.findAll().forEach(item -> {
			quotations
					.add(new QuotaionBO(item.getId(), item.getPolicyType(), item.getProductType(), item.getPlanCode()));
		});

		return quotations;
	}

	@GetMapping(path = "/quote/{id}")
	public QuotaionBO getQuotation(@PathVariable String id) {
		QuotationDTO item = quotationRepository.findOne(id);
		if (item != null)
			return new QuotaionBO(item.getId(), item.getPolicyType(), item.getProductType(), item.getPlanCode());
		else
			return null;
	}

}

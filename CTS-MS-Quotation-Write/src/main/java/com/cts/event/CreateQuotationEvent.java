package com.cts.event;

import com.cts.bo.QuotaionBO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateQuotationEvent {

	@JsonProperty("Quote")
	private QuotaionBO quotaionBO;

	public QuotaionBO getQuotaionBO() {
		return quotaionBO;
	}

	public void setQuotaionBO(QuotaionBO quotaionBO) {
		this.quotaionBO = quotaionBO;
	}

	public CreateQuotationEvent(QuotaionBO quotaionBO) {
		super();
		this.quotaionBO = quotaionBO;
	}
	
	
}

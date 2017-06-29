package com.cts.command;

import com.cts.bo.QuotaionBO;

public class CreateQuotationCommand {
	 
	private QuotaionBO quotaionBO;

	public QuotaionBO getQuotaionBO() {
		return quotaionBO;
	}

	public void setQuotaionBO(QuotaionBO quotaionBO) {
		this.quotaionBO = quotaionBO;
	}

	public CreateQuotationCommand(QuotaionBO quotaionBO) {
		super();
		this.quotaionBO = quotaionBO;
	}
	
	

}

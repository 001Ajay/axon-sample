package com.cts.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
"quotationId",
"policyType",
"productType",
"planCode"
})
public class QuotaionBO {

	@JsonProperty("quotationId")
	private String id;
	@JsonProperty("policyType")
	private String policyType;
	@JsonProperty("productType")
	private String productType;
	@JsonProperty("planCode")
	private String planCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

}

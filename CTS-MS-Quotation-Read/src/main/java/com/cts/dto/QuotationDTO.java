package com.cts.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Quotation")
public class QuotationDTO implements Serializable {
	
	
	private String id;
	
	private String policyType;
	
	private String productType;
	
	private String planCode;

	@Id
	@Column(name="QUOTATION_ID",length=50)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="POLICY_TYPE",length=100)
	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	@Column(name="PRODUCT_TYPE",length=100)
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(name="PLAN_CODE",length=100)
	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public QuotationDTO(String id, String policyType, String productType, String planCode) {
		super();
		this.id = id;
		this.policyType = policyType;
		this.productType = productType;
		this.planCode = planCode;
	}

	public QuotationDTO() {
		
	}
	
	

}

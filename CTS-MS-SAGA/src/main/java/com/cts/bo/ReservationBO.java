package com.cts.bo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReservationBO {

	private String iternaryId;
	private String name;
	private String to;
	private String form;

	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}

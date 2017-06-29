package com.cts.bo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Cognizant
 *
 */
@XmlRootElement(name = "Test")
public class TestBO {

	private String id;
	private String name;
	private String greetings;

	public String getId() {
		return id;
	}

	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
    @XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getGreetings() {
		return "Hello " + name;
	}

	@XmlElement
	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

}

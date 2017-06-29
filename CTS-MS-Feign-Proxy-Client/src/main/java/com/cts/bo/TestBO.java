package com.cts.bo;

/**
 * @author Cognizant
 *
 */

public class TestBO {

	private String id;
	private String name;
	private String greetings;

	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
    
	public void setName(String name) {
		this.name = name;
	}

	public String getGreetings() {
		return "Hello " + name;
	}

	
	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

}

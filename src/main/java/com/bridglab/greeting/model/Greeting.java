package com.bridglab.greeting.model;

public class Greeting {
	private long id;
	private String firstName;
	private String lastName;
	


	public Greeting(long id,String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Greetings [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}

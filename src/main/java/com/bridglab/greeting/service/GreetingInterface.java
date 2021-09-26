package com.bridglab.greeting.service;
import java.util.List;
import com.bridglab.greeting.model.Greeting;

public interface GreetingInterface {
	public  List<Greeting> getGreeting() ;
	public Greeting allGreeting(Greeting greetings);
	public Greeting editGreeting(long parseLong, Greeting greetings);
	
	
}

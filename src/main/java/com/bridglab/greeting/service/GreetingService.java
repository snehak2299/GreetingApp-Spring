package com.bridglab.greeting.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.bridglab.greeting.model.Greeting;

import java.util.*;
import java.util.List;

@Service
public class GreetingService implements GreetingInterface {
public static List<Greeting> greetingList;
	
	public GreetingService() {
		greetingList = new ArrayList<>();
		greetingList.add(new Greeting(1l,"sneha","kanase"));
		greetingList.add(new Greeting(2l,"sakshi","kanase"));
		greetingList.add(new Greeting(3l,"shubhangi","kanase"));
	}
	
	public List<Greeting> getGreeting(){
		return greetingList;
	}

	public static Greeting findGreeting(long id) {
		
			return greetingList.stream().filter(n->n.getId()==id).findFirst().get();
	}
	@Override
	public Greeting allGreeting(Greeting greetings) {
		greetingList.add(greetings);
		return greetings;
	}
	@Override
	public Greeting editGreeting(long id, Greeting greetings) {
		Greeting greet=null;
		for(Greeting greet1 : greetingList) {
			if(greet1.getId()==id) {
				greet1.setFirstName(greetings.getFirstName());
				greet1.setLastName(greetings.getLastName());
				break;
			}
		}
		return greetings;
	}

}

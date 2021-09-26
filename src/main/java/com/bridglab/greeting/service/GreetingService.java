package com.bridglab.greeting.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.bridglab.greeting.model.Greeting;

import java.util.*;
import java.util.List;

@Service
public class GreetingService implements GreetingInterface {
public List<Greeting> greetingList;
	
	public GreetingService() {
		greetingList = new ArrayList<>();
		greetingList.add(new Greeting(1l,"sneha","kanase"));
		greetingList.add(new Greeting(2l,"sakshi","kanase"));
		greetingList.add(new Greeting(3l,"shubhangi","kanase"));
	}
	
	public List<Greeting> getGreeting(){
		return greetingList;
	}




}

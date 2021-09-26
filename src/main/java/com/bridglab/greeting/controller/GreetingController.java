package com.bridglab.greeting.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridglab.greeting.model.Greeting;

@RestController
public class GreetingController {
	private static final String template="Hello %s";
	private final AtomicLong counter= new AtomicLong();
	
	@GetMapping("/greeting")        // UC1 return json
	public Greeting greeting(@RequestParam (value="name",defaultValue="Hello world") String name) {
		
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
		
	}
	@GetMapping("/start")  // UC2  hello world
	public String home() {
		return "Hello world !!";
	}
	
	@RequestMapping(value= {"/query"},method=RequestMethod.GET)  //UC3 firstname + lastname acc to user
	public String SayHello(@RequestParam (value="name",defaultValue="Hello world") String name,@RequestParam(value="firstName") String firstName,@RequestParam(value="lastName")String lastName) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name))+firstName+" "+lastName+"";
	
	}
}

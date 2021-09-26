package com.bridglab.greeting.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridglab.greeting.model.Greeting;
import com.bridglab.greeting.service.GreetingInterface;
import com.bridglab.greeting.service.GreetingService;

@RestController
public class GreetingController {
	
	@Autowired
	private GreetingInterface greetingList;	
	private final AtomicLong counter= new AtomicLong();
	
	@GetMapping("/greeting")        // UC1 return json
	public Greeting greeting(@RequestParam (value="name",defaultValue="Hello world") String firstName,String lastName) {
		
		return new Greeting(counter.incrementAndGet(),firstName,lastName);
		
	}
	@GetMapping("/start")  // UC2  hello world
	public String home() {
		return "Hello world !!";
	}
	
	@GetMapping("/hello")  //UC3 firstname + lastname acc to user
	public String sayHello(@RequestParam(value = "firstName") String firstName,
			@RequestParam(value = "lastName") String lastName) {
		return counter.incrementAndGet()+ "Hello " + firstName + " " + lastName + "!";
	}
	
	@GetMapping("/save")  //UC4 save greeting msg
	public List<Greeting> getGreeting() {
		return this.greetingList.getGreeting();
	}
	
	@RequestMapping("/findid/{id}") //UC5 find greeting by ID
	public Greeting findGretings(@PathVariable("id")long id) {
		return GreetingService.findGreeting(id);
	}
	@PostMapping("/save")   // UC6 show all greetings
	public Greeting addGreeting(@RequestBody Greeting greetings) {
		return this.greetingList.allGreeting(greetings);
	}
	@PutMapping("/save/{id}")  // UC7 edit greetings
	public Greeting editGreeting(@PathVariable String id, @RequestBody Greeting greetings) {
		return this.greetingList.editGreeting(Long.parseLong(id),greetings); 
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/greeting/{id}")  //UC8 delete greeting by ID
	public void deleteGretings(@PathVariable("id")long id) {
		GreetingService.deleteGreeting(id);
		
		
	}
}

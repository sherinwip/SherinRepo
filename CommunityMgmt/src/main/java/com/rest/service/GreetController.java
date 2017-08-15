package com.rest.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	 private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();

	    @RequestMapping(path="/greeting")
	    public Greet greeting(@RequestParam(value="name", defaultValue="World") String name) {
	        return new Greet(counter.incrementAndGet(),
	                            String.format(template, name));
	    }
	    
	    
	    @RequestMapping(path="/html")
	    public String html() {
	        return "Sherin in String";
	    }
}

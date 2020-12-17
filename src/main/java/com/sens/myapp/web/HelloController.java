package com.sens.myapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sens.myapp.domain.Member;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/hello/m")
	public Member returnMember(@RequestParam("id") int id, 
							   @RequestParam("name") String name) {
		return new Member(id, name);
	}
	
	
}

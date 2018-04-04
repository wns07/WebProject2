package org.zerock.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}
	
}

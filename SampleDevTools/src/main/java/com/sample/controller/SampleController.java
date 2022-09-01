package com.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@Value("${message}")
	public String message;
	
	@GetMapping("/hi")
	public String home()
	{
		return message;
	}
}

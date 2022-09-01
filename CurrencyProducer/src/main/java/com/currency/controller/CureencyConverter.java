package com.currency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CureencyConverter {

	@GetMapping("/dollar")
	public String getDollar() {
		return "77.77";
	}
	@GetMapping("/newshekel")
	public String getShekel() {
		return "22.89";
	}
	@GetMapping("/pound")
	public String getPound() {
		return "96.55";
	}
	@GetMapping("/rupee")
	public String getRupee() {
		return "77.77";
	}
}

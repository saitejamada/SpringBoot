package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.helper.JwtTokenUtil;
import com.emp.model.JwtResponse;
import com.emp.model.User;
import com.emp.userdetailservice.CustomUserDetailService;



@RestController
public class JWTController {
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtTokenUtil jwttokenutil;
	
	@Autowired 
	private AuthenticationManager mgr;
	
	@PostMapping("/signin")
	public ResponseEntity<?> generateToken(@RequestBody User user){
		try {
			System.out.println("user details in jwtcontroller"+user);
			this.mgr.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
			System.out.println("try block");
		}catch(UsernameNotFoundException ue)
		{
			System.out.println("in jwt controller catch block");
			throw new UsernameNotFoundException("user not found");
		}
		System.out.println("after try n catch jwtcontroller");
		UserDetails ud=this.customUserDetailService.loadUserByUsername(user.getUsername());
		System.out.println("cmpleted userdetails from jwt");
		String token=this.jwttokenutil.generateToken(ud);
		
		return ResponseEntity.ok(new JwtResponse(token));
		}
}

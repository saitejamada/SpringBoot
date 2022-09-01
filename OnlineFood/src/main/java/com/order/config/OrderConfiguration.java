package com.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.order.service.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class OrderConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailsService cds;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests()
		.antMatchers("/login/**","/reg/**","/menu/**","/validateuser/**","/insertuser/**").permitAll()
		.antMatchers("/insert/**","/home/**","/del/**","/delete/**","/deleteuser/**","/deluser/**","/up/**","/update/**").hasRole("ROLE_ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login");
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(cds).passwordEncoder(passwordEncoder());
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
	return new BCryptPasswordEncoder();
	}
}

package com.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.order.model.User;
import com.order.repo.UserRepo;

@SpringBootApplication
public class OnlineFoodApplication implements CommandLineRunner {

	@Autowired
	UserRepo ur;
	@Autowired
	BCryptPasswordEncoder bpc;
	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUsername("admin");
		u.setPassword(this.bpc.encode("admin"));
		u.setUtype("ROLE_ADMIN");
		ur.save(u);
		User u1=new User();
		u1.setUsername("sai");
		u1.setPassword(this.bpc.encode("sai"));
		u1.setUtype("ROLE_NORMAL");
		ur.save(u1);
	}

	

}

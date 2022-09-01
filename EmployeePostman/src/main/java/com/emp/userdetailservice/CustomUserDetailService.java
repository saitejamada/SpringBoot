package com.emp.userdetailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.emp.model.User;
import com.emp.repo.UserRepo;
import com.emp.userdetails.CustomUserDetail;

@Service
public class CustomUserDetailService implements UserDetailsService{
@Autowired
UserRepo repo;

public UserRepo getRepo() {
	return repo;
}

public void setRepo(UserRepo repo) {
	this.repo = repo;
}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// TODO Auto-generated method stub
	System.out.println("in customuserdetails");
User up=repo.findByUsername(username);
System.out.println("user details are"+up);
//if(up==null)
//{
//	throw new UsernameNotFoundException("user not found"+username);
//}
return new CustomUserDetail(up);
}

}


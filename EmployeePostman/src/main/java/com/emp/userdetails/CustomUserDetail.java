package com.emp.userdetails;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.emp.model.User;

@Configuration
public class CustomUserDetail implements UserDetails{ /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
User user;
public CustomUserDetail() {
super();
// TODO Auto-generated constructor stub
} 
public CustomUserDetail(User user) {
super();
this.user = user;
} 
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
// TODO Auto-generated method stub
HashSet<GrantedAuthority> hs=new HashSet<GrantedAuthority>();
hs.add(new SimpleGrantedAuthority(this.user.getRole()));
return hs;
}
@Override
public String getPassword() {
// TODO Auto-generated method stub
return this.user.getPassword();
} @Override
public String getUsername() {
// TODO Auto-generated method stub
return this.user.getUsername();
}
@Override
public boolean isAccountNonExpired() {
// TODO Auto-generated method stub
return true;
} @Override
public boolean isAccountNonLocked() {
// TODO Auto-generated method stub
return true;
} @Override
public boolean isCredentialsNonExpired() {
// TODO Auto-generated method stub
return true;
} @Override
public boolean isEnabled() {
// TODO Auto-generated method stub
return true;
}}


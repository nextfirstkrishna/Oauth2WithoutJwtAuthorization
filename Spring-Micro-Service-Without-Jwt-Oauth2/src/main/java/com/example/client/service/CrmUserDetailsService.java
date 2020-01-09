package com.example.client.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.client.model.User;
import com.example.client.repository.UserRepository;

@Service
public class CrmUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userValue;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user2=userValue.findByUsername(username); //get data from database
		
		user2.orElseThrow(() -> new UsernameNotFoundException("Username or Password is wrong"));
		UserDetails details=new CrmUserDetails(user2.get()); //creating user details object to return
		return user2.map(CrmUserDetails::new).get();
	}
	


}

package com.example.client.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.client.model.User;


public class CrmUserDetails extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String username;
	private String password;
	private boolean enabled;
	private boolean accountExpired;
	private boolean credentialExpired;
	private boolean accountLocked;
	private Collection<? extends GrantedAuthority> authorities;
	 
	public CrmUserDetails(User user){
		super(user);
		this.username=user.getUsername();
		this.password=user.getPassword();
		this.enabled=user.isEnabled();
		this.accountExpired=user.isAccountExpired();
		this.credentialExpired=user.isCredentialExpired();
		this.accountLocked=user.isAccountLocked();
		List<GrantedAuthority> list=new ArrayList<>();
		for(com.example.client.model.Role role: user.getRoles()){
			list.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		}
		this.authorities=list;
//		
	}
	
	public CrmUserDetails(){}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	
	@Override
	public String getUsername() {

		return username;
	}
	
	@Override
	public String getPassword() {

		
		return password;
	}
	
	@Override
	public boolean isAccountNonExpired() {

		return accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return accountLocked;

	}

	@Override
	public boolean isCredentialsNonExpired() {
	
		return credentialExpired;

	}
	
	@Override
	public boolean isEnabled() {

		return enabled;

	}

}

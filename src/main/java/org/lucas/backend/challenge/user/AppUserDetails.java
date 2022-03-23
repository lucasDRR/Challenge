package org.lucas.backend.challenge.user;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.lucas.backend.challenge.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AppUserDetails implements UserDetails {

	/**
	 *  Version 1: solo incluye GrantedAuthorities, username y password
	 *  otra informacion es falsa.
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	private AppUserDetails(String username, String password, List<GrantedAuthority> authorities) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public static AppUserDetails Of(User user) {
		
		List<GrantedAuthority> lista = Arrays.stream(user.getAuthorities().split(","))
		.map(p -> p.trim())
		.map(SimpleGrantedAuthority::new)
		.collect(Collectors
				.toList());
		
		return new AppUserDetails(user.getUsername(), user.getPassword(), lista);
	}

}

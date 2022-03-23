package org.lucas.backend.challenge.controllers;

import org.lucas.backend.challenge.models.User;
import org.lucas.backend.challenge.repositories.UserRepository;
import org.lucas.backend.challenge.user.JwAuthResponse;
import org.lucas.backend.challenge.user.JwtAuthRequest;
import org.lucas.backend.challenge.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private PasswordEncoder passworEncoder;
	
	@PostMapping(value = "auth/login")
	public ResponseEntity<?> userLoginJWT(@RequestBody JwtAuthRequest user) throws Exception{
				
		try {
			authManager.authenticate( new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		}catch(BadCredentialsException e) {
			
			throw new Exception("incorrect username or password ");
		}
		
		final UserDetails UserDetails = userDetailsService.loadUserByUsername(user.getUsername());
		
		final String token = jwtUtils.generarToken(UserDetails);
		
		return ResponseEntity.ok( new JwAuthResponse(token));
	}
	
	@PostMapping(value = "auth/register")
	public ResponseEntity<?> userRegistration(@RequestBody User user){
		
		// Falta validar los datos
		
		user.setPassword( passworEncoder.encode(user.getPassword()));
		
		this.userRepository.saveAndFlush(user);
		
		return ResponseEntity.ok("Registración correcta");
	}
	
		
	

}

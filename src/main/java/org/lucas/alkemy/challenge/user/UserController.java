package org.lucas.alkemy.challenge.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@PostMapping(value = "auth/login")
	public ResponseEntity<?> userLoginJWT(@RequestBody User user){
		
		return null;
	}
	
	@PostMapping(value = "auth/register")
	
	public ResponseEntity<?> userRegistration(@RequestBody User user){
		
		return null;
	}
	
		
	

}

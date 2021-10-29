package org.lucas.alkemy.challenge.user;

import lombok.Data;

@Data
public class JwtAuthRequest {
	
	private String username;
	private String password;

}

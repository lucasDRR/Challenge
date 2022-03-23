package org.lucas.backend.challenge.user;

import lombok.Data;

@Data
public class JwtAuthRequest {
	
	private String username;
	private String password;

}

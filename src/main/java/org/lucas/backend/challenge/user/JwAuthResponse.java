package org.lucas.backend.challenge.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwAuthResponse {

	private String jwtToken;
	
}

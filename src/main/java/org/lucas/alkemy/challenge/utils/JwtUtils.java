package org.lucas.alkemy.challenge.utils;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JwtUtils {

	private Algorithm algo = Algorithm.HMAC256("secreta"); // hardcode cambiar a autogenerada

	private JWTVerifier verifier = JWT.require(algo).build();

	public String generarToken(UserDetails userDetails) {

		String jwtToken = null;

		try {

			jwtToken = JWT.create()
					.withSubject(userDetails.getUsername())
					.withIssuedAt(new Date(System.currentTimeMillis()))
					.withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
					.sign(algo);

		} catch (JWTCreationException e) {
			
			System.out.println(e.getMessage());
		}

		return jwtToken;
	}

	private DecodedJWT verificarJwtToken(String token) {
		DecodedJWT jwt = verifier.verify(token);
		return jwt;
	}

	public String extractUsername(String token) {

		return this.verificarJwtToken(token).getSubject();
	}

	/** true indica que el token está caducado.
	 * false indica que el token es valido
	 */
	public boolean isTokenExpired(String token) {

		return JWT.decode(token)
		.getExpiresAt()
		.after(new Date(System.currentTimeMillis()));
	}

}

package org.lucas.alkemy.challenge.user;


import java.util.Optional;

import org.lucas.alkemy.challenge.models.User;
import org.lucas.alkemy.challenge.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> usuario = this.userRepository.findOptionalByUsername(username);

		if( usuario.isEmpty() == true ) {
			throw new UsernameNotFoundException("username: "+ username +" no encontrado");
		}

		return AppUserDetails.Of(usuario.get());
	}



}

package org.lucas.alkemy.challenge.user;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class User {

	private Long id;
	
	private String username;
	
	private String password;
	
	private String mail;
	
	private String authorities;
}

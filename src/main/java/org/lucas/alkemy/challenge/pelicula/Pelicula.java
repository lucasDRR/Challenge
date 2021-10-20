package org.lucas.alkemy.challenge.pelicula;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IMAGE")
	private String imagen;

	@Column(name = "TITLE")
	private String titulo;

	@Column(name = "CREATED")
	private Date fechaCreacion;

	@Column(name = "STARS")
	private int calificacion;

	// private List<Personaje> personajes;
}

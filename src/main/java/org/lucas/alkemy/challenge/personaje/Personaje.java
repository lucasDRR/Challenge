package org.lucas.alkemy.challenge.personaje;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IMAGE")
	private String imagen;

	@Column(name = "NAME")
	private String nombre;

	@Column(name = "AGE")
	private int edad;

	@Column(name = "WEIGHT")
	private double peso;

	@Column(name = "STORY")
	private String historia;

	// private List<Pelicula> peliculas;

}

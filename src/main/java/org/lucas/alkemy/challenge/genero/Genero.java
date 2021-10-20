package org.lucas.alkemy.challenge.genero;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IMAGE")
	private String imagen;

	@Column(name = "NOMBRE")
	private String nombre;

	// private List<Pelicula> peliculas;
}

package org.lucas.alkemy.challenge.personaje;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.lucas.alkemy.challenge.pelicula.Pelicula;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Personaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IMAGE")
	@Lob
	private String imagen;

	@Column(name = "NAME")
	private String nombre;

	@Column(name = "AGE")
	private int edad;

	@Column(name = "WEIGHT")
	private double peso;

	@Column(name = "STORY")
	private String historia;

	@ManyToMany(mappedBy = "personajes")
	@JsonBackReference
	private List<Pelicula> peliculas;

}

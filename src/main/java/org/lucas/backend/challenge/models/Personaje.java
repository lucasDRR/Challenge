package org.lucas.backend.challenge.models;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

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

	@ManyToMany(cascade = {MERGE, PERSIST}, mappedBy = "personajes")
	@JsonBackReference
	private Set<Pelicula> peliculas = new HashSet<>();

}

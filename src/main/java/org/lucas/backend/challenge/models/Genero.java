package org.lucas.backend.challenge.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	@OneToMany( mappedBy = "genero")
	@JsonBackReference
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
}

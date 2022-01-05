package org.lucas.alkemy.challenge.models;

import java.sql.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IMAGE")
	@Lob
	private String imagen;

	@Column(name = "TITLE")
	private String titulo;

	@Column(name = "CREATED")
	private Date fechaCreacion;

	@Column(name = "STARS")
	private int calificacion;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ID_GENERO")
	@JsonManagedReference
	private Genero genero;

	@ManyToMany(cascade = {PERSIST, DETACH, MERGE, REFRESH } )
	@JsonManagedReference
	private List<Personaje> personajes;
}

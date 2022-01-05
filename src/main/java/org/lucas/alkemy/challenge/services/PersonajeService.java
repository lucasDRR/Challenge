package org.lucas.alkemy.challenge.services;

import java.util.List;

import org.lucas.alkemy.challenge.DTOS.PersonajeParaLista;
import org.lucas.alkemy.challenge.models.Personaje;
import org.lucas.alkemy.challenge.repositories.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {

	@Autowired
	private PersonajeRepository personajeRepository;

	public List<PersonajeParaLista> getAllCharacters() {

		return this.personajeRepository.findAllBy();
	}

	public Personaje findByNombre(String Nombre) {

		return this.personajeRepository.findOptionalByNombre(Nombre).orElse(null);		
	}

	// búsquedas especiales

	public List<Personaje> findByEdad(Integer edad) {
		return this.personajeRepository.findByEdad(edad);
	}

	public List<Personaje> findByPeso(Double peso) {
		return this.personajeRepository.findByPeso(peso);
	}

	public List<Personaje> findByPeliculaId(Long idPelicula) {
		return this.personajeRepository.findByPeliculasId(idPelicula);
	}

	// crear editar y eliminar un personaje

	public Personaje savePersonaje(Personaje personaje) {
		return this.personajeRepository.save(personaje);
	}

	public Personaje editPersonaje(Personaje personaje) {
		return null;
	}

	public void deletePersonaje(Personaje personaje) {
		this.deletePersonaje(personaje);
	}

}

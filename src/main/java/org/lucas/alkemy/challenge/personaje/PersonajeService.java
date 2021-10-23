package org.lucas.alkemy.challenge.personaje;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonajeService {
	
	@Autowired
	private PersonajeRepository personajeRepository;
	
	public List<PersonajeParaLista> getAllCharacters() {
		
		return  this.personajeRepository.findAllBy();
	}
	
	public Personaje findByNombre(String Nombre) {
		
		return this.personajeRepository.findOptionalByNombre(Nombre).orElse(null);
	}
	
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

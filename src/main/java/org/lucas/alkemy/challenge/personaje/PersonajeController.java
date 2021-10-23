package org.lucas.alkemy.challenge.personaje;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PersonajeController {
	
	@Autowired
	private PersonajeService personajeService;
	
	@GetMapping("/characters")
	public List<PersonajeParaLista> verTodoslosPersonajes() {
		return this.personajeService.getAllCharacters();
	}
	
	// busqueda de personajes
	
	@GetMapping("/character")
	public Personaje buscarPorNombre(@RequestParam(name = "name" )String nombre) {
		return this.personajeService.findByNombre(nombre);
	}
	
	// Crear, editar y eliminar
	
	@PostMapping("/characters")
	public Personaje crearPersonaje(@RequestBody Personaje personaje) {
		return this.personajeService.savePersonaje(personaje);
	}
	
	
	@PutMapping("/characters")
	public void EditarPersonaje(@RequestBody Personaje personaje) {
		this.personajeService.editPersonaje(personaje);
	}
	
	
	@DeleteMapping("/characters")
	public void borrarPersonaje(@RequestBody Personaje personaje) {
		this.personajeService.deletePersonaje(personaje);
	}


}

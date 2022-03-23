package org.lucas.backend.challenge.controllers;

import java.util.List;

import org.lucas.backend.challenge.DTOS.PersonajeParaLista;
import org.lucas.backend.challenge.models.Personaje;
import org.lucas.backend.challenge.services.PersonajeService;
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

	@GetMapping(value = "/characters", params = "name")
	public Personaje buscarPorNombre(@RequestParam(name = "name") String nombre) {
		return this.personajeService.findByNombre(nombre);
	}

	// busquedas especiales

	@GetMapping(value = "/characters", params = "age")
	public List<Personaje> buscarPorEdad(@RequestParam(name = "age") Integer edad) {

		return this.personajeService.findByEdad(edad);
	}

	@GetMapping(value = "/characters", params = "weight")
	public List<Personaje> buscarPorPeso(@RequestParam(name = "weight") Double peso) {

		return this.personajeService.findByPeso(peso);
	}

	@GetMapping(value = "/characters", params = "idMovie")
	public List<Personaje> buscarPorPelicula(@RequestParam(name = "idMovie") Long idPelicula) {
		return this.personajeService.findByPeliculaId(idPelicula);
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

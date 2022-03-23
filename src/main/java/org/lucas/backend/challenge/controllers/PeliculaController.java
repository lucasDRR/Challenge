package org.lucas.backend.challenge.controllers;

import java.util.List;

import org.lucas.backend.challenge.DTOS.PeliculaParaLista;
import org.lucas.backend.challenge.models.Pelicula;
import org.lucas.backend.challenge.services.PeliculaService;
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
public class PeliculaController {

	@Autowired
	private PeliculaService peliculaService;

	@GetMapping("/movies")
	public List<PeliculaParaLista> verTodasLasPeliculas() {
		return this.peliculaService.getAllMovies();
	}

	// búsquedas especiales

	@GetMapping(value = "/movies", params = "name")
	public Pelicula buscarPeliculaPorNombre(@RequestParam(name = "name") String nombre) {
		return this.peliculaService.findMovieByNombre(nombre);
	}

	@GetMapping(value = "/movies", params = "order")
	public List<Pelicula> buscarPeliculasOrdenadasPorFecha(
			@RequestParam(name = "order", defaultValue = "ASC") String orden) {
		return this.peliculaService.findAllSortedByFecha(orden);
	}

	@GetMapping(value = "/movies", params = "genre")
	public List<Pelicula> buscarPeliculasPorGenero(@RequestParam(name = "genre") Long generoId) {
		return this.peliculaService.findByGeneroId(generoId);
	}

	// crear, editar y eliminar peliculas

	@PostMapping("/movies")
	public Pelicula guardarPelicula(@RequestBody Pelicula pelicula) {
		return this.peliculaService.savePelicula(pelicula);
	}

	@PutMapping("/movies")
	public Pelicula editarPelicula(@RequestBody Pelicula pelicula) {
		return null;
	}

	@DeleteMapping("/movies")
	public void borrarPelicula(@RequestBody Pelicula pelicula) {
		this.peliculaService.deletePelicula(pelicula);
	}

}

package org.lucas.alkemy.challenge.pelicula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
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
	public List<Pelicula> verTodasLasPeliculas(){
		return this.peliculaService.getAllMovies();
	}
	
	// búsquedas especiales
	
	@GetMapping(value = "/movies", params = "name")
	public Pelicula buscarPeliculaPorNombre(@RequestParam(name = "title") String nombre) {
		return this.peliculaService.findMovieByNombre(nombre);
	}
	
	@GetMapping(value = "/movies", params = "order")
	public List<Pelicula> buscarPeliculasOrdenadasPorFecha(@RequestParam(name = "order", defaultValue = "ASC") String nombre) {
		return null;
	}
	
	@GetMapping(value = "/movies", params = "genre")
	public List<Pelicula> buscarPeliculasPorGenero(@RequestParam(name = "genre") String genero) {
		return null;
	}
	
	@GetMapping(value = "/movies", params = {"genero", "orden"})
	public Slice<Pelicula> buscarPorGeneroOrdenar(@RequestParam(name = "genero")String genero,
			@RequestParam(name = "orden", defaultValue = "DESC") String order){
		
		return this.peliculaService.findByGeneroOrdenado(genero, order);
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

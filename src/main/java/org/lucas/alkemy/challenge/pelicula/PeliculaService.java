package org.lucas.alkemy.challenge.pelicula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;

	public List<Pelicula> getAllMovies() {

		return this.peliculaRepository.findAll();
	}

	// busquedas especiales
	
	public Pelicula findMovieByNombre(String Nombre) {

		return this.peliculaRepository.findOptionalByTitulo(Nombre).orElse(null);
	}
	
	public List<Pelicula> findByGenero(String genero){
		
		return this.peliculaRepository.findByGenero(genero);
	}
	
	public List<Pelicula> findAllSortedByFecha(String order){
		
		var direction = Sort.Direction.fromOptionalString(order);
		
		Sort sort = Sort.by(direction.orElse(Sort.Direction.ASC), "fechaCreacion");
		
		return this.peliculaRepository.findAll(sort);
		
	}

	/**
	 *  Busqueda por genero ordena por 'fechaCreacion' con el orden indicado 
	 *  
	 *  */
	public Slice<Pelicula> findByGeneroOrdenado(String genero, String orden){
		
		var sortDirection = Sort.Direction.fromOptionalString(orden);
		
		Sort sort = Sort.by(sortDirection.orElse(Sort.Direction.DESC), "fechaCreacion");
		
		return this.peliculaRepository.findByGenero(genero, sort);
		
	}
	
	
	public Pelicula savePelicula(Pelicula pelicula) {

		return this.peliculaRepository.save(pelicula);
	}

	public Pelicula editPelicula(Pelicula pelicula) {
		
		// no implementado aún
		return this.peliculaRepository.save(pelicula);
	}

	public void deletePelicula(Pelicula pelicula) {

		this.peliculaRepository.delete(pelicula);
	}

}

package org.lucas.alkemy.challenge.pelicula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {

	@Autowired
	private PeliculaRepository peliculaRepository;

	public List<PeliculaParaLista> getAllMovies() {

		return this.peliculaRepository.findAllBy();
	}

	// busquedas especiales

	public Pelicula findMovieByNombre(String Nombre) {

		return this.peliculaRepository.findOptionalByTitulo(Nombre).orElse(null);
	}

	public List<Pelicula> findByGeneroId(Long generoId) {

		return this.peliculaRepository.findByGeneroId(generoId);
	}

	public List<Pelicula> findAllSortedByFecha(String order) {

		var direction = Sort.Direction.fromOptionalString(order);

		Sort sort = Sort.by(direction.orElse(Sort.Direction.ASC), "fechaCreacion");

		return this.peliculaRepository.findAll(sort);

	}

	// crear, editar y eliminar

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

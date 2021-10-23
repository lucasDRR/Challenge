package org.lucas.alkemy.challenge.pelicula;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
	
	public Optional<Pelicula> findOptionalByTitulo(String titulo);
	
	public List<Pelicula> findByGenero(String genero);
	
	public List<Pelicula> findAll(Sort sort);
	
	public Slice<Pelicula> findByGenero(String genero, Sort sort);

}

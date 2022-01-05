package org.lucas.alkemy.challenge.repositories;

import java.util.List;
import java.util.Optional;

import org.lucas.alkemy.challenge.DTOS.PeliculaParaLista;
import org.lucas.alkemy.challenge.models.Pelicula;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
	
	public List<PeliculaParaLista> findAllBy();
	
	public Optional<Pelicula> findOptionalByTitulo(String titulo);

	public List<Pelicula> findByGeneroId(Long genero);

	public List<Pelicula> findAll(Sort sort);

}

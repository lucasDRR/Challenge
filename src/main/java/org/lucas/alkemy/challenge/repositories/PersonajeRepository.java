package org.lucas.alkemy.challenge.repositories;

import java.util.List;
import java.util.Optional;

import org.lucas.alkemy.challenge.DTOS.PersonajeParaLista;
import org.lucas.alkemy.challenge.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje, Long> {

	public List<PersonajeParaLista> findAllBy();

	public Optional<Personaje> findOptionalByNombre(String Nombre);

	public List<Personaje> findByEdad(Integer edad);

	public List<Personaje> findByPeso(Double peso);

	public List<Personaje> findByPeliculasId(Long id);

}

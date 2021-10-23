package org.lucas.alkemy.challenge.personaje;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonajeRepository extends CrudRepository<Personaje, Long> {
	
	public List<PersonajeParaLista> findAllBy();
	
	public Optional<Personaje> findOptionalByNombre(String Nombre);
	
	public List<Personaje> findByEdad(Integer edad);
	
	public List<Personaje> findByPeso(Double peso);
	
	//public List<Personaje> findByPeliculaId(Long idMovie); 
	

}

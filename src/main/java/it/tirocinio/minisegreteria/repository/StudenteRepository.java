package it.tirocinio.minisegreteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.tirocinio.minisegreteria.model.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Long>{
	boolean existsByMatricola(Integer matricola);
	boolean findByIdStudente(Long id);
	
	@Query(value="SELECT * FROM studenti " + "WHERE(:id IS NULL OR id=:id) "+
											"AND(:matricola IS NULL OR matricola=:matricola)",
			nativeQuery=true)
	List<Studente> cercaStudentiConFiltri(
					@Param("id")Long id,
					@Param("matricola") Integer matricola
					);
	

}

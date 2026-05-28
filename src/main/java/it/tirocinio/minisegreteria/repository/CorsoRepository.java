package it.tirocinio.minisegreteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.tirocinio.minisegreteria.model.Corso;
import it.tirocinio.minisegreteria.model.Iscrizione;

public interface CorsoRepository extends JpaRepository<Corso,Long>{
	boolean existsByNome(String nome);

	@Query(value = "SELECT * FROM corsi WHERE " +
            "LOWER(nome) LIKE LOWER(CONCAT('%', :nome, '%')) AND " +
            "LOWER(tipo_titolo) LIKE LOWER(CONCAT('%', :tipoTitolo, '%')) AND " +
            "LOWER(anno_accademico) LIKE LOWER(CONCAT('%', :annoAccademico, '%'))", 
    nativeQuery = true)
List<Corso> cercaCorsiConFiltri(
		@Param("nome") String nome,
		@Param("tipoTitolo") String tipoTitolo,
		@Param("annoAccademico") String annoAccademico
		);
}

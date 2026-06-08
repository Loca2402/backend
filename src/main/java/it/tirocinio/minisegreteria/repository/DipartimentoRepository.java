package it.tirocinio.minisegreteria.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tirocinio.minisegreteria.model.Dipartimento;
import jakarta.persistence.*;
@Repository
public interface DipartimentoRepository extends JpaRepository<Dipartimento,Long>{
	boolean existsByNome(String nome);
	List<Dipartimento> findByAteneoAteneoId(Long ateneoId);
	Optional<Dipartimento> findByCodice(Integer codice);
}

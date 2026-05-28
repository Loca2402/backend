package it.tirocinio.minisegreteria.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tirocinio.minisegreteria.model.Dipartimento;
import jakarta.persistence.*;
@Repository
public interface DipartimentoRepository extends JpaRepository<Dipartimento,Long>{
	boolean existsByNome(String name);
	List<Dipartimento> findByAteneoId(Long ateneoId);
}

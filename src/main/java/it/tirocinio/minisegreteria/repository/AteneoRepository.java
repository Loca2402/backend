package it.tirocinio.minisegreteria.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.tirocinio.minisegreteria.model.Ateneo;
import jakarta.persistence.*;
@Repository
public interface AteneoRepository extends JpaRepository<Ateneo,Long> {
	boolean existsByNome(String nome);


}

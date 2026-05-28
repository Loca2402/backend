package it.tirocinio.minisegreteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.tirocinio.minisegreteria.model.Recapito;

public interface RecapitoRepository extends JpaRepository<Recapito, Long> {
	
}

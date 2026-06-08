package it.tirocinio.minisegreteria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import it.tirocinio.minisegreteria.model.Iscrizione;

public interface IscrizioneRepository extends JpaRepository<Iscrizione, Long> {

    List<Iscrizione> findByStudenteId(Long idStudente);
    
    List<Iscrizione> findByCorsoIdCorso(Long idCorso);

    boolean existsByStudenteIdAndCorsoIdCorso(Long idStudente, Long idCorso);
    }
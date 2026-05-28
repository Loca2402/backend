package it.tirocinio.minisegreteria.service;			
import jakarta.persistence.*;
import it.tirocinio.minisegreteria.model.Ateneo;
import it.tirocinio.minisegreteria.repository.AteneoRepository;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class AteneoService {
 private AteneoRepository ateneoRepository;

 public AteneoService(AteneoRepository ateneoRepository) {
        this.ateneoRepository = ateneoRepository;
 	}
public List<Ateneo> trovaTuttiAtenei() {
    return ateneoRepository.findAll();
	}	
public Ateneo cercaAteneoPerId(Long id) {
    return ateneoRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Ateneo con ID " + id + " non trovato."));
}

public Ateneo createAteneo(Ateneo nuovoAteneo){
    boolean giaesiste = ateneoRepository.existsByNome(nuovoAteneo.getNome());
    if(giaesiste) {
        throw new IllegalArgumentException("L'ateneo non può essere inserito perchè gia esiste");
    }
    return ateneoRepository.save(nuovoAteneo);
}

public Ateneo cercaAteneo(Long id) {
    return ateneoRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Ateneo con ID " + id + " non trovato."));
	}
}
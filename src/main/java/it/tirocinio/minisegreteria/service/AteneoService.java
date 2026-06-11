package it.tirocinio.minisegreteria.service;			
import jakarta.persistence.*;
import it.tirocinio.minisegreteria.model.Ateneo;
import it.tirocinio.minisegreteria.repository.AteneoRepository;
import it.tirocinio.minisegreteria.repository.DipartimentoRepository;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AteneoService {
 private AteneoRepository ateneoRepository;
 
 @Autowired
 private DipartimentoRepository dipartimentoRepository;

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

public void cancellaAteneo(Long ateneoId) {
	if(!ateneoRepository.existsById(ateneoId)) {
		throw new NoSuchElementException("Ateneo non trovato.");
	}
	boolean dipartimentiSi = dipartimentoRepository.existsByAteneoAteneoId(ateneoId);
	if(dipartimentiSi) {
		throw new IllegalArgumentException("impossibile eliminare l'ateneo, ci sono dipartimenti associati ad esso.");
	}
	 ateneoRepository.deleteById(ateneoId);
}
}
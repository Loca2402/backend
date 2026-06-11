package it.tirocinio.minisegreteria.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import it.tirocinio.minisegreteria.model.Corso;
import it.tirocinio.minisegreteria.model.Iscrizione;
import it.tirocinio.minisegreteria.model.StatoIscrizione;
import it.tirocinio.minisegreteria.model.Studente;
import it.tirocinio.minisegreteria.repository.CorsoRepository;
import it.tirocinio.minisegreteria.repository.IscrizioneRepository;
import it.tirocinio.minisegreteria.repository.StudenteRepository;

@Service
public class IscrizioneService {
	private IscrizioneRepository iscrizioneRepository;
	private StudenteRepository studenteRepository;
	private CorsoRepository corsoRepository;
	
	public IscrizioneService(IscrizioneRepository iscrizioneRepository, StudenteRepository studenteRepository,
			CorsoRepository corsoRepository) {
		super();
		this.iscrizioneRepository = iscrizioneRepository;
		this.studenteRepository = studenteRepository;
		this.corsoRepository = corsoRepository;
	}
	
	public Iscrizione creaIscrizione(Long idStudente, Long idCorso, Iscrizione nuovaIscrizione) {
		Studente studente = studenteRepository.findById(idStudente).
				orElseThrow(()-> new NoSuchElementException("Lo studente con id "+idStudente+" non è stato trovato"));
		Corso corso = corsoRepository.findById(idCorso).
				orElseThrow(()-> new NoSuchElementException("Il corso con id "+idCorso+" non è stato trovato"));
		
		boolean studenteIscritto = iscrizioneRepository.existsByStudenteId(idStudente);
	    if (studenteIscritto) {
	        throw new IllegalArgumentException("Impossibile procedere: lo studente è già iscritto a un corso universitario e non può frequentarne più di uno.");
	    }
		
		nuovaIscrizione.setStudente(studente);
		nuovaIscrizione.setCorso(corso);
		
		return iscrizioneRepository.save(nuovaIscrizione);
	}
	
	public List trovaIscrizioneStudente(Long idStudente) {
		return iscrizioneRepository.findByStudenteId(idStudente);
	}
	
	public Iscrizione aggiornaStato(Long id, String nuovoStato) {
		Iscrizione iscrizione = iscrizioneRepository.findById(id).orElseThrow(
				()-> new NoSuchElementException("Iscrizione con id "+id+" non trovata"));
		
		try {
			StatoIscrizione newstato = StatoIscrizione.valueOf(nuovoStato.toUpperCase());
			iscrizione.setStato(newstato);
			return iscrizioneRepository.save(iscrizione);
		}
		catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("stato non valido.");
		}
	}
}

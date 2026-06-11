package it.tirocinio.minisegreteria.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tirocinio.minisegreteria.dto.CorsoDTO;
import it.tirocinio.minisegreteria.dto.CorsoMapper;
import it.tirocinio.minisegreteria.model.Corso;
import it.tirocinio.minisegreteria.model.Dipartimento;
import it.tirocinio.minisegreteria.model.Iscrizione;
import it.tirocinio.minisegreteria.repository.CorsoRepository;
import it.tirocinio.minisegreteria.repository.DipartimentoRepository;
import it.tirocinio.minisegreteria.repository.IscrizioneRepository;
import it.tirocinio.minisegreteria.repository.StudenteRepository;

@Service
public class CorsoService {
	private final CorsoRepository corsoRepository;
	private final DipartimentoRepository dipartimentoRepository;
	private final IscrizioneRepository iscrizioneRepository; 
	
	
	public CorsoService(CorsoRepository corsoRepository, 
			DipartimentoRepository dipartimentoRepository, 
			IscrizioneRepository iscrizioneRepository) {
		super();
		this.corsoRepository = corsoRepository;
		this.dipartimentoRepository = dipartimentoRepository;
		this.iscrizioneRepository = iscrizioneRepository;
	}
	
	public List<CorsoDTO> trovaTuttiCorsi(){
		List<Corso> corsi = corsoRepository.findAll();
	    return corsi.stream()
	            .map(CorsoMapper::toDTO)
	            .toList();
	}
	
	public Corso createCorso(CorsoDTO nuovoCorso) {
	    Corso corso = CorsoMapper.toModel(nuovoCorso);
	    Dipartimento dipartimentoReale = dipartimentoRepository.findByCodice(nuovoCorso.getCodiceDipartimento())
	    .orElseThrow(() -> new NoSuchElementException("Codice dipartimento errato: " + nuovoCorso.getCodiceDipartimento()));
	    corso.setDipartimento(dipartimentoReale);

	    return corsoRepository.save(corso);
	}
	
	public Corso cercaCorso(Long idCorso) {
		return corsoRepository.findById(idCorso).orElseThrow(
				()-> new NoSuchElementException("Corso con ID " + idCorso + " non trovato."));
	}
	
	public List<CorsoDTO> ricercaCorso(String nome, String tipoTitolo, String annoAccademico) {
	    List<Corso> corsi = corsoRepository.cercaCorsiConFiltri(nome, tipoTitolo, annoAccademico);
	    return corsi.stream()
	            .map(CorsoMapper::toDTO)
	            .toList();
	}
	
	public List<Iscrizione> studentiAlCorso(Long idCorso) {
	    if (!corsoRepository.existsById(idCorso)) {
	        throw new NoSuchElementException("Il corso con id " + idCorso + " non esiste.");
	    }
	    return iscrizioneRepository.findByCorsoIdCorso(idCorso);
	}
	
	public void cancellaCorso(Long idCorso) {
		if(!corsoRepository.existsById(idCorso)) {
			throw new NoSuchElementException("Corso non trovato.");
		}
		boolean studentiSi = iscrizioneRepository.existsByCorsoIdCorso(idCorso);
		if(studentiSi) {
			throw new IllegalArgumentException("impossibile eliminare il corso, ci sono studenti iscritti.");
		}
		 corsoRepository.deleteById(idCorso);
	}
	
	
}
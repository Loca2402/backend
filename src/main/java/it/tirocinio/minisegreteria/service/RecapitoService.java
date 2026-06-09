package it.tirocinio.minisegreteria.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tirocinio.minisegreteria.model.Recapito;
import it.tirocinio.minisegreteria.model.Studente;
import it.tirocinio.minisegreteria.repository.RecapitoRepository;
import it.tirocinio.minisegreteria.repository.StudenteRepository;

@Service
public class RecapitoService {
	@Autowired
	private RecapitoRepository recapitoRepository;
	
	@Autowired
	private StudenteRepository studenteRepository;
	
	public Recapito creaRecapitoPerStudente(Long id, Recapito nuovoRecapito) {
		Studente studente = studenteRepository.findById(id).orElseThrow(
			()-> new NoSuchElementException("studente con id "+id+" non è stato trovato."));
		
		nuovoRecapito.setStudente(studente);
		nuovoRecapito.setId(studente.getId());
		
		return recapitoRepository.save(nuovoRecapito);
	}
	
	public Recapito getRecapitoByStudente(Long id) {
		if(!studenteRepository.existsById(id)) {
			throw new NoSuchElementException("studente con id "+id+" non è stato trovato.");
		}
		return recapitoRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("Nessun recapito associato allo studente con ID "+id));
	}
}

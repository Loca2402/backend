package it.tirocinio.minisegreteria.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import it.tirocinio.minisegreteria.dto.StudenteDTO;
import it.tirocinio.minisegreteria.dto.StudenteMapper;
import it.tirocinio.minisegreteria.model.Studente;
import it.tirocinio.minisegreteria.repository.CorsoRepository;
import it.tirocinio.minisegreteria.repository.StudenteRepository;

@Service
public class StudenteService {
	private StudenteRepository studenteRepository;
	private CorsoRepository corsoRepository;
	
	public StudenteService(StudenteRepository studenteRepository, CorsoRepository corsoRepository) {
		super();
		this.studenteRepository = studenteRepository;
		this.corsoRepository = corsoRepository;
	}
	
	public List<StudenteDTO> trovaStudenti() {
		List<Studente> listastudenti = studenteRepository.findAll();
		
		return listastudenti.stream().map(StudenteMapper::toDTO).toList();
	}
	
	public Studente createStudente(Studente nuovoStudente) {
		boolean esisteStudente = studenteRepository.existsByMatricola(nuovoStudente.getMatricola());
		if (esisteStudente) {
			throw new IllegalArgumentException("Lo studente con matricola "+nuovoStudente.getMatricola()+" già è inserito");
		}
		return studenteRepository.save(nuovoStudente);
	}
	
	public Studente cercaStudente(Long id) {
		//Studente studente = 
				return studenteRepository.findById(id).orElseThrow(
				() -> new NoSuchElementException("Studente con ID " + id + " non trovato."));
		//return StudenteMapper.toDTO(studente);
	}
	
	public List<Studente> ricercaStudente(Long id, Integer matricola) {
		return studenteRepository.cercaStudentiConFiltri(id, matricola);
	}
}

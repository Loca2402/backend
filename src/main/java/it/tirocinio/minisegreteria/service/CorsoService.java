package it.tirocinio.minisegreteria.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

import it.tirocinio.minisegreteria.dto.CorsoDTO;
import it.tirocinio.minisegreteria.dto.CorsoMapper;
import it.tirocinio.minisegreteria.model.Corso;
import it.tirocinio.minisegreteria.model.Iscrizione;
import it.tirocinio.minisegreteria.repository.CorsoRepository;
import it.tirocinio.minisegreteria.repository.DipartimentoRepository;
import it.tirocinio.minisegreteria.repository.IscrizioneRepository;

@Service
public class CorsoService {
	private final CorsoRepository corsoRepository;
	private final DipartimentoRepository dipartimentoRepository;
	private final IscrizioneRepository iscrizioneRepository; // 👈 Ora verrà inizializzato correttamente
	
	// 🛠️ COSTRUTTORE AGGIORNATO CON TUTTE E 3 LE REPOSITORY REQUIRED
	public CorsoService(CorsoRepository corsoRepository, 
			DipartimentoRepository dipartimentoRepository, 
			IscrizioneRepository iscrizioneRepository) {
		super();
		this.corsoRepository = corsoRepository;
		this.dipartimentoRepository = dipartimentoRepository;
		this.iscrizioneRepository = iscrizioneRepository; // 👈 Fondamentale!
	}
	
	public List<CorsoDTO> trovaTuttiCorsi(){
		List<Corso> corsi = corsoRepository.findAll();
	    return corsi.stream()
	            .map(CorsoMapper::toDTO)
	            .toList();
	}
	
	public Corso createCorso(Corso nuovoCorso) {
		 boolean esistecorso = corsoRepository.existsByNome(nuovoCorso.getNome());
		   if(esistecorso) {
			   throw new IllegalArgumentException("Questo corso già è presente");
		   }
		   return corsoRepository.save(nuovoCorso);
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
	
	public Corso studentiAlCorso(Long idCorso) {
		List<Iscrizione> iscrizioneCorso = iscrizioneRepository.findByCorsoIdCorso(idCorso);
		if(iscrizioneCorso.isEmpty()) {
			throw new NoSuchElementException("Nessuno studente è iscritto al corso con id "+idCorso);
		}
		Corso corso = iscrizioneCorso.get(0).getCorso();
		return corso;
	}
}
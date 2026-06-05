package it.tirocinio.minisegreteria.service;
import it.tirocinio.minisegreteria.dto.AteneoDTO;
import it.tirocinio.minisegreteria.dto.AteneoMapper;
import it.tirocinio.minisegreteria.dto.DipartimentoDTO;
import it.tirocinio.minisegreteria.dto.DipartimentoMapper;
import it.tirocinio.minisegreteria.model.Ateneo;
import it.tirocinio.minisegreteria.model.Dipartimento;
import it.tirocinio.minisegreteria.repository.AteneoRepository;
import it.tirocinio.minisegreteria.repository.DipartimentoRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class DipartimentoService {
   private DipartimentoRepository dipartimentoRepository;
   private AteneoRepository ateneoRepository;

   public DipartimentoService(DipartimentoRepository dipartimentoRepository, AteneoRepository ateneoRepository) {
	this.dipartimentoRepository = dipartimentoRepository;
	this.ateneoRepository = ateneoRepository;
   }
  




   public List<DipartimentoDTO> trovaTuttiDipartimenti() {
	    List<Dipartimento> dipartimenti = dipartimentoRepository.findAll();
	    
	    return dipartimenti.stream()
	            .map(DipartimentoMapper::toDTO)
	            .toList(); 
	}
   
   
	
	public Dipartimento createDipartimento(Dipartimento nuovoDipartimento) {
	   boolean esistedip = dipartimentoRepository.existsByNomeDipartimento(nuovoDipartimento.getNome());
	   if(esistedip) {
		   throw new IllegalArgumentException("Questo dipartimento già esiste");
	   }
	   Long ateneoId = nuovoDipartimento.getAteneo().getAteneoId();
	   Ateneo ateneo = ateneoRepository.findById(ateneoId) 
			   .orElseThrow(()->  new NoSuchElementException("Ateneo non trovato con ID " + ateneoId));
	   nuovoDipartimento.setAteneo(ateneo);
	   return dipartimentoRepository.save(nuovoDipartimento);
   }
   
   
   
	public Map<String, Object> getAteneoById(Long ateneoId) {
	    List<Dipartimento> dipartimenti = dipartimentoRepository.findByAteneoId(ateneoId);	   
	    if (dipartimenti.isEmpty()) {
	        throw new NoSuchElementException("Nessun dipartimento trovato per l'Ateneo con ID " + ateneoId);
	    }
	    
	     List<DipartimentoDTO> dipartimento = dipartimenti.stream()
	            .map(DipartimentoMapper::toDTO)
	            .toList();
	     
	     Ateneo ateneo = dipartimenti.get(0).getAteneo();
	     AteneoDTO ateneoDTO = AteneoMapper.toDTO(ateneo);

	     Map<String, Object> risultato = new LinkedHashMap<>();
	     risultato.put("ateneo", ateneoDTO);
	     risultato.put("dipartimenti", dipartimento);
	     
	     
	     return risultato;
	}
   
}
   
 

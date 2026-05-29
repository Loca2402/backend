package it.tirocinio.minisegreteria.dto;

import it.tirocinio.minisegreteria.dto.CorsoDTO;
import it.tirocinio.minisegreteria.model.Ateneo;
import it.tirocinio.minisegreteria.model.Corso;
import it.tirocinio.minisegreteria.model.Dipartimento;

public class CorsoMapper {

    public static CorsoDTO toDTO(Corso corso) {
        if (corso == null) {
            return null;
        }
        
        CorsoDTO dto = new CorsoDTO();
        dto.setIdCorso(corso.getIdCorso());
        dto.setCodice(corso.getCodice());
        dto.setNome(corso.getNome());
        dto.setAnnoAccademico(corso.getAnnoAccademico());
        dto.setTipoTitolo(corso.getTipoTitolo());
        
        if(corso.getDipartimento() != null) {
        		Dipartimento dipartimento = corso.getDipartimento();
        		
        		DipartimentoDTO dipDTO = new DipartimentoDTO();
        		dipDTO.setId(dipartimento.getId());
        		dipDTO.setCodice(dipartimento.getCodice());
        		dipDTO.setNome(dipartimento.getNome());
        		
        		dto.setDipartimento(dipDTO);
	       
        		if(dipartimento.getAteneo() != null) {
        			Ateneo ateneo = dipartimento.getAteneo();
        			
        			AteneoDTO ateneoDTO = new AteneoDTO();
        			ateneoDTO.setNome(ateneo.getNome());
        			ateneoDTO.setAteneoId(ateneo.getAteneoId());
        			ateneoDTO.setCodice(ateneo.getCodice()); 
        			ateneoDTO.setCitta(ateneo.getCitta());
        			
        			dto.setAteneo(ateneoDTO);
        		}
        }
        
        return dto;
    }
}
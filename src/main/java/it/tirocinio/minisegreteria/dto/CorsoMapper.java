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
        
        Dipartimento dip = corso.getDipartimento();
        
        Ateneo ateneo = (dip != null )?dip.getAteneo() : null;
        
        return new CorsoDTO(
                corso.getIdCorso(),
                corso.getCodice(),
                corso.getNome(),
                corso.getAnnoAccademico(),
                corso.getTipoTitolo(),
                (dip != null ) ? dip.getCodice() : null,
                	(dip != null ) ? dip.getNome() : null,
                	(ateneo != null) ? ateneo.getCodice() : null,
                	(ateneo != null) ? ateneo.getNome() : null
                );
                
        }
    
    public static Corso toModel(CorsoDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Corso corso = new Corso();
        corso.setIdCorso(dto.getIdCorso());
        corso.setCodice(dto.getCodice());
        corso.setNome(dto.getNome());
        corso.setAnnoAccademico(dto.getAnnoAccademico());
        corso.setTipoTitolo(dto.getTipoTitolo());
        
        // Nota: Il dipartimento NON lo settiamo qui perché lo cerchi 
        // e lo associ direttamente nel Service tramite il codice!
        
        return corso;
    }
}

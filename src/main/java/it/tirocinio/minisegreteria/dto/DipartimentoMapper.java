package it.tirocinio.minisegreteria.dto;

import it.tirocinio.minisegreteria.dto.DipartimentoDTO;
import it.tirocinio.minisegreteria.model.Ateneo;
import it.tirocinio.minisegreteria.model.Dipartimento;

public class DipartimentoMapper {

    public static DipartimentoDTO toDTO(Dipartimento dipartimento) {
        if (dipartimento == null) {
            return null;
        }
        
        Ateneo ateneo = dipartimento.getAteneo();

        return new DipartimentoDTO(
            dipartimento.getId(),
            dipartimento.getCodice(),
            dipartimento.getNome(),
            (ateneo != null) ? ateneo.getAteneoId() : null,
            	(ateneo != null) ? ateneo.getNome() : null, 
            	(ateneo != null) ? ateneo.getCodice() : null 
        );
    }
}

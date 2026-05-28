package it.tirocinio.minisegreteria.dto;

import it.tirocinio.minisegreteria.dto.CorsoDTO;
import it.tirocinio.minisegreteria.model.Corso;

public class CorsoMapper {

    public static CorsoDTO toDTO(Corso corso) {
        if (corso == null) {
            return null;
        }

        return new CorsoDTO(
            corso.getIdCorso(), 
            corso.getCodice(),
            corso.getNome(),
            corso.getAnnoAccademico(),
            corso.getTipoTitolo()
        );
    }
}
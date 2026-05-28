package it.tirocinio.minisegreteria.dto;

import it.tirocinio.minisegreteria.model.Ateneo;
import it.tirocinio.minisegreteria.model.Dipartimento;

public class AteneoMapper {
	public static AteneoDTO toDTO(Ateneo ateneo) {
        if (ateneo == null) {
            return null;
        }

        return new AteneoDTO(
        		 ateneo.getAteneoId(),
        		 ateneo.getCodice(),
        		 ateneo.getNome(),
        		 ateneo.getCitta()
        );
    }
}


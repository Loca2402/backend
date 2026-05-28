package it.tirocinio.minisegreteria.dto;

import it.tirocinio.minisegreteria.dto.DipartimentoDTO;
import it.tirocinio.minisegreteria.model.Dipartimento;

public class DipartimentoMapper {

    public static DipartimentoDTO toDTO(Dipartimento dipartimento) {
        if (dipartimento == null) {
            return null;
        }

        return new DipartimentoDTO(
            dipartimento.getId(),
            dipartimento.getCodice(),
            dipartimento.getNome()
        );
    }
}

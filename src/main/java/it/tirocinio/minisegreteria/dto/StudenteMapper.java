package it.tirocinio.minisegreteria.dto;

import it.tirocinio.minisegreteria.dto.StudenteDTO;
import it.tirocinio.minisegreteria.model.Studente;

public class StudenteMapper {

    public static StudenteDTO toDTO(Studente studente) {
        if (studente == null) {
            return null;
        }

        return new StudenteDTO(
            studente.getMatricola(),
            studente.getNome(),
            studente.getCognome(),
            studente.getRecapito(),
            studente.getIscrizione()
            
        );
    }
}

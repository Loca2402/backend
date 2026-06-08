package it.tirocinio.minisegreteria.dto;

import it.tirocinio.minisegreteria.dto.RecapitoDTO;
import it.tirocinio.minisegreteria.model.Recapito;

public class RecapitoMapper {

    public static RecapitoDTO toDTO(Recapito entity) {
        if (entity == null) {
            return null;
        }
        RecapitoDTO dto = new RecapitoDTO();
        dto.setEmail(entity.getEmail());
        dto.setTelefono(entity.getTelefono());
        dto.setIndirizzo(entity.getIndirizzo());
        dto.setComune(entity.getComune());
        dto.setCap(entity.getCap());
        return dto;
    }

    public static Recapito toEntity(RecapitoDTO dto) {
        if (dto == null) {
            return null;
        }
        Recapito entity = new Recapito();
        entity.setEmail(dto.getEmail());
        entity.setTelefono(dto.getTelefono());
        entity.setIndirizzo(dto.getIndirizzo());
        entity.setComune(dto.getComune());
        entity.setCap(dto.getCap());
        return entity;
    }
}
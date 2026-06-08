package it.tirocinio.minisegreteria.dto;

import it.tirocinio.minisegreteria.dto.StudenteDTO;
import it.tirocinio.minisegreteria.model.Studente;

public class StudenteMapper {

	public static StudenteDTO toDTO(Studente entity) {
	    if (entity == null) {
	        return null;
	    }
	    
	    StudenteDTO dto = new StudenteDTO();
	    dto.setId(entity.getId());
	    dto.setNome(entity.getNome());
	    dto.setCognome(entity.getCognome());
	    dto.setMatricola(entity.getMatricola());
	    dto.setDataNascita(entity.getDataNascita());
        dto.setCodiceFiscale(entity.getCodiceFiscale());
        dto.setSesso(entity.getSesso());
	    
	    if (entity.getRecapito() != null) {
	        dto.setRecapito(RecapitoMapper.toDTO(entity.getRecapito()));
	    }
	    
	    return dto;
	}
    
    
    public static Studente toEntity(StudenteDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Studente entity = new Studente();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCognome(dto.getCognome());
        entity.setMatricola(dto.getMatricola());
        entity.setDataNascita(dto.getDataNascita()); 
        entity.setCodiceFiscale(dto.getCodiceFiscale());
        entity.setSesso(dto.getSesso());
        
        if (dto.getRecapito() != null) {
            entity.setRecapito(RecapitoMapper.toEntity(dto.getRecapito()));
        }
        
        return entity;
    }
}

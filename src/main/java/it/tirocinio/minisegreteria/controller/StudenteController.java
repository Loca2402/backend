package it.tirocinio.minisegreteria.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.tirocinio.minisegreteria.dto.StudenteDTO;
import it.tirocinio.minisegreteria.dto.StudenteMapper;
import it.tirocinio.minisegreteria.model.Iscrizione;
import it.tirocinio.minisegreteria.model.Recapito;
import it.tirocinio.minisegreteria.model.Studente;
import it.tirocinio.minisegreteria.response.ApiResponse;
import it.tirocinio.minisegreteria.service.IscrizioneService;
import it.tirocinio.minisegreteria.service.StudenteService;


@RestController
@RequestMapping("api/studenti")
@CrossOrigin(origins="http://localhost:4200")
public class StudenteController {
	private StudenteService studenteService;
	private IscrizioneService iscrizioneService;

	public StudenteController(StudenteService studenteService, IscrizioneService iscrizioneService) {
		super();
		this.studenteService = studenteService;
		this.iscrizioneService = iscrizioneService;
	}
	
	@GetMapping("")
	public ResponseEntity<ApiResponse<List<StudenteDTO>>> listaStudenti() {
	    List<StudenteDTO> studenti = studenteService.trovaStudenti();
	    ApiResponse<List<StudenteDTO>> response = new ApiResponse<>(studenti);
	    return ResponseEntity.ok(response);
	}
	
	@PostMapping("") 
	public ResponseEntity<ApiResponse<Studente>> creaStudente(@RequestBody StudenteDTO studenteDTO) {
		Studente nuovoStudente = studenteService.createStudente(studenteDTO);
		ApiResponse<Studente> response = new ApiResponse<>(nuovoStudente);
		response.setId(nuovoStudente.getId());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<StudenteDTO>> dettaglioStudente(@PathVariable Long id) {
	    // 1. Cerchi l'entità
	    Studente studente = studenteService.cercaStudente(id);
	    
	    // 2. Mappi direttamente dentro l'ApiResponse in un colpo solo
	    ApiResponse<StudenteDTO> response = new ApiResponse<>(StudenteMapper.toDTO(studente));
	    response.setId(id);
	    
	    return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/search")
	public ResponseEntity<ApiResponse<List<Studente>>> ricercaStudente(
		@RequestParam(value="id", required=false) Long id,
		@RequestParam(value="matricola", required=false) Integer matricola) {
	    List<Studente> studenti = studenteService.ricercaStudente(id, matricola);
	   
	    ApiResponse<List<Studente>> response = new ApiResponse<>(studenti);
	    return ResponseEntity.ok(response);
	}
	@GetMapping("/{idStudente}/iscrizioni")
	public ResponseEntity<ApiResponse<List<Iscrizione>>> studentiIscrittiACorso(@PathVariable Long idStudente) {
		List<Iscrizione> iscrizioni = iscrizioneService.trovaIscrizioneStudente(idStudente);
		ApiResponse<List<Iscrizione>> response = new ApiResponse<>(iscrizioni);
		return ResponseEntity.ok(response);
	}

}

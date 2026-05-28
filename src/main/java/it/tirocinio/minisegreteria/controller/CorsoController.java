package it.tirocinio.minisegreteria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.tirocinio.minisegreteria.dto.CorsoDTO;
import it.tirocinio.minisegreteria.dto.CorsoMapper;
import it.tirocinio.minisegreteria.model.Corso;
import it.tirocinio.minisegreteria.model.Dipartimento;
import it.tirocinio.minisegreteria.model.Iscrizione;
import it.tirocinio.minisegreteria.model.Studente;
import it.tirocinio.minisegreteria.response.ApiResponse;
import it.tirocinio.minisegreteria.service.CorsoService;
import it.tirocinio.minisegreteria.service.IscrizioneService;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/corsi")
public class CorsoController {
	private CorsoService corsoService;
	private IscrizioneService iscrizioneService;

	public CorsoController(CorsoService corsoService, IscrizioneService iscrizioneService) {
		super();
		this.corsoService = corsoService;
		this.iscrizioneService = iscrizioneService;
	}
	
	@GetMapping("")
	public ResponseEntity<ApiResponse<List<CorsoDTO>>> listaCorsi() {
	    List<CorsoDTO> corsi = corsoService.trovaTuttiCorsi(); 
	    ApiResponse<List<CorsoDTO>> response = new ApiResponse<>(corsi);
	    return ResponseEntity.ok(response);
	}
	
	@PostMapping("")
	public ResponseEntity<ApiResponse<Corso>> creaCorso(@RequestBody Corso corso) {
		Corso nuovoCorso = corsoService.createCorso(corso);
		ApiResponse<Corso> response = new ApiResponse<>(nuovoCorso);
		response.setId(nuovoCorso.getIdCorso());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/{idCorso}")
	public ResponseEntity<ApiResponse<CorsoDTO>> dettaglioCorso(@PathVariable Long idCorso) {
		Corso corso = corsoService.cercaCorso(idCorso);
		CorsoDTO corsoDTO = CorsoMapper.toDTO(corso);
        return ResponseEntity.ok(new ApiResponse<>(corsoDTO));
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<ApiResponse<List<CorsoDTO>>> ricercaCorsi(@RequestParam(value="nome", required=false, defaultValue="") String nome,
			@RequestParam(value="tipoTitolo", required=false, defaultValue="")String tipoTitolo,
			@RequestParam(value="annoAccademico", required=false, defaultValue="") String annoAccademico) {
	    List<CorsoDTO> corsi = corsoService.ricercaCorso(nome, tipoTitolo, annoAccademico);
	    ApiResponse<List<CorsoDTO>> response = new ApiResponse<>(corsi);
	    
	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{idCorso}/iscritti")
	public ResponseEntity<ApiResponse<Corso>> corsiConIscrizioni(@PathVariable Long idCorso) {
		Corso corso = corsoService.studentiAlCorso(idCorso);
		ApiResponse<Corso> response = new ApiResponse<>(corso);
		response.setId(idCorso);
		return ResponseEntity.ok(response);
	}
}

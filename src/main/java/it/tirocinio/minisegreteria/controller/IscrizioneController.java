package it.tirocinio.minisegreteria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.tirocinio.minisegreteria.model.Dipartimento;
import it.tirocinio.minisegreteria.model.Iscrizione;
import it.tirocinio.minisegreteria.response.ApiResponse;
import it.tirocinio.minisegreteria.service.IscrizioneService;

@RestController
@RequestMapping("api/iscrizioni")
public class IscrizioneController {
	private IscrizioneService iscrizioneService;
	
	
	
	public IscrizioneController(IscrizioneService iscrizioneService) {
		super();
		this.iscrizioneService = iscrizioneService;
	}



	@PostMapping("")
	public ResponseEntity<ApiResponse<Iscrizione>> IscriviStudenteACorso(@RequestBody Iscrizione iscrizione ) {
		Long idStudente = iscrizione.getStudente().getIdStudente();
		Long idCorso = iscrizione.getCorso().getIdCorso();
		
		Iscrizione nuovaIscrizione = iscrizioneService.creaIscrizione(idStudente, idCorso, iscrizione);
		ApiResponse<Iscrizione> response = new ApiResponse<>(nuovaIscrizione);
		response.setId(nuovaIscrizione.getId());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PatchMapping("/{id}/stato")
	public ResponseEntity<ApiResponse<Iscrizione>> CambioStatoIscrizione
													(@PathVariable Long id, @RequestParam String stato) {
		Iscrizione aggiornaIscrizione = iscrizioneService.aggiornaStato(id, stato);
		ApiResponse<Iscrizione> response = new ApiResponse<>(aggiornaIscrizione);
		response.setId(aggiornaIscrizione.getId());
		return ResponseEntity.ok(response);
	}

}

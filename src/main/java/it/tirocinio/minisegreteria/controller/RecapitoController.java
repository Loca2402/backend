package it.tirocinio.minisegreteria.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.tirocinio.minisegreteria.model.Recapito;
import it.tirocinio.minisegreteria.response.ApiResponse;
import it.tirocinio.minisegreteria.service.RecapitoService;

@RestController
@RequestMapping("api/studenti")
public class RecapitoController {
	@Autowired
	private RecapitoService recapitoService;
	
	@PostMapping("/{id}/recapiti")
	
	public ResponseEntity <ApiResponse<Recapito>> creaRecapito(@PathVariable Long id, @RequestBody Recapito recapito) {
		Recapito nuovoRecapito = recapitoService.creaRecapitoPerStudente(id, recapito);
		ApiResponse<Recapito> response = new ApiResponse<>(nuovoRecapito);
		response.setId(nuovoRecapito.getId());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}/recapiti")
	public ResponseEntity <ApiResponse<Recapito>> restituisciRecapito(@PathVariable Long id) {
		Recapito recapito = recapitoService.getRecapitoByStudente(id);
		ApiResponse<Recapito> response = new ApiResponse<>(recapito);
		response.setId(id);
		return ResponseEntity.ok(response);
		
		
	}
}

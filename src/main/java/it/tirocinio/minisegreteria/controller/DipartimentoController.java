package it.tirocinio.minisegreteria.controller;

import java.util.List;
import java.util.Map;

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

import it.tirocinio.minisegreteria.dto.DipartimentoDTO;
import it.tirocinio.minisegreteria.model.Dipartimento;
import it.tirocinio.minisegreteria.model.Studente;
import it.tirocinio.minisegreteria.response.ApiResponse;
import it.tirocinio.minisegreteria.service.AteneoService;
import it.tirocinio.minisegreteria.service.DipartimentoService;

@RestController
@RequestMapping("/api/dipartimenti")
@CrossOrigin(origins="http://localhost:4200")
public class DipartimentoController {
	private DipartimentoService dipartimentoService;


	public DipartimentoController(DipartimentoService dipartimentoService) {
		super();
		this.dipartimentoService = dipartimentoService;
	}
	
	
	@GetMapping("")
	public ResponseEntity<ApiResponse<List<DipartimentoDTO>>> listaDipartimenti() {
	    List<DipartimentoDTO> dipartimenti = dipartimentoService.trovaTuttiDipartimenti();
	    ApiResponse<List<DipartimentoDTO>> response = new ApiResponse<>(dipartimenti);
	    return ResponseEntity.ok(response);
	}
	
	@PostMapping("")
	public ResponseEntity<ApiResponse<Dipartimento>> creaDipartimento(@RequestBody Dipartimento dipartimento ) {
		Dipartimento nuovoDipartimento = dipartimentoService.createDipartimento(dipartimento);
		ApiResponse<Dipartimento> response = new ApiResponse<>(nuovoDipartimento);
		response.setId(nuovoDipartimento.getId());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/by-ateneo/{ateneoId}")
	public ResponseEntity<ApiResponse<Map<String,Object>>> dipartimentiDiUnAteneo(@PathVariable Long ateneoId , String nome) {
	    Map<String, Object> lista = dipartimentoService.getAteneoById(ateneoId); 
	    ApiResponse<Map<String,Object>> response = new ApiResponse<>(lista);
	    response.setId(ateneoId);
	    return ResponseEntity.ok(response);
	}
}

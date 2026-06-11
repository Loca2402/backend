package it.tirocinio.minisegreteria.controller;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.tirocinio.minisegreteria.dto.DipartimentoDTO;
import it.tirocinio.minisegreteria.model.Corso;
import it.tirocinio.minisegreteria.model.Dipartimento;
import it.tirocinio.minisegreteria.model.Studente;
import it.tirocinio.minisegreteria.repository.CorsoRepository;
import it.tirocinio.minisegreteria.repository.DipartimentoRepository;
import it.tirocinio.minisegreteria.response.ApiResponse;
import it.tirocinio.minisegreteria.service.AteneoService;
import it.tirocinio.minisegreteria.service.DipartimentoService;
import it.tirocinio.minisegreteria.dto.DipartimentoMapper;

@RestController
@RequestMapping("/api/dipartimenti")
@CrossOrigin(origins="http://localhost:4200")
public class DipartimentoController {
	private DipartimentoService dipartimentoService;
	
	@Autowired
	private DipartimentoRepository dipartimentoRepository;
	
	


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
	public ResponseEntity<ApiResponse<DipartimentoDTO>> creaDipartimento(@RequestBody Dipartimento dipartimento ) {
		Dipartimento nuovoDipartimento = dipartimentoService.createDipartimento(dipartimento);
		DipartimentoDTO dto = DipartimentoMapper.toDTO(nuovoDipartimento);
		ApiResponse<DipartimentoDTO> response = new ApiResponse<>(dto);
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Dipartimento>> eliminaCorso(@PathVariable Long id) {
		Dipartimento cancDip = dipartimentoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Dipartimento non trovato con ID: " + id));
	    dipartimentoService.cancellaDipartimento(id);
	    ApiResponse<Dipartimento> response = new ApiResponse<>(cancDip);
	    response.setId(cancDip.getId());
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
}

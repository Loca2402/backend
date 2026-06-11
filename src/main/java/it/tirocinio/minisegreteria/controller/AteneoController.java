package it.tirocinio.minisegreteria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.tirocinio.minisegreteria.model.Ateneo;
import it.tirocinio.minisegreteria.response.ApiResponse;
import it.tirocinio.minisegreteria.service.AteneoService;

@RestController
@RequestMapping("/api/atenei")
@CrossOrigin(origins="http://localhost:4200")
public class AteneoController {
	private AteneoService ateneoService;
	
	public AteneoController(AteneoService ateneoService) {
		super();
		this.ateneoService = ateneoService;
	}
	@GetMapping("")
    public ResponseEntity<ApiResponse<List<Ateneo>>> trovaTuttiAtenei() {
        List<Ateneo> ateneo = ateneoService.trovaTuttiAtenei();
        ApiResponse<List<Ateneo>> response = new ApiResponse<>(ateneo);
        return ResponseEntity.ok(response);
	}
	
	
	
	@PostMapping("")
    public ResponseEntity<ApiResponse<Ateneo>> creaAteneo(@RequestBody Ateneo ateneo) {
        Ateneo nuovoAteneo = ateneoService.createAteneo(ateneo);
        
        ApiResponse<Ateneo> response = new ApiResponse<>(nuovoAteneo);
        response.setId(nuovoAteneo.getAteneoId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
	
	
	
	
	
	@GetMapping("/{ateneoId}")
	public ResponseEntity<ApiResponse<Ateneo>> dettaglioAteneo(@PathVariable Long ateneoId) {
	    Ateneo ateneo = ateneoService.cercaAteneo(ateneoId);
	    ApiResponse<Ateneo> response = new ApiResponse<>(ateneo);
	    response.setId(ateneoId); 
	    return ResponseEntity.ok(response);
	}
	
	
	@DeleteMapping("/{ateneoId}")
	public ResponseEntity<ApiResponse<Ateneo>> eliminaAteneo(@PathVariable Long ateneoId) {
	    Ateneo cancAteneo = ateneoService.cercaAteneo(ateneoId);
	    ateneoService.cancellaAteneo(ateneoId);
	    ApiResponse<Ateneo> response = new ApiResponse<>(cancAteneo);
	    response.setId(cancAteneo.getAteneoId());
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

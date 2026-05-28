package it.tirocinio.minisegreteria.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HealthController {
    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of("STATUS", "UP");
    }
}

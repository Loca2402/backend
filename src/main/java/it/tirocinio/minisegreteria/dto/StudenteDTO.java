package it.tirocinio.minisegreteria.dto;

import java.util.List;

import it.tirocinio.minisegreteria.model.Iscrizione;
import it.tirocinio.minisegreteria.model.Recapito;

public class StudenteDTO {
    
    private Integer matricola;
    private String nome;
    private String cognome;

    public StudenteDTO() {
        super();
    }

    public StudenteDTO(Integer matricola, String nome, String cognome, Recapito recapito, List<Iscrizione> iscrizione) {
        super();
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
    }

    // Getter e Setter
    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
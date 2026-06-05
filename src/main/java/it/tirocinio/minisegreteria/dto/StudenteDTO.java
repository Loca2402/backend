package it.tirocinio.minisegreteria.dto;

import java.util.List;

import it.tirocinio.minisegreteria.model.Iscrizione;
import it.tirocinio.minisegreteria.model.Recapito;

public class StudenteDTO {
    private Long id;
    private Integer matricola;
    private String nome;
    private String cognome;

    public StudenteDTO() {
        super();
    }

    public StudenteDTO(Long id, Integer matricola, String nome, String cognome, Recapito recapito, List<Iscrizione> iscrizione) {
        super();
        this.id = id;
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
    }

    // Getter e Setter
    public Integer getMatricola() {
        return matricola;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
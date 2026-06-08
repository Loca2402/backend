package it.tirocinio.minisegreteria.dto;

import java.time.LocalDate;
import java.util.List;

import it.tirocinio.minisegreteria.model.Iscrizione;
import it.tirocinio.minisegreteria.model.Recapito;

public class StudenteDTO {
    private Long id;
    private String matricola;
    private String nome;
    private String cognome;
    private RecapitoDTO recapito;
    private LocalDate dataNascita; 
    private String codiceFiscale;
    private Character sesso;

    public StudenteDTO() {
        super();
    }

    public StudenteDTO(Long id, String matricola, String nome, String cognome, Recapito recapito, List<Iscrizione> iscrizione) {
        super();
        this.id = id;
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
    }

    // Getter e Setter
    public String getMatricola() {
        return matricola;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMatricola(String matricola) {
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

	public RecapitoDTO getRecapito() {
		return recapito;
	}

	public void setRecapito(RecapitoDTO recapito) {
		this.recapito = recapito;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Character getSesso() {
		return sesso;
	}

	public void setSesso(Character sesso) {
		this.sesso = sesso;
	}
    
    
}
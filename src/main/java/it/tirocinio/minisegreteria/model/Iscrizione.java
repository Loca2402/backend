package it.tirocinio.minisegreteria.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="iscrizioni")
@JsonPropertyOrder({"id", "annoAccademico", "stato", "dataIscrizione", "studente"})
public class Iscrizione {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="studente_id",nullable=false)
	@JsonIgnoreProperties("iscrizioni")
	private Studente studente;
	
	@JsonIgnoreProperties("iscrizioni")
	@ManyToOne
    @JoinColumn(name = "corso_id")
    private Corso corso;
	
	@Column
	private String annoAccademico;
	
	@Column
	@Enumerated(EnumType.STRING)
	private StatoIscrizione stato;
	
	@Column
	private LocalDate dataIscrizione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public Corso getCorso() {
		return corso;
	}

	public void setCorso(Corso corso) {
		this.corso = corso;
	}

	public String getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(String annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public StatoIscrizione getStato() {
		return stato;
	}

	public void setStato(StatoIscrizione stato) {
		this.stato = stato;
	}

	public LocalDate getDataIscrizione() {
		return dataIscrizione;
	}

	public void setDataIscrizione(LocalDate dataIscrizione) {
		this.dataIscrizione = dataIscrizione;
	}

	public Iscrizione(Long id, Studente studente, Corso corso, String annoAccademico, StatoIscrizione stato,
			LocalDate dataIscrizione) {
		super();
		this.id = id;
		this.studente = studente;
		this.corso = corso;
		this.annoAccademico = annoAccademico;
		this.stato = stato;
		this.dataIscrizione = dataIscrizione;
	}

	public Iscrizione() {
		super();
	}
	
	
}



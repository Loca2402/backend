package it.tirocinio.minisegreteria.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="studenti")
public class Studente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String matricola;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String cognome;
	@Column(nullable=false)
	private LocalDate dataNascita;
	@Column
	private String codiceFiscale;
	@Column
	private Character sesso;
	
//	@ManyToOne
//	@JoinColumn(name="corso_id")
//	@JsonIgnoreProperties("studenti")
//	private Corso corso;
	
	@OneToOne(mappedBy="studente", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonIgnoreProperties("studente")
	private Recapito recapito;
	
	@OneToMany(mappedBy="studente", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("studente")
	private List<Iscrizione> iscrizione;
	
	
	public Studente() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricola() {
		return matricola;
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
	
//	public Corso getCorso() {
//		return corso;
//	}
//	public void setCorso(Corso corso) {
//		this.corso = corso;
//	}
	public Recapito getRecapito() {
		return recapito;
	}
	public void setRecapito(Recapito recapito) {
		this.recapito = recapito;
	}
	public List<Iscrizione> getIscrizione() {
		return iscrizione;
	}
	public void setIscrizione(List<Iscrizione> iscrizione) {
		this.iscrizione = iscrizione;
	}
	public Studente(Long id, String matricola, String nome, String cognome, LocalDate dataNascita, String codiceFiscale,
			Character sesso) { 
		super();
		this.id = id;
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.codiceFiscale = codiceFiscale;
		this.sesso = sesso;
	}
}
package it.tirocinio.minisegreteria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="recapito")
public class Recapito {
	@Id
	@JsonIgnore
	private Long id;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(unique=true, nullable=false)
	private String telefono;
	
	@Column(unique=true, nullable=false)
	private String indirizzo;
	
	@Column
	private String comune;
	
	@Column
	private Integer cap;
	
	@OneToOne
	@JoinColumn(name="studente_id", referencedColumnName = "id")
	@MapsId
	@JsonIgnoreProperties("recapito")
	private Studente studente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public Recapito(Long id, String email, String telefono, String indirizzo, String comune, Integer cap,
			Studente studente) {
		super();
		this.id = id;
		this.email = email;
		this.telefono = telefono;
		this.indirizzo = indirizzo;
		this.comune = comune;
		this.cap = cap;
		this.studente = studente;
	}

	public Recapito() {
		super();
	}
}

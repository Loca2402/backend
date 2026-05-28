package it.tirocinio.minisegreteria.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;
@Entity
@Table(name="corsi")
@JsonPropertyOrder({"idCorso", "codice", "nome", "annoAccademico", "tipoTitolo", "dipartimento"})
public class Corso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCorso;
	@Column(unique=true)
	private Integer codice;
	@Column(unique=true)
	private String nome;
	@Column
	private String annoAccademico;
	@Column
	private String tipoTitolo;
	@ManyToOne
	@JoinColumn(name="dipartimento_id",nullable=false)
	@JsonIgnoreProperties("corsi")
	@JsonIgnore
	private Dipartimento dipartimento;
	
//	@OneToMany(mappedBy="corso")
//	@JsonInclude(JsonInclude.Include.NON_EMPTY)
//	@JsonIgnoreProperties("corso")
//	private List<Studente> studenti;
	
	@OneToMany(mappedBy="corso", cascade=CascadeType.ALL)
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@JsonIgnoreProperties("corso")
	private List<Iscrizione> iscrizioni;
	
	public Corso(Long idCorso, Integer codice, String nome, String anno_accademico, String tipo_titolo,
			Dipartimento dipartimento) {
		super();
		this.idCorso = idCorso;
		this.codice = codice;
		this.nome = nome;
		this.annoAccademico = anno_accademico;
		this.tipoTitolo = tipo_titolo;
		this.dipartimento = dipartimento;
	}
	
	public Corso() {
		super();
	}
	
	public Long getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(Long idCorso) {
		this.idCorso = idCorso;
	}
	public Integer getCodice() {
		return codice;
	}
	public void setCodice(Integer codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public String getAnnoAccademico() {
		return annoAccademico;
	}

	public void setAnnoAccademico(String annoAccademico) {
		this.annoAccademico = annoAccademico;
	}

	public String getTipoTitolo() {
		return tipoTitolo;
	}

	public void setTipoTitolo(String tipoTitolo) {
		this.tipoTitolo = tipoTitolo;
	}

//	public List<Studente> getStudenti() {
//		return studenti;
//	}
//
//	public void setStudenti(List<Studente> studenti) {
//		this.studenti = studenti;
//	}

	public List<Iscrizione> getIscrizione() {
		return iscrizioni;
	}

	public void setIscrizione(List<Iscrizione> iscrizione) {
		this.iscrizioni = iscrizioni;
	}
}

package it.tirocinio.minisegreteria.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.*;

@Entity
@Table(name = "dipartimenti")
@JsonPropertyOrder({"id","codice","nome","ateneo"})
public class Dipartimento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private Integer codice;
    @Column
    private String nome;
    @ManyToOne
    @JoinColumn(name="ateneo_id", nullable=false)
    @JsonIgnoreProperties("dipartimenti")
    private Ateneo ateneo;
    
    @OneToMany(mappedBy = "dipartimento", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"dipartimento", "corsi", "studenti"})
    private List<Corso> corsi;

    public Dipartimento() {
    }

    public Dipartimento(Integer codice, String nome, Ateneo ateneo) {
        this.codice = codice;
        this.nome = nome;
        this.ateneo = ateneo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Ateneo getAteneo() {
        return ateneo;
    }

    public void setAteneo(Ateneo ateneo) {
        this.ateneo = ateneo;
    }

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
    
    

}

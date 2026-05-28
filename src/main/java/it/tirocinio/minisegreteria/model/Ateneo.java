package it.tirocinio.minisegreteria.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "atenei")
public class Ateneo {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long ateneoId;

    @Column(unique=true)
    private Integer codice;

    @Column
    @NotBlank
    private String nome;

    @Column
    @NotBlank
    private String citta;
    
    @OneToMany(mappedBy = "ateneo", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("ateneo")
    private List<Dipartimento> dipartimenti;


    public Ateneo() {
    }

    public Ateneo(String nome, String citta, Integer codice) {
        this.nome = nome;
        this.citta = citta;
        this.codice = codice;
    }

    public Long getAteneoId() {
        return ateneoId;
    }

    public void setId(Long ateneoId) {
        this.ateneoId = ateneoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }
}


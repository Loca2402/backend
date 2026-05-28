package it.tirocinio.minisegreteria.dto;

import java.util.List;

public class CorsoDTO {
    
    private Long idCorso;
    private Integer codice;
    private String nome;
    private String annoAccademico;
    private String tipoTitolo;

    // Costruttore vuoto
    public CorsoDTO() {}

    // Costruttore completo
    public CorsoDTO(Long idCorso, Integer codice, String nome, String annoAccademico, String tipoTitolo) {
        this.idCorso = idCorso;
        this.codice = codice;
        this.nome = nome;
        this.annoAccademico = annoAccademico;
        this.tipoTitolo = tipoTitolo;
    }

    // Getter e Setter per il Corso
    public Long getIdCorso() { return idCorso; }
    public void setIdCorso(Long idCorso) { this.idCorso = idCorso; }
    public Integer getCodice() { return codice; }
    public void setCodice(Integer codice) { this.codice = codice; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getAnnoAccademico() { return annoAccademico; }
    public void setAnnoAccademico(String annoAccademico) { this.annoAccademico = annoAccademico; }
    public String getTipoTitolo() { return tipoTitolo; }
    public void setTipoTitolo(String tipoTitolo) { this.tipoTitolo = tipoTitolo; }
  
    
}
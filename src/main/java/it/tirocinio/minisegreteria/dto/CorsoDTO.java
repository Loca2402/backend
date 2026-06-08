package it.tirocinio.minisegreteria.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({"nome","idCorso","codice","nome","annoAccademico","tipoTitolo","dipartimento", "ateneo"})
public class CorsoDTO {
    
    private Long idCorso;
    private Integer codice;
    private String nome;
    private String annoAccademico;
    private String tipoTitolo;
    
    private String nomeDipartimento;
	private Integer codiceDipartimento;
    private Integer codiceAteneo;
    private String nomeAteneo;
    

    public Integer getCodiceDipartimento() {
		return codiceDipartimento;
	}

	public void setCodiceDipartimento(Integer codiceDipartimento) {
		this.codiceDipartimento = codiceDipartimento;
	}

	public Integer getCodiceAteneo() { return codiceAteneo; }
    public void setCodiceAteneo(Integer codiceAteneo) { this.codiceAteneo = codiceAteneo; }

    public String getNomeAteneo() { return nomeAteneo; }
    public void setNomeAteneo(String nomeAteneo) { this.nomeAteneo = nomeAteneo; }
	
	

    public String getNomeDipartimento() {
		return nomeDipartimento;
	}

	public void setNomeDipartimento(String nomeDipartimento) {
		this.nomeDipartimento = nomeDipartimento;
	}


	public CorsoDTO() {}

    public CorsoDTO(Long idCorso, Integer codice, String nome, String annoAccademico, String tipoTitolo,
    					Integer codiceDipartimento, String nomeDipartimento, Integer codiceAteneo, String nomeAteneo) {
        this.idCorso = idCorso;
        this.codice = codice;
        this.nome = nome;
        this.annoAccademico = annoAccademico;
        this.tipoTitolo = tipoTitolo;
        this.codiceDipartimento = codiceDipartimento;
        this.nomeDipartimento = nomeDipartimento;
        this.codiceAteneo = codiceAteneo;
        this.nomeAteneo = nomeAteneo;
        }

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
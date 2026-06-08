package it.tirocinio.minisegreteria.dto;

public class DipartimentoDTO {
	private Long dipartimentoId;
	private Integer codice;
	private String nome;
	private Long ateneoId;
	private String nomeAteneo;

	public DipartimentoDTO(Long dipartimentoId, Integer codice, String nome, Long ateneoId, String nomeAteneo) {
		super();
		this.dipartimentoId = dipartimentoId;
		this.codice = codice;
		this.nome = nome;
		this.ateneoId = ateneoId;
		this.nomeAteneo = nomeAteneo;
	}
	public DipartimentoDTO() {
		super();
	}
	public Long getDipartimentoId() {
		return dipartimentoId;
	}
	public void setDipartimentoId(Long dipartimentoId) {
		this.dipartimentoId = dipartimentoId;
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
	public Long getAteneoId() {
		return ateneoId;
	}
	public void setAteneoId(Long ateneoId) {
		this.ateneoId = ateneoId;
	}
	public String getNomeAteneo() {
		return nomeAteneo;
	}
	public void setNomeAteneo(String nomeAteneo) {
		this.nomeAteneo = nomeAteneo;
	}	
	
	
}

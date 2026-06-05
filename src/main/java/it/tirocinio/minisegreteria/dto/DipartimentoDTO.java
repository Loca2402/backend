package it.tirocinio.minisegreteria.dto;

public class DipartimentoDTO {
	private Long dipartimentoId;
	private Integer codiceDipartimento;
	private String nomeDipartimento;
	private Long ateneoId;
	private String nomeAteneo;

	public DipartimentoDTO(Long dipartimentoId, Integer codice, String nomeDipartimento, Long ateneoId, String nomeAteneo) {
		super();
		this.dipartimentoId = dipartimentoId;
		this.codiceDipartimento = codiceDipartimento;
		this.nomeDipartimento = nomeDipartimento;
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
	public Integer getCodiceDipartimento() {
		return codiceDipartimento;
	}
	public void setCodiceDipartimento(Integer codice) {
		this.codiceDipartimento = codiceDipartimento;
	}
	public String getNomeDipartimento() {
		return nomeDipartimento;
	}
	public void setNomeDipartimento(String nomeDipartimento) {
		this.nomeDipartimento = nomeDipartimento;
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

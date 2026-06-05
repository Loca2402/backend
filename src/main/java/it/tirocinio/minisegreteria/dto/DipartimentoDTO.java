package it.tirocinio.minisegreteria.dto;

public class DipartimentoDTO {
	private Long id;
	private Integer codice;
	private String nome;
	private Long ateneoId;
	private String nomeAteneo;

	public DipartimentoDTO(Long id, Integer codice, String nome, Long ateneoId, String nomeAteneo) {
		super();
		this.id = id;
		this.codice = codice;
		this.nome = nome;
		this.ateneoId = ateneoId;
		this.nomeAteneo = nomeAteneo;
	}
	public DipartimentoDTO() {
		super();
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

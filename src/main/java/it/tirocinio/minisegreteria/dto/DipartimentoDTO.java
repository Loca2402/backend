package it.tirocinio.minisegreteria.dto;

public class DipartimentoDTO {
	private Long id;
	private Integer codice;
	private String nome;

	public DipartimentoDTO(Long id, Integer codice, String nome) {
		super();
		this.id = id;
		this.codice = codice;
		this.nome = nome;
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
}

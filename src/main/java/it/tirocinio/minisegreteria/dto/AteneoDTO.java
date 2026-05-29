package it.tirocinio.minisegreteria.dto;

public class AteneoDTO {
	private Long ateneoId;
	private Integer codice;
	private String nome;
	private String citta;
	public AteneoDTO(Long ateneoId, Integer codice, String nome, String citta) {
		super();
		this.ateneoId = ateneoId;
		this.codice = codice;
		this.nome = nome;
		this.citta = citta;
	}
	public AteneoDTO() {
		super();
	}
	public Long getAteneoId() {
		return ateneoId;
	}
	public void setAteneoId(Long ateneoId) {
		this.ateneoId = ateneoId;
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
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
		
	
	

}

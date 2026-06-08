package it.tirocinio.minisegreteria.dto;

public class RecapitoDTO {
    
    private String email;
    private String telefono;
    private String indirizzo;
    private String comune;
    private Integer cap;

    public RecapitoDTO() {}

    public RecapitoDTO(String email, String telefono, String indirizzo, String comune, Integer cap) {
        this.email = email;
        this.telefono = telefono;
        this.indirizzo = indirizzo;
        this.comune = comune;
        this.cap = cap;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getIndirizzo() { return indirizzo; }
    public void setIndirizzo(String indirizzo) { this.indirizzo = indirizzo; }

    public String getComune() { return comune; }
    public void setComune(String comune) { this.comune = comune; }

    public Integer getCap() { return cap; }
    public void setCap(Integer cap) { this.cap = cap; }
}
package it.tirocinio.minisegreteria.response;

public class ApiResponse<T> {
	private String apiVersion = "1.0";
	private ApiError error;
	private Long id;
	private T result;
	
	public ApiResponse() {
		super();
	}

	public ApiResponse(ApiError error) {    //in caso di errore
		super();
		this.error = error;
		this.result = result;
	}
	
	public ApiResponse(T result) {    //in caso di successo
		super();
		this.result = result;
		this.error = error;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public ApiError getError() {
		return error;
	}

	public void setError(ApiError error) {
		this.error = error;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	
	
	
}

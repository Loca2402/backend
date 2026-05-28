package it.tirocinio.minisegreteria.response;

public class ApiError {
	private int httpcode;
	private String code;
	private String message;
	private String devMessage;
	
	public ApiError() {
		super();
	}
	
	public ApiError(int httpcode, String code, String message, String devMessage) {
		super();
		this.httpcode = httpcode;
		this.code = code;
		this.message = message;
		this.devMessage = devMessage;
	}

	public int getHttpcode() {
		return httpcode;
	}

	public void setHttpcode(int httpcode) {
		this.httpcode = httpcode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDevMessage() {
		return devMessage;
	}

	public void setDevMessage(String devMessage) {
		this.devMessage = devMessage;
	}
	
	
	
	

}

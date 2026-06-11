package it.tirocinio.minisegreteria.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.tirocinio.minisegreteria.response.ApiError;
import it.tirocinio.minisegreteria.response.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<ApiResponse<Void>> gestisciErroreRecapito(NoSuchElementException er) {
	
	String code = "STUDENT_NOT_FOUND";
	String message = "Studente non trovato";
	String devMessage = er.getMessage() != null ? er.getMessage().toLowerCase() : "";
	
	if (devMessage.contains("corso")) {
        code = "CORSO_NOT_FOUND";
        message = "Corso non trovato";
    } else if (devMessage.contains("ateneo")) {
        code = "ATENEO_NOT_FOUND";
        message = "Ateneo non trovato";
    } else if (devMessage.contains("dipartimento")) {
        code = "DIPARTIMENTO_NOT_FOUND";
        message = "Dipartimento non trovato";
    } else if (devMessage.contains("recapito")) {
        code = "RECAPITO_NOT_FOUND";
        message = "Recapito non trovato";
    }
	
	ApiError apiError = new ApiError(
			HttpStatus.NOT_FOUND.value(),
			code,
			message,
			er.getMessage()
			);
	ApiResponse<Void> response = new ApiResponse<>(apiError);
	return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
}



	
	

}

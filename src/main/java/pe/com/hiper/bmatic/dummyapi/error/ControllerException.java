package pe.com.hiper.bmatic.dummyapi.error;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import pe.com.hiper.bmatic.dummyapi.domain.error.ErrorATUDTO;

public abstract class ControllerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final HttpStatus status;
    private final String message;

    public ControllerException(final HttpStatus status, final String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public ResponseEntity<ErrorATUDTO> getResponse() {
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorATUDTO(this.getClass().getSimpleName(), message));
    }
}

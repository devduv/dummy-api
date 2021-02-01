package pe.com.hiper.bmatic.dummyapi.error;

public class BmaticException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BmaticException(final String message) {
        super(message);
    }
}

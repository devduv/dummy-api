package pe.com.hiper.bmatic.dummyapi.domain.error;

public class ErrorATUDTO {
	private String error;
    private String error_description;

    public ErrorATUDTO(String error, String error_description) {

        this.error = error;
        this.error_description = error_description;
    }
    
    public ErrorATUDTO(Exception exception) {
        this(exception.getClass().getSimpleName(), exception.getMessage());
    }

    public String getError() {
        return error;
    }

    public String getError_description() {
        return error_description;
    }
}

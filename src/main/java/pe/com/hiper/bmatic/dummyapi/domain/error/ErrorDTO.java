package pe.com.hiper.bmatic.dummyapi.domain.error;

public class ErrorDTO {

    private String type;
    private String message;

    public ErrorDTO(String type, String message) {

        this.type = type;
        this.message = message == null || message.isEmpty() ? "An unknown error occurred" : message;
    }

    public ErrorDTO(Exception exception) {
        this(exception.getClass().getSimpleName(), exception.getMessage());
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

}

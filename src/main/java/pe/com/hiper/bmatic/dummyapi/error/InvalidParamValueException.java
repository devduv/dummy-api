package pe.com.hiper.bmatic.dummyapi.error;
import com.google.common.base.CaseFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public class InvalidParamValueException extends ControllerException {

	private static final long serialVersionUID = 1L;
	private static final String TEMPLATE = "Invalid value '%s' for param '%s'";

    public InvalidParamValueException(String param, Object value) {
        super(HttpStatus.BAD_REQUEST, String.format(TEMPLATE, value, toSnakeCase(param)));
    }

    public InvalidParamValueException(FieldError error) {
        this(error.getField(), error.getRejectedValue());
    }

    private static String toSnakeCase(String param) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, param);
    }
}
package pe.com.hiper.bmatic.dummyapi.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import pe.com.hiper.bmatic.dummyapi.domain.error.ErrorATUDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BmaticException.class, EntityException.class})
    public ResponseEntity<ErrorATUDTO> handleOwnException(Exception exception, HttpServletRequest request) {

        return new ResponseEntity<>(new ErrorATUDTO(exception), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ControllerException.class})
    public ResponseEntity<ErrorATUDTO> handleControllerException(ControllerException exception,
                                                              HttpServletRequest request) {

        return exception.getResponse();
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorATUDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception,
                                                                          HttpServletRequest request) {

        Throwable throwable = exception.getCause();

        return new InvalidRequestException(throwable.getClass().getSimpleName()).getResponse();
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorATUDTO> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException exception, HttpServletRequest request) {


        return new InvalidParamValueException(exception.getName(), exception.getValue()).getResponse();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorATUDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                          HttpServletRequest request) {



        BindingResult result = exception.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        return new InvalidParamValueException(fieldErrors.get(0)).getResponse();
    }
}

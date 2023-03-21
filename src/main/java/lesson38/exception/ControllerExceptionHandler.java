package lesson38.exception;

import lesson38.dto.ErrorMessageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author spasko
 */
@RestControllerAdvice
public class ControllerExceptionHandler {
    private static final Logger LOG = LogManager.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageResponse unexpected(Exception e) {
        LOG.error("Unexpected exception {}", e.getMessage());
        return new ErrorMessageResponse(e.getMessage());
    }

    @ExceptionHandler(value = {UpdateException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorMessageResponse entityExistingProblem(Exception e) {
        LOG.warn("Unprocesable entity {}", e.getMessage());
        return new ErrorMessageResponse(e.getMessage());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageResponse validationProblem(MethodArgumentNotValidException e) {
        LOG.warn("Request validation problem {}", e.getMessage());
        FieldError fe = e.getBindingResult()
                .getFieldError();
        return new ErrorMessageResponse(fe.getObjectName() + "-" + fe.getDefaultMessage());
    }

}

package dkuac.backend.common.exception;

import dkuac.backend.common.presentation.ErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ErrorResponse handleAllException(Exception ex, WebRequest request) {
        log.error("ERROR ::: [AllException] ", ex);
        return ErrorResponse.of(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DomainException.class)
    public final ErrorResponse handleDomainException(DomainException ex) {
        HttpStatus httpStatus = Optional.ofNullable(ex.getHttpStatus()).orElse(HttpStatus.INTERNAL_SERVER_ERROR);
        log.error("ERROR ::: [DomainException] ", ex);
        return ErrorResponse.of(ex.getMessage(), httpStatus);
    }
}


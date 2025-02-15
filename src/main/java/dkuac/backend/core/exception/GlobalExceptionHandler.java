package dkuac.backend.core.exception;

import dkuac.backend.core.presentation.ErrorResponse;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@Hidden
@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<ErrorResponse> handleAllException(Exception ex, WebRequest request) {
        log.error("ERROR ::: [AllException] ", ex);
        ErrorResponse errorResponse = ErrorResponse.createErrorResponse().statusCode(500).exception(ex).build();
        return ResponseEntity.internalServerError().body(errorResponse);
    }

    @ExceptionHandler(DomainException.class)
    public final ResponseEntity<ErrorResponse> handleDomainException(DomainException ex) {
        log.error("ERROR ::: [DomainException] ", ex);
        HttpStatus httpStatus = Optional.ofNullable(ex.getHttpStatus()).orElse(HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorResponse errorResponse = ErrorResponse.createDomainErrorResponse().statusCode(httpStatus.value()).exception(ex).build();
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error("ERROR ::: [MethodArgumentNotValidException] ", ex);
        ErrorResponse errorResponse = ErrorResponse.createValidationErrorResponse().statusCode(400).exception(ex).build();
        return ResponseEntity.badRequest().body(errorResponse);
    }
}


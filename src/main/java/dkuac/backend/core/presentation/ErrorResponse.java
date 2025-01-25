package dkuac.backend.core.presentation;

import org.springframework.http.HttpStatus;

public record ErrorResponse(String message, HttpStatus httpStatus) {
    public static ErrorResponse of(String message, HttpStatus httpStatus) {
        return new ErrorResponse(message, httpStatus);
    }
}

package dkuac.backend.common.presentation;

import java.time.LocalDateTime;

public record ApiResponse<T>(boolean success, int status, T body, LocalDateTime timestamp) {
    public static <T> ApiResponse<T> of(boolean success, int status, T body) {
        return new ApiResponse<>(success, status, body, LocalDateTime.now());
    }
}

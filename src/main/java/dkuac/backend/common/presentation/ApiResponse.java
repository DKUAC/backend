package dkuac.backend.common.presentation;

import java.time.LocalDateTime;

public record ApiResponse<T>(boolean success, T body, LocalDateTime timestamp) {

    public ApiResponse {
        timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> of(T body) {
        return new ApiResponse<>(true, body, null);
    }
}

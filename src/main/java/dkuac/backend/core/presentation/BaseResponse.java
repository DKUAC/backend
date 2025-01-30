package dkuac.backend.core.presentation;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseResponse {

    private final boolean success;

    private final LocalDateTime timestamp;
}

package dkuac.backend.auth.presentation.dto.reqeust;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(
        @NotNull(message = "학번은 필수 입력 항목입니다.")
        @Min(value = 10000000, message = "학번은 8자리여야 합니다.")
        @Max(value = 99999999, message = "학번은 8자리여야 합니다.")
        @Schema(description = "학번", example = "32201234")
        int studentNumber,

        @NotNull(message = "비밀번호는 필수 입력 항목입니다.")
        @Schema(description = "비밀번호", example = "12345678")
        String password
) {
}

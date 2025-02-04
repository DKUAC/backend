package dkuac.backend.auth.presentation.dto.reqeust;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record LoginRequest(
        @NotNull(message = "학번은 필수 입력 항목입니다.")
        @Pattern(
                regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
                message = "이메일 형식으로 입력해주세요."
        )
        @Schema(description = "이메일", example = "example@example.com")
        String email,

        @NotNull(message = "비밀번호는 필수 입력 항목입니다.")
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?=\\S+$).{8,20}$",
                message = "비밀번호는 영문 대소문자, 숫자, 특수문자를 포함한 8자 이상 20자 이내로 입력해주세요."
        )
        String password
) {
}

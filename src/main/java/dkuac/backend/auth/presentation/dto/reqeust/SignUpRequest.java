package dkuac.backend.auth.presentation.dto.reqeust;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SignUpRequest(
        @NotNull(message = "이름은 필수 입력 항목입니다.")
        @Pattern(regexp = "^[a-zA-Z가-힣ㄱ-ㅎ]{1,15}$", message = "이름은 한글 또는 영어 최대 15자 이내로 입력해주세요.")
        @Schema(description = "이름", example = "홍길동")
        String name,

        @NotNull(message = "이메일은 필수 입력 항목입니다.")
        @Pattern(
                regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
                message = "이메일 형식으로 입력해주세요."
        )
        @Schema(description = "이메일", example = "example@dkuac.co.kr")
        String email,

        @NotNull(message = "전공은 필수 입력 항목입니다.")
        @Schema(description = "전공", example = "소프트웨어학과")
        String major,

        @NotNull(message = "학번은 필수 입력 항목입니다.")
        @Min(value = 10000000, message = "학번은 8자리여야 합니다.")
        @Max(value = 99999999, message = "학번은 8자리여야 합니다.")
        @Schema(description = "학번", example = "32201234")
        int studentNumber,

        @NotNull(message = "생년월일은 필수 입력 항목입니다.")
        @Schema(description = "생년월일", example = "2000-01-30")
        String birth,

        @NotNull(message = "전화번호는 필수 입력 항목입니다.")
        @Pattern(
                regexp = "^01(?:0|1|[6-9])\\d{8}$",
                message = "전화번호는 010으로 시작하는 11자리 숫자로 입력해주세요."
        )
        @Schema(description = "전화번호", example = "01012345678")
        String phone
) {
}

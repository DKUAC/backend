package dkuac.backend.auth.presentation.swagger;

import dkuac.backend.auth.presentation.dto.reqeust.SignUpRequest;
import dkuac.backend.core.configuration.ApiErrorCode;
import dkuac.backend.core.exception.error.GlobalErrorCode;
import dkuac.backend.core.presentation.RestResponse;
import dkuac.backend.member.exception.MemberErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Auth", description = "인증/인가")
public interface SignUpSwagger {

    @Operation(
            summary = "회원가입 API",
            description = "사용자가 이름, 이메일, 전공, 학번, 생년월일, 핸드폰 번호를 입력하여 회원가입을 진행합니다. 단, 회원은 이메일 인증을 마친 상태여야 합니다.",
            operationId = "/auth/signup"
    )
    @ApiErrorCode({GlobalErrorCode.class, MemberErrorCode.class})
    ResponseEntity<RestResponse<?>> signUp(SignUpRequest request);
}

package dkuac.backend.auth.presentation.swagger;

import dkuac.backend.auth.exception.AuthenticationErrorCode;
import dkuac.backend.auth.presentation.dto.reqeust.LoginRequest;
import dkuac.backend.auth.presentation.dto.response.LoginResponse;
import dkuac.backend.core.configuration.swagger.ApiErrorCode;
import dkuac.backend.core.exception.error.GlobalErrorCode;
import dkuac.backend.core.presentation.RestResponse;
import dkuac.backend.member.exception.MemberErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Auth", description = "인증/인가")
public interface LoginSwagger {

    @Operation(
            summary = "로그인 API",
            description = "사용자가 학번과 비밀번호를 입력하여 로그인을 진행합니다.",
            operationId = "/auth/login"
    )
    @ApiErrorCode({GlobalErrorCode.class, MemberErrorCode.class, AuthenticationErrorCode.class})
    ResponseEntity<RestResponse<LoginResponse>> logIn(LoginRequest request);
}

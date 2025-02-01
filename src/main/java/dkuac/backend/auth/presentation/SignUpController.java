package dkuac.backend.auth.presentation;

import dkuac.backend.auth.application.SignUpService;
import dkuac.backend.auth.presentation.dto.reqeust.SignUpRequest;
import dkuac.backend.auth.presentation.swagger.SignUpSwagger;
import dkuac.backend.core.presentation.RestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class SignUpController implements SignUpSwagger {

    private final SignUpService signUpService;

    @PostMapping("/signup")
    public ResponseEntity<RestResponse<?>> signUp(
            @Valid @RequestBody SignUpRequest request
    ) {
        signUpService.signUp(request);
        return ResponseEntity.ok(
                new RestResponse<>("회원가입에 성공했습니다.")
        );
    }
}

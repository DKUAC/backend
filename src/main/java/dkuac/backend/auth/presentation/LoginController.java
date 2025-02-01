package dkuac.backend.auth.presentation;

import dkuac.backend.auth.application.LoginService;
import dkuac.backend.auth.presentation.dto.reqeust.LoginRequest;
import dkuac.backend.auth.presentation.dto.response.LoginResponse;
import dkuac.backend.auth.presentation.swagger.LoginSwagger;
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
public class LoginController implements LoginSwagger {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<RestResponse<LoginResponse>> logIn(
            @Valid  @RequestBody LoginRequest request
    ) {
        LoginResponse loginResponse = loginService.login(request);
        return ResponseEntity.ok(new RestResponse<>(loginResponse));
    }
}

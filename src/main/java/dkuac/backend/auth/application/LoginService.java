package dkuac.backend.auth.application;

import dkuac.backend.auth.presentation.dto.reqeust.LoginRequest;
import dkuac.backend.auth.presentation.dto.response.LoginResponse;
import dkuac.backend.member.domain.entity.Member;
import dkuac.backend.member.domain.repository.MemberRepository;
import dkuac.backend.member.exception.MemberErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;
    private final PasswordHashingService passwordHashingService;
    private final TokenProvider tokenProvider;

    public LoginResponse login(LoginRequest request) {
        Member member = memberRepository.findByEmail(request.email()).orElseThrow(MemberErrorCode.MEMBER_NOT_EXISTS::toException);
        passwordHashingService.matches(request.password(), member.getPassword());
        String accessToken = tokenProvider.provideAccessToken(member);
        return LoginResponse.of(
                member,
                accessToken
        );
    }
}

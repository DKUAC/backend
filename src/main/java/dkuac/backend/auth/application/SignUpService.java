package dkuac.backend.auth.application;

import dkuac.backend.auth.domain.entity.HashedPassword;
import dkuac.backend.auth.domain.entity.Password;
import dkuac.backend.auth.presentation.dto.reqeust.SignUpRequest;
import dkuac.backend.member.domain.entity.Member;
import dkuac.backend.member.domain.repository.MemberRepository;
import dkuac.backend.member.exception.MemberErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final MemberRepository memberRepository;
    private final PasswordHashingService passwordHashingService;

    public void signUp(SignUpRequest request) {
        validate(request);
        Password password = Password.from(request.password());
        HashedPassword hashedPassword = passwordHashingService.hash(password);
        Member newMember = Member.create(
                request.name(),
                request.email(),
                hashedPassword
        );
        memberRepository.save(newMember);
    }

    private void validate(SignUpRequest request) {
        if (memberRepository.findByName(request.name()).isPresent()) {
            throw MemberErrorCode.MEMBER_ALREADY_EXISTS.toException();
        }
    }
}

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
        Password password = Password.fromPhone(request.phone());
        HashedPassword hashedPassword = passwordHashingService.hash(password);
        Member newMember = Member.create(
                request.name(),
                request.email(),
                hashedPassword,
                request.studentNumber(),
                request.major(),
                request.birth(),
                request.phone()
        );
        memberRepository.save(newMember);
    }


    private void validate(SignUpRequest request) {
        if (memberRepository.findByStudentEmail(request.email()) != null) {
            throw MemberErrorCode.MEMBER_ALREADY_EXISTS.toException();
        }

        if (memberRepository.findByStudentNumber(request.studentNumber()) != null) {
            throw MemberErrorCode.MEMBER_ALREADY_EXISTS.toException();
        }
    }

    ;
}

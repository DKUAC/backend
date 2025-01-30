package dkuac.backend.auth.application;

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

    public void signUp(SignUpRequest request) {
        validate(request);
        Member newMember = Member.create(request.name(), request.email(), request.studentNumber(), request.major(), request.birth(), request.phone());
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

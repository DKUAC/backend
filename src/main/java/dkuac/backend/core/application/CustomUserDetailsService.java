package dkuac.backend.core.application;

import dkuac.backend.core.infrastructure.security.CustomUserDetails;
import dkuac.backend.member.domain.entity.Member;
import dkuac.backend.member.domain.repository.MemberRepository;
import dkuac.backend.member.exception.MemberErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByName(username).orElseThrow(MemberErrorCode.MEMBER_NOT_EXISTS::toException);

        return new CustomUserDetails(member);
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        Member member = memberRepository.findById(id).orElseThrow(MemberErrorCode.MEMBER_NOT_EXISTS::toException);

        return new CustomUserDetails(member);
    }
}

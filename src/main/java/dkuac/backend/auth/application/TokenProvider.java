package dkuac.backend.auth.application;

import dkuac.backend.member.domain.entity.Member;

public interface TokenProvider {
    String provideAccessToken(Member member);
    String provideRefreshToken(Member member);
}

package dkuac.backend.auth.presentation.dto.response;

import dkuac.backend.member.domain.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(
        @Schema(description = "사용자 정보")
        UserInfo userInfo,

        @Schema(description = "액세스 토큰")
        String accessToken

) {
    public record UserInfo(
            @Schema(description = "사용자 ID", example = "1L")
            Long id,

            @Schema(description = "사용자 이름", example = "홍길동")
            String name
    ) {
        public static UserInfo from(Member member) {
            return new UserInfo(member.getId(), member.getName());
        }
    }

    public static LoginResponse of(Member member, String accessToken) {
        return new LoginResponse(UserInfo.from(member), accessToken);
    }
}

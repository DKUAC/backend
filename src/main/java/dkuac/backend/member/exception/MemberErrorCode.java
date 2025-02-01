package dkuac.backend.member.exception;

import dkuac.backend.core.exception.DomainException;
import dkuac.backend.core.exception.error.BaseErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum MemberErrorCode implements BaseErrorCode<DomainException> {

    MEMBER_SAVE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "사용자 정보를 저장하는데 실패했습니다."),
    MEMBER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "이미 가입된 사용자입니다."),
    MEMBER_NOT_EXISTS(HttpStatus.BAD_REQUEST, "존재하지 않는 회원입니다.");

    private final HttpStatus httpStatus;

    private final String message;

    @Override
    public DomainException toException() {
        return new DomainException(httpStatus, this);
    }
}

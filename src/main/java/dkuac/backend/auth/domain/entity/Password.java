package dkuac.backend.auth.domain.entity;

import lombok.Value;

@Value
public class Password {
    String value;

    private Password(String value) {
        validate(value);
        this.value = value;
    }

    public static Password from(String value) {
        return new Password(value);
    }

    private void validate(String password) {
        if (!checkPasswordPattern(password)) {
            throw new IllegalArgumentException("비밀번호는 영문 대소문자, 숫자, 특수문자를 포함한 8자 이상 20자 이내로 입력해주세요.");
        }
    }

    private boolean checkPasswordPattern(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?=\\S+$).{8,20}$");
    }
}

package dkuac.backend.auth.domain.entity;

import lombok.Value;

@Value
public class Password {
    private static final String PHONE_PREFIX = "010";
    String value;

    private Password(String value) {
        validate(value);
        this.value = value;
    }

    public static Password fromPhone(String phone) {
        return new Password(phone.replace(PHONE_PREFIX, ""));
    }

    public static Password of(String password) {
        return new Password(password);
    }

    private void validate(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상이어야 합니다.");
        }
    }
}

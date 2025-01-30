package dkuac.backend.auth.infrastructure;

import dkuac.backend.auth.application.PasswordHashingService;
import dkuac.backend.auth.domain.entity.HashedPassword;
import dkuac.backend.auth.domain.entity.Password;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BcryptPasswordHashingService implements PasswordHashingService {
    private final PasswordEncoder passwordEncoder;

    @Override
    public HashedPassword hash(Password password) {
        return HashedPassword.of(passwordEncoder.encode(password.getValue()));
    }

    @Override
    public boolean matches(Password rawPassword, HashedPassword hashedPassword) {
        return passwordEncoder.matches(rawPassword.getValue(), hashedPassword.getValue());
    }
}

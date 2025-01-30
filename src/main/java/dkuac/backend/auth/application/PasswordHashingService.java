package dkuac.backend.auth.application;

import dkuac.backend.auth.domain.entity.HashedPassword;
import dkuac.backend.auth.domain.entity.Password;

public interface PasswordHashingService {
    HashedPassword hash(Password password);
    boolean matches(Password rawPassword, HashedPassword hashedPassword);
}

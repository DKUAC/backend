package dkuac.backend.member.domain.entity;

import dkuac.backend.auth.domain.entity.HashedPassword;
import dkuac.backend.member.infrastructure.persistence.jpa.entity.MemberJpaEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Member {
    private Long id;

    private String name;

    private String email;

    private HashedPassword password;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean deleted;

    public static Member create(String name, String email, HashedPassword hashedPassword) {
        return Member.builder()
                .id(null)
                .name(name)
                .email(email)
                .password(hashedPassword)
                .build();
    }

    public static Member toDomainEntity(MemberJpaEntity memberJpaEntity) {
        return Member.builder()
                .id(memberJpaEntity.getId())
                .name(memberJpaEntity.getName())
                .email(memberJpaEntity.getEmail())
                .password(HashedPassword.of(memberJpaEntity.getPassword()))
                .createdAt(memberJpaEntity.getCreatedAt())
                .updatedAt(memberJpaEntity.getUpdatedAt())
                .deleted(memberJpaEntity.getDeleted())
                .build();
    }

}

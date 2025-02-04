package dkuac.backend.member.infrastructure.persistence.jpa.entity;

import dkuac.backend.core.infrastructure.jpa.entity.BaseEntity;
import dkuac.backend.member.domain.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Optional;

@Entity
@Getter
@SuperBuilder
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberJpaEntity extends BaseEntity {

    private String name;

    private String email;

    private String password;

    public static MemberJpaEntity toJpaEntity(Member member) {

        return MemberJpaEntity.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword().getValue())
                .createdAt(member.getCreatedAt())
                .updatedAt(member.getUpdatedAt())
                .deleted(Optional.ofNullable(member.getDeleted()).orElse(false))
                .build();
    }
}

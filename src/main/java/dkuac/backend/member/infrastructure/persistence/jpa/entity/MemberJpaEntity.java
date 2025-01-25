package dkuac.backend.member.infrastructure.persistence.jpa.entity;

import dkuac.backend.core.infrastructure.jpa.entity.BaseEntity;
import dkuac.backend.member.domain.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Getter
@SuperBuilder
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberJpaEntity extends BaseEntity {

    private String name;

    private int studentNumber;

    private LocalDate birth;

    private String phone;

    private String major;

    private String password;

    private boolean isStaff;

    private boolean isCurrentSemesterMember;

    private boolean isPaid;

    public static MemberJpaEntity toJpaEntity(Member member) {
        return MemberJpaEntity.builder()
                .id(member.getId())
                .name(member.getName())
                .studentNumber(member.getStudentNumber())
                .birth(member.getBirth())
                .phone(member.getPhone())
                .major(member.getMajor())
                .password(member.getPassword())
                .isStaff(member.isStaff())
                .isCurrentSemesterMember(member.isCurrentSemesterMember())
                .isPaid(member.isPaid())
                .createdAt(member.getCreatedAt())
                .updatedAt(member.getUpdatedAt())
                .deleted(Optional.ofNullable(member.getDeleted()).orElse(false))
                .build();
    }
}

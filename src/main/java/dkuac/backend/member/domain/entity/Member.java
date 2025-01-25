package dkuac.backend.member.domain.entity;

import dkuac.backend.member.infrastructure.persistence.jpa.entity.MemberJpaEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class Member {
    private long id;

    private String name;

    private int studentNumber;

    private LocalDate birth;

    private String phone;

    private String major;

    private String password;

    private boolean isStaff;

    private boolean isCurrentSemesterMember;

    private boolean isPaid;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean deleted;

    public static Member toDomainEntity(MemberJpaEntity memberJpaEntity) {
        return Member.builder()
                .id(memberJpaEntity.getId())
                .name(memberJpaEntity.getName())
                .studentNumber(memberJpaEntity.getStudentNumber())
                .birth(memberJpaEntity.getBirth())
                .phone(memberJpaEntity.getPhone())
                .major(memberJpaEntity.getMajor())
                .password(memberJpaEntity.getPassword())
                .isStaff(memberJpaEntity.isStaff())
                .isCurrentSemesterMember(memberJpaEntity.isCurrentSemesterMember())
                .isPaid(memberJpaEntity.isPaid())
                .createdAt(memberJpaEntity.getCreatedAt())
                .updatedAt(memberJpaEntity.getUpdatedAt())
                .deleted(memberJpaEntity.getDeleted())
                .build();
    }

}

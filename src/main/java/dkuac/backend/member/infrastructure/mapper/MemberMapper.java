package dkuac.backend.member.infrastructure.mapper;

import dkuac.backend.member.domain.entity.Member;
import dkuac.backend.member.infrastructure.persistence.jpa.entity.MemberJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member toDomainEntity(MemberJpaEntity memberJpaEntity) {
        return Member.toDomainEntity(memberJpaEntity);
    }

    public MemberJpaEntity toJpaEntity(Member memberEntity) {
        return MemberJpaEntity.toJpaEntity(memberEntity);
    }
}

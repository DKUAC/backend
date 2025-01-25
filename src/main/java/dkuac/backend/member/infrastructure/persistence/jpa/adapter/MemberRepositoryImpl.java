package dkuac.backend.member.infrastructure.persistence.jpa.adapter;

import dkuac.backend.member.domain.entity.Member;
import dkuac.backend.member.domain.repository.MemberRepository;
import dkuac.backend.member.exception.MemberErrorCode;
import dkuac.backend.member.infrastructure.mapper.MemberMapper;
import dkuac.backend.member.infrastructure.persistence.jpa.entity.MemberJpaEntity;
import dkuac.backend.member.infrastructure.persistence.jpa.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberMapper memberMapper;
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member findById(Long id) {
        MemberJpaEntity memberJpaEntity = memberJpaRepository.findById(id).orElse(null);
        if (memberJpaEntity == null) {
            return null;
        }
        return memberMapper.toDomainEntity(memberJpaEntity);
    }

    @Override
    public Member save(Member member) {
        MemberJpaEntity memberJpaEntity = memberMapper.toJpaEntity(member);
        if(memberJpaEntity == null) {
            throw MemberErrorCode.MEMBER_SAVE_FAILED.toException();
        }
        memberJpaRepository.save(memberJpaEntity);
        return memberMapper.toDomainEntity(memberJpaEntity);
    }


}

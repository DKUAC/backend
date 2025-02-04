package dkuac.backend.member.infrastructure.persistence.jpa.adapter;

import dkuac.backend.member.domain.entity.Member;
import dkuac.backend.member.domain.repository.MemberRepository;
import dkuac.backend.member.exception.MemberErrorCode;
import dkuac.backend.member.infrastructure.mapper.MemberMapper;
import dkuac.backend.member.infrastructure.persistence.jpa.entity.MemberJpaEntity;
import dkuac.backend.member.infrastructure.persistence.jpa.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final MemberMapper memberMapper;
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public Member save(Member member) {
        MemberJpaEntity memberJpaEntity = memberMapper.toJpaEntity(member);
        if(memberJpaEntity == null) {
            throw MemberErrorCode.MEMBER_SAVE_FAILED.toException();
        }
        memberJpaRepository.save(memberJpaEntity);
        return memberMapper.toDomainEntity(memberJpaEntity);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberJpaRepository.findById(id).map(memberMapper::toDomainEntity);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return memberJpaRepository.findByName(name).map(memberMapper::toDomainEntity);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberJpaRepository.findByEmail(email).map(memberMapper::toDomainEntity);
    }
}

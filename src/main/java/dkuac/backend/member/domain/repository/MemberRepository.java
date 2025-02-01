package dkuac.backend.member.domain.repository;

import dkuac.backend.member.domain.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByStudentNumber(int studentNumber);
    Optional<Member> findByStudentEmail(String email);
    Optional<Member> findByStudentName(String name);
}

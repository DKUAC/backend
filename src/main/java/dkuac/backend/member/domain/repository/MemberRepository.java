package dkuac.backend.member.domain.repository;

import dkuac.backend.member.domain.entity.Member;

public interface MemberRepository {
    Member findById(Long id);
    Member save(Member member);
    Member findByStudentNumber(int studentNumber);
    Member findByStudentEmail(String email);
}

package dkuac.backend.member.infrastructure.persistence.jpa.repository;

import dkuac.backend.member.infrastructure.persistence.jpa.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {
    MemberJpaEntity findByStudentNumber(int studentNumber );
}

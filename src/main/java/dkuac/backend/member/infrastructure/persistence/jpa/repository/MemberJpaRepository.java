package dkuac.backend.member.infrastructure.persistence.jpa.repository;

import dkuac.backend.member.infrastructure.persistence.jpa.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {
    Optional<MemberJpaEntity> findByStudentNumber(int studentNumber);
    Optional<MemberJpaEntity> findByEmail(String email);
    Optional<MemberJpaEntity> findByName(String name);
}

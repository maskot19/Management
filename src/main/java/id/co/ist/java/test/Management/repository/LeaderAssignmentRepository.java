package id.co.ist.java.test.Management.repository;

import id.co.ist.java.test.Management.domain.LeaderAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeaderAssignmentRepository extends JpaRepository<LeaderAssignment, Long> {
    Optional<LeaderAssignment> findByProjectId(Long projectId);
}

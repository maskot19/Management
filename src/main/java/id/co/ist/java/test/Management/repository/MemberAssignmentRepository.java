package id.co.ist.java.test.Management.repository;

import id.co.ist.java.test.Management.domain.MemberAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAssignmentRepository extends JpaRepository<MemberAssignment, Long> {
}

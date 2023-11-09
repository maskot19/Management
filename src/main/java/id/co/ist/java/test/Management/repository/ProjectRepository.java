package id.co.ist.java.test.Management.repository;

import id.co.ist.java.test.Management.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

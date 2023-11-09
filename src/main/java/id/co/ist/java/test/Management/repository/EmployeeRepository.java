package id.co.ist.java.test.Management.repository;

import id.co.ist.java.test.Management.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

package id.co.ist.java.test.Management.domain.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class LeaderAssignmentDTO {
    private Long id;
    private String assignment;

    @ManyToOne
    @JoinColumn(name = "employee_id ")
    private EmployeeDTO employeeDTO;

    @ManyToOne
    @JoinColumn(name = "project_id  ")
    private ProjectDTO projectDTO;

    public void setId(Long id) { this.id = id; }

    public String getAssignment() { return assignment; }
    public void setAssignment(String assigment) { this.assignment = assigment; }

    public EmployeeDTO getEmployee() {
        return employeeDTO;
    }
    public void setEmployee(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public ProjectDTO getProject() {
        return projectDTO;
    }
    public void setProject(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }
}

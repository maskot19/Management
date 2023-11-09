package id.co.ist.java.test.Management.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "leader_assignment")
public class LeaderAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //akan terus lanjut ID nya walaupun dari table lain ID sebelumnya
    private Long id;

    @Column(name = "assignment")
    private String assignment;

    @ManyToOne
    @JoinColumn(name = "employee_id ")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id  ")
    private Project project;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAssignment() { return assignment; }
    public void setAssignment(String assigment) { this.assignment = assigment; }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

}

package id.co.ist.java.test.Management.controller;

import id.co.ist.java.test.Management.domain.Employee;
import id.co.ist.java.test.Management.domain.dto.EmployeeDTO;
import id.co.ist.java.test.Management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        super();
        this.employeeService = employeeService;
    }

    @GetMapping("/view")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK).getBody();
    }

    @GetMapping("/api_view")
    public List<EmployeeDTO> getAllEmployeesToAPI() {
        return employeeService.getAllEmployeesToAPI();
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee addEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Employee> editEmployee(@RequestBody Employee employee, @PathVariable("id") Long employeeId) {
        return new ResponseEntity<Employee>(employeeService.editEmployee(employee, employeeId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
    }
}

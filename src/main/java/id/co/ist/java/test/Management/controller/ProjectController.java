package id.co.ist.java.test.Management.controller;

import id.co.ist.java.test.Management.domain.Project;
import id.co.ist.java.test.Management.domain.dto.ProjectDTO;
import id.co.ist.java.test.Management.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        super();
        this.projectService = projectService;
    }

    @GetMapping("/view")
    public List<Project> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK).getBody();
    }

    @GetMapping("/api_view")
    public List<ProjectDTO> getAllProjectsToAPI() {
        return projectService.getAllProjectsToAPI();
    }

    @PostMapping("/add")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project addProject = projectService.addProject(project);
        return new ResponseEntity<>(addProject, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Project> editProject(@RequestBody Project project, @PathVariable("id") Long projectId) {
        return new ResponseEntity<Project>(projectService.editProject(project, projectId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long projectId) {
        projectService.deleteProject(projectId);

        return new ResponseEntity<String>("Project deleted successfully!", HttpStatus.OK);
    }
}

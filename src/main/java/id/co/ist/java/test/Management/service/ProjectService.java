package id.co.ist.java.test.Management.service;

import id.co.ist.java.test.Management.domain.Project;
import id.co.ist.java.test.Management.domain.dto.ProjectDTO;
import id.co.ist.java.test.Management.exception.ResourceNotFoundException;
import id.co.ist.java.test.Management.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private ModelMapper modelMapper = new ModelMapper();;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        super();
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }


    public List<ProjectDTO> getAllProjectsToAPI() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", "Id", id));
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public Project editProject(Project project, Long id) {
        Project existingProject = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", "Id", id));

        existingProject.setName(project.getName());

        projectRepository.save(existingProject);

        return existingProject;
    }

    public void deleteProject(Long id) {
        projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", "Id", id));

        projectRepository.deleteById(id);
    }
}

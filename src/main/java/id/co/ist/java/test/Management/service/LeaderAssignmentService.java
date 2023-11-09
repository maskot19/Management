package id.co.ist.java.test.Management.service;

import id.co.ist.java.test.Management.domain.LeaderAssignment;
import id.co.ist.java.test.Management.domain.dto.LeaderAssignmentDTO;
import id.co.ist.java.test.Management.exception.ResourceNotFoundException;
import id.co.ist.java.test.Management.repository.LeaderAssignmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaderAssignmentService {
    private final LeaderAssignmentRepository leaderAssignmentRepository;
    private ModelMapper modelMapper = new ModelMapper();;

    @Autowired
    public LeaderAssignmentService(LeaderAssignmentRepository leaderAssignmentRepository){
        super();
        this.leaderAssignmentRepository = leaderAssignmentRepository;
    }

    public List<LeaderAssignment> getAllLeaderAssignments() {
        return leaderAssignmentRepository.findAll();
    }

    public List<LeaderAssignmentDTO> getAllLeaderAssignmentsToAPI() {
        List<LeaderAssignment> leaderAssignments = leaderAssignmentRepository.findAll();
        return leaderAssignments.stream()
                .map(leaderAssignment -> modelMapper.map(leaderAssignment, LeaderAssignmentDTO.class))
                .collect(Collectors.toList());
    }

    public LeaderAssignment getLeaderAssignmentById(Long id) {
        return leaderAssignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LeaderAssignment", "Id", id));
    }

    public LeaderAssignment addLeaderAssignment(LeaderAssignment leaderAssignment) {
        if (leaderAssignmentRepository.findByProjectId(leaderAssignment.getProject().getId()).isPresent()) {
            return new LeaderAssignment();
        }

        return leaderAssignmentRepository.save(leaderAssignment);
    }

    public LeaderAssignment editLeaderAssignment(LeaderAssignment leaderAssignment, Long id) {
        LeaderAssignment existingLeaderAssignment = leaderAssignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LeaderAssignment", "Id", id));

        existingLeaderAssignment.setAssignment(leaderAssignment.getAssignment());
        existingLeaderAssignment.setEmployee(leaderAssignment.getEmployee());
        existingLeaderAssignment.setProject(leaderAssignment.getProject());

        if (leaderAssignmentRepository.findByProjectId(leaderAssignment.getProject().getId()).isPresent()) {
            return new LeaderAssignment();
        }
        leaderAssignmentRepository.save(existingLeaderAssignment);

        return existingLeaderAssignment;
    }

    public void deleteLeaderAssignment(Long id) {
        leaderAssignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("LeaderAssignment", "Id", id));

        leaderAssignmentRepository.deleteById(id);
    }
}

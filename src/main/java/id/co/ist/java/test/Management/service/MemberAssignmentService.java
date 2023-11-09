package id.co.ist.java.test.Management.service;

import id.co.ist.java.test.Management.domain.MemberAssignment;
import id.co.ist.java.test.Management.domain.dto.MemberAssignmentDTO;
import id.co.ist.java.test.Management.exception.ResourceNotFoundException;
import id.co.ist.java.test.Management.repository.MemberAssignmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberAssignmentService {
    private final MemberAssignmentRepository memberAssignmentRepository;
    private ModelMapper modelMapper = new ModelMapper();;

    @Autowired
    public MemberAssignmentService(MemberAssignmentRepository memberAssignmentRepository){
        super();
        this.memberAssignmentRepository = memberAssignmentRepository;
    }

    public List<MemberAssignment> getAllMemberAssignments() {
        return memberAssignmentRepository.findAll();
    }

    public List<MemberAssignmentDTO> getAllMemberAssignmentsToAPI() {
        List<MemberAssignment> memberAssignments = memberAssignmentRepository.findAll();
        return memberAssignments.stream()
                .map(memberAssignment -> modelMapper.map(memberAssignment, MemberAssignmentDTO.class))
                .collect(Collectors.toList());
    }

    public MemberAssignment getMemberAssignmentById(Long id) {
        return memberAssignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MemberAssignment", "Id", id));
    }

    public MemberAssignment addMemberAssignment(MemberAssignment memberAssignment) {
        return memberAssignmentRepository.save(memberAssignment);
    }

    public MemberAssignment editMemberAssignment(MemberAssignment memberAssignment, Long id) {
        MemberAssignment existingMemberAssignment = memberAssignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MemberAssignment", "Id", id));

        existingMemberAssignment.setAssignment(memberAssignment.getAssignment());
        existingMemberAssignment.setEmployee(memberAssignment.getEmployee());
        existingMemberAssignment.setProject(memberAssignment.getProject());

        memberAssignmentRepository.save(existingMemberAssignment);

        return existingMemberAssignment;
    }

    public void deleteMemberAssignment(Long id) {
        memberAssignmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("MemberAssignment", "Id", id));

        memberAssignmentRepository.deleteById(id);
    }
}

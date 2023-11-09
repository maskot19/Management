package id.co.ist.java.test.Management.controller;

import id.co.ist.java.test.Management.domain.MemberAssignment;
import id.co.ist.java.test.Management.domain.dto.MemberAssignmentDTO;
import id.co.ist.java.test.Management.service.MemberAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member_assignment")
public class MemberAssignmentController {
    private final MemberAssignmentService memberAssignmentService;

    @Autowired
    public MemberAssignmentController(MemberAssignmentService memberAssignmentService){
        super();
        this.memberAssignmentService = memberAssignmentService;
    }

    @GetMapping("/view")
    public List<MemberAssignment> getAllEmployees() {
        List<MemberAssignment> memberAssignments = memberAssignmentService.getAllMemberAssignments();
        return new ResponseEntity<>(memberAssignments, HttpStatus.OK).getBody();
    }

    @GetMapping("/api_view")
    public List<MemberAssignmentDTO> getAllMemberAssignmentsToAPI() {
        return memberAssignmentService.getAllMemberAssignmentsToAPI();
    }

    @PostMapping("/add")
    public ResponseEntity<MemberAssignment> addMemberAssignment(@RequestBody MemberAssignment memberAssignment) {
        MemberAssignment addMemberAssignment = memberAssignmentService.addMemberAssignment(memberAssignment);
        return new ResponseEntity<>(addMemberAssignment, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<MemberAssignment> editMemberAssignment(@RequestBody MemberAssignment memberAssignment, @PathVariable("id") Long memberAssignmentId) {
        return new ResponseEntity<MemberAssignment>(memberAssignmentService.editMemberAssignment(memberAssignment, memberAssignmentId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMemberAssignment(@PathVariable("id") Long memberAssignmentId) {
        memberAssignmentService.deleteMemberAssignment(memberAssignmentId);

        return new ResponseEntity<String>("Member Assignment deleted successfully!", HttpStatus.OK);
    }
}

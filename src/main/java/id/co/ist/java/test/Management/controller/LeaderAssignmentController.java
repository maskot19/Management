package id.co.ist.java.test.Management.controller;

import id.co.ist.java.test.Management.domain.LeaderAssignment;
import id.co.ist.java.test.Management.domain.dto.LeaderAssignmentDTO;
import id.co.ist.java.test.Management.service.LeaderAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leader_assignment")
public class LeaderAssignmentController {
    private final LeaderAssignmentService leaderAssignmentService;

    @Autowired
    public LeaderAssignmentController(LeaderAssignmentService leaderAssignmentService){
        super();
        this.leaderAssignmentService = leaderAssignmentService;
    }

    @GetMapping("/view")
    public List<LeaderAssignment> getAllEmployees() {
        List<LeaderAssignment> leaderAssignments = leaderAssignmentService.getAllLeaderAssignments();
        return new ResponseEntity<>(leaderAssignments, HttpStatus.OK).getBody();
    }

    @GetMapping("/api_view")
    public List<LeaderAssignmentDTO> getAllLeaderAssignmentsToAPI() {
        return leaderAssignmentService.getAllLeaderAssignmentsToAPI();
    }

    @PostMapping("/add")
    public ResponseEntity<LeaderAssignment> addLeaderAssignment(@RequestBody LeaderAssignment leaderAssignment) {
        LeaderAssignment addLeaderAssignment = leaderAssignmentService.addLeaderAssignment(leaderAssignment);
        return new ResponseEntity<>(addLeaderAssignment, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<LeaderAssignment> editLeaderAssignment(@RequestBody LeaderAssignment leaderAssignment, @PathVariable("id") Long leaderAssignmentId) {
        return new ResponseEntity<LeaderAssignment>(leaderAssignmentService.editLeaderAssignment(leaderAssignment, leaderAssignmentId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLeaderAssignment(@PathVariable("id") Long leaderAssignmentId) {
        leaderAssignmentService.deleteLeaderAssignment(leaderAssignmentId);

        return new ResponseEntity<String>("Leader Assignment deleted successfully!", HttpStatus.OK);
    }
}

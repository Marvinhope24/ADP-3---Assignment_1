/*
StudentController.java
Controller Student
Author: Marvin Hope - 219445842
 */


package za.ac.cput.controller.studentdetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.services.Interface.studentdetails.IStudent;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abc-school-management/student")
@Slf4j
public class StudentController {
    private final IStudent iStudentservice;

    @Autowired
    public StudentController(IStudent iStudentservice) {
        this.iStudentservice = iStudentservice;
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student) {
        log.info("Save request: {}", student);
        System.out.println(String.format("Save request: &s", student));
        Student save = iStudentservice.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{studentId}")
    public ResponseEntity<Student> read(@PathVariable String studentId) {
        log.info("Read Request: {}", studentId);
        Student read = this.iStudentservice.read(studentId).get();
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable String studentId) {
        log.info("Delete request {}", studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity <List<Student>> findAll() {
        List<Student> student = this.iStudentservice.findAll();
        return ResponseEntity.ok(student);
    }
}

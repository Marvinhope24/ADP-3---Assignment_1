package za.ac.cput.controller.studentdetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.studentdetails.StudentPrestige;
import za.ac.cput.services.Interface.studentdetails.IStudentPrestige;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abc-school-management/student-prestige")
@Slf4j
public class StudentPrestigeController {
    private final IStudentPrestige iStudentPrestige;

    @Autowired
    public StudentPrestigeController(IStudentPrestige iStudentPrestige) {
        this.iStudentPrestige = iStudentPrestige;
    }

    @PostMapping("/save")
    public ResponseEntity<StudentPrestige> save (@Valid @RequestBody StudentPrestige studentPrestige){
        log.info("Save request: {}", studentPrestige);
        System.out.println(String.format("Save request: &s", studentPrestige));
        StudentPrestige save = iStudentPrestige.save(studentPrestige);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{prestigeId}")
    public ResponseEntity<StudentPrestige> read (@PathVariable String prestigeId){
        log.info ("Read request: {}", prestigeId);
        StudentPrestige read = this.iStudentPrestige.read(prestigeId).get();
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{prestigeId}")
    public ResponseEntity<Void> delete (@PathVariable String prestigeId){
        log.info("Delete request: {}", prestigeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentPrestige>> findAll() {
        List<StudentPrestige> studentPrestige = this.iStudentPrestige.findAll();
        return ResponseEntity.ok(studentPrestige);
    }
}

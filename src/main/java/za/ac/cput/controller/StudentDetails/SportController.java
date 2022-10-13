package za.ac.cput.controller.StudentDetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.StudentDetails.Sport;


import za.ac.cput.services.Interface.StudentDetails.ISport;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abc-school-management/student")
@Slf4j
public class SportController {
    private final ISport ISportServices;

    @Autowired
    public SportController(ISport ISportServices) {
        this.ISportServices = ISportServices;
    }
    @PostMapping("/save")
    public ResponseEntity<Sport> save(@Valid @RequestBody Sport sport) {
        log.info("Save request: {}", sport);
        System.out.println(String.format("Save request: &s", sport));
        Sport save = ISportServices.save(sport);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{SporID}")
    public ResponseEntity<Sport> read(@PathVariable String SportID){
        log.info("Read request: {}", SportID);
        Sport read = this.ISportServices.read(SportID).get();
        return ResponseEntity.ok(read);
    }
    @DeleteMapping("delete/{SportID}")
    public ResponseEntity<Void> delete(@PathVariable String SportID) {
        log.info("Delete request {}", SportID);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity <List<Sport>> findAll() {
        List<Sport> sport = this.ISportServices.findAll();
        return ResponseEntity.ok(sport);
    }


}

/*
SportController.java
Controller Sport
Author: Marvin Hope - 219445842
 */



package za.ac.cput.controller.studentdetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.studentdetails.Sport;
import za.ac.cput.services.Interface.studentdetails.ISport;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abc-school-management/sport")
@Slf4j
public class SportController {
    private final ISport iSport;

    @Autowired
    public SportController(ISport iSport) {
        this.iSport = iSport;
    }
    @PostMapping("/save")
    public ResponseEntity<Sport> save(@Valid @RequestBody Sport sport) {
        log.info("Save request: {}", sport);
        System.out.println(String.format("Save request: &s", sport));
        Sport save = iSport.save(sport);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{sportID}")
    public ResponseEntity<Sport> read(@PathVariable String sportID) {
        log.info("Read Request: {}", sportID);
        Sport read = this.iSport.read(sportID).get();
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{sportID}")
    public ResponseEntity<Void> delete(@PathVariable String sportID) {
        log.info("Delete request {}", sportID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity <List<Sport>> findAll() {
        List<Sport> sport = this.iSport.findAll();
        return ResponseEntity.ok(sport);
    }
}
/*
ParentController.java
Controller Parent
Author: Marvin Hope - 219445842
 */


package za.ac.cput.controller.parentdetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.parentdetails.Parent;
import za.ac.cput.services.Interface.parentdetails.IParent;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abc-school-management/parent")
@Slf4j
public class ParentController {
    private final IParent iParentService;

    @Autowired
    public ParentController(IParent iParentService) {
        this.iParentService = iParentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Parent> save(@Valid @RequestBody Parent parent) {
        log.info("Save request: {}", parent);
        System.out.println(String.format("Save request: &s", parent));
        Parent save = iParentService.save(parent);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{parentId}")
    public ResponseEntity<Parent> read(@PathVariable String parentId) {
        log.info("Read Request: {}", parentId);
        Parent read = this.iParentService.read(parentId).get();
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{parentId}")
    public ResponseEntity<Void> delete(@PathVariable String parentId) {
        log.info("Delete request {}", parentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity <List<Parent>> findAll() {
        List<Parent> parent = this.iParentService.findall();
        return ResponseEntity.ok(parent);
    }
}
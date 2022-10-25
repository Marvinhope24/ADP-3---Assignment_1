package za.ac.cput.controller.staffdetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.staffdetails.SupportStaff;
import za.ac.cput.services.Interface.staffdetails.ISupportStaff;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/abc-school-management/supportStaff")
@Slf4j
public class SupportStaffController {
    private final ISupportStaff iSupportStaff;

    @Autowired
    public SupportStaffController(ISupportStaff iSupportStaff) {
        this.iSupportStaff = iSupportStaff;
    }
    @PostMapping("/save")
    public ResponseEntity<SupportStaff> save(@Valid @RequestBody SupportStaff supportStaff) {
        log.info("Save request: {}", supportStaff);
        System.out.println(String.format("Save request: &s", supportStaff));
        SupportStaff save = iSupportStaff.save(supportStaff);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{supportStaffID}")
    public ResponseEntity<SupportStaff> read(@PathVariable String supportStaffID) {
        log.info("Read Request: {}", supportStaffID);
        SupportStaff read = this.iSupportStaff.read(supportStaffID).get();
        return ResponseEntity.ok(read);
    }
    @DeleteMapping("delete/{supportStaffID}")
    public ResponseEntity<Void> delete(@PathVariable String supportStaffID) {
        log.info("Delete request {}", supportStaffID);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public ResponseEntity <List<SupportStaff>> findAll() {
        List<SupportStaff> supportStaffs = this.iSupportStaff.findall();
        return ResponseEntity.ok(supportStaffs);
    }
}
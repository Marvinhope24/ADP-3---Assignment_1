/*  StudentPrestigeImpl.java
    Services
    Author: Kegomoditswe Leshope - 219189048
    Date: 7 August 2022
 */

package za.ac.cput.services.Impl.studentdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.studentdetails.StudentPrestige;
import za.ac.cput.repository.studentdetailsrepo.IStudentPrestigeRepository;
import za.ac.cput.services.Interface.studentdetails.IStudentPrestige;

import java.util.List;
import java.util.Optional;

@Service
public class StudentPrestigeImpl implements IStudentPrestige {
    private final IStudentPrestigeRepository repository;

    @Autowired
    public StudentPrestigeImpl(IStudentPrestigeRepository repository) {
        this.repository = repository;
    }
    @Override
    public StudentPrestige save(StudentPrestige studentPrestige) {
        return this.repository.save(studentPrestige);
    }

    @Override
    public Optional<StudentPrestige> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(StudentPrestige studentPrestige) {
    this.repository.delete(studentPrestige);
    }

    @Override
    public List<StudentPrestige> findAll() {
        return this.repository.findAll();
    }
}

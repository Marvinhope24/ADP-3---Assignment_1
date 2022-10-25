/*
SportImpl.java
Services SportImpl
Author: Marvin Hope - 219445842
 */

package za.ac.cput.services.Impl.studentdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.studentdetails.Sport;
import za.ac.cput.repository.studentdetailsrepo.ISportRepository;
import za.ac.cput.services.Interface.studentdetails.ISport;

import java.util.List;
import java.util.Optional;

@Service
public class SportImpl implements ISport {
    @Autowired
    private final ISportRepository repository;

    @Autowired
    public SportImpl(ISportRepository repository){
        this.repository =  repository;
    }
    @Override
    public Sport save(Sport sport) {
        return this.repository.save(sport);
    }

    @Override
    public Optional<Sport> read(String id) {
        return this.repository.findById(id);
    }
    @Override
    public void delete(Sport sport) {
        this.repository.delete(sport);
    }

    @Override
    public List<Sport> findAll() {
        return this.repository.findAll();
    }

}
package za.ac.cput.services.Impl.parentdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.parentdetails.Fees;
import za.ac.cput.repository.parentdetailsrepo.IFeesRepository;
import za.ac.cput.services.Interface.parentdetails.IFees;

import java.util.List;
import java.util.Optional;

@Service
public class FeesImpl implements IFees {
    private final IFeesRepository repository;

    @Autowired public FeesImpl(IFeesRepository repository){
        this.repository = repository;
    }
    @Override
    public Fees save(Fees fees) {
        return this.repository.save(fees);
    }
    @Override
    public Optional<Fees> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Fees fees) {
        this.repository.delete(fees);
    }

    @Override
    public List<Fees> findAll() {
        return this.repository.findAll();
    }
}

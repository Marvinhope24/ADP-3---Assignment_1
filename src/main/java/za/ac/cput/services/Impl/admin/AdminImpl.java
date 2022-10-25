/*
AdminImpl.java
Factory AdminImpl
Author: Marvin Hope - 219445842
 */


package za.ac.cput.services.Impl.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.repository.adminrepo.IAdminRepository;
import za.ac.cput.services.Interface.admin.IAdmin;

import java.util.List;
import java.util.Optional;

@Service
public class AdminImpl implements IAdmin {
    private final IAdminRepository repository;

    @Autowired
    public AdminImpl(IAdminRepository repository) {
        this.repository = repository;
    }
    @Override
    public Admin save(Admin admin) {
        return this.repository.save(admin);
    }
    @Override
    public Optional<Admin> read(String s) {
        return this.repository.findById(s);
    }
    @Override
    public void delete(Admin admin) {
        this.repository.findAll();
    }
    @Override
    public List<Admin> findall() {
        return this.repository.findAll();
    }
}
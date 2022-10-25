package za.ac.cput.repository.studentdetailsrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.studentdetails.Sport;

@Repository
public interface ISportRepository extends JpaRepository<Sport, String> {

}

/*
ISupportStaff.java
Repository for ISupportStaffRepository
Author: Tiffany Kiwiets
*/

package za.ac.cput.repository.staffdetailsrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.staffdetails.SupportStaff;

@Repository
public interface ISupportStaffRepository extends JpaRepository<SupportStaff, String> {
}

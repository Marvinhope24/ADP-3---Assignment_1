/*
SupportStaffFactoryTest.java
Test for SupportStaffFactory
Author: Tiffany Kiwiets (219322732)
*/

package za.ac.cput.factory.staffdetails;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.domain.staffdetails.SupportStaff;
import za.ac.cput.factory.admin.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

class SupportStaffFactoryTest {
    @Test
    public void BuildWithSuccess() {
        Admin admin = AdminFactory.createAdmin(
                "6325984",
                "48569 1266 75896");

        SupportStaff supportStaff = SupportStaffFactory.build(
                "635941258",
                admin,
                "Julius",
                "Jacob",
                "08569112567",
                "Allegic to bees",
                "Degree in sport management",
                "Head of sports management");
        assertNotNull(supportStaff);
        System.out.println(supportStaff);
    }

    @Test
    public void BuildWithError() {
        Admin admin = AdminFactory.createAdmin(
                "6325984",
                "48569 1266 75896");

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SupportStaffFactory.build(
                        null,
                        admin,
                        "Julius",
                        "Jacob",
                        "08569112567",
                        "Allegic to bees",
                        "Degree in sport management",
                        "Head of sports management"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("ID is required!", exceptionMessage);

    }
}
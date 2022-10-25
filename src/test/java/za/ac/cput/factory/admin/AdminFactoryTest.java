/*
AdminFactory.java
Test AdminFactory
Author: Marvin Hope - 219445842
 */

package za.ac.cput.factory.admin;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.admin.Admin;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    public void BuildWithSuccess() {
        Admin admin = AdminFactory.createAdmin(
                "3245643",
                "45694 3244 54324");
        assertNotNull(admin);
        System.out.println(admin);

    }
    @Test
    public void BuildWithFailure() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> AdminFactory.createAdmin(
                        null ,
                        "45694 3244 54324"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Banking ID is required!", exceptionMessage);
    }
}
/* AdminImplTest.java
Testing for AdminImpl
Author: Marvin Peter Hope (219445842)
*/
package za.ac.cput.services.Impl.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.factory.admin.AdminFactory;
import za.ac.cput.services.Interface.admin.IAdmin;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminImplTest {
    private Admin admin;
    @Autowired
    private IAdmin service;

    @BeforeEach
    void setUp(){
        this.admin = AdminFactory.createAdmin(
                "3245643",
                "45696 3244 54324");
        Admin save = this.service.save(this.admin);
        assertAll(
                () -> assertNotNull(save),
                () -> assertEquals(this.admin, save)
        );
    }

    @Test
    @Order(1)
    void findall() {
        List<Admin> adminList = this.service.findall();
        System.out.println(adminList);
        assertEquals(1, adminList.size());
    }

    @Test
    @Order(2)
    void save() {
        Admin save = this.service.save(this.admin);
        System.out.println(save);
        assertNotNull(save);
    }

    @Test
    @Order(3)
    void read() {
        Optional<Admin> read = this.service.read(this.admin.getAdminID());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.admin, read.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        Admin delete = this.service.save(this.admin);
        List<Admin> adminList = this.service.findall();
        assertEquals(1,adminList.size());
        System.out.println("Deleted!");
        this.service.delete(delete);
    }
}


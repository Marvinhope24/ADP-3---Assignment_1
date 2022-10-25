package za.ac.cput.services.Impl.parentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.domain.parentdetails.Fees;
import za.ac.cput.domain.parentdetails.Parent;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.factory.admin.AdminFactory;
import za.ac.cput.factory.parentdetails.FeesFactory;
import za.ac.cput.factory.parentdetails.ParentFactory;
import za.ac.cput.factory.studentdetails.StudentFactory;
import za.ac.cput.services.Interface.parentdetails.IFees;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FeesImplTest {
    private Student student;
    private Parent parent;
    private Admin admin;
    private Fees fees;
    @Autowired
    private IFees service;

    @BeforeEach
    void setUp(){
        this.student = StudentFactory.Build(
                "2138532",
                "Jack",
                "Molten",
                12,
                "5th January 1999",
                3345,
                "14 Hope Street Cape Town",
                "None",
                54.6);
        this.parent = ParentFactory.build(
                "2343544",
                "John",
                "Molten",
                "073 697 1537",
                "johnmolton12@gmail.com",
                student);
        this.admin = AdminFactory.createAdmin(
                "3245643",
                "45696 3244 54324");
        this.fees = FeesFactory.build("34532"
                ,student
                ,admin
                ,parent
                ,2000.00);
        Fees save = this.service.save(this.fees);
    }

    @Test
    @Order(1)
    void findall() {
        List<Fees> feesList = this.service.findAll();
        System.out.println(feesList);
        assertEquals(1,feesList.size());
    }

    @Test
    @Order(2)
    void save() {
        Fees save = this.service.save(this.fees);
        System.out.println(save);
        assertNotNull(save);
    }

    @Test
    @Order(3)
    void read() {
        Optional<Fees> read = this.service.read(this.fees.getFeeID());
        System.out.println(read);
    }

    @Test
    @Order(4)
    void delete() {
        Fees delete = this.service.save(this.fees);
        List<Fees> feesList = this.service.findAll();
        assertEquals(1,feesList.size());
        System.out.println("Deleted! ");
        this.service.delete(delete);
    }
}
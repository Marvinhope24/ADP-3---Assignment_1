/* SportImplTest.java
Testing for SportIMpl
Author: Marvin Peter Hope (219445842)
*/

package za.ac.cput.services.Impl.studentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.domain.staffdetails.Teacher;
import za.ac.cput.domain.studentdetails.Sport;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.factory.admin.AdminFactory;
import za.ac.cput.factory.staffdetails.TeacherFactory;
import za.ac.cput.factory.studentdetails.SportFactory;
import za.ac.cput.factory.studentdetails.StudentFactory;
import za.ac.cput.services.Interface.studentdetails.ISport;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SportImplTest {
    private Student student;
    private Teacher teacher;
    private Sport sport;
    private Admin admin;

    @Autowired
    private ISport service;

    @BeforeEach
    void setUp() {
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
       this.admin = AdminFactory.createAdmin(
                "3245643",
                "45694 3244 54324");

        this.teacher = TeacherFactory.build("36594",
                "Jimmy",
                "Beast",
                "039 359 1536",
                "Master degree",
                "None",
                "Government",
                admin);
        this.sport = SportFactory.createSport("23452",
                student,
                teacher,
                "34.45%");
        Sport save = this.service.save(this.sport);
        assertAll(
                () -> assertNotNull(save),
                () -> assertEquals(this.sport, save)
        );
    }
    @Test
    @Order(1)
    void findAll() {
        List<Sport> sportList = this.service.findAll();
        System.out.println(sportList);
        assertEquals(2,sportList.size());
    }
    @Test
    @Order(2)
    void save() {
        Sport save = this.service.save(this.sport);
        System.out.println(save);
        assertNotNull(save);
    }

    @Test
    @Order(3)
    void read() {
        Optional<Sport> read = this.service.read(this.sport.getSportID());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.sport, read.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        Sport delete = this.service.save(this.sport);
        List<Sport> sportList = this.service.findAll();
        assertEquals(2,sportList.size());
        System.out.println("Deleted!");
        this.service.delete(delete);
    }
}
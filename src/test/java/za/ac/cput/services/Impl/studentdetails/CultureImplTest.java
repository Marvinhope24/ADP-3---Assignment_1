/*  CultureImplTest.java
    Culture services Tests
    Author: Kegomoditswe Leshope - 219189048
    Date: 7 August 2022
 */

package za.ac.cput.services.Impl.studentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.studentdetails.Culture;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.factory.studentdetails.CultureFactory;
import za.ac.cput.factory.studentdetails.StudentFactory;
import za.ac.cput.services.Interface.studentdetails.ICulture;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CultureImplTest {
    private Student student;
    private Culture culture;
    @Autowired private ICulture service;
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
        this.culture = CultureFactory.build(
                "178",
                "Dance",
                student);
        Culture save = this.service.save(this.culture);
        assertAll(
                () -> assertNotNull(save),
                () -> assertEquals(this.culture, save)
        );
    }
    @Test
    @Order(1)
    void findAll() {
        List<Culture> cultureList = this.service.findAll();
        System.out.println(cultureList);
        assertEquals(2,cultureList.size());
    }

    @Test
    @Order(2)
    void save() {
        Culture save = this.service.save(this.culture);
        System.out.println(save);
        assertNotNull(save);
    }

    @Test
    @Order(3)
    void read() {
        Optional<Culture> read = this.service.read(this.culture.getCultureId());
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.culture, read.get())
        );
    }

    @Test
    @Order(4)
    void delete() {
        Culture delete = this.service.save(this.culture);
        List<Culture> employeeList = this.service.findAll();
        assertEquals(2,employeeList.size());
        System.out.println("Deleted! ");
        this.service.delete(delete);
    }
}
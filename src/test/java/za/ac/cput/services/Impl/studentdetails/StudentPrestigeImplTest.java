/*  StudentPrestigeImplTest.java
    StudentPrestige services Tests
    Author: Kegomoditswe Leshope - 219189048
    Date: 7 August 2022
 */

package za.ac.cput.services.Impl.studentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.domain.staffdetails.Subject;
import za.ac.cput.domain.staffdetails.SubjectDepartment;
import za.ac.cput.domain.staffdetails.Teacher;
import za.ac.cput.domain.studentdetails.Culture;
import za.ac.cput.domain.studentdetails.Sport;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.domain.studentdetails.StudentPrestige;
import za.ac.cput.factory.admin.AdminFactory;
import za.ac.cput.factory.staffdetails.SubjectDepartmentFactory;
import za.ac.cput.factory.staffdetails.SubjectFactory;
import za.ac.cput.factory.staffdetails.TeacherFactory;
import za.ac.cput.factory.studentdetails.CultureFactory;
import za.ac.cput.factory.studentdetails.SportFactory;
import za.ac.cput.factory.studentdetails.StudentFactory;
import za.ac.cput.factory.studentdetails.StudentPrestigeFactory;
import za.ac.cput.services.Interface.studentdetails.IStudentPrestige;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentPrestigeImplTest {
    private Student student;
    private Admin admin;
    private Teacher teacher;
    private Sport sport;
    private SubjectDepartment subjectDepartment;
    private Subject subject;
    private Culture culture;
    private StudentPrestige studentPrestige;

    @Autowired private IStudentPrestige service;

    @BeforeEach
    void setUp(){
        this.subjectDepartment = SubjectDepartmentFactory.Build(
                "219091498",
                "Mathematics");
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
        this.sport = SportFactory.createSport(
                "05",
                student,
                teacher,
                "85");

        this.subject = SubjectFactory.build(
                "36259",
                "Math",
                56.30,
                65,
                subjectDepartment,
                student,
                teacher);
        this.culture= CultureFactory.build("01",
                "Dance",
                student);
        this.studentPrestige = StudentPrestigeFactory.build("01",
                "Certificate",
                student,
                sport,
                culture,
                subject);
        StudentPrestige save = this.service.save(this.studentPrestige);
    }

    @Test
    @Order(1)
    void findAll() {
        List<StudentPrestige> studentPrestigeList = this.service.findAll();
        System.out.println(studentPrestigeList);
        assertEquals(1,studentPrestigeList.size());
    }

    @Test
    @Order(2)
    void save() {
        StudentPrestige save = this.service.save(this.studentPrestige);
        System.out.println(save);
        assertNotNull(save);
    }

    @Test
    @Order(3)
    void read() {
        Optional<StudentPrestige> read = this.service.read(this.studentPrestige.getPrestigeId());
        System.out.println(read);
    }

    @Test
    @Order(4)
    void delete() {
        this.service.delete(this.studentPrestige);
    }
}
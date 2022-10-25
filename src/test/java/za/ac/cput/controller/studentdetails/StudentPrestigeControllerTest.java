package za.ac.cput.controller.studentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentPrestigeControllerTest {
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";
    @LocalServerPort
    private int port;
    @Autowired
    private StudentPrestigeController Controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Student student;
    private Admin admin;
    private Teacher teacher;
    private Sport sport;
    private Culture culture;
    private Subject subject;
    private SubjectDepartment subjectDepartment;
    private StudentPrestige studentPrestige;
    private String baseUrl;

    @BeforeEach
    void Setup() {
        assertNotNull(Controller);
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
        this.subjectDepartment = SubjectDepartmentFactory.Build(
                "219091498",
                "Mathematics");

        this.subject = SubjectFactory.build(
                "36259",
                "Math",
                56.30,
                65,
                subjectDepartment,
                student,
                teacher);
        this.culture = CultureFactory.build(
                "01",
                "Dance",
                student);
        this.studentPrestige = StudentPrestigeFactory.build(
                "01",
                "Certificate",
                student,
                sport,
                culture,
                subject);
        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/student-prestige";
    }
    @Test
    @Order(1)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
//        ResponseEntity<StudentPrestige[]> response = this.restTemplate.getForEntity(url, StudentPrestige[].class);
//        System.out.println(Arrays.asList(response.getBody()));

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<StudentPrestige[]> entity = new HttpEntity<>(null,headers);
        ResponseEntity<StudentPrestige[]> response =
                restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET,entity, StudentPrestige[].class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

    @Test
    @Order(2)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<StudentPrestige> response = this.restTemplate.postForEntity(url, this.studentPrestige, StudentPrestige.class);
        System.out.println(response);

    }

    @Test
    @Order(3)
    void read() {
        String url = baseUrl + "/read/" + this.studentPrestige.getPrestigeId();
        System.out.println(url);
        ResponseEntity<StudentPrestige> response = this.restTemplate.getForEntity(url, StudentPrestige.class);
        System.out.println(response);

    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + this.studentPrestige.getPrestigeId();
        this.restTemplate.delete(url);
        System.out.println("Deleted Record! ");
    }
}
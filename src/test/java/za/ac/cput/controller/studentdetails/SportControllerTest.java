/* SportControllerTest.java
Tests for SportController
Author: Marvin Peter Hope (219445842)
*/

package za.ac.cput.controller.studentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.domain.staffdetails.Teacher;
import za.ac.cput.domain.studentdetails.Sport;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.factory.admin.AdminFactory;
import za.ac.cput.factory.staffdetails.TeacherFactory;
import za.ac.cput.factory.studentdetails.SportFactory;
import za.ac.cput.factory.studentdetails.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SportControllerTest {
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";
    @LocalServerPort
    private int port;
    @Autowired
    private SportController Controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Student student;
    private Teacher teacher;
    private Sport sport;
    private Admin admin;
    private String baseUrl;

    @BeforeEach
    void setUp() {
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

        this.teacher = TeacherFactory.build(
                "36594",
                "Jimmy",
                "Beast",
                "039 359 1536",
                "Master degree",
                "None",
                "Government",
                admin);
        this.sport = SportFactory.createSport(
                "23452",
                student,
                teacher,
                "34.45%");
        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/sport";
    }
    @Test
    @Order(1)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Sport[]> entity = new HttpEntity<>(null,headers);
        ResponseEntity<Sport[]> response =
                restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET,entity, Sport[].class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
//        ResponseEntity<Sport[]> response =
//                this.restTemplate.getForEntity(url, Sport[].class);
//        System.out.println(Arrays.asList(response.getBody()));
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertTrue(response.getBody().length == 0 )
//        );
    }

    @Test
    @Order(2)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Sport> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, this.sport, Sport.class);
        System.out.println(response);
    }

    @Test
    @Order(3)
    void read() {
        String url = baseUrl + "/read/" + this.sport.getSportID();
        System.out.println(url);
        ResponseEntity<Sport> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).getForEntity(url, Sport.class);
        System.out.println(response);
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + this.sport.getSportID();
        this.restTemplate.delete(url);
        System.out.println("Deleted Record! ");
    }
}
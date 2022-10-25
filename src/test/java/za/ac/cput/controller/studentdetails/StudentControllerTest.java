/* StudentControllerTest.java
Tests for StudentController
Author: Marvin Peter Hope (219445842)
*/

package za.ac.cput.controller.studentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.factory.studentdetails.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";
    @LocalServerPort
    private int port;
    @Autowired
    private StudentController Controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Student student;
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
        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/student";
    }

    @Test
    @Order(1)
    void findAll() {
        String url = baseUrl + "/findAll";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Student[]> entity = new HttpEntity<>(null,headers);
        ResponseEntity<Student[]> response =
                restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET,entity, Student[].class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
//        System.out.println(url);
//        ResponseEntity<Student[]> response =
//                this.restTemplate.getForEntity(url, Student[].class);
//        System.out.println(Arrays.asList(response.getBody()));
   }

    @Test
    @Order(2)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, this.student, Student.class);
        System.out.println(response);
    }

    @Test
    @Order(3)
    void read() {
        String url = baseUrl + "/read/" + this.student.getStudentID();
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).getForEntity(url, Student.class);
        System.out.println(response);
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + this.student.getStudentID();
        this.restTemplate.delete(url);
        System.out.println("Deleted Record! ");
    }
}
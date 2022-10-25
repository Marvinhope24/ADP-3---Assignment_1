/* ParentControllerTest.java
Tests for ParentController
Author: Marvin Peter Hope (219445842)
*/

package za.ac.cput.controller.parentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.parentdetails.Parent;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.factory.parentdetails.ParentFactory;
import za.ac.cput.factory.studentdetails.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParentControllerTest {
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";
    @LocalServerPort
    private int port;
    @Autowired
    private ParentController parentController;
    @Autowired
    private TestRestTemplate restTemplate;
    private Student student;
    private Parent parent;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(parentController);
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
                student
        );
        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/parent";
    }

    @Test
    @Order(1)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<Parent[]> response =
                restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET,entity, Parent[].class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(Arrays.toString(response.getBody()));
        System.out.println(url);
//        ResponseEntity<Parent[]> response =
//                this.restTemplate.getForEntity(url, Parent[].class);
//        System.out.println(Arrays.asList(response.getBody()));
  }

    @Test
    @Order(2)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Parent> response = this.restTemplate.postForEntity(url, this.parent, Parent.class);
        System.out.println(response);
    }

    @Test
    @Order(3)
    void read() {
        String url = baseUrl + "/read/" + this.parent.getParentID();
        System.out.println(url);
        ResponseEntity<Parent> response = this.restTemplate.getForEntity(url, Parent.class);
        System.out.println(response);
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + this.parent.getParentID();
        this.restTemplate.delete(url);
        System.out.println("Deleted Record! ");
    }

}
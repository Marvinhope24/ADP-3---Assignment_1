/* SubjectDepartmentControllerTest.java
   Controller Test for the Subject Department
   Author: Raeesah Williams (219091498)
   Date: 07 October 2022
*/

package za.ac.cput.controller.staffdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.staffdetails.SubjectDepartment;
import za.ac.cput.factory.staffdetails.SubjectDepartmentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SubjectDepartmentControllerTest
{
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";
    @LocalServerPort
    private int port;
    @Autowired
    private SubjectDepartmentController Controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private SubjectDepartment subjectDepartment;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(Controller);
        this.subjectDepartment = SubjectDepartmentFactory.Build(
                "219091498",
                "Geography");
        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/subjectDepartment";
    }

    @Test
    @Order(1)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<SubjectDepartment[]> entity = new HttpEntity<>(null,headers);
        ResponseEntity<SubjectDepartment[]> response =
                restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET,entity, SubjectDepartment[].class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
//        ResponseEntity<SubjectDepartment[]> response =
//                this.restTemplate.getForEntity(url, SubjectDepartment[].class);
//        System.out.println(Arrays.asList(response.getBody()));
    }

    @Test
    @Order(2)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<SubjectDepartment> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, this.subjectDepartment, SubjectDepartment.class);
        System.out.println(response);
    }

    @Test
    @Order(3)
    void read() {
        String url = baseUrl + "/read/" + this.subjectDepartment.getSubDeptID();
        System.out.println(url);
        ResponseEntity<SubjectDepartment> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).getForEntity(url, SubjectDepartment.class);
        System.out.println(response);
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + this.subjectDepartment.getSubDeptID();
        this.restTemplate.delete(url);
        System.out.println("Record Deleted");
    }
}
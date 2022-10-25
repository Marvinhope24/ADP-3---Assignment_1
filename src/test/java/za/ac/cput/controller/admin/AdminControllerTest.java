/* AdminControllerTest.java
Tests for AdminController
Author: Marvin Peter Hope (219445842)
*/
package za.ac.cput.controller.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.factory.admin.AdminFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminControllerTest {
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";
    @LocalServerPort
    private int port;
    @Autowired
    private AdminController Controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Admin admin;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(Controller);
        this.admin = AdminFactory.createAdmin(
                "3245643",
                "45694 3244 54324");
        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/admin";
    }


    @Test
    @Order(1)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity <String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<Admin[]> response =
                restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET,entity, Admin[].class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
//        System.out.println(url);
//        ResponseEntity<Admin[]> response =
//                this.restTemplate.getForEntity(url, Admin[].class);
        //        System.out.println(Arrays.asList(response.getBody()));

    }

    @Test
    @Order(2)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Admin> response = this.restTemplate.postForEntity(url, this.admin, Admin.class);
        System.out.println(response);
    }

    @Test
    @Order(3)
    void read() {
            String url = baseUrl + "/read/" + this.admin.getAdminID();
            System.out.println(url);
            ResponseEntity<Admin> response = this.restTemplate.getForEntity(url, Admin.class);
            System.out.println(response);
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + this.admin.getAdminID();
        this.restTemplate.delete(url);
        System.out.println("Deleted Record! ");
    }
}
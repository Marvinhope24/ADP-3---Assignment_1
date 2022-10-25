package za.ac.cput.controller.staffdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.domain.staffdetails.SupportStaff;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.factory.admin.AdminFactory;
import za.ac.cput.factory.staffdetails.SupportStaffFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupportStaffControllerTest {

    public static String SECURITY_USERNAME = "user";
    public static String SECURITY_PASSWORD = "password";

    @LocalServerPort
    private int port;

    @Autowired
    private SupportStaffController Controller;

    @Autowired
    private TestRestTemplate restTemplate;

    private Admin admin;
    private SupportStaff supportStaff;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(Controller);
        this.admin = AdminFactory.createAdmin(
                "3245643",
                "45696 3244 54324");
        this.supportStaff = SupportStaffFactory.build(
                "635941258",
                admin,
                "Julius",
                "Jacob",
                "08569112567",
                "Allegic to bees",
                "Degree in sport management",
                "Head of sports management");

        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/supportStaff";
    }

    @Order(1)
    @Test
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<SupportStaff[]> entity = new HttpEntity<>(null,headers);
        ResponseEntity<SupportStaff[]> response =
                restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET,entity, SupportStaff[].class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
//        System.out.println(url);
//        ResponseEntity<SupportStaff[]> response =
//                this.restTemplate.getForEntity(url, SupportStaff[].class);
//        System.out.println(Arrays.asList(response.getBody()));
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> assertTrue(response.getBody().length == 0 )
//        );
    }

    @Order(2)
    @Test
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<SupportStaff> response = this.restTemplate.postForEntity(url, this.supportStaff, SupportStaff.class);
        System.out.println(response);
    }

    @Order(3)
    @Test
    void read() {
        String url = baseUrl + "/read/" + this.supportStaff.getSuppStaffID();
        System.out.println(url);
        ResponseEntity<SupportStaff> response = this.restTemplate.getForEntity(url, SupportStaff.class);
        System.out.println(response);
    }

    @Order(4)
    @Test
    void delete() {
        String url = baseUrl + "/delete/" + this.supportStaff.getSuppStaffID();
        this.restTemplate.delete(url);
        System.out.println("Deleted Record! ");
    }
}
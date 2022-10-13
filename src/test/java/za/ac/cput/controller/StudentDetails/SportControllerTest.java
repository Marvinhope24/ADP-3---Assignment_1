package za.ac.cput.controller.StudentDetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.StudentDetails.Sport;

import za.ac.cput.factory.StudentDetails.SportFactory;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SportControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private Sport Controller;
    @Autowired
    TestRestTemplate restTemplate;
    private Sport sport;
    private String baseUrl;

    @BeforeEach
    void setUp() {


        assertNotNull(Controller);
        this.sport = SportFactory.createSport(
                "219200815",
                "00012",
                "02030",
                "25%");
        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/student";


    }

    @Test
    @Order(1)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        ResponseEntity<Sport[]> response =
                this.restTemplate.getForEntity(url, Sport[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );


    }

    @Test
    @Order(2)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Sport> response = this.restTemplate.postForEntity(url, this.sport, Sport.class);
        System.out.println(response);
        assertAll (
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(3)
    void read() {
        String url = baseUrl + "/read/" + this.sport.getSportID();
        System.out.println(url);
        ResponseEntity<Sport> response = this.restTemplate.getForEntity(url, Sport.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + this.sport.getSportID();
        this.restTemplate.delete(url);
        System.out.println("Deleted Record! ");
    }

}
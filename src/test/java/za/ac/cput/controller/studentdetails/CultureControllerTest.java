/* CultureControllerTest.java
   Controller Tests for Culture
   Author: Kegomoditswe Leshope - 219189048
   Date:  7 September 2022
*/

package za.ac.cput.controller.studentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.studentdetails.Culture;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.factory.studentdetails.CultureFactory;
import za.ac.cput.factory.studentdetails.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CultureControllerTest {
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";
    @LocalServerPort
    private int port;
    @Autowired CultureController controller;
    @Autowired TestRestTemplate restTemplate;
    private Culture culture;
    private Student student;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
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
        this.culture = CultureFactory.build("01",
                "Dance",
                student);

        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/culture";
    }
    @Test
    @Order(1)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Culture[]> entity = new HttpEntity<>(null,headers);
        ResponseEntity<Culture[]> response =
                restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET,entity, Culture[].class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
//        ResponseEntity<Culture[]> response =
//                this.restTemplate.getForEntity(url, Culture[].class);
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
        ResponseEntity<Culture> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url, this.culture, Culture.class);
        System.out.println(response);
    }

    @Test
    @Order(3)
    void read() {
        String url = baseUrl + "/read/" + this.culture.getCultureId();
        System.out.println(url);
        ResponseEntity<Culture> response = this.restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).getForEntity(url, Culture.class);
        System.out.println(response);
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + this.culture.getCultureId();
        this.restTemplate.delete(url);
        System.out.println("Deleted Record! ");
    }
}
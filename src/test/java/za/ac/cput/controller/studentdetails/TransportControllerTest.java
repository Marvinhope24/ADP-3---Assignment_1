/* TransportControllerTest.java
   Controller Test for the Subject Department
   Author: Raeesah Williams (219091498)
   Date: 07 October 2022
*/

package za.ac.cput.controller.studentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.ac.cput.domain.studentdetails.Transport;
import za.ac.cput.factory.studentdetails.TransportFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransportControllerTest
{
    public static String SECURITY_USERNAME= "user";
    public static String SECURITY_PASSWORD= "password";
    @LocalServerPort
    private int port;
    @Autowired
    private TransportController Controller;
    @Autowired
    private TestRestTemplate restTemplate;
    private Transport transport;
    private String baseUrl;

    @BeforeEach
    void setUp()
    {
        assertNotNull(Controller);
        this.transport = TransportFactory.Build(
                "219091498",
                "Bus");
        this.baseUrl = "http://localhost:" + this.port + "/abc-school-management/transport";
    }

    @Test
    @Order(1)
    void findAll() {
        String url = baseUrl + "/all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<Transport[]> response =
                restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                        .exchange(url, HttpMethod.GET,entity, Transport[].class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
//        ResponseEntity<Transport[]> response =
//                this.restTemplate.getForEntity(url, Transport[].class);
//        System.out.println(Arrays.asList(response.getBody()));
    }

    @Test
    @Order(2)
    void save() {
        String url = baseUrl + "/save";
        System.out.println(url);
        ResponseEntity<Transport> response = this.restTemplate.postForEntity(url, this.transport, Transport.class);
        System.out.println(response);
    }

    @Test
    @Order(3)
    void read() {
        String url = baseUrl + "/read/" + this.transport.getTransportID();
        System.out.println(url);
        ResponseEntity<Transport> response = this.restTemplate.getForEntity(url, Transport.class);
        System.out.println(response);
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseUrl + "/delete/" + this.transport.getTransportID();
        this.restTemplate.delete(url);
        System.out.println("Record Deleted");
    }
}
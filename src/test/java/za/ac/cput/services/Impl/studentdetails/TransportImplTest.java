/* TransportImplTest.java
   Implementation Test for Transport
   Author: Raeesah Williams (219091498)
   Date: 05 September 2022
*/

package za.ac.cput.services.Impl.studentdetails;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.studentdetails.Transport;
import za.ac.cput.factory.studentdetails.TransportFactory;
import za.ac.cput.services.Interface.studentdetails.ITransport;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransportImplTest
{
    private Transport transport;
    @Autowired
    private ITransport service;

    @BeforeEach
    void setUp()
    {
        this.transport = TransportFactory.Build(
                "395704859",
                "30954");
        Transport save = this.service.save(this.transport);
        assertAll(
                () -> assertNotNull(save),
                () -> assertEquals(this.transport, save)
        );
    }
    @Test
    @Order(1)
    void findAll()
    {
        List<Transport> transportList = this.service.findAll();
        System.out.println(transportList);
        assertEquals(2, transportList.size());
    }

    @Test
    @Order(2)
    void save()
    {
        Transport save = this.service.save(this.transport);
        System.out.println(save);
        assertNotNull(save);
    }

    @Test
    @Order(3)
    void read()
    {
        Optional<Transport> read = this.service.read(this.transport.getTransportID());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(this.transport, read.get())
        );
    }

    @Test
    @Order(4)
    void delete()
    {
        Transport delete = this.service.save(this.transport);
        List<Transport> transportList = this.service.findAll();
        assertEquals(2, transportList.size());
        System.out.println("Deleted");
        this.service.delete(delete);
    }
}
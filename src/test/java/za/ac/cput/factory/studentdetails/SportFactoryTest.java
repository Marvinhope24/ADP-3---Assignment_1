/* SportFactoryTest.java
Testing for SportFactoryTest
Author: Marvin Peter Hope (219445842)
*/
package za.ac.cput.factory.studentdetails;

import org.junit.jupiter.api.Test;

import za.ac.cput.domain.admin.Admin;
import za.ac.cput.domain.staffdetails.Teacher;
import za.ac.cput.domain.studentdetails.Sport;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.factory.admin.AdminFactory;
import za.ac.cput.factory.staffdetails.TeacherFactory;

import static org.junit.jupiter.api.Assertions.*;

class SportFactoryTest {
    @Test
    public void BuildWithSuccess() {
        Student student = StudentFactory.Build(
                "2138532",
                "Jack",
                "Molten",
                12,
                "5th January 1999",
                3345,
                "14 Hope Street Cape Town",
                "None",
                54.6);
        Admin admin = AdminFactory.createAdmin(
                "3245643",
                "45694 3244 54324");

        Teacher teacher = TeacherFactory.build("36594",
                "Jimmy",
                "Beast",
                "039 359 1536",
                "Master degree",
                "None",
                "Government",
                admin);
        Sport sport = SportFactory.createSport("23452",student,teacher,"34.45%");
        assertNotNull(sport);
        System.out.println(sport);
    }
    @Test
    public void BuildWithFailure(){

        Student student = StudentFactory.Build(
                "2138532",
                "Jack",
                "Molten",
                12,
                "5th January 1999",
                3345,
                "14 Hope Street Cape Town",
                "None",
                54.6);
        Admin admin = AdminFactory.createAdmin(
                "3245643",
                "45694 3244 54324");

        Teacher teacher = TeacherFactory.build("36594",
                "Jimmy",
                "Beast",
                "039 359 1536",
                "Master degree",
                "None",
                "Government",
                admin);
        Exception error = assertThrows(IllegalArgumentException.class, () ->
                 SportFactory.createSport(null,student,teacher,"34.45%"));
        String ExceptionMessage = error.getMessage();
        System.out.println(error);
        assertSame("Sports ID Required!", ExceptionMessage);

    }
}
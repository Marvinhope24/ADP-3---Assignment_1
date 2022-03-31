package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Sport;
import za.ac.cput.util.Helper;


//Siyabonga Tumelo Masango
//219200815
//31/03/2022
//sportFactory.java
public class SportFactory {

    public static Sport createSport(int sportID, int  studentID, int teacherID, double performanceScore) {
        if ( sportID < 0 || studentID < 0 || teacherID < 0 ||performanceScore <= 0)
            return null;

        return new Sport.Builder()
                .setSportID(sportID)
                .setStudentID(studentID)
                .setTeacherID(teacherID).
                setPerormanceScore(performanceScore)
                .build();


    }
}
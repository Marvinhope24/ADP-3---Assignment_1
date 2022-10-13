package za.ac.cput.factory.StudentDetails;


import za.ac.cput.domain.StudentDetails.Sport;
import za.ac.cput.util.Helper;

//Siyabonga Tumelo Masango
//219200815
//31/03/2022
//sportFactory.java
public class SportFactory {

    public static Sport createSport(String sportID, String  studentID, String teacherID, String performanceScore) {
        if(Helper. isEmptyOrNull(sportID)|| Helper. isEmptyOrNull((studentID)) || Helper. isEmptyOrNull(teacherID)|| Helper. isEmptyOrNull(performanceScore))
            return null;

        return new Sport.Builder()
                .setSportID(sportID)
                .setStudentID(studentID)
                .setTeacherID(teacherID).
                setPerormanceScore(performanceScore)
                .build();


    }
}
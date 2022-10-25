/*
SportController.java
Domain Sport
Author: Marvin Hope - 219445842
 */

package za.ac.cput.domain.studentdetails;

import com.sun.istack.NotNull;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import za.ac.cput.domain.staffdetails.Teacher;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
public class Sport {

    @NotNull
    @Id
    private String sportID;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @NotFound(action = NotFoundAction.IGNORE)
    @NotNull
    private Student studentID;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @NotFound(action = NotFoundAction.IGNORE)
    @NotNull
    private Teacher teacherID;
    @NotNull
    private  String  perormanceScore;

    protected Sport() {
    }

    private Sport(Sport.Builder builder){

        this.sportID = builder.sportID;
        this.studentID = builder.studentID;
        this.teacherID = builder.teacherID;
        this.perormanceScore = builder.perormanceScore;
    }

    public String getSportID() {
        return sportID;
    }

    public Student getStudentID() {
        return studentID;
    }

    public Teacher getTeacherID() {
        return teacherID;
    }

    public String getPerormanceScore() {
        return perormanceScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sport sport = (Sport) o;
        return sportID.equals(sport.sportID) && studentID.equals(sport.studentID) && teacherID.equals(sport.teacherID) && perormanceScore.equals(sport.perormanceScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportID, studentID, teacherID, perormanceScore);
    }
    @Override
    public String toString() {
        return "Sport{" +
                "sportID='" + sportID + '\'' +
                ", studentID=" + studentID +
                ", teacherID=" + teacherID +
                ", perormanceScore='" + perormanceScore + '\'' +
                '}';
    }

    public static class Builder {
        private String sportID;
        private Student studentID;
        private Teacher teacherID;
        private  String perormanceScore;


        public Builder setSportID(String sportID) {
            this.sportID = sportID;
            return this;
        }

        public Builder setStudentID(Student studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setTeacherID(Teacher teacherID) {
            this.teacherID = teacherID;
            return this;
        }

        public Builder setPerormanceScore(String perormanceScore) {
            this.perormanceScore = perormanceScore;
            return this;
        }
        public Sport.Builder copy(Sport  sport){

            this.sportID = sport.sportID;
            this.studentID = sport.studentID;
            this.teacherID = sport.teacherID;
            this.perormanceScore = sport.perormanceScore;
            return this;

        }
        public Sport build(){
            return new Sport (this);
        }
    }
}


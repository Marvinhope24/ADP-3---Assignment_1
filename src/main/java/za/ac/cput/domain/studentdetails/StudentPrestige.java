package za.ac.cput.domain.studentdetails;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import za.ac.cput.domain.staffdetails.Subject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
public class StudentPrestige implements Serializable {
    @Id
//    @Column(name = "prestige_id")
    @NotNull
    private String prestigeId;
    @NotNull private String prestigeType;

    //    @ManyToOne
//    @JoinColumn(name = "student_id")
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private Student student;

    //    @ManyToOne
//    @JoinColumn (name = "sport_id")
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private Sport sport;

    //    @ManyToOne
//    @JoinColumn (name = "culture_id")
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private Culture culture;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    private Subject subject;

    protected StudentPrestige(){
    }

    //Private constructor====

    private StudentPrestige (Builder builder){
        this.prestigeId = builder.prestigeId;
        this.prestigeType = builder.prestigeType;
        this.student = builder.student;
        this.sport = builder.sport;
        this.culture = builder.culture;
        this.subject = builder.subject;
    }

    //Getters====

    public String getPrestigeId() {
        return prestigeId;
    }

    public String getPrestigeType() {
        return prestigeType;
    }

    public Student getStudent() {
        return student;
    }

    public Sport getSport() {
        return sport;
    }

    public Culture getCulture() {
        return culture;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentPrestige that = (StudentPrestige) o;
        return Objects.equals(prestigeId, that.prestigeId) && Objects.equals(prestigeType, that.prestigeType) && Objects.equals(student, that.student) && Objects.equals(sport, that.sport) && Objects.equals(culture, that.culture) && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prestigeId, prestigeType, student, sport, culture, subject);
    }

    //toString====
    @Override
    public String toString() {
        return "StudentPrestige{" +
                "prestigeId='" + prestigeId + '\'' +
                ", prestigeType='" + prestigeType + '\'' +
                ", student=" + student +
                ", sport=" + sport +
                ", culture=" + culture +
                ", subject=" + subject +
                '}';
    }

    //Builder pattern====
    public static class Builder{
        private String prestigeId;
        private String prestigeType;
        private Student student;
        private Sport sport;
        private Culture culture;
        private Subject subject;

        public Builder prestigeId(String prestigeId){
            this.prestigeId = prestigeId;
            return this;
        }

        public Builder prestigeType(String prestigeType){
            this.prestigeType = prestigeType;
            return this;
        }

        public Builder student(Student student){
            this.student = student;
            return this;
        }

        public Builder sport (Sport sport){
            this.sport = sport;
            return this;
        }

        public Builder culture (Culture culture){
            this.culture = culture;
            return this;
        }

        public Builder subject (Subject subject){
            this.subject = subject;
            return this;
        }

        public Builder copy (StudentPrestige studentPrestige){
            this.prestigeId = studentPrestige.prestigeId;
            this.prestigeType = studentPrestige.prestigeType;
            this.student = studentPrestige.student;
            this.sport = studentPrestige.sport;
            this.culture = studentPrestige.culture;
            this.subject = studentPrestige.subject;
            return this;
        }

        public StudentPrestige build(){
            return new StudentPrestige(this);
        }
    }
}

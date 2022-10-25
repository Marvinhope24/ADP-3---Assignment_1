/* Parent.java
Builder Pattern for Parent
Author: Marvin Peter Hope (219445842)
Date: 7 August 2022
*/

package za.ac.cput.domain.parentdetails;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import za.ac.cput.domain.studentdetails.Student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Entity
public class Parent implements Serializable {
    @Id @NotNull private String parentID;
    @NotNull private String parName;
    @NotNull private String parSurname;
    @NotNull private String cellNumber;
    @NotNull private String email;
    @ManyToOne(cascade = {PERSIST, MERGE})
    @NotFound(action = NotFoundAction.IGNORE)
    @NotNull
    private Student student;

    protected Parent() {
    }

    //====================================================
    //Private Constructor
    private Parent(Builder builder) {
        this.parentID = builder.parentID;
        this.parName = builder.parName;
        this.parSurname = builder.parSurname;
        this.cellNumber = builder.cellNumber;
        this.email = builder.email;
        this.student = builder.student;
    }

    //====================================================
    //Getters
    public String getParentID() {
        return parentID;
    }

    public String getParName() {
        return parName;
    }

    public String getParSurname() {
        return parSurname;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getEmail() {
        return email;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return parentID.equals(parent.parentID) && parName.equals(parent.parName) && parSurname.equals(parent.parSurname) && cellNumber.equals(parent.cellNumber) && email.equals(parent.email) && student.equals(parent.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentID, parName, parSurname, cellNumber, email, student);
    }

    //====================================================
    // toString
    @Override
    public String toString() {
        return "Parent{" +
                "parentID='" + parentID + '\'' +
                ", parName='" + parName + '\'' +
                ", parSurname='" + parSurname + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                ", email='" + email + '\'' +
                ", student=" + student +
                '}';
    }
    //====================================================
    // Builder Pattern
    public static class Builder {
        private String parentID;
        private String parName;
        private String parSurname;
        private String cellNumber;
        private String email;
        private Student student;

        public Parent.Builder setParentID(String parentID) {
            this.parentID = parentID;
            return this;
        }

        public Parent.Builder setParName(String parName) {
            this.parName = parName;
            return this;
        }

        public Parent.Builder setParSurname(String parSurname) {
            this.parSurname = parSurname;
            return this;
        }

        public Parent.Builder setCellNumber(String cellNumber) {
            this.cellNumber = cellNumber;
            return this;
        }

        public Parent.Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Parent.Builder Student(Student student) {
            this.student = student;
            return this;
        }
        public Builder copy(Parent parent) {
            this.parentID = parent.parentID;
            this.parName = parent.parName;
            this.parSurname = parent.parSurname;
            this.cellNumber = parent.cellNumber;
            this.email = parent.email;
            this.student = parent.student;
            return this;
        }
        public Parent build() {
            return new Parent(this);
        }
    }
}

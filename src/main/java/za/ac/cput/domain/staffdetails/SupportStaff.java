/*
SupportStaff.java
Entity for Support staff
Author: Tiffany Kiwiets (219322732)
 */

package za.ac.cput.domain.staffdetails;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import za.ac.cput.domain.admin.Admin;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;


@Entity
@Table(name = "support_staff")
public class SupportStaff implements Serializable {
    @NotNull @Id
    private String suppStaffID;
//    @ManyToOne(cascade = {PERSIST, MERGE})
//    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne
    @JoinColumn(name = "admin_id")
    private Admin adminID;
    @NotNull private String suppStaffName;
    @NotNull private String suppStaffSurname;
    @NotNull private String cellNumber;
    @NotNull private String importHealthInfo;
    @NotNull private String qualification;
    @NotNull private String typeOfWork;

    protected SupportStaff () {
    }

    //Private constructor
    private SupportStaff(Builder builder) {
        this.suppStaffID = builder.suppStaffID;
        this.adminID = builder.adminID;
        this.suppStaffName = builder.suppStaffName;
        this.suppStaffSurname = builder.suppStaffSurname;
        this.cellNumber = builder.cellNumber;
        this.importHealthInfo = builder.importHealthInfo;
        this.qualification = builder.qualification;
        this.typeOfWork = builder.typeOfWork;
    }

    public String getSuppStaffID() {
        return suppStaffID;
    }

    public Admin getAdminID() {
        return adminID;
    }

    public String getSuppStaffName() {
        return suppStaffName;
    }

    public String getSuppStaffSurname() {
        return suppStaffSurname;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getImportHealthInfo() {
        return importHealthInfo;
    }

    public String getQualification() {
        return qualification;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupportStaff that = (SupportStaff) o;
        return suppStaffID.equals(that.suppStaffID) && adminID.equals(that.adminID) && suppStaffName.equals(that.suppStaffName) && suppStaffSurname.equals(that.suppStaffSurname) && cellNumber.equals(that.cellNumber) && importHealthInfo.equals(that.importHealthInfo) && qualification.equals(that.qualification) && typeOfWork.equals(that.typeOfWork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suppStaffID, adminID, suppStaffName, suppStaffSurname, cellNumber, importHealthInfo, qualification, typeOfWork);
    }

    @Override
    public String toString() {
        return "SupportStaff{" +
                "suppStaffID='" + suppStaffID + '\'' +
                ", adminID=" + adminID +
                ", suppStaffName='" + suppStaffName + '\'' +
                ", suppStaffSurname='" + suppStaffSurname + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                ", importHealthInfo='" + importHealthInfo + '\'' +
                ", qualification='" + qualification + '\'' +
                ", typeOfWork='" + typeOfWork + '\'' +
                '}';
    }

    public static class Builder {
        private String suppStaffID;
        private Admin adminID;
        private String suppStaffName;
        private String suppStaffSurname;
        private String cellNumber;
        private String importHealthInfo;
        private String qualification;
        private String typeOfWork;



        public Builder setSuppStaffID(String suppStaffID) {
            this.suppStaffID = suppStaffID;
            return this;
        }

        public Builder setAdminID(Admin adminID) {
            this.adminID = adminID;
            return this;
        }

       public Builder setSuppStaffName(String suppStaffName) {
            this.suppStaffName = suppStaffName;
            return this;
        }

        public Builder setSuppStaffSurname(String suppStaffSurname) {
            this.suppStaffSurname = suppStaffSurname;
            return  this;
        }

        public Builder setCellNumber(String cellNumber) {
            this.cellNumber = cellNumber;
            return this;
        }

        public Builder setImportHealthInfo(String importHealthInfo) {
            this.importHealthInfo = importHealthInfo;
            return this;
        }

        public Builder setQualification(String qualification) {
            this.qualification = qualification;
            return this;
        }

        public Builder setTypeOfWork(String typeOfWork) {
            this.typeOfWork = typeOfWork;
            return this;
        }

        public Builder copy(SupportStaff supportStaff) {
            this.suppStaffID = supportStaff.suppStaffID;
            this.adminID = supportStaff.adminID;
            this.suppStaffName = supportStaff.suppStaffName;
            this.suppStaffSurname = supportStaff.suppStaffSurname;
            this.cellNumber = supportStaff.cellNumber;
            this.importHealthInfo = supportStaff.importHealthInfo;
            this.qualification = supportStaff.qualification;
            this.typeOfWork = supportStaff.typeOfWork;
            return this;
        }
        public SupportStaff build() { return new SupportStaff( this); }
    }
}

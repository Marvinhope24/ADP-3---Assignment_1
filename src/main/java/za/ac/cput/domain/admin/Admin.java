//Siyabonga Tumelo Masango
//219200815
//31/03/2022
//Admin.javapackage za.ac.cput.domain.Admin;

package za.ac.cput.domain.admin;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Admin implements Serializable {
    @NotNull
    @Id
    private String adminID;
    @NotNull
    private String bankingID;

    protected Admin(){
    }

    private Admin(Builder builder) {
        this.adminID = builder.adminID;
        this.bankingID = builder.bankingID;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getBankingID() {
        return bankingID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return adminID.equals(admin.adminID) && bankingID.equals(admin.bankingID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID, bankingID);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + adminID + '\'' +
                ", bankingID='" + bankingID + '\'' +
                '}';
    }

    public static class Builder {
        private String adminID;
        private String bankingID;

        public Admin.Builder setAdminID(String adminID) {
            this.adminID = adminID;
            return this;
        }

        public Admin.Builder setBankingID(String bankingID) {
            this.bankingID = bankingID;
            return this;
        }
        public Builder copy(Admin  admin){
            this.adminID = admin.adminID;
            this.bankingID = admin.bankingID;
            return this;

        }
        public Admin build(){
            return new Admin(this);
        }
    }
}
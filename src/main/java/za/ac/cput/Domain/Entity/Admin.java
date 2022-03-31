package za.ac.cput.Domain.Entity;
//Siyabonga Tumelo Masango
//219200815
//31/03/2022
//Admin.java
public class Admin {

    private String adminID;
    private String bankingID;


    private Admin(Builder builder) {
        this.adminID = builder.adminID;
        this.bankingID = builder.bankingID;
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getBankingID() {
        return bankingID;
    }

    public void setBankingID(String bankingID) {
        this.bankingID = bankingID;
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

        public Builder setAdminID(String adminID) {
            this.adminID = adminID;
            return this;
        }

        public Builder setBankingID(String bankingID) {
            this.bankingID = bankingID;
            return this;
        }
        public Builder copy( Admin  admin){
            this.adminID = admin.adminID;
            this.bankingID = admin.bankingID;
            return this;

        }
        public Admin build(){
            return new Admin(this);
        }
    }

}
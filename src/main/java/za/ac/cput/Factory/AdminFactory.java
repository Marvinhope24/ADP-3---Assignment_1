package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.util.Helper;

//Siyabonga Tumelo Masango
//219200815
//31/03/2022
//AdminFactory.java
public class AdminFactory {

    public static Admin createAdmin(String adminID, String bankingID) {
        if(Helper.isNotEmpty(adminID)|| Helper.isNotEmpty(bankingID))
            return null;

        return new Admin.Builder()
                .setAdminID(adminID)
                .setBankingID(bankingID)
                .build();



}
}


/*
FeesFactory.java
Factory for FeesFactory
Author: Tiffany Kiwiets (219322732)
 */

package za.ac.cput.factory.parentdetails;

import za.ac.cput.domain.parentdetails.Fees;
import za.ac.cput.domain.studentdetails.Student;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.domain.parentdetails.Parent;
import za.ac.cput.util.Helper;

public class FeesFactory {
    public static Fees build (String feeID, Student student, Admin admin, Parent parent, double amount) {

        Helper.isEmptyOrNull("feeID");
        Helper.isEmptyOrNull("studentID");
        Helper.isEmptyOrNull("adminId");
        Helper.isEmptyOrNull("parentID");
        Helper.isEmptyOrNull("amount");

        Helper.CheckStringParm("feeID", feeID);

        return new Fees.Builder()
                .setfeeID(feeID)
                .setStudentID(student)
                .setAdminID(admin)
                .setParentID(parent)
                .setAmount(amount)
                .build();
    }
}
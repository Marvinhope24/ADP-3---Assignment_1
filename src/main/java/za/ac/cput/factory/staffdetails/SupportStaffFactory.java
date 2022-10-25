/*
SupportStaff.java
Factory for SupportStaffFactory
Author: Tiffany Kiwiets (219322732)
*/

package za.ac.cput.factory.staffdetails;

import za.ac.cput.domain.staffdetails.SupportStaff;
import za.ac.cput.domain.admin.Admin;
import za.ac.cput.util.Helper;

public class SupportStaffFactory {
    public static SupportStaff build (String suppStaffID, Admin admin, String suppStaffName, String suppStaffSurname, String cellNumber, String importHealthInfo, String qualification,
                                      String typeOfWork ) {

        Helper.isEmptyOrNull("suppStaffID");
        Helper.isEmptyOrNull("admin");
        Helper.isEmptyOrNull("suppStaffName");
        Helper.isEmptyOrNull("suppStaffSurname");
        Helper.isEmptyOrNull("cellNumber");
        Helper.isEmptyOrNull("importHealthInfo");
        Helper.isEmptyOrNull("qualification");
        Helper.isEmptyOrNull("typeOfWork");


        Helper.CheckStringParm("suppStaffID", suppStaffID);
        Helper.CheckStringParm("suppStaffName", suppStaffName);
        Helper.CheckStringParm("suppStaffSurname", suppStaffSurname);
        Helper.CheckStringParm("cellNumber", cellNumber);
        Helper.CheckStringParm("importHealthInfo", importHealthInfo);
        Helper.CheckStringParm("qualification", qualification);
        Helper.CheckStringParm("typeOfWork", typeOfWork);

        return new SupportStaff.Builder()
                .setSuppStaffID(suppStaffID)
                .setAdminID(admin)
                .setSuppStaffName(suppStaffName)
                .setSuppStaffSurname(suppStaffSurname)
                .setCellNumber(cellNumber)
                .setImportHealthInfo(importHealthInfo)
                .setQualification(qualification)
                .setTypeOfWork(typeOfWork)
                .build();
    }
}
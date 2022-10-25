/*
IAdmin.java
Interface Admin
Author: Marvin Hope - 219445842
 */

package za.ac.cput.services.Interface.admin;

import za.ac.cput.domain.admin.Admin;
import za.ac.cput.services.IService;

import java.util.List;
public interface IAdmin extends IService<Admin, String> {
    List<Admin> findall();
}

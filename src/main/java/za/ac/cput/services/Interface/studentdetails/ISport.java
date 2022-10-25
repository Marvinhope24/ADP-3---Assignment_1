/*
ISport.java
Interface ISport
Author: Marvin Hope - 219445842
 */

package za.ac.cput.services.Interface.studentdetails;

import za.ac.cput.domain.studentdetails.Sport;
import za.ac.cput.services.IService;

import java.util.List;

public interface ISport extends IService<Sport, String> {
    List<Sport> findAll();
}

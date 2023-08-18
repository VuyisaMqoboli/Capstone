package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;


/*
* EmployeeFactory.java
* Author: Dawood Kamalie  (220147760)
* Date: 7/4/2023
* */

public class EmployeeFactory {
    public static Employee createEmployee( String name, String surname, String phoneNumber, String email) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname) || Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(email)) {
            return null;
        }

        String empId = Helper.generateId();

       Employee employee = new Employee.Builder().setEmpId(empId).setName(name).setSurname(surname).setPhoneNumber(phoneNumber).setEmail(email).build();
       return employee;
    }
}

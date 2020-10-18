package services;

import model.Employees;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by omid on 10/4/2020.
 */
public class EmployeesDao {
    public Employees getEmployee(int employeeId , String employeePassword) {
        int employeeNum = employeeId;
        String emplyeePass = employeePassword;
        Employees target = null;
        try (Session session = HiberConf.getSession()) {
            List<Employees> employeesList = session.createQuery("from Employees").getResultList();
            for (Employees employees : employeesList){
                if (employees.getEmployeeId() == employeeNum){
                    target = employees;
                }
            }
        }
        return target;
    }
}


package com.xcc.designmode.no13.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class CompanyDirectory implements Employee{
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public void showEmployeeDetails() {
        for (Employee employee : employeeList) {
            employee.showEmployeeDetails();
        }
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }
}

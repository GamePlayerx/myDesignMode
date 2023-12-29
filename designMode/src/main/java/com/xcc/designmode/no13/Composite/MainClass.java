package com.xcc.designmode.no13.Composite;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class MainClass {
    public static void main(String[] args) {
        Developer developer1 = new Developer("xcc", 26, "game");
        Developer developer2 = new Developer("qwe", 27, "player");
        CompanyDirectory companyDirectory1 = new CompanyDirectory();
        companyDirectory1.addEmployee(developer1);
        companyDirectory1.addEmployee(developer2);

        Manager manager1 = new Manager("today", 1,"weeking");
        Manager manager2 = new Manager("tomorrow", 7,"working");

        CompanyDirectory companyDirectory2 = new CompanyDirectory();
        companyDirectory2.addEmployee(manager1);
        companyDirectory2.addEmployee(manager2);

        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(companyDirectory1);
        directory.addEmployee(companyDirectory2);
        directory.showEmployeeDetails();
    }
}

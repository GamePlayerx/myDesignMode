package com.xcc.designmode.no13.Composite;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/29
 */
public class Developer implements Employee{
    private String name;
    private long empId;
    private String position;

    public Developer(String name, long empId, String position) {
        this.name = name;
        this.empId = empId;
        this.position = position;
    }
    @Override
    public void showEmployeeDetails() {
        System.out.println(empId + " " + name + " " + position);
    }
}

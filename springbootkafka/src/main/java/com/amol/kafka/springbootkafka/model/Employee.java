package com.amol.kafka.springbootkafka.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private String employeeId;
    private String employeeName;
    private String salary;
    private String deptId;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String salary, String deptId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.deptId = deptId;
    }

    public String getemployeeId() {
        return this.employeeId;
    }

    public void setemployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getemployeeName() {
        return this.employeeName;
    }

    public void setemployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getsalary() {
        return this.salary;
    }

    public void setsalary(String salary) {
        this.salary = salary;
    }

    public String getdeptId() {
        return this.deptId;
    }

    public void setdeptId(String deptId) {
        this.deptId = deptId;
    }

}

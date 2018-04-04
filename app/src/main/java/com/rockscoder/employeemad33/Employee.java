package com.rockscoder.employeemad33;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable{
    private String empName;
    private String empAge;
    private String empDOB;
    private String empGender;
    private String empPhone;
    private String empType;
    private String empCity;
    private List<String> skills;

    public Employee(String empName, String empAge, String empDOB, String empGender, String empPhone, String empType, String empCity, List<String> skills) {
        this.empName = empName;
        this.empAge = empAge;
        this.empDOB = empDOB;
        this.empGender = empGender;
        this.empPhone = empPhone;
        this.empType = empType;
        this.empCity = empCity;
        this.skills = skills;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAge() {
        return empAge;
    }

    public void setEmpAge(String empAge) {
        this.empAge = empAge;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getEmpGender() {
        return empGender;
    }

    public String getEmpType() {
        return empType;
    }

    public String getEmpDOB() {
        return empDOB;
    }

    public String getEmpCity() {
        return empCity;
    }
}

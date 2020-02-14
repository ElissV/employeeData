package com.example;

import java.io.Serializable;

class Employee implements Serializable {

    private int id;
    private String name;
    private int age;
    private Job job;
    static final long serialVersionUID = 2L;

    private Employee(String name, int age, Job job) {
        int employeeQty = new EmployeeList().getEmployeeQty();
        id = employeeQty + 1;
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nAge: " + age +
                "\nJob: " + job + "\n";
    }

    Job getJob() { return job; }
    int getAge() { return age; }

}
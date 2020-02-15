package com.example;

import java.io.Serializable;

class Employee implements Serializable {

    private int id;
    private String name;
    private int age;
    private Job job;
    static final long serialVersionUID = 2L;

    Employee(EmployeeDataRequest e) {
        this.id = getNextID();
        this.name = e.getName();
        this.age = e.getAge();
        this.job = e.getJob();
    }

    Employee(String name, int age, Job job) {
        this.id = getNextID();
        this.name = name;
        this.age = age;
        this.job = job;
    }

    private int getNextID() {
        int employeeQty = new EmployeeList().getEmployeeQty();
        return employeeQty + 1;
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
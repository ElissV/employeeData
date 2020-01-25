package com.example;

import java.io.Serializable;
import java.util.Scanner;

class Employee implements Serializable {

    private int id;
    private String name;
    private int age;
    private Job job;
    static final long serialVersionUID = 2L;

    private Employee(String name, int age, Job job) {
        int employeeQty = EmployeeData.getEmployeeQty();
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

    static void addNewEmployee() {
        String name = nameRequest();
        int age = ageRequest();
        Job job = jobRequest();
        EmployeeData.addEmployeeToList(new Employee(name, age, job));
        System.out.println("Employee was successfully added to the system!\n");
    }

    private static String nameRequest() {   // Requests the name until user inputs name without numbers
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter employee name: ");
            String name = scan.nextLine();
            if (!(name.isEmpty()) && !(name.matches(".*\\d.*"))) return name;
            System.out.println(name);
        }
    }

    private static int ageRequest() {   // Requests the age until user inputs a number between 18 and 60
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter age: ");
        int minAge = 18, maxAge = 60;
        while (true) {
            int age = 0;
            try {
                age = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You should enter only numbers");
            }
            if (!(age < minAge || age > maxAge)) return age;
            else { System.out.println("Employee's age has to be greater than " + minAge +
                                        " and less than " + maxAge); }
        }
    }

    private static Job jobRequest() {   // Requests the job until user chooses one of the suggested values
        Scanner scan = new Scanner(System.in);
        Job job;
        while (true) {
            System.out.println("Choose a job name: \n");
            Job.showJobs();
            int choice = scan.nextInt();
            if (!(choice <= 0 || choice > Job.values().length)) {
                job = Job.getJob(choice);
                break;
            }
        }
        return job;
    }

    Job getJob() {
        return job;
    }

    int getAge() {
        return age;
    }
}
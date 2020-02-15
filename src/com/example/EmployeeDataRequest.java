package com.example;

import java.util.Scanner;

class EmployeeDataRequest {

    private static Scanner scanner;
    private String name;
    private int age;
    private Job job;

    static {
        scanner = new Scanner(System.in);
    }

    void dataRequest() {
        nameRequest();
        ageRequest();
        jobRequest();
    }

    private void nameRequest() {
        while (true) {
            System.out.println("Enter employee name: ");
            name = scanner.nextLine();
            if (!(name.isEmpty())) {
                if (!name.matches(".*\\d.*"))
                    break;
            }
        }
    }

    private void ageRequest() {
        System.out.println("Enter age: ");
        while (true) {
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (ageInRange()) break;
            } catch (NumberFormatException e) {
                System.out.println("You should enter only numbers");
            }
        }
    }

    private boolean ageInRange() {
        int minAge = 18, maxAge = 60;
        if (age < minAge || age > maxAge) {
            System.out.println("Employee's age has to be greater than " +
                    minAge + " and less than " + maxAge);
            return false;
        }
        return true;
    }

    //////////////////////////////////////// PARSE INT ?????????????????????????????
    private void jobRequest() {
        while (true) {
            System.out.println("Choose a job name: \n");
            Job.showJobs();
            int choice = scanner.nextInt(); ////
            if (jobInRange(choice)) {
                job = Job.getJob(choice);
                break;
            }
        }
    }
    
    private boolean jobInRange(int choice) {
        if (choice < Job.values().length)
            return choice > 0;
        return false;
    }

    String getName() { return name; }

    int getAge() { return age; }

    Job getJob() { return job; }

}

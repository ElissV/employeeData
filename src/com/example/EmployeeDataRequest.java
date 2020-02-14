package com.example;

import java.util.Scanner;

class EmployeeDataRequest {

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

}

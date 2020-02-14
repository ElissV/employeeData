package com.example;

public class EmployeeStatistics{

    void showAverageAge() {
        int ageSum = 0;
        for (Employee employee : employees) {
            ageSum += employee.getAge();
        }
        int employeeAverageAge = ageSum / employeeQty;
        System.out.println("Average age is: " + employeeAverageAge);
    }

    void showEmployeeQty() {
        System.out.println("\n");
        for (Job job : Job.values()) {
            int employeeWithCurrentJob = 0;
            for (Employee e : employees) {
                if (e.getJob() == job) employeeWithCurrentJob++;
            }
            System.out.printf("%-25s%6d\n",
                    job, employeeWithCurrentJob);
        }
        System.out.println("-------------------------------");
        System.out.printf("%-25s%6d\n", "TOTAL:", employeeQty);
    }

    void showEmployees() {
        if (employees.size() == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

}

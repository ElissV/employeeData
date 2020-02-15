package com.example;

import java.util.List;

class EmployeeStatistics {

    private static List<Employee> employees;

    static void updateList(List<Employee> e) { employees = e; }

    void showAverageAge() {
        int ageSum = getEmployeeAgeSum();
        int employeeAverageAge = ageSum / employees.size();
        System.out.println("Average employee age is: " + employeeAverageAge);
    }

    private int getEmployeeAgeSum() {
        return employees.stream().mapToInt(Employee::getAge).sum();
    }

    void showEmployeeQty() {
        System.out.println("\n");
        for (Job job : Job.values()) {
            showEmployeesWithCertainJob(job);
        }
        showTotalEmployeeCount();
    }

    private void showEmployeesWithCertainJob(Job job) {
        int count = 0;
        for (Employee e : employees) {
            if (e.getJob() == job) count++;
        }
        System.out.printf("%-25s%6d\n", job, count);
    }

    private void showTotalEmployeeCount() {
        System.out.println("-------------------------------");
        System.out.printf("%-25s%6d\n", "TOTAL:", employees.size());
    }

}

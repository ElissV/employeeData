package com.example;

import java.util.ArrayList;
import java.util.Scanner;

class EmployeeData {

    private static ArrayList<Employee> employees = new ArrayList<>();
    private static int employeeQty = 0;


    static void fillEmployeeList(ArrayList<Employee> employeesFromFile) {   // Employee list is being filled after the file with employee list is read
        employees.addAll(employeesFromFile);
        employeeQty = employees.size();
    }

    static void addEmployeeToList(Employee e) {
        employeeQty++;
        employees.add(e);
    }

    static void showEmployees() {
        if (employees.size() == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    static void showAverageAge() {
        int ageSum = 0;
        for (Employee employee : employees) {
            ageSum += employee.getAge();
        }
        int employeeAverageAge = ageSum / employeeQty;
        System.out.println("Average age is: " + employeeAverageAge);
    }

    static void showEmployeeQty() {
        for (Job job : Job.values()) {
            int employeeWithCurrentJob = 0;
            for (Employee e : employees) {
                if (e.getJob() == job) employeeWithCurrentJob++;
            }

            int jobNameLength = job.toString().length();
            System.out.print(job + ": \t");
            if (jobNameLength <= 6) System.out.print("\t\t\t\t\t");
            else if (jobNameLength <= 8) System.out.print("\t\t\t\t");
            else if (jobNameLength <= 17) System.out.print("\t\t");
            else if (jobNameLength <= 21) System.out.print("\t");
            System.out.print(employeeWithCurrentJob + "\n");
        }
        System.out.println("-----------------------------");
        System.out.println("TOTAL: \t\t\t\t\t\t" + employeeQty + "\n");
    }

    static void deleteEmployee() {
        Employee employee = getEmployee();
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully");
        }
    }

    private static Employee getEmployee() {
        Scanner scan = new Scanner(System.in);
        while(true) {
            String input = "";
            System.out.println("Write employee ID to delete. Enter X to return to menu.");
            showEmployees();
            try {
                input = scan.nextLine();
                int id = Integer.parseInt(input);
                Employee employee = null;
                try {
                    employee = employees.get(id - 1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("There is no employee with this ID \n");
                }
                if (employee != null) return employee;
            }
            catch (NumberFormatException e) {
                if (input.equals("x") || input.equals("X")) return null;
                System.out.println("You should enter only numbers");
            }
        }
    }

    static ArrayList<Employee> getList() { return employees; }

    static int getEmployeeQty() { return employeeQty; }

    static boolean employeeListEmpty() { return employees.size() == 0; }
}

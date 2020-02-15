package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EmployeeList {

    private static List<Employee> employees;

    static {
        employees = new ArrayList<>();
    }


    static void FillEmployeeListAfterReadingFile(List<Employee> employeesFromFile) {
        employees.addAll(employeesFromFile);
        EmployeeStatistics.updateList(employees);
    }

    void createNewEmployeeAndAddToList() {
        EmployeeDataRequest dataRequest = new EmployeeDataRequest();
        dataRequest.dataRequest();
        Employee e = new Employee(dataRequest);
        addEmployeeToList(e);
    }

    private static void addEmployeeToList(Employee e) {
        if (e != null)
            employees.add(e);
        EmployeeStatistics.updateList(employees);
    }

    void deleteEmployee() {
        Employee employee = getEmployee();
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully");
        }
        EmployeeStatistics.updateList(employees);
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

    void showEmployees() {
        if (employees.size() == 0) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) {
            System.out.println(e);
        }
    }


    static List<Employee> getList() {
        return employees;
    }

    int getEmployeeQty() {
        return employees.size();
    }

    static boolean employeeListIsEmpty() {
        return employees.size() == 0;
    }

}
package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EmployeeList {

    private static List<Employee> employees;

    static {
        employees = new ArrayList<>();
    }


    void fillEmployeeList(List<Employee> employeesFromFile) {
        employees.addAll(employeesFromFile);
        EmployeeStatistics.updateList(employees);
    }

    void createNewEmployeeAndAddToList() {
        EmployeeDataRequest dataRequest = new EmployeeDataRequest();
        dataRequest.dataRequest();
        Employee e = new Employee(dataRequest);
        addEmployeeToList(e);
    }

    private void addEmployeeToList(Employee e) {
        if (e != null)
            employees.add(e);
        EmployeeStatistics.updateList(employees);
    }

    void deleteEmployee() {
        Employee employee = getChoiceAndFindEmployee();
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully");
        }
        EmployeeStatistics.updateList(employees);
    }

    private Employee getChoiceAndFindEmployee() {
        while(true) {
            System.out.println("Write employee ID to delete. Enter X to return to menu.");
            showEmployees();
            int id = getUserChoice();
            if (id == -1) return null;
            Employee employee = getEmployeeByID(id);
            if (employee != null)
                return employee;
        }
    }

    private int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        String input = "";
        try {
            input = scan.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            if (input.equalsIgnoreCase("x")) return 0;
            System.out.println("You should enter only numbers");
            return -1;
        }
    }

    private Employee getEmployeeByID(int id) {
        Employee employee;
        try {
            employee = employees.get(id - 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no employee with this ID \n");
            employee = null;
        }
        return employee;
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


    List<Employee> getList() {
        return employees;
    }

    int getEmployeeQty() {
        return employees.size();
    }

    static boolean employeeListIsEmpty() {
        return employees.size() == 0;
    }

}

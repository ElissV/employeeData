package com.example;

import java.util.Scanner;

public class Main {

    private static FileHandler fileHandler;
    private static boolean programIsRunning = false;

    public static void main(String[] args) {
        fileHandler = new FileHandler();
        checkIfCanStart();
    }

    private static void checkIfCanStart() {
        if (!programIsRunning) {
            programIsRunning = true;
            start();
        }
    }

    private static void start() {
        fileHandler.readFile();
        while (programIsRunning) {
            Command.showValues();
            int choice = getUserChoice();
            if (choice == 6) systemExit();
            if (numInRange(choice)) {
                passCommandOn(choice);
            }
        }
    }

    private static boolean numInRange(int num) {
        if (num >= 0) {
            return num < Command.values().length;
        }
        return false;
    }

    private static int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        return convertChoiceToInt(scan.nextLine());
    }

    private static int convertChoiceToInt(String choice) {
        try {
            return Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            System.out.println("You should enter only numbers");
            return getUserChoice();
        }
    }
    
    private static void passCommandOn(int choice) {
        EmployeeStatistics statistics = new EmployeeStatistics();
        EmployeeList list = new EmployeeList();

        if (choice == 1)
            list.createNewEmployeeAndAddToList();
        else if (choice == 2)
            statistics.showAverageAge();
        else if (choice == 3)
            list.showEmployees();
        else if (choice == 4)
            statistics.showEmployeeQty();
        else if (choice == 5)
            list.deleteEmployee();
    }

    private static void systemExit() {
        fileHandler.writeToFile();
        System.out.println("You logged out of the system");
        programIsRunning = false;
    }

}
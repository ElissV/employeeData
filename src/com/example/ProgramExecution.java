package com.example;

import java.util.Scanner;

abstract class ProgramExecution {

    private static boolean isRunning = false;

    private static void execute() {
        FileHandler.readFile();         // Reads employees (which were added in previous sessions) from
        boolean inSystem = true;        // a file and adds them into ArrayList
        while (inSystem) {
            Command.showValues();
            Scanner scan = new Scanner(System.in);
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(scan.nextLine());
                    if (choice != 0) break;
                } catch (NumberFormatException e) {
                    System.out.println("You should enter only numbers");
                }
            }
            inSystem = CommandHandler.executeCommand(choice);
        }
    }

    static void start() {
        if (!isRunning) {
            execute();
            isRunning = true;
        }
    }

}

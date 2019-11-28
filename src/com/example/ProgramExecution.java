package com.example;

import java.util.Scanner;

abstract class ProgramExecution {

    private static boolean isRunning = false;

    static void start() {
        if (!isRunning) {
            execute();
            isRunning = true;
        }
    }

    private static void execute() {
        FileHandler.readFile();         // Reads employees (which were added in previous sessions) from
        boolean inSystem = true;        // a file and adds them into ArrayList
        while (inSystem) {
            Command.showValues();
            int choice = getAnswerAsNumber();
            inSystem = CommandHandler.executeCommand(choice);
        }
    }

    private static int getAnswerAsNumber() {
        Scanner scan = new Scanner(System.in);
        int choice;
        try {
            choice = Integer.parseInt(scan.nextLine());
            if (choice != 0) return choice;
        } catch (NumberFormatException e) {
            System.out.println("You should enter only numbers");
        }
        return getAnswerAsNumber();
    }
}

package com.example;

import java.util.Scanner;

class ProgramExecution {

    private static boolean isRunning = false;

    void start() {
        if (!isRunning) {
            execute();
            isRunning = true;
        }
    }

    private void execute() {
        FileHandler.readFile();
        boolean inSystem = true;
        while (inSystem) {
            Command.showValues();
            int choice = getAnswerAsNumber();
            inSystem = CommandHandler.executeCommand(choice);
        }
    }

    private int getAnswerAsNumber() {
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

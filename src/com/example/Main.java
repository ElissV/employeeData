package com.example;

import java.util.Scanner;

public class Main {

    private static boolean isRunning = false;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        if (!isRunning) {
            execute();
            isRunning = true;
        }
    }

    private static void execute() {
        FileHandler.readFile();
        boolean inSystem = true;
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
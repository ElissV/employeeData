package com.example;

import java.util.Scanner;

public class Main {

    private static boolean programIsRunning = false;

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        if (!programIsRunning) {
            programIsRunning = true;
            execute();
        }
    }

    private static void execute() {
        FileHandler.readFile();
        while (programIsRunning) {
            Command.showValues();
            int choice = getUserChoice();
            programIsRunning = CommandHandler.executeCommand(choice);
        }
    }

    private static int getUserChoice() {
        Scanner scan = new Scanner(System.in);
        return convertToInt(scan.nextLine());
    }

    private static int convertToInt(String choice) {
        try {
            return Integer.parseInt(choice);
        } catch (NumberFormatException e) {
            System.out.println("You should enter only numbers");
            return getUserChoice();
        }
    }

}
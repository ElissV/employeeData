package com.example;

import java.util.EnumSet;

enum Command {

    ENTER_NEW_EMPLOYEE("Enter new employee"),
    SEE_AVERAGE_EMPLOYEE_AGE("See average employee age"),
    SEE_EMPLOYEE_LIST ("See employee list"),
    SEE_EMPLOYEE_COUNT("See employee count"),
    DELETE_EMPLOYEE("Delete employee"),
    EXIT("Exit");

    private String name;
    private static EnumSet<Command> commands;

    static {
        commands = EnumSet.allOf(Command.class);
    }

    Command(String name) {
        this.name = name;
    }

    public static void showValues() {
        System.out.println("\n");
        int i = 1;
        for (Command c : commands) {
            System.out.println(i + " - " + c);
            i++;
        }
    }

    @Override
    public String toString() {
        return name;
    }

}
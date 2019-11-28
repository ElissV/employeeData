package com.example;

import java.util.EnumSet;

enum Command {
    ENTER_NEW_EMPLOYEE,
    SEE_AVERAGE_EMPLOYEE_AGE,
    SEE_EMPLOYEE_LIST,
    SEE_EMPLOYEE_COUNT,
    DELETE_EMPLOYEE,
    EXIT;


    private static EnumSet<Command> commands = EnumSet.allOf(Command.class);

    public static void showValues() {
        System.out.println("\n");
        int i = 1;
        for (Command c : commands) {
            String str = c.toString().toLowerCase().replaceAll("_", " ");
            str = str.substring(0, 1).toUpperCase() + str.substring(1);
            System.out.println(i + " - " + str);
            i++;
        }
    }
}

package com.example;

class CommandHandler {

    static boolean executeCommand(int commandNr) {
        boolean inSystem = true;
        switch (commandNr) {
            case 1:
                Employee.addNewEmployee();
                break;
            case 2:
                EmployeeDataRequest.showAverageAge();
                break;
            case 3:
                EmployeeDataRequest.showEmployees();
                break;
            case 4:
                EmployeeDataRequest.showEmployeeQty();
                break;
            case 5:
                EmployeeDataRequest.deleteEmployee();
                break;
            case 6:
                FileHandler.writeToFile();      // Writes ArrayList with employees to file
                inSystem = false;
                System.out.println("You logged out of the system");
                break;
            default:
                int commandQty = Command.values().length;
                System.out.println("The choice can be form 1 to " + commandQty);
                break;
        }
        return inSystem;
    }
}

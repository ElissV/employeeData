class CommandHandler {

    static boolean executeCommand(int commandNr) {
        boolean inSystem = true;
        switch (commandNr) {
            case 1:
                Employee.addNewEmployee();
                break;
            case 2:
                EmployeeData.showAverageAge();
                break;
            case 3:
                EmployeeData.showEmployees();
                break;
            case 4:
                EmployeeData.showEmployeeQty();
                break;
            case 5:
                EmployeeData.deleteEmployee();
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

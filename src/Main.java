import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileHandler.readFile();     // Reads employees (which were added in previous sessions) from file and adds them into ArrayList
        boolean inSystem = true;
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
}

import java.util.Scanner;

public class EntranceHall {

    /**
     * Starts the room's main loop and handles menu options.
     *
     * @param scanner     The shared Scanner instance.
     * @param curatorName The player's name.
     */
    public void start(Scanner scanner, String curatorName) {
        boolean running = true;

        while (running) {
            printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline buffer

                System.out.println();
                running = handleChoice(choice, curatorName);
            } else {
                System.out.println();
                System.out.println("The voice echoes: \"Speak clearly. Enter a number: 1, 2, or 3.\"");
                System.out.println();
                scanner.nextLine(); // Clear invalid input buffer
            }
        }
    }

    private void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("            ENTRANCE HALL");
        System.out.println("----------------------------------------");
        System.out.println("1. Enter the Museum");
        System.out.println("2. Read the Curator's Handbook");
        System.out.println("3. Exit");
        System.out.print("\n> ");
    }

    private boolean handleChoice(int choice, String curatorName) {
        switch (choice) {
            case 1:
                System.out.println("You push open the heavy double doors and step deeper into the dark corridors...");
                System.out.println("[Room selection unlocked in future sprint]");
                System.out.println();
                return true;

            case 2:
                System.out.println("=== CURATOR'S HANDBOOK ===");
                System.out.println("Rule 1: Do not stare at the paintings.");
                System.out.println("Rule 2: If an artifact whispers, do not answer.");
                System.out.println("Rule 3: Keep your flashlight charged.");
                System.out.println("==========================");
                System.out.println();
                return true;

            case 3:
                System.out.println("You turn the key and leave the museum to its silent anomalous residents.");
                System.out.println("Goodbye, Curator " + curatorName + ".");
                return false; // Signals the while loop to terminate

            default:
                System.out.println("The voice echoes: \"Invalid choice, Curator. Choose 1, 2, or 3.\"");
                System.out.println();
                return true;
        }
    }
}
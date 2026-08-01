import java.util.Scanner;

/*
 * Midnight Museum
 *
 * Version History
 * ----------------------------
 * Sprint 0 - Project initialized
 * Sprint 1 - MM-001 Curator introduction
 * Sprint 2 - MM-002 Entrance Hall menu & modular refactoring
 *
 * Sprint 2 Checklists
 * [x] Add version history update
 * [x] Create main menu loop using while loop
 * [x] Implement options with switch statement
 * [x] Add input validation for invalid choices
 * [x] Refactor main() into storyboard methods (Single Responsibility Principle)
 */
public class Main {

    /**
     * Displays the game title header.
     */
    public static void printTitle() {
        System.out.println("========================================");
        System.out.println("         MIDNIGHT MUSEUM");
        System.out.println("========================================");
    }

    /**
     * Prompts the player for their name and returns it.
     *
     * @param scanner The shared Scanner instance.
     * @return The curator's name.
     */
    public static String introduceCurator(Scanner scanner) {
        System.out.println();
        System.out.println("The entrance doors close behind you.");
        System.out.println();
        System.out.println("A voice echoes through the empty halls...");
        System.out.println();
        System.out.print("\"State your name, Curator.\"\n\n> ");
        return scanner.nextLine();
    }

    /**
     * Prints the atmospheric welcome text for the curator.
     *
     * @param curatorName The player's name.
     */
    public static void printGreeting(String curatorName) {
        System.out.println();
        System.out.println("Welcome, " + curatorName + ".");
        System.out.println();
        System.out.println("You have been appointed as the Night Curator.");
        System.out.println();
        System.out.println("The museum opens only after sunset.");
        System.out.println();
        System.out.println("Protect the artifacts.");
        System.out.println("Contain the anomalies.");
        System.out.println();
        System.out.println("May you flourish in your mission to protect this museum.");
        System.out.println();
    }

    /**
     * Controls the main game loop for the Entrance Hall.
     *
     * @param scanner     The shared Scanner instance.
     * @param curatorName The player's name.
     */
    public static void enterEntranceHall(Scanner scanner, String curatorName) {
        boolean running = true;
        while (running) {
            System.out.println("----------------------------------------");
            System.out.println("            ENTRANCE HALL");
            System.out.println("----------------------------------------");
            System.out.println("1. Enter the Museum");
            System.out.println("2. Read the Curator's Handbook");
            System.out.println("3. Exit");
            System.out.print("\n> ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline buffer
                System.out.println();
                switch (choice) {
                    case 1:
                        System.out.println("You push open the heavy double doors and step deeper into the dark corridors...");
                        System.out.println("[Room selection unlocked in future sprint]");
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("=== CURATOR'S HANDBOOK ===");
                        System.out.println("Rule 1: Do not stare at the paintings.");
                        System.out.println("Rule 2: If an artifact whispers, do not answer.");
                        System.out.println("Rule 3: Keep your flashlight charged.");
                        System.out.println("==========================");
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("You turn the key and leave the museum to its silent anomalous residents.");
                        System.out.println("Goodbye, Curator " + curatorName + ".");
                        running = false;
                        break;
                    default:
                        System.out.println("The voice echoes: \"Invalid choice, Curator. Choose 1, 2, or 3.\"");
                        System.out.println();
                        break;
                }
            } else {
                System.out.println();
                System.out.println("The voice echoes: \"Speak clearly. Enter a number: 1, 2, or 3.\"");
                System.out.println();
                scanner.nextLine(); // Clear bad input buffer
            }
        }
    }

    /**
     * Main entry point - acts strictly as an orchestrator / storyboard.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printTitle();
        String curatorName = introduceCurator(scanner);
        printGreeting(curatorName);
        enterEntranceHall(scanner, curatorName);
        scanner.close();
    }
}
import java.util.Scanner;

/*
 * Midnight Museum
 *
 * Version History
 * ----------------------------
 * Sprint 0 - Project initialized
 * Sprint 1 - MM-001 Curator introduction
 * Sprint 2 - MM-002 Entrance Hall menu & modular refactoring
 * Sprint 2.1 - First OOP Refactor: Extracted EntranceHall object
 *
 * Sprint 2.1 Checklists
 * [x] Create standalone EntranceHall class
 * [x] Move Entrance Hall menu and loop out of Main
 * [x] Instantiate EntranceHall inside Main and call start()
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
     * Main entry point - acts purely as the game orchestrator/storyboard.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printTitle();
        String curatorName = introduceCurator(scanner);
        printGreeting(curatorName);

        // Instantiating the room object
        EntranceHall entranceHall = new EntranceHall();
        entranceHall.start(scanner, curatorName);

        scanner.close();
    }
}
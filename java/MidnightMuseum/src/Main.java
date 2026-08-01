import game.Player;
import locations.EntranceHall;

import java.util.Scanner;

/*
 * Midnight locations.Museum
 *
 * Version History
 * ----------------------------
 * Sprint 0 - Project initialized
 * Sprint 1 - MM-001 Curator introduction
 * Sprint 2 - MM-002 Entrance Hall menu
 * Sprint 2.1 - Extracted locations.EntranceHall object
 * Sprint 3 - MM-003 locations.Museum Wing Selection
 * Sprint 4 - MM-004 Create the game.Player object
 */
public class Main {

    private static Player player;

    public static void printTitle() {
        System.out.println("========================================");
        System.out.println("         MIDNIGHT MUSEUM");
        System.out.println("========================================");
    }

    public static String introduceCurator(Scanner scanner) {
        System.out.println();
        System.out.println("The entrance doors close behind you.");
        System.out.println();
        System.out.println("A voice echoes through the empty halls...");
        System.out.println();
        System.out.print("\"State your name, Curator.\"\n\n> ");
        return scanner.nextLine();
    }

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printTitle();
        String curatorName = introduceCurator(scanner);
        printGreeting(curatorName);

        // Sprint 4: Wrap the name into our new game.Player object
        Player player = new Player(curatorName);

        EntranceHall entranceHall = new EntranceHall();
        entranceHall.start(scanner, player);
        scanner.close();
    }
}
import game.Key;
import game.Player;
import locations.EntranceHall;

import java.util.Scanner;

/*
 * Midnight Museum
 *
 * Version History
 * ----------------------------
 * Sprint 0 - Project initialized
 * Sprint 1 - MM-001 Curator introduction
 * Sprint 2 - MM-002 Entrance Hall menu
 * Sprint 2.1 - Extracted EntranceHall object
 * Sprint 3 - MM-003 Museum Wing Selection
 * Sprint 4 - MM-004 Create the Player object
 * Sprint 5 - MM-005 The First Real Gallery
 * Sprint 5.1 - Extract location classes
 * Sprint 5.2 - Refine narrative pacing
 * Sprint 6 - MM-006 Interactive Artifact & Persistent Choices
 * Sprint 7 - MM-007 Curator's Induction & First Item
 */
public class Main {

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

    public static void performKeyCeremony(Player player) {
        System.out.println("Out of nowhere, an old caretaker steps silently from the shadows.");
        System.out.println("He studies you for a long moment, his eyes milky with age.");
        System.out.println();
        System.out.println("Without a word, he places an ancient brass key into your hand.");
        System.out.println();
        System.out.println("\"This key does not open the museum.\"");
        System.out.println("\"It tells the museum who you are.\"");
        System.out.println();

        Key masterKey = new Key(
                "Curator's Master Key",
                "A heavy brass key worn smooth by countless hands. Engraved with symbols older than the museum itself. The metal feels strangely warm."
        );

        player.receiveKey(masterKey);

        System.out.println("You receive: [ " + masterKey.getName() + " ]");
        System.out.println();
        System.out.println("The caretaker vanishes back into the darkness as silently as he arrived.");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printTitle();
        String curatorName = introduceCurator(scanner);
        printGreeting(curatorName);

        Player player = new Player(curatorName);

        // Sprint 7 Induction
        performKeyCeremony(player);

        EntranceHall entranceHall = new EntranceHall();
        entranceHall.start(scanner, player);

        scanner.close();
    }
}
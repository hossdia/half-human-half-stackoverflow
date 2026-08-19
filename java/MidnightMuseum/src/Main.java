import game.Key;
import game.Player;
import locations.EntranceHall;
import utils.TextEffects;

import java.util.Scanner;

/*
 * Midnight Museum
 *
 * Version History
 * ----------------------------
 * Sprint 0   - Project initialized
 * Sprint 1   - MM-001 Curator introduction
 * Sprint 2   - MM-002 Entrance Hall menu
 * Sprint 2.1 - Extracted EntranceHall object
 * Sprint 3   - MM-003 Museum Wing Selection
 * Sprint 4   - MM-004 Create the Player object
 * Sprint 5   - MM-005 The First Real Gallery
 * Sprint 5.1 - Extract location classes
 * Sprint 5.2 - Refine narrative pacing
 * Sprint 6   - MM-006 Interactive Artifact & Persistent Choices
 * Sprint 7   - MM-007 Curator's Induction & First Item
 * Sprint 7.1 - Refined Crate #042 text pacing
 * Sprint 7.2 - Dynamic post-knock revisit states
 * Sprint 7.3 - Psychological escalation on 4th knock callback
 * Sprint 7.4 - Text effects & cinematic presentation layer
 * Sprint 7.5 - Cleaned up TextEffects helpers (blankLine, typeLine)
 * Sprint 7.6 - Atmospheric pacing & stateful escalation across all wings
 * Sprint 8   - MM-008 The Fourth Knock & Crate #043 Discovery
 * Sprint 8.1 - Extracted LocationUI helper and normalized scene structure
 */

public class Main {

    public static void printTitle() {
        System.out.println("========================================");
        System.out.println("         MIDNIGHT MUSEUM");
        System.out.println("========================================");
    }

    public static String introduceCurator(Scanner scanner) {
        System.out.println();
        TextEffects.type("The entrance doors close behind you...", TextEffects.SLOW);
        TextEffects.pause(600);
        System.out.println();
        TextEffects.type("A voice echoes through the empty halls...", TextEffects.NORMAL);
        TextEffects.pause(500);
        System.out.println();
        TextEffects.type("\"State your name, Curator.\"", TextEffects.SLOW);
        System.out.print("\n> ");
        return scanner.nextLine();
    }

    public static void printGreeting(String curatorName) {
        System.out.println();
        TextEffects.type("Welcome, " + curatorName + ".", TextEffects.SLOW);
        TextEffects.pause(400);
        System.out.println();
        TextEffects.type("You have been appointed as the Night Curator.", TextEffects.NORMAL);
        TextEffects.type("The museum opens only after sunset.", TextEffects.NORMAL);
        TextEffects.pause(500);
        System.out.println();
        TextEffects.type("Protect the artifacts.", TextEffects.SLOW);
        TextEffects.type("Contain the anomalies.", TextEffects.SLOW);
        TextEffects.pause(600);
        System.out.println();
        TextEffects.type("May you flourish in your mission to protect this museum.", TextEffects.NORMAL);
        System.out.println();
    }

    public static void performKeyCeremony(Player player) {
        TextEffects.pause(800);
        TextEffects.type("Out of nowhere, an old caretaker steps silently from the shadows...", TextEffects.SLOW);
        TextEffects.pause(600);
        TextEffects.type("He studies you for a long moment, his eyes milky with age.", TextEffects.NORMAL);
        System.out.println();
        TextEffects.type("Without a word, he places an ancient brass key into your hand.", TextEffects.NORMAL);
        TextEffects.pause(800);
        System.out.println();
        TextEffects.type("\"This key does not open the museum.\"", TextEffects.SLOW);
        TextEffects.pause(500);
        TextEffects.type("\"It tells the museum who you are.\"", TextEffects.SLOW);
        TextEffects.pause(600);
        System.out.println();

        Key masterKey = new Key(
                "Curator's Master Key",
                "A heavy brass key worn smooth by countless hands. Engraved with symbols older than the museum itself. The metal feels strangely warm."
        );

        player.receiveKey(masterKey);

        System.out.println("You receive: [ " + masterKey.getName() + " ]");
        System.out.println();
        TextEffects.type("The caretaker vanishes back into the darkness as silently as he arrived.", TextEffects.FAST);
        TextEffects.pause(1000);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printTitle();
        String curatorName = introduceCurator(scanner);
        printGreeting(curatorName);

        Player player = new Player(curatorName);

        performKeyCeremony(player);

        EntranceHall entranceHall = new EntranceHall();
        entranceHall.start(scanner, player);

        scanner.close();
    }
}
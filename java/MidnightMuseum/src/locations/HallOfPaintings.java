package locations;

import game.Player;
import java.util.Scanner;

public class HallOfPaintings {

    public void start(Scanner scanner, Player player) {
        boolean inHall = true;

        System.out.println("An impossible silence fills the gallery.");
        System.out.println("Dozens of oil portraits line the dark velvet walls.");
        System.out.println("None of their painted eyes seem to be looking where they should...\n");

        while (inHall) {
            printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                inHall = handleChoice(choice, player);
            } else {
                System.out.println("\nA chill runs down your spine: Choose a valid option: 1, 2, 3, or 4.\n");
                scanner.nextLine();
            }
        }
    }

    private void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("          HALL OF PAINTINGS");
        System.out.println("----------------------------------------");
        System.out.println("1. Inspect the central portrait");
        System.out.println("2. Check the brass nameplates");
        System.out.println("3. Peer into the dark alcove");
        System.out.println("4. Return to Museum corridor");
        System.out.print("\n> ");
    }

    private boolean handleChoice(int choice, Player player) {
        switch (choice) {
            case 1 -> {
                System.out.println("The life-sized oil painting depicts a 19th-century noblewoman.");
                System.out.println("When you step to the left, her gaze moves with you.");
                System.out.println("When you step to the right... her smile grows slightly wider.\n");
                return true;
            }
            case 2 -> {
                System.out.println("You shine your light on the tarnished brass plates below the frames.");
                System.out.println("Every single plate has been violently scratched clean of names or dates.");
                System.out.println("Only one word remains legible across the entire wall: 'REMEMBER'.\n");
                return true;
            }
            case 3 -> {
                System.out.println("Curator " + player.getName() + ", you raise your flashlight toward the unlit alcove.");
                System.out.println("An empty golden frame hangs on the wall.");
                System.out.println("Fresh canvas dust lies scattered on the floor beneath it... as if whatever was painted inside recently stepped out.\n");
                return true;
            }
            case 4 -> {
                System.out.println("You lower your eyes and carefully step back into the central corridor.\n");
                return false;
            }
            default -> {
                System.out.println("The shadows shift silently. Choose 1, 2, 3, or 4.\n");
                return true;
            }
        }
    }
}
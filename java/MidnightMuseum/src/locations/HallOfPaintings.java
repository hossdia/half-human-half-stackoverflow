package locations;

import game.Player;
import java.util.Scanner;

public class HallOfPaintings {

    private int portraitInspections = 0;

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
                inspectPortrait();
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

    private void inspectPortrait() {
        portraitInspections++;

        switch (portraitInspections) {
            case 1 -> System.out.println("The portrait's gaze seems to follow you as you step across the room.");
            case 2 -> System.out.println("You lean closer. You could swear her expression wasn't smiling before.");
            case 3 -> System.out.println("She is definitely smiling now. Her painted teeth glisten faintly in your flashlight beam.");
            case 4 -> {
                System.out.println("The canvas inside the frame is completely blank.");
                System.out.println("Only wet oil paint drips slowly onto the floor...");
            }
            default -> {
                System.out.println("You stare at the empty frame.");
                System.out.println("The temperature plunges.");
                System.out.println("A cold breath touches the back of your neck.");
                System.out.println("Someone is standing behind you.");
            }
        }
        System.out.println();
    }
}
package locations;

import game.Player;
import java.util.Scanner;

public class Museum {

    public void start(Scanner scanner, Player player) {
        boolean inMuseum = true;

        while (inMuseum) {
            printMuseumMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                inMuseum = handleWingSelection(choice, scanner, player);
            } else {
                System.out.println("\nThe voice echoes: \"Speak clearly. Enter a number: 1, 2, 3, or 4.\"\n");
                scanner.nextLine();
            }
        }
    }

    private void printMuseumMenu() {
        System.out.println("========================================");
        System.out.println("               THE MUSEUM");
        System.out.println("========================================");
        System.out.println("The corridors stretch endlessly into pitch blackness.");
        System.out.println("Unseen eyes linger on your every step.");
        System.out.println();
        System.out.println("Choose a wing:");
        System.out.println("1. Egyptian Gallery");
        System.out.println("2. Hall of Paintings");
        System.out.println("3. Artifact Storage");
        System.out.println("4. Return to Entrance Hall");
        System.out.print("\n> ");
    }

    private boolean handleWingSelection(int choice, Scanner scanner, Player player) {
        switch (choice) {
            case 1:
                // Instantiates and delegates to the dedicated location class
                EgyptianGallery gallery = new EgyptianGallery();
                gallery.start(scanner, player);
                return true;

            case 2:
                paintings();
                return true;

            case 3:
                storage();
                return true;

            case 4:
                System.out.println("You retreat back into the relative safety of the Entrance Hall, Curator " + player.getName() + ".\n");
                return false;

            default:
                System.out.println("The voice echoes: \"Invalid wing selection, Curator. Choose 1, 2, 3, or 4.\"\n");
                return true;
        }
    }

    private void paintings() {
        System.out.println("--- HALL OF PAINTINGS ---");
        System.out.println("The portraits seem to follow you.");
        System.out.println("Perhaps... they always have.");
        System.out.println("\n[Coming Soon]\n");
    }

    private void storage() {
        System.out.println("--- ARTIFACT STORAGE ---");
        System.out.println("Thousands of sealed artifacts.");
        System.out.println("Most are harmless. Some merely pretend to be.");
        System.out.println("\n[Coming Soon]\n");
    }
}
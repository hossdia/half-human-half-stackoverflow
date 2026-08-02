package locations;

import game.Player;
import java.util.Scanner;

public class EgyptianGallery {

    private boolean scarabTaken = false;

    public void start(Scanner scanner, Player player) {
        boolean inGallery = true;

        System.out.println("The temperature drops instantly as you cross the threshold.");
        System.out.println("A suffocating smell of ancient dust clings to the air...\n");

        while (inGallery) {
            printGalleryMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                inGallery = handleChoice(choice, scanner, player);
            } else {
                System.out.println("\nThe darkness vibrates: \"Select a valid action: 1, 2, 3, or 4.\"\n");
                scanner.nextLine();
            }
        }
    }

    private void printGalleryMenu() {
        System.out.println("----------------------------------------");
        System.out.println("            EGYPTIAN GALLERY");
        System.out.println("----------------------------------------");
        System.out.println("Rows of towering stone sarcophagi stand silently in the dim light.");
        System.out.println();
        System.out.println("1. Inspect the open sarcophagus");
        System.out.println("2. Examine the hieroglyphs");
        System.out.println("3. Look around the room");
        System.out.println("4. Return to Museum corridor");
        System.out.print("\n> ");
    }

    private boolean handleChoice(int choice, Scanner scanner, Player player) {
        switch (choice) {
            case 1 -> {
                inspectSarcophagus(scanner);
                return true;
            }
            case 2 -> {
                examineHieroglyphs();
                return true;
            }
            case 3 -> {
                lookAround(player);
                return true;
            }
            case 4 -> {
                System.out.println("You back away from the looming sarcophagi and return to the main corridor.\n");
                return false;
            }
            default -> {
                System.out.println("An uneasy breeze sweeps past. Choose 1, 2, 3, or 4.\n");
                return true;
            }
        }
    }

    private void inspectSarcophagus(Scanner scanner) {
        System.out.println("The heavy granite lid is displaced by a few inches.");

        if (scarabTaken) {
            System.out.println("The sarcophagus is empty.");
            System.out.println("Only the deep scratches on the inside remain.");
            System.out.println();
            return;
        }

        System.out.println("Inside lies an ancient, pulsing bronze scarab.");
        System.out.println();
        System.out.println("1. Take the Bronze Scarab");
        System.out.println("2. Leave it where it is");
        System.out.println("3. Step away");
        System.out.print("\n> ");

        if (scanner.hasNextInt()) {
            int subChoice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (subChoice) {
                case 1 -> {
                    scarabTaken = true;
                    System.out.println("You wrap the bronze scarab in cloth and place it inside your satchel.");
                    System.out.println("It feels... warm. Almost like a slow heartbeat.\n");
                }
                case 2 -> {
                    System.out.println("You leave the scarab resting on the velvet interior.");
                    System.out.println("It still waits inside. Almost patiently.\n");
                }
                case 3 -> System.out.println("You carefully step back from the open sarcophagus.");
                default -> System.out.println("You hesitate too long and step back.");
            }
        } else {
            scanner.nextLine();
            System.out.println("You step back into the shadow.\n");
        }
    }

    private void examineHieroglyphs() {
        System.out.println("Intricate carvings cover the tomb walls from floor to ceiling.");
        System.out.println("The symbols depict a ritual of containment... but several crucial glyphs have been gouged out.");
        System.out.println("A chilling realization hits you: whatever was bound here was released on purpose.\n");
    }

    private void lookAround(Player player) {
        System.out.println("Your flashlight beam cuts through thick airborne dust.");
        System.out.println("Curator " + player.getName() + ", you hear a faint, rhythmic scraping sound from the shadowed corner of the ceiling...");
        System.out.println("When you raise your light, the sound instantly stops.\n");
    }
}
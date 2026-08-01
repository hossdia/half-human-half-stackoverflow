package locations;

import game.Player;
import java.util.Scanner;

public class EgyptianGallery {

    private boolean inspectedSarcophagus = false;

    public void start(Scanner scanner, Player player) {
        boolean inGallery = true;

        System.out.println("The temperature drops instantly as you cross the threshold.");
        System.out.println("A suffocating smell of ancient dust and crushed dry flowers fills the air...\n");

        while (inGallery) {
            printGalleryMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                inGallery = handleChoice(choice, player);
            } else {
                System.out.println("\nThe darkness vibrates: \"Select a valid action, Curator: 1, 2, 3, or 4.\"\n");
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

    private boolean handleChoice(int choice, Player player) {
        switch (choice) {
            case 1:
                inspectSarcophagus();
                return true;

            case 2:
                examineHieroglyphs();
                return true;

            case 3:
                lookAround(player);
                return true;

            case 4:
                System.out.println("You back away from the looming sarcophagi and return to the main corridor.\n");
                return false;

            default:
                System.out.println("An uneasy breeze sweeps past. Choose 1, 2, 3, or 4.\n");
                return true;
        }
    }

    private void inspectSarcophagus() {
        if (!inspectedSarcophagus) {
            System.out.println("The heavy granite lid is displaced by a few inches.");
            System.out.println("You shine your flashlight inside... cold air rushes out.");
            System.out.println("Scratches score the inner walls of the stone. Deep scratches.");
            System.out.println("It was opened... from the INSIDE.");
            System.out.println("Resting on the velvet floor lies an ancient, pulsing bronze scarab.");
            inspectedSarcophagus = true;
        } else {
            System.out.println("The sarcophagus remains open.");
            System.out.println("The bronze scarab still rests inside, faint warmth radiating from its shell.");
            System.out.println("You decide not to linger near the scratched stone edge.");
        }
        System.out.println();
    }

    private void examineHieroglyphs() {
        System.out.println("Intricate carvings cover the tomb walls from floor to ceiling.");
        System.out.println("The symbols depict a ritual of containment... but several crucial glyphs have been intentionally gouged out.");
        System.out.println("A chilling realization hits you: whatever was bound here was released on purpose.");
        System.out.println();
    }

    private void lookAround(Player player) {
        System.out.println("Your flashlight beam cuts through thick airborne dust.");
        System.out.println("Curator " + player.getName() + ", you hear a faint, rhythmic scraping sound from the shadowed corner of the ceiling...");
        System.out.println("When you raise your light, the sound instantly stops.");
        System.out.println();
    }
}
package locations;

import game.Player;
import utils.TextEffects;

import java.util.Scanner;

public class EgyptianGallery {

    private boolean scarabTaken = false;
    private int sarcophagusRevisits = 0;

    public void start(Scanner scanner, Player player) {
        boolean inGallery = true;

        TextEffects.typeLine("The temperature drops instantly as you cross the threshold.", TextEffects.SLOW);
        TextEffects.typeLine("A suffocating smell of ancient dust clings to the air...", TextEffects.SLOW);
        System.out.println("Hieroglyphs cover the towering sandstone walls.");
        System.out.println("Golden artifacts gleam dimly behind reinforced display glass.\n");

        while (inGallery) {
            printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                inGallery = handleChoice(choice, scanner, player);
            } else {
                System.out.println("\nA hollow whisper echoes: Choose 1, 2, 3, or 4.\n");
                scanner.nextLine();
            }
        }
    }

    private void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("          EGYPTIAN GALLERY");
        System.out.println("----------------------------------------");
        System.out.println("1. Inspect the Golden Sarcophagus");
        System.out.println("2. Examine the Obsidian Scarab");
        System.out.println("3. Read the hieroglyph wall plaque");
        System.out.println("4. Return to Museum corridor");
        System.out.print("\n> ");
    }

    private boolean handleChoice(int choice, Scanner scanner, Player player) {
        switch (choice) {
            case 1 -> {
                inspectSarcophagus();
                return true;
            }
            case 2 -> {
                examineScarab();
                return true;
            }
            case 3 -> {
                readHieroglyphs();
                return true;
            }
            case 4 -> {
                System.out.println("You step away from the ancient tombs and return to the main corridor.\n");
                return false;
            }
            default -> {
                System.out.println("Dust settles softly in the air. Choose 1, 2, 3, or 4.\n");
                return true;
            }
        }
    }

    private void inspectSarcophagus() {
        System.out.println("The gilded coffin of High Priest Ankh-ef-en-Khonsu stands upright.");

        if (!scarabTaken) {
            System.out.println("Its painted eyes stare blankly into the quiet gallery.\n");
            return;
        }

        sarcophagusRevisits++;

        switch (sarcophagusRevisits) {
            case 1 -> {
                TextEffects.pause(500);
                TextEffects.typeLine("The painted eyes of the mask seem slightly turned toward you now...", TextEffects.SLOW);
            }
            case 2 -> {
                TextEffects.pause(500);
                TextEffects.typeLine("The gilded face seems to tilt downward, as if looking into your satchel.", TextEffects.SLOW);
            }
            default -> {
                TextEffects.pause(500);
                TextEffects.typeLine("The stone lid appears slightly more open than before.", TextEffects.SLOW);
                TextEffects.pause(700);
                TextEffects.typeLine("A narrow strip of pitch-black shadow gapes along the seam.", TextEffects.SLOW);
            }
        }
    }

    private void examineScarab() {
        if (!scarabTaken) {
            scarabTaken = true;
            TextEffects.typeLine("You wrap the carved scarab in cloth and place it inside your satchel.", TextEffects.NORMAL);
            TextEffects.pause(500);
            TextEffects.typeLine("It feels...", TextEffects.SLOW);
            TextEffects.pause(700);
            TextEffects.typeLine("Warm.", TextEffects.SLOW);
            TextEffects.pause(500);
            TextEffects.typeLine("Almost like a slow heartbeat.", TextEffects.SLOW);
        } else {
            TextEffects.typeLine("Your satchel grows strangely warm.", TextEffects.SLOW);
            TextEffects.typeLine("You never remember putting it back.", TextEffects.SLOW);
        }
    }

    private void readHieroglyphs() {
        TextEffects.typeLine("The translated plaque reads:", TextEffects.NORMAL);
        TextEffects.pause(400);
        TextEffects.typeLine("'Those who watch the dead must never look away...'", TextEffects.NORMAL);
        TextEffects.pause(700);
        TextEffects.typeLine("'...when the dead watch back.'", TextEffects.SLOW);
    }
}
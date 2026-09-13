package locations;

import game.Player;
import utils.LocationUI;
import utils.TextEffects;

import java.util.Scanner;

public class EgyptianGallery {

    private boolean scarabTaken = false;
    private int sarcophagusRevisits = 0;

    public void start(Scanner scanner, Player player) {
        boolean inGallery = true;

        printIntroduction();

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

    private void printIntroduction() {
        TextEffects.typeLine("The temperature drops instantly as you cross the threshold.", TextEffects.SLOW);
        TextEffects.typeLine("A suffocating smell of ancient dust clings to the air...", TextEffects.SLOW);
        System.out.println("Hieroglyphs cover the towering sandstone walls.");
        System.out.println("Golden artifacts gleam dimly behind reinforced display glass.\n");
    }

    private void printMenu() {
        LocationUI.printMenu(
                "EGYPTIAN GALLERY",
                "Inspect the Golden Sarcophagus",
                "Examine the Obsidian Scarab",
                "Read the hieroglyph wall plaque",
                "Return to Museum corridor"
        );
    }

    private boolean handleChoice(int choice, Scanner scanner, Player player) {
        switch (choice) {
            case 1 -> {
                inspectSarcophagus();
                return true;
            }
            case 2 -> {
                examineScarab(scanner, player);
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
                TextEffects.typeLine("The painted eyes of the mask are no longer facing where they were before.", TextEffects.SLOW);
            }
            case 2 -> {
                TextEffects.pause(500);
                TextEffects.typeLine("The gilded face appears directed straight toward your satchel.", TextEffects.SLOW);
            }
            case 3 -> {
                TextEffects.pause(500);
                TextEffects.typeLine("The carved lips of the gold mask twist upward into a rigid, hollow smile.", TextEffects.SLOW);
                TextEffects.pause(800);
                TextEffects.typeLine("You are certain it wasn't smiling before.", TextEffects.SLOW);
            }
            default -> {
                TextEffects.pause(500);
                TextEffects.typeLine("The sarcophagus stands silent in the dim light, smiling into the dark.", TextEffects.SLOW);
                TextEffects.pause(700);
                TextEffects.typeLine("The stone lid appears slightly more open than before.", TextEffects.SLOW);
            }
        }
        System.out.println();
    }

    private void examineScarab(Scanner scanner, Player player) {
        if (!scarabTaken) {
            TextEffects.typeLine("An obsidian scarab rests inside an unsealed glass case.", TextEffects.NORMAL);
            TextEffects.typeLine("Its surface is impossibly smooth, carved from pitch-black stone.", TextEffects.NORMAL);
            System.out.println("\nDo you take the Obsidian Scarab?");
            System.out.println("1. Take the scarab and place it in your satchel");
            System.out.println("2. Leave it undisturbed");
            System.out.print("\n> ");

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                if (option == 1) {
                    scarabTaken = true;
                    player.addItem("Obsidian Scarab");
                    TextEffects.typeLine("You wrap the carved scarab in cloth and place it inside your satchel.", TextEffects.NORMAL);
                    TextEffects.pause(500);
                    TextEffects.typeLine("It feels...", TextEffects.SLOW);
                    TextEffects.pause(700);
                    TextEffects.typeLine("Warm.", TextEffects.SLOW);
                    TextEffects.pause(500);
                    TextEffects.typeLine("Almost like a slow, faint heartbeat.", TextEffects.SLOW);
                } else {
                    TextEffects.typeLine("You decide against taking the artifact and step back.", TextEffects.NORMAL);
                }
            } else {
                scanner.nextLine();
                TextEffects.typeLine("You hesitate and pull your hand back.", TextEffects.NORMAL);
            }
        } else {
            TextEffects.typeLine("Your satchel grows strangely warm against your hip.", TextEffects.SLOW);
            TextEffects.typeLine("The Obsidian Scarab rests safely inside.", TextEffects.SLOW);
        }
        System.out.println();
    }

    private void readHieroglyphs() {
        TextEffects.typeLine("The translated plaque reads:", TextEffects.NORMAL);
        TextEffects.pause(400);
        TextEffects.typeLine("'Those who watch the dead must never look away...'", TextEffects.NORMAL);
        TextEffects.pause(700);
        TextEffects.typeLine("'...when the dead watch back.'", TextEffects.SLOW);
        System.out.println();
    }
}
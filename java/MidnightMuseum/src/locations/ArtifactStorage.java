package locations;

import game.Player;
import utils.TextEffects;

import java.util.Scanner;

public class ArtifactStorage {

    private boolean readLogbook = false;
    private boolean knockedBack = false;
    private int crateRevisits = 0;

    public void start(Scanner scanner, Player player) {
        boolean inStorage = true;

        System.out.println("Steel shelves stretch into the darkness, towering up toward the ceiling.");
        System.out.println("Thousands of sealed containers sit behind reinforced glass.");
        System.out.println("Tiny identification tags swing gently... despite the complete absence of any wind.\n");

        while (inStorage) {
            printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                inStorage = handleChoice(choice, scanner, player);
            } else {
                System.out.println("\nA metallic hum reverberates: Choose 1, 2, 3, or 4.\n");
                scanner.nextLine();
            }
        }
    }

    private void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("            ARTIFACT STORAGE");
        System.out.println("----------------------------------------");
        System.out.println("1. Inspect Crate #042");
        System.out.println("2. Read the containment logbook");
        System.out.println("3. Listen to the dark shelf row");
        System.out.println("4. Return to Museum corridor");
        System.out.print("\n> ");
    }

    private boolean handleChoice(int choice, Scanner scanner, Player player) {
        switch (choice) {
            case 1 -> {
                inspectCrate(scanner);
                return true;
            }
            case 2 -> {
                readContainmentLogbook();
                return true;
            }
            case 3 -> {
                System.out.println("Curator " + player.getName() + ", you stand still and listen closely.");
                System.out.println("Amidst the quiet hum of electricity, a faint, rhythmic breathing echoes down Row 7.\n");
                return true;
            }
            case 4 -> {
                System.out.println("You lock the storage mesh gate behind you and step back out.\n");
                return false;
            }
            default -> {
                System.out.println("The metal shelves groan under hidden weight. Choose 1, 2, 3, or 4.\n");
                return true;
            }
        }
    }

    private void inspectCrate(Scanner scanner) {
        System.out.println("A heavy iron-reinforced wooden crate sits on a low pallet.");
        System.out.println("Heavy padlocks bind three thick steel chains wrapped around it.");

        if (knockedBack) {
            crateRevisits++;
            printPostKnockSilence();
            return;
        }

        System.out.println("A soft, deliberate tapping comes from inside the crate.");
        System.out.println("Three knocks.");
        System.out.println("Then silence.");
        System.out.println();

        if (readLogbook) {
            System.out.println("1. Knock back three times");
            System.out.println("2. Stay silent and step away");
            System.out.print("\n> ");

            if (scanner.hasNextInt()) {
                int subChoice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();

                if (subChoice == 1) {
                    knockBack();
                } else {
                    System.out.println("Remembering the logbook warning, you hold your breath and back away quietly.\n");
                }
            } else {
                scanner.nextLine();
                System.out.println("You stay silent and back away.\n");
            }
        }
    }

    private void printPostKnockSilence() {
        switch (crateRevisits) {
            case 1 -> {
                System.out.println("The crate is silent.");
                System.out.println("No tapping comes from within.");
            }
            case 2 -> {
                System.out.println("The silence feels deliberate.");
            }
            case 3 -> {
                System.out.println("You find yourself listening for the knocks.");
                System.out.println("None come.");
            }
            default -> {
                System.out.println("The crate remains silent.");
                System.out.println();
                System.out.println("You find yourself waiting");
                System.out.println("for the fourth knock.");
            }
        }
        System.out.println();
    }

    private void knockBack() {
        knockedBack = true;
        TextEffects.type("You reach out and rap your knuckles against the thick wood three times.", TextEffects.NORMAL);
        System.out.println();
        TextEffects.type("A heavy silence falls over the entire storage room...", TextEffects.SLOW);
        TextEffects.pause(1200); // Suspense building
        System.out.println();
        TextEffects.type("Then...", TextEffects.SLOW);
        TextEffects.pause(1000);
        System.out.println();
        TextEffects.type("A DEAFENING BANG ERUPTS FROM INSIDE THE CRATE!", TextEffects.FAST);
        TextEffects.pause(400);
        TextEffects.type("The chains rattle violently.", TextEffects.FAST);
        TextEffects.pause(1200);
        System.out.println();
        TextEffects.type("Everything falls silent.", TextEffects.SLOW);
        TextEffects.pause(800);
        System.out.println();
        TextEffects.type("Far too silent.\n", TextEffects.SLOW);
    }

    private void readContainmentLogbook() {
        readLogbook = true;
        System.out.println("A leather-bound ledger rests on a metal desk, coated in dust.");
        System.out.println("The last entry reads:");
        System.out.println("'CONTAINMENT PROTOCOL FOR CRATE #042: Never answer knocks. If you knock back, it knows you hear it.'\n");
    }
}
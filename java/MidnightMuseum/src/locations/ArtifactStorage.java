package locations;

import game.Player;
import java.util.Scanner;

public class ArtifactStorage {

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
                inStorage = handleChoice(choice, player);
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

    private boolean handleChoice(int choice, Player player) {
        switch (choice) {
            case 1 -> {
                System.out.println("A heavy iron-reinforced wooden crate sits on a low pallet.");
                System.out.println("Heavy padlocks bind three thick steel chains wrapped around it.");
                System.out.println("As you draw near, a soft, deliberate tapping sounds from WITHIN the wood.\n");
                return true;
            }
            case 2 -> {
                System.out.println("A leather-bound ledger rests on a metal desk, coated in dust.");
                System.out.println("The last entry reads: 'Do not attempt inventory after midnight. The counts never match.'\n");
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
}
package locations;

import game.Player;
import java.util.Scanner;

public class EntranceHall {

    private boolean firstTimeEnteringMuseum = true;

    public void start(Scanner scanner, Player player) {
        boolean running = true;

        while (running) {
            printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                running = handleChoice(choice, scanner, player);
            } else {
                System.out.println("\nThe voice echoes: \"Speak clearly. Enter a number: 1, 2, 3, or 4.\"\n");
                scanner.nextLine();
            }
        }
    }

    private void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("            ENTRANCE HALL");
        System.out.println("----------------------------------------");
        System.out.println("1. Enter the Museum");
        System.out.println("2. Read the Curator's Handbook");
        System.out.println("3. Examine Curator's Key");
        System.out.println("4. Exit");
        System.out.print("\n> ");
    }

    private boolean handleChoice(int choice, Scanner scanner, Player player) {
        switch (choice) {
            case 1 -> {
                if (firstTimeEnteringMuseum) {
                    System.out.println("The brass key vibrates softly in your pocket.");
                    System.out.println("The great iron doors unlock on their own with a heavy click...\n");
                    firstTimeEnteringMuseum = false;
                } else {
                    System.out.println("The museum welcomes its Curator.\n");
                }
                Museum museum = new Museum();
                museum.start(scanner, player);
                return true;
            }
            case 2 -> {
                System.out.println("=== CURATOR'S HANDBOOK: ANOMALY PROTOCOLS ===");
                System.out.println("RULE 1: Never stare into a portrait's eyes for longer than three seconds.");
                System.out.println("RULE 2: If a stone sarcophagus begins to hum... leave the wing immediately.");
                System.out.println("RULE 3: Shadows do not belong to you here. Do not look behind you.");
                System.out.println("RULE 4: If an artifact whispers your real name... DO NOT ANSWER.");
                System.out.println("RULE 5: Never lose the Curator's Key. Some doors only recognize its owner.");
                System.out.println("============================================");
                System.out.println();
                return true;
            }
            case 3 -> {
                if (player.hasKey()) {
                    System.out.println("=== " + player.getKey().getName().toUpperCase() + " ===");
                    System.out.println(player.getKey().getDescription());
                    System.out.println("============================================");
                } else {
                    System.out.println("Your hands are empty.");
                }
                System.out.println();
                return true;
            }
            case 4 -> {
                System.out.println("You turn the heavy brass key, sealing the museum and leaving its silent residents in the dark.");
                System.out.println("Goodbye, Curator " + player.getName() + ".");
                return false;
            }
            default -> {
                System.out.println("The voice echoes: \"Invalid choice, Curator. Choose 1, 2, 3, or 4.\"\n");
                return true;
            }
        }
    }
}
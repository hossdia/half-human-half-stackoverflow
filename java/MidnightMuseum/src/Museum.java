import java.util.Scanner;

public class Museum {

    public void start(Scanner scanner, String curatorName) {
        boolean inMuseum = true;

        while (inMuseum) {
            printMuseumMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                inMuseum = handleWingSelection(choice, curatorName);
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
        System.out.println("The corridors stretch endlessly.");
        System.out.println("Ancient relics watch from the darkness.");
        System.out.println();
        System.out.println("Choose a wing:");
        System.out.println("1. Egyptian Gallery");
        System.out.println("2. Hall of Paintings");
        System.out.println("3. Artifact Storage");
        System.out.println("4. Return to Entrance Hall");
        System.out.print("\n> ");
    }

    private boolean handleWingSelection(int choice, String curatorName) {
        return switch (choice) {
            case 1 -> {
                egyptianGallery();
                yield true;
            }
            case 2 -> {
                paintings();
                yield true;
            }
            case 3 -> {
                storage();
                yield true;
            }
            case 4 -> {
                System.out.println("You step back into the safety of the Entrance Hall, Curator " + curatorName + ".\n");
                yield false;
            }
            default -> {
                System.out.println("The voice echoes: \"Invalid wing selection, Curator. Choose 1, 2, 3, or 4.\"\n");
                yield true;
            }
        };
    }

    private void egyptianGallery() {
        System.out.println("--- EGYPTIAN GALLERY ---");
        System.out.println("Rows of stone sarcophagi line the walls.");
        System.out.println("One of them feels... slightly open.");
        System.out.println("\n[Coming Soon]\n");
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
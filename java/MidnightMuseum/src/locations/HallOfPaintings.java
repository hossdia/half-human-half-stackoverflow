package locations;

import game.Player;
import utils.LocationUI;
import utils.TextEffects;

import java.util.Scanner;

public class HallOfPaintings {

    private boolean lookedBehindCurtain = false;

    public void start(Scanner scanner, Player player) {
        boolean inHall = true;

        printIntroduction();

        while (inHall) {
            printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                inHall = handleChoice(choice, scanner, player);
            } else {
                System.out.println("\nA floorboard creaks nearby: Choose 1, 2, 3, or 4.\n");
                scanner.nextLine();
            }
        }
    }

    private void printIntroduction() {
        System.out.println("Heavy velvet drapes line the grand hall.");
        System.out.println("Gold-framed oil paintings cover every inch of vertical wall space.\n");
    }

    private void printMenu() {
        LocationUI.printMenu(
                "HALL OF PAINTINGS",
                "Examine 'Portrait of an Unknown Lady'",
                "Inspect the empty gilded frame",
                "Look behind the black velvet curtain",
                "Return to Museum corridor"
        );
    }

    private boolean handleChoice(int choice, Scanner scanner, Player player) {
        switch (choice) {
            case 1 -> {
                examinePortrait();
                return true;
            }
            case 2 -> {
                inspectEmptyFrame();
                return true;
            }
            case 3 -> {
                lookBehindCurtain();
                return true;
            }
            case 4 -> {
                System.out.println("You leave the watchful painted eyes behind and step back into the corridor.\n");
                return false;
            }
            default -> {
                System.out.println("The portraits seem to wait. Choose 1, 2, 3, or 4.\n");
                return true;
            }
        }
    }

    private void examinePortrait() {
        TextEffects.typeLine("An imposing oil portrait of an 18th-century noblewoman.", TextEffects.NORMAL);
        TextEffects.pause(400);

        if (lookedBehindCurtain) {
            TextEffects.typeLine("She is definitely smiling now.", TextEffects.SLOW);
            TextEffects.pause(600);
            TextEffects.typeLine("Her painted teeth glisten faintly in your flashlight beam.", TextEffects.SLOW);
        } else {
            TextEffects.typeLine("Her eyes rest on a dark velvet drape at the far end of the gallery.", TextEffects.NORMAL);
        }
    }

    private void inspectEmptyFrame() {
        TextEffects.typeLine("You stare at the empty frame.", TextEffects.SLOW);
        TextEffects.pause(600);
        TextEffects.typeLine("The canvas inside the frame is completely blank.", TextEffects.SLOW);
        TextEffects.pause(700);
        TextEffects.typeLine("Only wet oil paint drips slowly onto the floor...", TextEffects.SLOW);

        if (lookedBehindCurtain) {
            TextEffects.pause(1000);
            TextEffects.typeLine("The temperature plunges.", TextEffects.SLOW);
            TextEffects.pause(1000);
            TextEffects.typeLine("A cold breath touches the back of your neck.", TextEffects.SLOW);
            TextEffects.pause(1200);
            TextEffects.typeLine("Someone is standing behind you.", TextEffects.SLOW);
        }
    }

    private void lookBehindCurtain() {
        lookedBehindCurtain = true;

        TextEffects.typeLine("You reach out and pull back the heavy black velvet curtain.", TextEffects.NORMAL);
        TextEffects.pause(800);
        TextEffects.typeLine("Behind it rests a mirror, covered in thick gray dust.", TextEffects.SLOW);
        TextEffects.pause(600);
        TextEffects.typeLine("In the reflection, you see the gallery behind you clearly...", TextEffects.SLOW);
        TextEffects.pause(1000);
        TextEffects.typeLine("...except none of the figures in the paintings are in their frames.", TextEffects.FAST);
    }
}
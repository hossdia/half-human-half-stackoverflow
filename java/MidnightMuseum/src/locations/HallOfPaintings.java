package locations;

import game.Player;
import utils.LocationUI;
import utils.TextEffects;

import java.util.Scanner;

public class HallOfPaintings {

    private boolean portraitObserved = false;
    private boolean lookedBehindCurtain = false;
    private int portraitRevisits = 0;

    public static boolean enter(Scanner scanner, Player player, boolean corridorPortraitObserved) {
        HallOfPaintings hall = new HallOfPaintings();
        hall.portraitObserved = corridorPortraitObserved;
        hall.start(scanner, player);
        return hall.portraitObserved;
    }

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
        portraitObserved = true;
        portraitRevisits++;

        TextEffects.typeLine("An imposing oil portrait of an 18th-century noblewoman.", TextEffects.NORMAL);
        TextEffects.pause(400);

        if (!lookedBehindCurtain) {
            if (portraitRevisits == 1) {
                TextEffects.typeLine("Her eyes rest quietly on a dark velvet drape at the far end of the gallery.", TextEffects.NORMAL);
            } else {
                TextEffects.typeLine("You could swear her eyes are facing slightly more toward you than before.", TextEffects.SLOW);
            }
        } else {
            switch (portraitRevisits) {
                case 1 -> {
                    TextEffects.typeLine("The noblewoman's eyes are no longer fixed on the velvet drape.", TextEffects.SLOW);
                    TextEffects.pause(600);
                    TextEffects.typeLine("They are looking directly at you.", TextEffects.SLOW);
                }
                case 2 -> {
                    TextEffects.typeLine("The portrait seems unchanged at first...", TextEffects.SLOW);
                    TextEffects.pause(700);
                    TextEffects.typeLine("Then you notice the position of her hands.", TextEffects.SLOW);
                    TextEffects.pause(800);
                    TextEffects.typeLine("Her painted fingers now curl around the inner wooden edge of the frame.", TextEffects.FAST);
                }
                case 3 -> {
                    TextEffects.typeLine("The noblewoman is smiling.", TextEffects.SLOW);
                    TextEffects.pause(600);
                    TextEffects.typeLine("Not the subtle suggestion of a smile painted by the artist.", TextEffects.SLOW);
                    TextEffects.pause(800);
                    TextEffects.typeLine("A real, wide smile exposing glistening painted teeth.", TextEffects.FAST);
                    TextEffects.pause(800);
                    TextEffects.typeLine("You are certain she wasn't smiling before.", TextEffects.SLOW);
                }
                default -> {
                    TextEffects.typeLine("Her gaze moves with you across the room.", TextEffects.SLOW);
                    TextEffects.typeLine("You don't need to look again to know she is still smiling.", TextEffects.SLOW);
                }
            }
        }
        System.out.println();
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
        System.out.println();
    }

    private void lookBehindCurtain() {
        if (!lookedBehindCurtain) {
            lookedBehindCurtain = true;
            portraitRevisits = 0;

            TextEffects.typeLine("You reach out and pull back the heavy black velvet curtain.", TextEffects.NORMAL);
            TextEffects.pause(800);
            TextEffects.typeLine("Behind it rests a mirror, covered in thick gray dust.", TextEffects.SLOW);
            TextEffects.pause(600);
            TextEffects.typeLine("In the reflection, you see the gallery behind you clearly...", TextEffects.SLOW);
            TextEffects.pause(1000);
            TextEffects.typeLine("...except none of the figures in the paintings are in their frames.", TextEffects.FAST);
        } else {
            TextEffects.typeLine("The dusty mirror rests behind the curtain.", TextEffects.SLOW);
            TextEffects.typeLine("You refrain from looking into the reflection again.", TextEffects.SLOW);
        }
        System.out.println();
    }
}
package locations;

import game.Player;
import utils.TextEffects;

import java.util.Scanner;

public class ArtifactStorage {

    private boolean readLogbook = false;
    private boolean knockedBack = false;
    private int crateRevisits = 0;
    private int rowSevenVisits = 0;

    public void start(Scanner scanner, Player player) {
        boolean inStorage = true;

        System.out.println("Dust motes float through beams of fluorescent light.");
        System.out.println("Rows of tall metal shelving stretch into shadows.\n");

        while (inStorage) {
            printMenu();

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println();
                inStorage = handleChoice(choice, scanner, player);
            } else {
                System.out.println("\nA metal shelf creaks in the dark. Choose 1, 2, 3, or 4.\n");
                scanner.nextLine();
            }
        }
    }

    private void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("          ARTIFACT STORAGE");
        System.out.println("----------------------------------------");
        System.out.println("1. Inspect Crate #042");
        System.out.println("2. Read shipping logbook");
        System.out.println("3. Listen to the dark shelf row");
        System.out.println("4. Return to Museum corridor");
        System.out.print("\n> ");
    }

    private boolean handleChoice(int choice, Scanner scanner, Player player) {
        switch (choice) {
            case 1 -> {
                inspectCrate042(scanner);
                return true;
            }
            case 2 -> {
                readLogbook();
                return true;
            }
            case 3 -> {
                listenToRowSeven(player);
                return true;
            }
            case 4 -> {
                System.out.println("You back away from the shadows and return to the main corridor.\n");
                return false;
            }
            default -> {
                System.out.println("Shadows stretch across the floor. Choose 1, 2, 3, or 4.\n");
                return true;
            }
        }
    }

    private void inspectCrate042(Scanner scanner) {
        if (!knockedBack) {
            TextEffects.typeLine("A massive wooden crate bound in heavy iron chains sits in the shadow.", TextEffects.NORMAL);
            TextEffects.pause(500);
            TextEffects.typeLine("From inside the crate...", TextEffects.SLOW);
            TextEffects.pause(800);
            TextEffects.typeLine("KNOCK.", TextEffects.FAST);
            TextEffects.pause(400);
            TextEffects.typeLine("KNOCK.", TextEffects.FAST);
            TextEffects.pause(400);
            TextEffects.typeLine("KNOCK.", TextEffects.FAST);
            TextEffects.pause(600);

            if (!readLogbook) {
                TextEffects.typeLine("Three distinct raps echo against the wood, then silence falls.", TextEffects.NORMAL);
                TextEffects.typeLine("Without context, you decide not to disturb it further.\n", TextEffects.NORMAL);
            } else {
                TextEffects.typeLine("You remember the logbook's warning: 'DO NOT RESPOND TO AUDITORY STIMULI.'", TextEffects.SLOW);
                System.out.println("\nWhat do you do?");
                System.out.println("1. Knock back three times");
                System.out.println("2. Remain silent and step away");
                System.out.print("\n> ");

                if (scanner.hasNextInt()) {
                    int response = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    if (response == 1) {
                        knockBack();
                    } else {
                        TextEffects.typeLine("You heed the warning and step back into the aisle.", TextEffects.NORMAL);
                    }
                } else {
                    scanner.nextLine();
                    TextEffects.typeLine("You hesitate too long and step away in silence.", TextEffects.NORMAL);
                }
            }
        } else {
            crateRevisits++;
            handleCrateRevisit();
        }
    }

    private void knockBack() {
        knockedBack = true;

        TextEffects.typeLine("You reach out and rap your knuckles against the thick wood three times.", TextEffects.NORMAL);
        TextEffects.typeLine("A heavy silence falls over the entire storage room...", TextEffects.SLOW);

        TextEffects.pause(1200);
        TextEffects.typeLine("Then...", TextEffects.SLOW);

        TextEffects.pause(1000);
        TextEffects.typeLine("A DEAFENING BANG ERUPTS FROM INSIDE THE CRATE!", TextEffects.FAST);

        TextEffects.pause(400);
        TextEffects.typeLine("The chains rattle violently.", TextEffects.FAST);

        TextEffects.pause(1200);
        TextEffects.typeLine("Everything falls silent.", TextEffects.SLOW);

        TextEffects.pause(800);
        TextEffects.typeLine("Far too silent.", TextEffects.SLOW);
    }

    private void handleCrateRevisit() {
        switch (crateRevisits) {
            case 1 -> {
                TextEffects.typeLine("Crate #042 remains completely still.", TextEffects.SLOW);
                TextEffects.pause(500);
                TextEffects.typeLine("The thick iron chains hang motionless.", TextEffects.SLOW);
            }
            case 2 -> {
                TextEffects.typeLine("You place a hand gently against the wood.", TextEffects.NORMAL);
                TextEffects.pause(600);
                TextEffects.typeLine("It feels ice cold to the touch.", TextEffects.SLOW);
                TextEffects.pause(800);
                TextEffects.typeLine("No sound comes from within.", TextEffects.SLOW);
            }
            case 3 -> {
                TextEffects.typeLine("You stare at the crate for a long moment.", TextEffects.SLOW);
                TextEffects.pause(700);
                TextEffects.typeLine("You find yourself expecting another bang...", TextEffects.SLOW);
                TextEffects.pause(1000);
                TextEffects.typeLine("...but Crate #042 offers no answer.", TextEffects.SLOW);
            }
            default -> {
                TextEffects.typeLine("Crate #042 stands silent in the dim light.", TextEffects.NORMAL);
                TextEffects.typeLine("Whatever was inside seems to have stopped trying to get out.", TextEffects.SLOW);
            }
        }
    }

    private void readLogbook() {
        readLogbook = true;
        TextEffects.typeLine("The logbook rests on a metal table, covered in yellowed dust.", TextEffects.NORMAL);
        TextEffects.pause(400);
        TextEffects.typeLine("'Item #042 - Recovered from North Sea excavation site.'", TextEffects.NORMAL);
        TextEffects.typeLine("'DO NOT ATTEMPT TO OPEN. DO NOT RESPOND TO AUDITORY STIMULI.'", TextEffects.SLOW);
    }

    private void listenToRowSeven(Player player) {
        rowSevenVisits++;

        if (knockedBack) {
            switch (rowSevenVisits) {
                case 1 -> {
                    TextEffects.typeLine("Curator " + player.getName() + ", you stand still and listen closely.", TextEffects.NORMAL);
                    TextEffects.pause(600);
                    TextEffects.typeLine("...", TextEffects.SLOW);
                    TextEffects.pause(800);
                    TextEffects.typeLine("Nothing.", TextEffects.SLOW);
                    TextEffects.pause(600);
                    TextEffects.typeLine("The rhythmic breathing is completely gone.", TextEffects.SLOW);
                }
                case 2 -> {
                    TextEffects.typeLine("You stand at the mouth of Row 7 and wait.", TextEffects.NORMAL);
                    TextEffects.pause(800);
                    TextEffects.typeLine("For several seconds, absolute silence reigns.", TextEffects.SLOW);
                    TextEffects.pause(1000);
                    TextEffects.typeLine("Then—", TextEffects.FAST);
                    TextEffects.pause(800);
                    TextEffects.typeLine("KNOCK.", TextEffects.FAST);
                    TextEffects.pause(400);
                    TextEffects.typeLine("KNOCK.", TextEffects.FAST);
                    TextEffects.pause(400);
                    TextEffects.typeLine("KNOCK.", TextEffects.FAST);
                    TextEffects.pause(900);
                    TextEffects.typeLine("The sound echoes from somewhere deep within Row 7... then abruptly stops.", TextEffects.SLOW);
                }
                case 3 -> {
                    TextEffects.typeLine("The storage room is silent.", TextEffects.SLOW);
                    TextEffects.pause(800);
                    TextEffects.typeLine("You wait.", TextEffects.SLOW);
                    TextEffects.pause(1000);
                    TextEffects.typeLine("One second.", TextEffects.SLOW);
                    TextEffects.pause(1000);
                    TextEffects.typeLine("Two seconds.", TextEffects.SLOW);
                    TextEffects.pause(1000);
                    TextEffects.typeLine("Three.", TextEffects.SLOW);
                    TextEffects.pause(1200);
                    TextEffects.typeLine("You find yourself waiting for the fourth knock.", TextEffects.SLOW);
                    TextEffects.pause(1500);
                    TextEffects.typeLine("It never comes.", TextEffects.SLOW);
                }
                default -> {
                    TextEffects.typeLine("You move deeper into Row 7, flashlight cutting through the gloom.", TextEffects.NORMAL);
                    TextEffects.pause(800);
                    TextEffects.typeLine("Your beam catches a small metal container sitting alone on a middle shelf.", TextEffects.SLOW);
                    TextEffects.pause(800);
                    TextEffects.typeLine("You are certain it wasn't there before.", TextEffects.SLOW);
                    TextEffects.pause(1000);
                    TextEffects.typeLine("A brass tag hangs from its rusted handle:", TextEffects.NORMAL);
                    TextEffects.pause(500);
                    TextEffects.typeLine("CRATE #043", TextEffects.SLOW);
                    TextEffects.pause(800);
                    TextEffects.typeLine("Below it, written in faded red ink:", TextEffects.NORMAL);
                    TextEffects.pause(600);
                    TextEffects.typeLine("CONTAINMENT STATUS: LISTENING", TextEffects.SLOW);
                }
            }
        } else {
            switch (rowSevenVisits) {
                case 1 -> {
                    TextEffects.typeLine("Curator " + player.getName() + ", you stand still and listen closely.", TextEffects.NORMAL);
                    TextEffects.pause(600);
                    TextEffects.typeLine("Amidst the quiet hum of electricity, a faint, rhythmic breathing echoes down Row 7.", TextEffects.SLOW);
                }
                case 2 -> {
                    TextEffects.typeLine("You listen again at the edge of the shelving.", TextEffects.NORMAL);
                    TextEffects.pause(600);
                    TextEffects.typeLine("The breathing starts again...", TextEffects.SLOW);
                    TextEffects.pause(600);
                    TextEffects.typeLine("You take one cautious step toward Row 7.", TextEffects.NORMAL);
                    TextEffects.pause(500);
                    TextEffects.typeLine("It immediately stops.", TextEffects.SLOW);
                }
                case 3 -> {
                    TextEffects.typeLine("The darkness between the shelves remains completely still.", TextEffects.SLOW);
                    TextEffects.pause(800);
                    TextEffects.typeLine("Then something slowly scrapes across the concrete floor.", TextEffects.SLOW);
                    TextEffects.pause(1000);
                    TextEffects.typeLine("Once.", TextEffects.SLOW);
                    TextEffects.pause(800);
                    TextEffects.typeLine("From somewhere far beyond the reach of your flashlight.", TextEffects.SLOW);
                }
                default -> {
                    TextEffects.typeLine("Row 7 is quiet.", TextEffects.SLOW);
                    TextEffects.pause(800);
                    TextEffects.typeLine("You are no longer sure whether that is a good thing.", TextEffects.SLOW);
                }
            }
        }
    }
}
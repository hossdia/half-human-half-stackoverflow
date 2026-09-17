package locations;

import game.Player;
import utils.LocationUI;
import utils.TextEffects;

import java.util.Scanner;

public class MuseumCorridor {

    public static boolean enter(
            Scanner scanner,
            Player player,
            boolean scarabTaken,
            boolean crateAnswered,
            boolean portraitObserved
    ) {
        boolean inCorridor = true;

        while (inCorridor) {
            System.out.println();

            // Dynamic corridor atmosphere based on current state
            if (scarabTaken) {
                TextEffects.typeLine(
                        "As you step into the corridor, something inside your satchel gives a faint metallic click."
                );
            } else if (portraitObserved) {
                TextEffects.typeLine(
                        "For a moment, you have the uncomfortable feeling that the corridor is longer than it was before."
                );
            } else if (crateAnswered) {
                TextEffects.typeLine(
                        "The corridor is unusually quiet tonight. You can't remember it ever being this quiet."
                );
            } else {
                TextEffects.typeLine(
                        "You step back into the main corridor."
                );
            }

            System.out.println();

            TextEffects.typeLine(
                    "The hallway stretches farther than you remembered,"
            );
            TextEffects.typeLine(
                    "long and narrow beneath a row of dim emergency lights."
            );

            System.out.println();

            TextEffects.typeLine(
                    "To your left stands the entrance to the Egyptian Gallery."
            );
            TextEffects.typeLine(
                    "To your right, a set of heavy wooden doors leads into the Hall of Paintings."
            );
            TextEffects.typeLine(
                    "Farther down the corridor, beneath a flickering light, is the reinforced door to Artifact Storage."
            );
            TextEffects.typeLine(
                    "Behind you are the iron doors leading back to the Entrance Hall."
            );

            System.out.println();

            TextEffects.typeLine(
                    "For a moment, everything is still."
            );
            TextEffects.typeLine(
                    "Then one of the lights flickers."
            );

            LocationUI.printMenu(
                    "MUSEUM CORRIDOR",
                    "Enter Egyptian Gallery",
                    "Enter Hall of Paintings",
                    "Enter Artifact Storage",
                    "Return to Entrance Hall"
            );

            int choice = LocationUI.getChoice(scanner, 4);

            switch (choice) {
                case 1 -> EgyptianGallery.enter(scanner, player, scarabTaken);
                case 2 -> HallOfPaintings.enter(scanner, player, portraitObserved);
                case 3 -> ArtifactStorage.enter(scanner, player, crateAnswered);
                case 4 -> {
                    TextEffects.typeLine(
                            "You turn back toward the iron doors of the Entrance Hall..."
                    );
                    inCorridor = false;
                }
            }
        }

        return true;
    }
}
package locations;

import game.Player;
import utils.LocationUI;
import utils.TextEffects;

import java.util.Scanner;

public class MuseumCorridor {

    private boolean scarabTaken = false;
    private boolean crateAnswered = false;
    private boolean portraitObserved = false;
    private int corridorVisits = 0;

    public static boolean enter(Scanner scanner, Player player) {
        MuseumCorridor corridor = new MuseumCorridor();
        return corridor.start(scanner, player);
    }

    private boolean start(Scanner scanner, Player player) {
        boolean inCorridor = true;

        while (inCorridor) {
            corridorVisits++;
            System.out.println();

            // Atmospheric memory hooks based on state flags
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
                TextEffects.typeLine("You step into the central axis of the museum.");
            }

            System.out.println();

            // Dynamic spatial prose based on revisit count
            if (corridorVisits == 1) {
                TextEffects.typeLine(
                        "The grand hallway stretches ahead into shadow, narrow beneath a row of dim, buzz-humming emergency lights."
                );
                TextEffects.typeLine(
                        "To your left, a vaulted archway framed in sandstone leads into the Egyptian Gallery."
                );
                TextEffects.typeLine(
                        "To your right, double-leafed heavy wooden doors mark the entrance to the Hall of Paintings."
                );
                TextEffects.typeLine(
                        "Farther down the corridor on the left sits a padlocked brass service gate."
                );
                TextEffects.typeLine(
                        "Straight ahead, where the ceiling drops low beneath exposed iron pipes, stands the reinforced steel door to Artifact Storage."
                );
                TextEffects.typeLine(
                        "Beyond that door, the corridor continues past the emergency lighting, swallowing into absolute dark."
                );
            } else {
                TextEffects.typeLine(
                        "You stand once again in the main hallway. Behind you lie the double iron doors to the Entrance Hall."
                );
                TextEffects.typeLine(
                        "The sandstone arch of the Egyptian Gallery sits on your left, while the heavy wooden doors of the Hall of Paintings rest to your right."
                );
                TextEffects.typeLine(
                        "Farther down, past the padlocked service gate, the reinforced door of Artifact Storage looms in the gloom."
                );
                TextEffects.typeLine(
                        "Deep at the far end of the corridor, a single emergency light flickers uselessly against the dark."
                );
            }

            System.out.println();

            LocationUI.printMenu(
                    "MUSEUM CORRIDOR",
                    "Enter Egyptian Gallery (Left)",
                    "Enter Hall of Paintings (Right)",
                    "Approach Artifact Storage (Ahead)",
                    "Inspect Padlocked Service Gate",
                    "Return to Entrance Hall (Behind)"
            );

            int choice = LocationUI.getChoice(scanner, 5);

            switch (choice) {
                case 1 -> scarabTaken =
                        EgyptianGallery.enter(scanner, player, scarabTaken);

                case 2 -> portraitObserved =
                        HallOfPaintings.enter(scanner, player, portraitObserved);

                case 3 -> crateAnswered =
                        ArtifactStorage.enter(scanner, player, crateAnswered);

                case 4 -> inspectServiceGate();

                case 5 -> {
                    TextEffects.typeLine(
                            "You turn away from the long hallway and step back through the iron doors..."
                    );
                    inCorridor = false;
                }
            }
        }

        return true;
    }

    private void inspectServiceGate() {
        TextEffects.typeLine(
                "You step closer to the padlocked brass service gate between the gallery doors.", TextEffects.NORMAL
        );
        TextEffects.pause(500);
        TextEffects.typeLine(
                "A heavy steel chain binds the handles together. A handwritten card hanging from the latch reads:", TextEffects.NORMAL
        );
        TextEffects.pause(400);
        TextEffects.typeLine(
                "'RESTORATION IN PROGRESS - NO ENTRY'", TextEffects.SLOW
        );
        TextEffects.pause(600);
        TextEffects.typeLine(
                "Through the iron bars, a dark staircase descends into the museum's sub-basement.", TextEffects.SLOW
        );
        TextEffects.pause(500);
        TextEffects.typeLine(
                "You step back to the central corridor.", TextEffects.NORMAL
        );
        System.out.println();
    }
}
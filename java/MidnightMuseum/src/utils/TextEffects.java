package utils;

public class TextEffects {

    public static final int FAST = 10;
    public static final int NORMAL = 25;
    public static final int SLOW = 50;

    public static void type(String text, int speedMs) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            pause(speedMs);
        }
        System.out.println();
    }

    public static void type(String text) {
        type(text, NORMAL);
    }

    public static void typeLine(String text, int speedMs) {
        type(text, speedMs);
        blankLine();
    }

    public static void typeLine(String text) {
        typeLine(text, NORMAL);
    }

    public static void blankLine() {
        System.out.println();
    }

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
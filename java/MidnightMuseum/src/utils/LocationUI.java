package utils;

public class LocationUI {

    private static final String SEPARATOR = "----------------------------------------";

    public static void printHeader(String locationName) {
        System.out.println(SEPARATOR);
        System.out.printf("          %s%n", locationName.toUpperCase());
        System.out.println(SEPARATOR);
    }

    public static void printMenu(String title, String... options) {
        printHeader(title);

        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        System.out.print("\n> ");
    }
}
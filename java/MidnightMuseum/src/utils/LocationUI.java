package utils;

import java.util.Scanner;

public class LocationUI {

    public static void printMenu(String title, String... options) {
        System.out.println("----------------------------------------");
        System.out.println("          " + title);
        System.out.println("----------------------------------------");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println();
    }

    public static int getChoice(Scanner scanner, int maxChoice) {
        int choice = -1;
        while (choice < 1 || choice > maxChoice) {
            System.out.print("> ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear newline buffer
            } else {
                scanner.nextLine(); // Clear invalid input
            }
        }
        return choice;
    }
}
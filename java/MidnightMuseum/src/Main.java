import java.util.Scanner;


/*
 * Midnight Museum
 *
 * Sprint 1
 * MM-001 - Night Curator Introduction
 *
 * TODO
 * [ ] Print title
 * [ ] Ask player's name
 * [ ] Store player's name
 * [ ] Display personalized welcome
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String curatorName;
        System.out.println("========================================");
        System.out.println("         MIDNIGHT MUSEUM");
        System.out.println("========================================");
        System.out.println();
        System.out.println("The entrance doors close behind you.");
        System.out.println();
        System.out.println("A voice echoes through the empty halls...");
        System.out.println();
        System.out.print("\"State your name, Curator.\"\n\n> ");
        curatorName = scanner.nextLine();
        System.out.println();
        System.out.println("Welcome, " + curatorName + ".");
        System.out.println();
        System.out.println("You have been appointed as the Night Curator.");
        System.out.println();
        System.out.println("The museum opens only after sunset.");
        System.out.println();
        System.out.println("Protect the artifacts.");
        System.out.println("Contain the anomalies.");
        System.out.println();
        System.out.println("May you flourish in your mission to protect this museum.");
        scanner.close();
    }
}

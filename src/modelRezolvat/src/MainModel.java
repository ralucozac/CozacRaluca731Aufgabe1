package modelRezolvat.src;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main class to run the Hogwarts house points application
 */
public class MainModel {
    public static void main(String[] args) {
        Functionality app = new Functionality();
        Scanner scanner = new Scanner(System.in);




        try {
            // Task a) Read from file
            System.out.println("Reading data from punkte.txt...");
            app.readFromFile();
            System.out.println("Data loaded successfully.");

            // Task b) Filter students by letter
            System.out.print("\nEnter a letter to filter students: ");
            char letter = scanner.nextLine().charAt(0); //prin asta iei caracteru prin care incepe
            System.out.println("\nStudents starting with '" + letter + "':");
            app.showStudentsStartingWith(letter);

            // Task c) Show sorted Gryffindor students
            System.out.println("\nGryffindor students (alphabetically):");
            app.showGryffindorStudents();

            // Task d) Save house points
            app.saveHousePoints();
            System.out.println("\nHouse points have been saved to ergebnis.txt");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
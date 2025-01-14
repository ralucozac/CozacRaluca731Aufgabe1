package modelRezolvat.src;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Application to manage Hogwarts house points system
 */
public class Functionality {
    private final List<StudentRecord> listaDeVrajitori = new ArrayList<>();

    /**
     * Reads student records from the input file
     * @throws IOException if file cannot be read
     */
    public void readFromFile() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/punkte.txt"));
        for (String line : lines) {
            String[] parts = line.split("&");
            if (parts.length == 5) {
                listaDeVrajitori.add(new StudentRecord(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        House.valueOf(parts[2].toUpperCase()),
                        parts[3],
                        Integer.parseInt(parts[4])
                ));
            }
        }
    }

    /**
     * Shows students whose names start with the given letter
     * @param startLetter the letter to filter by
     */
    public void showStudentsStartingWith(char startLetter) {
        listaDeVrajitori.stream()
                .map(StudentRecord::getName)
                .distinct()
                .filter(name -> name.toUpperCase().startsWith(String.valueOf(startLetter).toUpperCase())) // filtreaza ceva.toUppercase astfel incat sa inceapa valuare in String to uppercase
                .forEach(System.out::println);
    }


//Exemplu daca cu filter daca ti se da sa fie filtrati cu nota mai mica decat ceva cu tot cu citire din consola cu scanner

//    List<Integer> numbers = Arrays.asList(15, 18, 12, 20, 8, 16, 14, 19); asta ar fi de exemplu rezultatu la map(StudentRecord::getGrades)
//
//    // Create scanner for keyboard input
//    Scanner scanner = new Scanner(System.in);
//
//    // Read the threshold number from user
//        System.out.print("Enter a number to filter by: ");
//    int valuareDeLaTastatura = scanner.nextInt();
//
//    // Print numbers less than the threshold
//
//        numbers.stream()
//                .filter(nota -> nota < valuareDeLaTastatura)
//            .forEach(System.out::println);
//
//        scanner.close();  // Don't forget to close the scanner
//}

    /**
     * Shows Gryffindor students in alphabetical order
     */
    public void showGryffindorStudents() {
        listaDeVrajitori.stream()
                .filter(student -> student.getHouse() == House.GRYFFINDOR)
                .map(StudentRecord::getName)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Calculates and saves house points to output file
     * @throws IOException if file cannot be written
     */
    public void saveHousePoints() throws IOException {
        Map<House, Integer> housePoints = new HashMap<>();

        // Calculate total points for each house
//        for (StudentRecord record : listaDeVrajitori) {
//            housePoints.merge(record.getHouse(), record.getPoints(), Integer::sum);
//        } varianta 1


        for (StudentRecord vrajitor : listaDeVrajitori) {
            House casaVrajitorului = vrajitor.getHouse(); // in astea 2 am salvat variabile locale ca sa nu le tot scriem ca vrajitor.getHouse() si vrajitor.getPoints()
            int puncteleVrajitorului = vrajitor.getPoints();

            // If house exists in map, add to its current points
            if (housePoints.containsKey(casaVrajitorului)) {
                int currentPoints = housePoints.get(casaVrajitorului);
                housePoints.put(casaVrajitorului, currentPoints + puncteleVrajitorului); //put pune chestii in Hashmap(Key,Value) la Value
            }
            // If house doesn't exist yet, add it with these points
            else {
                housePoints.put(casaVrajitorului, puncteleVrajitorului);
            }
        }

        // Sort houses by points in descending order
        List<Map.Entry<House, Integer>> sortedHouses = new ArrayList<>(housePoints.entrySet());
        sortedHouses.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Write to file
        List<String> outputLines = new ArrayList<>();
        for (Map.Entry<House, Integer> entry : sortedHouses) {
            outputLines.add(entry.getKey().name() + "#" + entry.getValue());
        }
        Files.write(Paths.get("src/ergebnis.txt"), outputLines);
    }
}




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Functionality {

    private final List<EreignissRecord> listaDeEvenimente = new ArrayList<>();

   /*
   public void readFromFile() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/evenimente.xml"));
        for (String line : lines) {
            String[] parts = line.split("&");
            if (parts.length == 5) {
                listaDeEvenimente.add(new EreignissRecord(
                        Date.parse(parts[0]),
                        parts[1],
                        House.valueOf(parts[2].toUpperCase()),
                        parts[3],
                        Integer.parseInt(parts[4])
                ));
            }
        }
    }


    */


    /**
     * Shows students whose names start with the given letter
     * @param startLetter the letter to filter by
     */
    public void showMitgliedStartingWith(char startLetter) {
        listaDeEvenimente.stream()
                .map(EreignissRecord::getMitgliedsname)
                .distinct()
                .filter(name -> name.toUpperCase().startsWith(String.valueOf(startLetter).toUpperCase())) // filtreaza ceva.toUppercase astfel incat sa inceapa valuare in String to uppercase
                .forEach(System.out::println);
    }



}
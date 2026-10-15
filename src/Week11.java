import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Week11 {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("board-fixtures.csv");
        List<String> rows = List.of(
            "id,label,state",
            "S-101,ALPHA,READY",
            "S-102,BETA,HELD",
            "S-103,GAMMA,READY"
        );
        // Save rows to file
        Files.write(file, rows);

        // Read rows back
        List<String> loaded = Files.readAllLines(file);
        System.out.println("Saved " + (loaded.size() - 1) + " fictional board cards");
        System.out.println("Loaded " + loaded.get(1));
        System.out.println("File result: PASS");
    }
}

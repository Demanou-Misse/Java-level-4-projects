package analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private List<String> lines;

    public FileUtils (String path) {
        try {
            this.lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
            this.lines = new ArrayList<>();
        }
    }

    public List<String > getLines () {
        return lines;
    }

    public List<String> CleanedLines() {
        return lines.stream()
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("\\p{Punct}", ""))
                .map(s -> s.replaceAll("\\s+", " "))
                .toList();
    }

}

package analyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequencyCounter {

    private Map<String, Integer> map = new HashMap<>();

    public WordFrequencyCounter (List<String> cleanedLines) {
        List<String> words = List.of(String.join(" ", cleanedLines).split("\\s+"));
        words.forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
    }

    public void mostFrequentWords() {
        System.out.println("\n--- Most Frequent Words ---");

        var topFive = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .toList();

        int i = 1;
        for (var entry : topFive) {
            System.out.println(i + ". \"" + entry.getKey() + "\" -> " + entry.getValue());
            i++;
        }

    }

}

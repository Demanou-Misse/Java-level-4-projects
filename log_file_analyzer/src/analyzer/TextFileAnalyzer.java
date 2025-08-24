package analyzer;

import java.util.Arrays;
import java.util.List;

public class TextFileAnalyzer {
    private FileUtils fileUtils;

    public TextFileAnalyzer (String path) {
        this.fileUtils = new FileUtils(path);
        System.out.println("\n📄 Analyzing file: \"" + path + "\"");
    }

    public void basicStatistics() {
        System.out.println("\n--- Basic Statistics ---");
        System.out.println("Total lines: " + fileUtils.getLines().size());

        // Total words
        List<String> words = List.of(String.join(" ", fileUtils.CleanedLines()).split("\\s+"));
        System.out.println("Total words: " + words.size());

        // Total characters (with spaces)
        int num = fileUtils.getLines().stream()
                .mapToInt(String::length).sum();
        System.out.println("Total characters (with spaces): " + num);

        // Total characters (without spaces)
        long num1 = fileUtils.getLines().stream()
                .flatMapToInt(String::chars)
                .filter(ch -> ch != ' ').count();
        System.out.println("Total characters (without spaces): " + num1);
    }

    // Most frequent Words
    public void mostFrequentWords () {
        WordFrequencyCounter wordFrequencyCounter = new WordFrequencyCounter(fileUtils.CleanedLines());
        wordFrequencyCounter.mostFrequentWords();
    }

    // Similarity Check
    public void similarityCheck (String path1, String path2) {
        FileUtils fileUtils1 = new FileUtils(path1);
        FileUtils fileUtils2 = new FileUtils(path2);
        List<String> words1 = words(fileUtils1.CleanedLines());
        List<String> words2 = words(fileUtils2.CleanedLines());

        SimilarityChecker similarityChecker = new SimilarityChecker();
        double score = similarityChecker.calculateSimilarity(words1, words2);

        System.out.println("\n--- Similarity Check ---");
        System.out.println("📄 Comparing file: \"" + path1 + "\" with \"" + path2 + "\"");
        System.out.printf("👉 Similarity score: %.2f%%", score);
        similarityChecker.getPlagiarismMessage(score);
    }

    // Lines to words
    public List<String> words(List<String> lines) {
        String line = String.join(" ", lines);
        return Arrays.asList(line.split("\\s+"));
    }

}

package analyzer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimilarityChecker {

    public double calculateSimilarity(List<String> words1, List<String> words2) {
        Set<String> set1 = new HashSet<>(words1);
        Set<String> set2 = new HashSet<>(words2);

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        if (union.isEmpty()) return 0.0;
        return (double) intersection.size() / union.size() * 100;
    }

    public void getPlagiarismMessage(double score) {
        if (score > 85) System.out.println("(Possible plagiarism detected)");
        else if (score > 70) System.out.println("(Possible partial plagiarism detected)");
        else System.out.println();
    }

}

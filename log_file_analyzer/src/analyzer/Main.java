//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package analyzer;

public class Main {
    public static void main(String[] args) {
        String path = "data/sample_text.txt";
        String path1 =  "data/other_text.txt";
        String path2 =  "data/copied_text.txt";
        System.out.println("\n===🔍 Text File Analyser ===");

        TextFileAnalyzer textFileAnalyzer = new TextFileAnalyzer(path);
        textFileAnalyzer.basicStatistics();
        textFileAnalyzer.mostFrequentWords();

        textFileAnalyzer.similarityCheck(path1, path2);
        System.out.println("\n=== End of Report ===");
    }
}
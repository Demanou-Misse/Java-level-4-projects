//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import service.LogParser;

public class Main {
    public static void main(String[] args) {
        LogParser logParser = new LogParser("data/application.txt");

        System.out.println("\n===📊 Log file Analysis Report ===\n");

        logParser.extractingData();
        logParser.countEntries();
        logParser.firstEntries();
        logParser.mostFrequentErrors();

        System.out.println("\n===👋 End of Report ===");

    }
}
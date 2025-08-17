package service;

import model.LogEntry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {

    private final Map<String, List<LogEntry>> map = new HashMap<>();
    List<String> lines;

    public LogParser(String path) {
        try {
            this.lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
            this.lines = new ArrayList<>();
        }
    }

    public Matcher matcher (String regex, String line) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(line);
    }

    // Extracting data
    public void extractingData() {
        System.out.println("📂 File analysed: application.txt");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String regex = "(\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2})\\s+([A-Z]+):\\s+(.+)";

        for (String line : lines) {
            Matcher matcher = matcher(regex, line);
            if (matcher.find()) {
                try {
                    String dateTimeStr = matcher.group(1);
                    String type = matcher.group(2);
                    String message = matcher.group(3);

                    LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
                    LogEntry logEntry = new LogEntry(dateTime, message);
                    map.computeIfAbsent(type, k -> new ArrayList<>()).add(logEntry);
                } catch (Exception e) {
                    System.out.println("❌ Error during line processing: " + line);
                }
            } else {
                System.out.println("⚠️ Non-conforming line ignored: " + line);
            }
        }
        System.out.println("✅ Data successfully extracted.");
    }

    // Total entries and Log Count by Type
    public void countEntries() {
        System.out.println("\n🎯Total entries: " + lines.size());

        //Log Count by Type
        System.out.println("=== Log Count by Type ===:");

        map.forEach((type, logEntries) -> System.out.print("    🔹 " + type.toUpperCase() + " -> " + logEntries.size() + "\n"));
        System.out.println("=".repeat(25));
    }

    // First 5 entries sorted by Date/Time
    public void firstEntries() {
        System.out.println("\n===🧾 Sorted by Date/Time (first 5 entries) ===");

        for (int i = 0; i <= 4; i++) {
            System.out.println("\t" + lines.get(i));
        }
    }

    // Most Frequent Errors
    public void mostFrequentErrors() {
        if (!map.containsKey("ERROR")) {
            System.out.println("❌ No error found.");
            return;
        }
        List<String> list = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap<>(); // Map for errors and theirs items

        List<LogEntry> logEntriesError = map.get("ERROR");
        logEntriesError.forEach(logEntry -> list.add(logEntry.getMessage()));

        list.forEach(error -> map1.put(error, map1.getOrDefault(error, 0) + 1));

        var topThree = map1.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .toList();

        System.out.println("\n===🔍 Most Frequent Errors ===");
        for (var entry : topThree) {
            System.out.println("\t" + entry.getKey() + " -> " + entry.getValue() + " items");
        }
    }


}

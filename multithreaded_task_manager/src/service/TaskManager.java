package service;

import model.*;

import java.io.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TaskManager {

    private final Map<Priority, List<Task>> map = new HashMap<>();

    // Valid Time
    public boolean validTime(String userInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime now = LocalTime.now();

        try {
            LocalTime time = LocalTime.parse(userInput, formatter);
            if (time.isBefore(now)) {
                System.out.println("❌ Time is already passed, enter a future time.");
            }
            return time.isAfter(now);
        } catch (DateTimeParseException e) {
            System.out.println("❌ Invalid format (use HH:mm).");
            return false;
        }
    }

    // Add a Task
    public void addTask(Scanner input, ReminderService reminderService) {

        String title;
        while (true) {
            System.out.print("\nTask title: ");
            title = input.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("❌ Task title cannot be empty.");
                continue;
            }
            break;
        }

        LocalTime time;
        while (true) {
            System.out.print("Time (HH:mm): ");
            String userInput = input.nextLine().trim();
            if (userInput.isEmpty()) {
                System.out.println("❌ Time cannot be empty.");
                continue;
            }
            if (validTime(userInput)) {
                time = LocalTime.parse(userInput);
                break;
            }
        }

        Priority priority;
        while (true) {
            System.out.print("Priority (LOW/MEDIUM/HIGH): ");
            String userInput = input.nextLine().trim().toUpperCase();
            if (userInput.isEmpty()) {
                System.out.println("❌ Priority cannot be empty.");
                continue;
            }

            try {
                priority = Priority.valueOf(userInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid Priority. Use: LOW/MEDIUM/HIGH.");
            }
        }

        Task task = new Task(title, time);
        map.computeIfAbsent(priority, k -> new ArrayList<>()).add(task);

        // compute delays
        long delayTask = Duration.between(LocalTime.now(), task.getTime()).toSeconds();
        long delayReminder = delayTask - (20);
        if (delayReminder < 0) delayReminder = 0;

        // Plan Reminder
        reminderService.scheduleTask(() -> System.out.println("\n🔔 Reminder: Task \"" + task.getTitle() + "\" starts at " + time + " (20 seconds left)."), delayReminder, TimeUnit.SECONDS);

        // Pan Task Execution
        reminderService.scheduleTask(() -> System.out.println("✅ [Execution] It's time to do: " + task.getTitle() + " (" + time + ")."), delayTask, TimeUnit.SECONDS);

        System.out.println("\n✅ Task added successfully and reminder scheduled!");

    }

    // Show all tasks
    public void showAllTasks() {
        if (map.isEmpty()) {
            System.out.println("❌ No task found.");
            return;
        }

        System.out.println("\n===🧾 All Tasks ====\n");
        map.forEach((priority, tasks) -> {
            System.out.println("🔹 [" + priority + "]:");
            tasks.forEach(task -> System.out.println("\t" + task.toString()));
        });

    }

    // Show tasks by priority
    public void showTasksByPriority (Scanner input) {

        Priority priority;
        while (true) {
            System.out.print("\nShow tasks by which priority? (LOW/MEDIUM/HIGH): ");
            String userInput = input.nextLine().trim().toUpperCase();
            if (userInput.isEmpty()) {
                System.out.println("❌ Priority cannot be empty.");
                continue;
            }

            try {
                priority = Priority.valueOf(userInput);
                if (!map.containsKey(priority)) System.out.println("❌ This priority doesn't exist.");
                else {
                    System.out.println("\n=== Tasks with priority " + priority + " ===");
                    List<Task> tasks = map.get(priority);
                    for (Task task : tasks) {
                        System.out.println("\t" + task.toString());
                    }
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid input. Enter LOW/MEDIUM/HIGH.");
            }
        }

    }

    // Save in a file
    public void save() {
        if (map.isEmpty()) {
            System.out.println("❌ No task found.");
            return;
        }

        File file = new File("data/tasks.txt");
        try {
            if (!file.getParentFile().exists()) file.getParentFile().mkdirs();
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            System.out.println("❌ " + e.getMessage());
        }

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {

            pw.println("\n===🧾 All Tasks ====\n");
            map.forEach((priority, tasks) -> {
                pw.println("🔹 [" + priority + "]:");
                tasks.forEach(task -> pw.println("\t" + task.toString()));
            });
            System.out.println("\n✅ Tasks saved successfully.");

        } catch (IOException e) {
            System.out.println("❌ Error by saving.");
        }
    }

}

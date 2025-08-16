import java.util.Scanner;
import service.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        ReminderService reminderService = new ReminderService(2);


        int choice;

        System.out.println("\n===📋 Multithreaded Task Manager ===");
        System.out.println("\n💡 Note: You will receive a reminder 20 seconds before the scheduled time of your task.");

        do {
            System.out.println("\n==== Main Menu ===");
            System.out.println("    [1] Add a task");
            System.out.println("    [2] Show all tasks");
            System.out.println("    [3] Show tasks by priority");
            System.out.println("    [4] Save");
            System.out.println("    [5] Exit");

            while (true) {
                System.out.print(">> your choice: ");
                String userInput = input.nextLine().trim();
                if (userInput.isEmpty()) {
                    System.out.println("❌ Your choice cannot be empty.");
                    continue;
                }

                try {
                    choice = Integer.parseInt(userInput);

                    if (choice >= 1 && choice <= 5) break;
                    System.out.println("❌ Invalid input. Enter a number between 1 and 5.");
                } catch (NumberFormatException e) {
                    System.out.println("❌ invalid input.");
                }
            }

            switch (choice) {
                case 1:
                    taskManager.addTask(input, reminderService);
                    break;

                case 2:
                    taskManager.showAllTasks();
                    break;

                case 3:
                    taskManager.showTasksByPriority(input);
                    break;

                case 4:
                    taskManager.save();
                    break;

                case 5:
                    reminderService.shutdown();
                    System.out.println("\n👋 Exiting... Goodbye!");
            }

        } while (choice != 5);

        input.close();

    }
}
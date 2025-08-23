package service;

import model.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StudentGradeAggregator {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printReport() {
        System.out.println("=== Student Grade Aggregator ===\n");
        System.out.println("Adding grades for students...\n");

        // Print students and their grades
        System.out.println("Subjects and Grades:");
        for (Student student : students) {
            System.out.println("- Student: " + student.getName());
            for (Subject subject : Subject.values()) {
                String values = student.getGrades().get(subject).stream()
                        .map(n -> String.valueOf(n.getValue()))
                        .collect(Collectors.joining(", "));
                System.out.println("  * " + subject + ": [" + values + "]");
            }
            System.out.println();
        }

        // Average grades by subject
        System.out.println("=== Average Grades by Subject ===");
        for (Subject subject : Subject.values()) {
            System.out.println(subject + ":");
            students.stream()
                    .sorted((s1, s2) -> Double.compare(s2.getAverageBySubject(subject), s1.getAverageBySubject(subject)))
                    .forEach(s -> System.out.printf("  - %s: %.2f%n", s.getName(), s.getAverageBySubject(subject)));
            System.out.println();
        }

        // Top performer by subject
        System.out.println("=== Top Performer by Subject ===");
        for (Subject subject : Subject.values()) {
            Student top = students.stream()
                    .max(Comparator.comparingDouble(s -> s.getAverageBySubject(subject)))
                    .orElse(null);
            if (top != null) {
                System.out.printf("%s: %s (%.2f)%n", subject, top.getName(), top.getAverageBySubject(subject));
            }
        }
        System.out.println();

        // Overall class ranking
        System.out.println("=== Overall Class Ranking ===");
        AtomicInteger rank = new AtomicInteger(1);

        students.stream()
                .sorted(Comparator.comparingDouble(Student::getOverallAverage).reversed())
                .forEachOrdered(s ->
                        System.out.printf("%d. %s - Average: %.2f%n",
                                rank.getAndIncrement(),
                                s.getName(),
                                s.getOverallAverage())
                );

        System.out.println("\n=== End of Report ===");
    }
}

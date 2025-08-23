package model;

import java.util.*;

public class Student {
    private final String name;
    private final Map<Subject, List<Note<? extends Number>>> grades = new EnumMap<>(Subject.class);

    public Student(String name) {
        this.name = name;
        for (Subject subject : Subject.values()) {
            grades.put(subject, new ArrayList<>());
        }
    }

    public String getName() {
        return name;
    }

    public void addGrade(Note<? extends Number> note) {
        grades.get(note.getSubject()).add(note);
    }

    public Map<Subject, List<Note<? extends Number>>> getGrades() {
        return grades;
    }

    public double getAverageBySubject(Subject subject) {
        return grades.get(subject).stream()
                .mapToDouble(n -> n.getValue().doubleValue())
                .average()
                .orElse(0.0);
    }

    public double getOverallAverage() {
        return grades.values().stream()
                .flatMap(List::stream)
                .mapToDouble(n -> n.getValue().doubleValue())
                .average()
                .orElse(0.0);
    }
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import service.StudentGradeAggregator;
import model.*;

public class Main {
    public static void main(String[] args) {
        Student alice = new Student("Alice");
        alice.addGrade(new Note<>(Subject.MATH, 85));
        alice.addGrade(new Note<>(Subject.MATH, 90));
        alice.addGrade(new Note<>(Subject.MATH, 78));
        alice.addGrade(new Note<>(Subject.ENGLISH, 88));
        alice.addGrade(new Note<>(Subject.ENGLISH, 92));
        alice.addGrade(new Note<>(Subject.SCIENCE, 95));
        alice.addGrade(new Note<>(Subject.SCIENCE, 87));
        alice.addGrade(new Note<>(Subject.SCIENCE, 91));

        Student bob = new Student("Bob");
        bob.addGrade(new Note<>(Subject.MATH, 75));
        bob.addGrade(new Note<>(Subject.MATH, 80));
        bob.addGrade(new Note<>(Subject.MATH, 82));
        bob.addGrade(new Note<>(Subject.ENGLISH, 78));
        bob.addGrade(new Note<>(Subject.ENGLISH, 85));
        bob.addGrade(new Note<>(Subject.SCIENCE, 80));
        bob.addGrade(new Note<>(Subject.SCIENCE, 76));

        Student charlie = new Student("Charlie");
        charlie.addGrade(new Note<>(Subject.MATH, 92));
        charlie.addGrade(new Note<>(Subject.MATH, 88));
        charlie.addGrade(new Note<>(Subject.MATH, 95));
        charlie.addGrade(new Note<>(Subject.ENGLISH, 90));
        charlie.addGrade(new Note<>(Subject.ENGLISH, 87));
        charlie.addGrade(new Note<>(Subject.SCIENCE, 85));
        charlie.addGrade(new Note<>(Subject.SCIENCE, 89));
        charlie.addGrade(new Note<>(Subject.SCIENCE, 93));

        StudentGradeAggregator aggregator = new StudentGradeAggregator();
        aggregator.addStudent(alice);
        aggregator.addStudent(bob);
        aggregator.addStudent(charlie);

        aggregator.printReport();
    }
}

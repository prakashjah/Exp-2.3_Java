import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Rahul", 82),
            new Student("Neha", 74),
            new Student("Prakash", 91),
            new Student("Anjali", 88)
        );

        System.out.println("Students scoring above 75% sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks))
                .map(s -> s.name + " - " + s.marks)
                .forEach(System.out::println);
    }
}

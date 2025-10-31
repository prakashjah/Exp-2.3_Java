import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + age + " - " + salary;
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Prakash", 24, 55000),
            new Employee("Amit", 22, 60000),
            new Employee("Ravi", 25, 50000)
        );

        System.out.println("Sort by Name:");
        employees.stream()
                 .sorted((e1, e2) -> e1.name.compareTo(e2.name))
                 .forEach(System.out::println);

        System.out.println("\nSort by Age:");
        employees.stream()
                 .sorted((e1, e2) -> Integer.compare(e1.age, e2.age))
                 .forEach(System.out::println);

        System.out.println("\nSort by Salary:");
        employees.stream()
                 .sorted((e1, e2) -> Double.compare(e1.salary, e2.salary))
                 .forEach(System.out::println);
    }
}

package session_eight_inheritance.assignment_problems;

import java.util.Scanner;
import java.util.ArrayList;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    double bonus() {
        return 0;
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends Employee {
    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("FULLTIME")) {
                employees.add(new FullTimeEmployee(name, salary));
            } else if (type.equals("PARTTIME")) {
                employees.add(new PartTimeEmployee(name, salary));
            } else if (type.equals("INTERN")) {
                employees.add(new InternEmployee(name, salary));
            }
        }

        double total = 0;
        for (Employee e : employees) {
            System.out.printf("%s: %.2f%n", e.name, e.bonus());
            total += e.bonus();
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}

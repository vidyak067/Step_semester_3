package session_nine_abstraction.assignment_problems;

import java.util.Scanner;
import java.util.ArrayList;

interface BusUser {
    double TRANSPORT_FEE = 12000;
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuition();

    double totalFee() {
        if (this instanceof BusUser) {
            return tuition() + BusUser.TRANSPORT_FEE;
        }
        return tuition();
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    double tuition() {
        return 40000;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double tuition() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    double tuition() {
        return 40000 / 2;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {
                students.add(new DayScholar(name));
            } else if (type.equals("HOSTELLER")) {
                students.add(new Hosteller(name));
            } else if (type.equals("SCHOLAR")) {
                students.add(new ScholarshipStudent(name));
            }
        }

        double total = 0;
        for (Student s : students) {
            System.out.printf("%s: %.2f%n", s.name, s.totalFee());
            total += s.totalFee();
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}

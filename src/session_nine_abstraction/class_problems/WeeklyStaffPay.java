package session_nine_abstraction.class_problems;

import java.util.Scanner;
import java.util.ArrayList;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double pay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * 1.5 * rate;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Staff> staff = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("FULLTIME")) {
                staff.add(new FullTime(name, sc.nextDouble()));
            } else if (type.equals("HOURLY")) {
                staff.add(new Hourly(name, sc.nextDouble(), sc.nextDouble()));
            } else if (type.equals("INTERN")) {
                staff.add(new Intern(name, sc.nextDouble()));
            }
        }

        double total = 0;
        for (Staff s : staff) {
            System.out.printf("%s: %.2f%n", s.name, s.pay());
            total += s.pay();
        }
        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}

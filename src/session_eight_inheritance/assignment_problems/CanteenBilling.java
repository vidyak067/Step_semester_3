package session_eight_inheritance.assignment_problems;

import java.util.Scanner;
import java.util.ArrayList;

class Customer {
    String type;
    double amount;

    Customer(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    double finalAmount() {
        return amount;
    }
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) {
        super("STUDENT", amount);
    }

    double finalAmount() {
        return amount - amount * 0.10;
    }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) {
        super("STAFF", amount);
    }

    double finalAmount() {
        return amount - amount * 0.05;
    }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) {
        super("GUEST", amount);
    }

    double finalAmount() {
        return amount + 10;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("STUDENT")) {
                bills.add(new StudentCustomer(amount));
            } else if (type.equals("STAFF")) {
                bills.add(new StaffCustomer(amount));
            } else if (type.equals("GUEST")) {
                bills.add(new GuestCustomer(amount));
            }
        }

        double total = 0;
        for (Customer c : bills) {
            System.out.printf("%s: %.2f%n", c.type, c.finalAmount());
            total += c.finalAmount();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

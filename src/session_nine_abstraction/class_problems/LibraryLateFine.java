package session_nine_abstraction.class_problems;

import java.util.Scanner;
import java.util.ArrayList;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double fine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return 2 * daysLate;
    }
}

class Dvd extends LibraryItem {
    Dvd(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return Math.min(5 * daysLate, 50);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate;
    }
}

public class LibraryLateFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            if (type.equals("BOOK")) {
                items.add(new Book(title, days));
            } else if (type.equals("DVD")) {
                items.add(new Dvd(title, days));
            } else if (type.equals("MAGAZINE")) {
                items.add(new Magazine(title, days));
            }
        }

        double total = 0;
        for (LibraryItem item : items) {
            System.out.printf("%s: %.2f%n", item.title, item.fine());
            total += item.fine();
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}

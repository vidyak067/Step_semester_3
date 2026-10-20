package session_eight_inheritance.class_problems;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    int borrowingDays() {
        return 0;
    }

    LocalDate dueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(borrowingDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int borrowingDays() {
        return 14;
    }
}

class Dvd extends LibraryItem {
    Dvd(String title) {
        super(title);
    }

    int borrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int borrowingDays() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        ArrayList<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));

            if (type.equals("BOOK")) {
                items.add(new Book(title));
            } else if (type.equals("DVD")) {
                items.add(new Dvd(title));
            } else if (type.equals("MAGAZINE")) {
                items.add(new Magazine(title));
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.dueDate());
        }
        sc.close();
    }
}

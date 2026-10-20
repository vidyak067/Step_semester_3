package session_eight_inheritance.assignment_problems;

import java.util.Scanner;
import java.util.ArrayList;

class Room {
    String type;
    double units;

    Room(String type, double units) {
        this.type = type;
        this.units = units;
    }

    double bill() {
        return 0;
    }
}

class SingleRoom extends Room {
    SingleRoom(double units) {
        super("SINGLE", units);
    }

    double bill() {
        return units * 8;
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(double units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    double bill() {
        return units * 6 / occupants;
    }
}

class AcRoom extends Room {
    AcRoom(double units) {
        super("AC", units);
    }

    double bill() {
        return units * 10 + 200;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equals("AC")) {
                rooms.add(new AcRoom(units));
            }
        }

        double total = 0;
        for (Room r : rooms) {
            System.out.printf("%s: %.2f%n", r.type, r.bill());
            total += r.bill();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

package session_nine_abstraction.class_problems;

import java.util.Scanner;
import java.util.ArrayList;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double bill();
    abstract String type();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double bill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }

    String type() {
        return "HOME";
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double bill() {
        return units * 8 + 100;
    }

    String type() {
        return "SHOP";
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double bill() {
        return Math.max(units * 6, 1000);
    }

    String type() {
        return "FACTORY";
    }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            if (type.equals("HOME")) {
                connections.add(new Home(units));
            } else if (type.equals("SHOP")) {
                connections.add(new Shop(units));
            } else if (type.equals("FACTORY")) {
                connections.add(new Factory(units));
            }
        }

        double total = 0;
        for (Connection c : connections) {
            System.out.printf("%s: %.2f%n", c.type(), c.bill());
            total += c.bill();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

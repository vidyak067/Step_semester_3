package session_eight_inheritance.assignment_problems;

import java.util.Scanner;
import java.util.ArrayList;

class Vehicle {
    String type;
    int hours;

    Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    double charge() {
        return 0;
    }
}

class Bike extends Vehicle {
    Bike(int hours) {
        super("BIKE", hours);
    }

    double charge() {
        return 10 * hours;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super("CAR", hours);
    }

    double charge() {
        return 30 + 20 * (hours - 1);
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super("TRUCK", hours);
    }

    double charge() {
        return Math.max(50 * hours, 100);
    }
}

public class CampusParkingCharge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            if (type.equals("BIKE")) {
                vehicles.add(new Bike(hours));
            } else if (type.equals("CAR")) {
                vehicles.add(new Car(hours));
            } else if (type.equals("TRUCK")) {
                vehicles.add(new Truck(hours));
            }
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            System.out.printf("%s: %.2f%n", v.type, v.charge());
            total += v.charge();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

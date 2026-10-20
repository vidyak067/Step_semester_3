package session_eight_inheritance.class_problems;

import java.util.Scanner;
import java.util.ArrayList;

class Transport {
    String type;
    double distance;

    Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    double fare() {
        return 0;
    }
}

class Bus extends Transport {
    Bus(double distance) {
        super("BUS", distance);
    }

    double fare() {
        return Math.min(2 + 0.10 * distance, 10);
    }
}

class Train extends Transport {
    Train(double distance) {
        super("TRAIN", distance);
    }

    double fare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    double peakFactor;

    Metro(double distance, double peakFactor) {
        super("METRO", distance);
        this.peakFactor = peakFactor;
    }

    double fare() {
        return (1.50 + 0.20 * distance) * peakFactor;
    }
}

public class TransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            if (type.equals("BUS")) {
                journeys.add(new Bus(distance));
            } else if (type.equals("TRAIN")) {
                journeys.add(new Train(distance));
            } else if (type.equals("METRO")) {
                double factor = sc.nextDouble();
                journeys.add(new Metro(distance, factor));
            }
        }

        double total = 0;
        for (Transport t : journeys) {
            System.out.printf("%s: %.2f%n", t.type, t.fare());
            total += t.fare();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

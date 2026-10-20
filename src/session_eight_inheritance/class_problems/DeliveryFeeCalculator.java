package session_eight_inheritance.class_problems;

import java.util.Scanner;
import java.util.ArrayList;

class Delivery {
    String type;
    double weight, distance;

    Delivery(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    double fee() {
        return 0;
    }
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    double fee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    double fee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    double customs;

    InternationalDelivery(double weight, double distance, double customs) {
        super("INTERNATIONAL", weight, distance);
        this.customs = customs;
    }

    double fee() {
        return 25 + 2.00 * weight + 0.50 * distance + customs;
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();

            if (type.equals("STANDARD")) {
                deliveries.add(new StandardDelivery(weight, distance));
            } else if (type.equals("EXPRESS")) {
                deliveries.add(new ExpressDelivery(weight, distance));
            } else if (type.equals("INTERNATIONAL")) {
                double customs = sc.nextDouble();
                deliveries.add(new InternationalDelivery(weight, distance, customs));
            }
        }

        double total = 0;
        for (Delivery d : deliveries) {
            System.out.printf("%s: %.2f%n", d.type, d.fee());
            total += d.fee();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

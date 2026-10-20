package session_nine_abstraction.assignment_problems;

import java.util.Scanner;
import java.util.ArrayList;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double charge();
    abstract String type();
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 40 + 10 * weight;
    }

    String type() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    String type() {
        return "EXPRESS";
    }

    public double insurance() {
        return value * 0.02;
    }
}

class FragileParcel extends StandardParcel implements Insurable {
    FragileParcel(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return super.charge() + 50;
    }

    String type() {
        return "FRAGILE";
    }

    public double insurance() {
        return value * 0.02;
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            if (type.equals("STANDARD")) {
                parcels.add(new StandardParcel(weight, value));
            } else if (type.equals("EXPRESS")) {
                parcels.add(new ExpressParcel(weight, value));
            } else if (type.equals("FRAGILE")) {
                parcels.add(new FragileParcel(weight, value));
            }
        }

        double grand = 0;
        for (Parcel p : parcels) {
            double insurance = 0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).insurance();
            }
            double total = p.charge() + insurance;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.type(), p.charge(), insurance, total);
            grand += total;
        }
        System.out.printf("Grand Total: %.2f%n", grand);
        sc.close();
    }
}

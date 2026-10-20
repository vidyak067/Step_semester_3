package session_nine_abstraction.assignment_problems;

import java.util.Scanner;

interface SaverMode {
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance {
    double hours;
    boolean saver;

    Appliance(double hours, boolean saver) {
        this.hours = hours;
        this.saver = saver;
    }

    abstract double power();
    abstract String name();

    double units() {
        double u = power() * hours / 1000;
        if (saver) {
            u = u * SaverMode.SAVER_FACTOR;
        }
        return u;
    }

    double cost() {
        return units() * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours, boolean saver) {
        super(hours, saver);
    }

    double power() {
        return 150;
    }

    String name() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours, boolean saver) {
        super(hours, saver);
    }

    double power() {
        return 1500;
    }

    String name() {
        return "AC";
    }
}

class Tv extends Appliance {
    Tv(double hours, boolean saver) {
        super(hours, saver);
    }

    double power() {
        return 100;
    }

    String name() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours, boolean saver) {
        super(hours, saver);
    }

    double power() {
        return 500;
    }

    String name() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] t = sc.nextLine().trim().split("\\s+");
            double hours = Double.parseDouble(t[1]);
            boolean saver = t.length > 2 && t[2].equals("SAVER");

            Appliance a = null;
            if (t[0].equals("FRIDGE")) {
                a = new Fridge(hours, saver);
            } else if (t[0].equals("AC")) {
                a = new AirConditioner(hours, saver);
            } else if (t[0].equals("TV")) {
                a = new Tv(hours, saver);
            } else if (t[0].equals("WASHER")) {
                a = new WashingMachine(hours, saver);
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(a.name() + ": saver mode not supported");
                continue;
            }
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.name(), a.units(), a.cost());
            total += a.cost();
        }
        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}

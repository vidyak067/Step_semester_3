package session_nine_abstraction.assignment_problems;

import java.util.Scanner;

interface NightService {
    double NIGHT_EXTRA = 0.20;
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();
    abstract String type();

    double fare() {
        return Math.max(km * rate(), 100);
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }

    String type() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    String type() {
        return "SEDAN";
    }
}

class SuvCab extends Cab implements NightService {
    SuvCab(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    String type() {
        return "SUV";
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab = null;
            if (type.equals("MINI")) {
                cab = new MiniCab(km);
            } else if (type.equals("SEDAN")) {
                cab = new SedanCab(km);
            } else if (type.equals("SUV")) {
                cab = new SuvCab(km);
            }

            double fare = cab.fare();
            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    fare = fare + fare * NightService.NIGHT_EXTRA;
                } else {
                    System.out.println(cab.type() + ": night service not available");
                    continue;
                }
            }
            System.out.printf("%s: %.2f%n", cab.type(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

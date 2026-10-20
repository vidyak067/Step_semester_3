package session_nine_abstraction.assignment_problems;

import java.util.Scanner;
import java.util.ArrayList;

abstract class Ticket {
    static final double FEE = 20;
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double price();
    abstract String seat();

    double amount() {
        return count * (price() + FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double price() {
        return 150;
    }

    String seat() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double price() {
        return 250;
    }

    String seat() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double price() {
        return 400;
    }

    String seat() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            if (seat.equals("REGULAR")) {
                tickets.add(new RegularTicket(count));
            } else if (seat.equals("PREMIUM")) {
                tickets.add(new PremiumTicket(count));
            } else if (seat.equals("RECLINER")) {
                tickets.add(new ReclinerTicket(count));
            }
        }

        double total = 0;
        for (Ticket t : tickets) {
            System.out.printf("%s: %.2f%n", t.seat(), t.amount());
            total += t.amount();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

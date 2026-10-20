package session_eight_inheritance.class_problems;

import java.util.Scanner;
import java.util.ArrayList;

class Payment {
    String type;
    double amount;

    Payment(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    double finalAmount() {
        return amount;
    }
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super("CARD", amount);
    }

    double finalAmount() {
        return amount + amount * 0.02;
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super("WALLET", amount);
    }

    double finalAmount() {
        return amount + amount * 0.01;
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }
}

public class PaymentFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            if (type.equals("CARD")) {
                payments.add(new CardPayment(amount));
            } else if (type.equals("WALLET")) {
                payments.add(new WalletPayment(amount));
            } else if (type.equals("BANKTRANSFER")) {
                payments.add(new BankTransferPayment(amount));
            }
        }

        double total = 0;
        for (Payment p : payments) {
            System.out.printf("%s: %.2f%n", p.type, p.finalAmount());
            total += p.finalAmount();
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

package session_eight_inheritance.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    int validityDays() {
        return 0;
    }

    LocalDate renewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 365;
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Plan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());

            if (type.equals("BASIC")) {
                plans.add(new BasicPlan(name, start));
            } else if (type.equals("STANDARD")) {
                plans.add(new StandardPlan(name, start));
            } else if (type.equals("PREMIUM")) {
                plans.add(new PremiumPlan(name, start));
            }
        }

        for (Plan p : plans) {
            System.out.println(p.name + ": " + p.renewalDate());
        }
        sc.close();
    }
}

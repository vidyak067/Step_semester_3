package session_nine_abstraction.class_problems
  import java.util.Scanner;
import java.util.ArrayList;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
    abstract String shape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    String shape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }

    String shape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }

    String shape() {
        return "TRIANGLE";
    }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            if (type.equals("CIRCLE")) {
                plots.add(new Circle(owner, sc.nextDouble()));
            } else if (type.equals("RECTANGLE")) {
                plots.add(new Rectangle(owner, sc.nextDouble(), sc.nextDouble()));
            } else if (type.equals("TRIANGLE")) {
                plots.add(new Triangle(owner, sc.nextDouble(), sc.nextDouble()));
            }
        }

        double total = 0;
        for (Plot p : plots) {
            System.out.printf("%s (%s): %.2f%n", p.owner, p.shape(), p.area());
            total += p.area();
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}

package session_eight_inheritance.class_problems;

import java.util.Scanner;
import java.util.ArrayList;

class Question {
    String type, correct, student;
    double points;

    Question(String type, String correct, String student, double points) {
        this.type = type;
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    double score() {
        return 0;
    }
}

class McqQuestion extends Question {
    McqQuestion(String correct, String student, double points) {
        super("MCQ", correct, student, points);
    }

    double score() {
        if (student.equals(correct)) {
            return points;
        }
        return 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String correct, String student, double points) {
        super("TF", correct, student, points);
    }

    double score() {
        if (student.equals(correct)) {
            return points;
        }
        return 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correct, String student, double points) {
        super("ESSAY", correct, student, points);
    }

    double score() {
        int matched = 0;
        String answer = student.toLowerCase();
        for (String keyword : correct.split(",")) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matched++;
            }
        }
        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        }
        return 0;
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        ArrayList<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\"");
            String type = parts[0].trim();
            String correct = parts[3];
            String student = parts[5];
            double points = Double.parseDouble(parts[6].trim());

            if (type.equals("MCQ")) {
                questions.add(new McqQuestion(correct, student, points));
            } else if (type.equals("TF")) {
                questions.add(new TrueFalseQuestion(correct, student, points));
            } else if (type.equals("ESSAY")) {
                questions.add(new EssayQuestion(correct, student, points));
            }
        }

        double total = 0;
        for (Question q : questions) {
            System.out.printf("%s: %.2f%n", q.type, q.score());
            total += q.score();
        }
        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}

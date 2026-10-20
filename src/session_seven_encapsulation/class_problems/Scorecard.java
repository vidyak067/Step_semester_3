package session_seven_encapsulation.class_problems;

public class Scorecard {
    private final boolean[] results;
    private int recorded;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        recorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (recorded < results.length) {
            results[recorded] = correct;
            recorded++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore());
    }
}

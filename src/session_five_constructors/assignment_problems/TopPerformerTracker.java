package session_five_constructors.assignment_problems;

public class TopPerformerTracker {
    static String findMinMaxSpread(int[] scores) {
        int min = scores[0];
        int max = scores[0];

        for (int s : scores) {
            if (s < min) {
                min = s;
            }
            if (s > max) {
                max = s;
            }
        }
        return "Min: " + min + " | Max: " + max + " | Spread: " + (max - min);
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores));
    }
}

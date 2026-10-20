package session_five_constructors.assignment_problems;

public class MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int value : row) {
            sum += value;
        }
        return sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        String result = "";
        for (int i = 0; i < runsPerOver.length; i++) {
            String label;
            if (rowAverage(runsPerOver[i]) >= threshold) {
                label = "Power Surge";
            } else {
                label = "Normal";
            }
            if (i > 0) {
                result += " | ";
            }
            result += "Match " + i + ": " + label;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
    }
}

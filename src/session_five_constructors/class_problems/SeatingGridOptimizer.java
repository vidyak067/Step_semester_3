package session_five_constructors.class_problems;

public class SeatingGridOptimizer {
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

    static String classifyRows(int[][] seatingScores, int threshold) {
        String result = "";
        for (int i = 0; i < seatingScores.length; i++) {
            String zone;
            if (rowAverage(seatingScores[i]) < threshold) {
                zone = "Quiet Zone";
            } else {
                zone = "Buzzing Zone";
            }
            if (i > 0) {
                result += " | ";
            }
            result += "Row " + i + ": " + zone;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
    }
}

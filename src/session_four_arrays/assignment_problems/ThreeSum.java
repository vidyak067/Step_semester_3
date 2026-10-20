package session_four_arrays.assignment_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    static int[][] threeSum(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < sorted.length - 2; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = sorted.length - 1;

            while (left < right) {
                int sum = sorted[i] + sorted[left] + sorted[right];

                if (sum == 0) {
                    result.add(new int[]{sorted[i], sorted[left], sorted[right]});
                    left++;
                    right--;
                    while (left < right && sorted[left] == sorted[left - 1]) {
                        left++;
                    }
                    while (left < right && sorted[right] == sorted[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeSum(new int[]{-1, 0, 1, 2, -1, -4})));
        System.out.println(Arrays.deepToString(threeSum(new int[]{0, 0, 0})));
    }
}

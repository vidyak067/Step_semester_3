package session_four_arrays.class_problems;

import java.util.Arrays;

public class RotateArray {
    static int[] rotateArray(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        k = k % nums.length;
        int[] rotated = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2}, 3)));
    }
}

package functions_and_arrays.class_problems;

import java.util.Arrays;

public class RotateArray {

    /**
     * Rotates an array of n elements to the right by k steps.
     * Uses modulo arithmetic to calculate new positions and creates a rotated array.
     *
     * @param nums Array of integers to rotate
     * @param k    Number of positions to rotate right
     * @return New array containing the rotated elements
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        k = k % n;
        if (k < 0) {
            k += n;
        }

        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }

        // Copy back into original array as per task specification
        System.arraycopy(rotated, 0, nums, 0, n);

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println("--- L5. Rotate Array ---");
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("nums: " + Arrays.toString(nums1) + ", k = " + k1);
        int[] result1 = rotateArray(nums1, k1);
        System.out.println("Rotated Output: " + Arrays.toString(result1));

        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("\nnums: " + Arrays.toString(nums2) + ", k = " + k2);
        int[] result2 = rotateArray(nums2, k2);
        System.out.println("Rotated Output: " + Arrays.toString(result2));
    }
}

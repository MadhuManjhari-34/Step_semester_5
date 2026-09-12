package functions_and_arrays.class_problems;

import java.util.Arrays;

public class ContainsDuplicate {

    /**
     * Checks if any value appears at least twice in the array using nested loops.
     *
     * @param nums Array of integers
     * @return true if duplicate exists, false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("--- L3. Contains Duplicate ---");
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("nums: " + Arrays.toString(nums1));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("\nnums: " + Arrays.toString(nums2));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums2));
    }
}

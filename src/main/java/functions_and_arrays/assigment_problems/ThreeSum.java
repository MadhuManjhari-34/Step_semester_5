package functions_and_arrays.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * Finds all unique triplets in the array that sum up to 0.
     * Uses sorting followed by a two-pointer inward scan with duplicate avoidance.
     *
     * @param nums Array of integers
     * @return 2D array of unique triplets summing to 0
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Early break if the smallest value is greater than 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicate values for second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate values for third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("--- A3. 3Sum ---");
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("nums: " + Arrays.toString(nums1));
        int[][] triplets1 = threeSum(nums1);
        System.out.println("Triplets: " + Arrays.deepToString(triplets1));

        int[] nums2 = {0, 0, 0};
        System.out.println("\nnums: " + Arrays.toString(nums2));
        int[][] triplets2 = threeSum(nums2);
        System.out.println("Triplets: " + Arrays.deepToString(triplets2));
    }
}

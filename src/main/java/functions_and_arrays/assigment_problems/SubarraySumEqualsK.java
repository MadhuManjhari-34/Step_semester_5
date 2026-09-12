package functions_and_arrays.assigment_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * Finds the total number of continuous subarrays whose sum equals k.
     * Uses prefix sums combined with a hash map of frequencies to achieve O(n) time.
     *
     * @param nums Array of integers (may contain negative numbers)
     * @param k    Target sum
     * @return Total count of subarrays whose sum is equal to k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int currentSum = 0;

        // Map stores (prefixSum -> frequency)
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();

        // Base case: prefix sum of 0 has occurred once (empty prefix before index 0)
        prefixSumFreq.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in map, it means there are subarrays ending here with sum = k
            if (prefixSumFreq.containsKey(currentSum - k)) {
                count += prefixSumFreq.get(currentSum - k);
            }

            // Record current prefix sum in the frequency map
            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("--- A4. Subarray Sum Equals K ---");
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("nums: " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Total Subarrays: " + subarraySum(nums1, k1));

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("\nnums: " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Total Subarrays: " + subarraySum(nums2, k2));
    }
}

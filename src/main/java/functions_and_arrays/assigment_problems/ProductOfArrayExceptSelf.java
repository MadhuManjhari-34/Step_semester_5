package functions_and_arrays.assigment_problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Computes an array such that answer[i] is equal to the product of all elements of nums except nums[i].
     * Solves in O(n) time using two passes (prefix and suffix products) without division.
     *
     * @param nums Array of integers
     * @return Output array containing products of all elements except self
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] answer = new int[n];

        // First pass: Calculate prefix products (product of all elements to the left)
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Second pass: Multiply by suffix products (product of all elements to the right)
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("--- A1. Product of Array Except Self ---");
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("nums: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1)));

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("\nnums: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2)));
    }
}

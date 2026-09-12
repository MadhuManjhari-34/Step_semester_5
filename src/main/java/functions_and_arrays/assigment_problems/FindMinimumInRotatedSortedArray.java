package functions_and_arrays.assigment_problems;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    /**
     * Finds the minimum element in a rotated sorted array of unique elements.
     * Solves in O(log n) time using modified binary search by comparing mid with the right boundary.
     *
     * @param nums Rotated sorted array of distinct integers
     * @return Minimum element in the array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If middle element is greater than the rightmost element,
            // the pivot and minimum element must lie strictly in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("--- A5. Find Minimum in Rotated Sorted Array ---");
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("nums: " + Arrays.toString(nums1));
        System.out.println("Minimum Element: " + findMin(nums1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("\nnums: " + Arrays.toString(nums2));
        System.out.println("Minimum Element: " + findMin(nums2));

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("\nnums: " + Arrays.toString(nums3));
        System.out.println("Minimum Element: " + findMin(nums3));
    }
}

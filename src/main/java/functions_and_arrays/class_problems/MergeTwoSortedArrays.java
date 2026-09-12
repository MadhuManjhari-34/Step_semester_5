package functions_and_arrays.class_problems;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    /**
     * Merges two sorted arrays into a single sorted array using two pointers.
     *
     * @param arr1 First sorted array
     * @param arr2 Second sorted array
     * @return Merged sorted array
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return new int[]{};
        if (arr1 == null || arr1.length == 0) return arr2 != null ? arr2.clone() : new int[]{};
        if (arr2 == null || arr2.length == 0) return arr1.clone();

        int p1 = 0;
        int p2 = 0;
        int k = 0;
        int[] result = new int[arr1.length + arr2.length];

        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] <= arr2[p2]) {
                result[k++] = arr1[p1++];
            } else {
                result[k++] = arr2[p2++];
            }
        }

        while (p1 < arr1.length) {
            result[k++] = arr1[p1++];
        }

        while (p2 < arr2.length) {
            result[k++] = arr2[p2++];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("--- L4. Merge Two Sorted Arrays ---");
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6};
        System.out.println("arr1: " + Arrays.toString(a1) + ", arr2: " + Arrays.toString(a2));
        System.out.println("Merged: " + Arrays.toString(mergeSortedArrays(a1, a2)));

        int[] b1 = {};
        int[] b2 = {1, 2, 3};
        System.out.println("\narr1: " + Arrays.toString(b1) + ", arr2: " + Arrays.toString(b2));
        System.out.println("Merged: " + Arrays.toString(mergeSortedArrays(b1, b2)));
    }
}

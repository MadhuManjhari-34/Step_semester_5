package core_java.class_problems;

public class PalindromeChecker {

    /**
     * Approach 1: Iterative check using two pointers moving toward the middle.
     */
    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive check shrinking substring each call.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Array-reversal check.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void verifyPalindrome(String text) {
        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        String iterResult = iterative ? "Palindrome" : "Not Palindrome";
        String recurResult = recursive ? "Palindrome" : "Not Palindrome";
        String arrResult = arrayReversal ? "Palindrome" : "Not Palindrome";

        System.out.printf("Input: \"%s\"%n", text);
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n%n",
                iterResult, recurResult, arrResult);
    }

    public static void main(String[] args) {
        System.out.println("--- Palindrome Checker (3 Approaches) ---");
        verifyPalindrome("madam");
        verifyPalindrome("hello");
        verifyPalindrome("racecar");
    }
}

package core_java.class_problems;

public class ReverseCustomerName {

    /**
     * Reverses the given customer name using character traversal.
     * Keeps the original name unchanged.
     *
     * @param customerName The original customer name
     * @return The reversed customer name
     */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void printVerification(String customerName) {
        String reversed = reverseCustomerName(customerName);
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Customer Identity Verification System ---");
        printVerification("Sunil");
        printVerification("Madhu");
        printVerification("Alexander");
    }
}

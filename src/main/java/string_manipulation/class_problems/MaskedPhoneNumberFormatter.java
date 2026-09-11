package string_manipulation.class_problems;

public class MaskedPhoneNumberFormatter {

    /**
     * Validates and masks a 10-digit phone number in the format XXXXXX-last4.
     *
     * @param phone Input phone number string
     * @return Formatted masked phone number, or "Invalid phone number"
     */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append(phone.substring(6));
        sb.insert(6, "-");

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Masked Phone Number Formatter ---");
        String p1 = "9876543210";
        System.out.println("Input: " + p1 + " -> " + maskPhoneNumber(p1));

        String p2 = "98765";
        System.out.println("Input: " + p2 + " -> " + maskPhoneNumber(p2));

        String p3 = "98765abcd0";
        System.out.println("Input: " + p3 + " -> " + maskPhoneNumber(p3));
    }
}

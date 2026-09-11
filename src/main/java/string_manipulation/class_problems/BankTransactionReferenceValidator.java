package string_manipulation.class_problems;

public class BankTransactionReferenceValidator {

    /**
     * Normalizes raw reference string by trimming spaces and uppercasing first 3 characters.
     *
     * @param raw Raw input reference
     * @return Normalized string
     */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return null;
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates and formats the reference string.
     *
     * @param reference Normalized reference string
     * @return Formatted display string or specific invalid reason
     */
    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void processReference(String raw) {
        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\"%nResult: %s%n%n", raw, result);
    }

    public static void main(String[] args) {
        System.out.println("--- Bank Transaction Reference Generator & Validator ---");
        processReference(" hdf03022600042 ");
        processReference("12F03022600042");
        processReference("sbi010126ABCD1");
        processReference("icici12345");
    }
}

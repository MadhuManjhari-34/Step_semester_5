package core_java.assigment_problems;

public class TypingSpeedAccuracyChecker {

    /**
     * Compares the original passage with the typed text and reports accuracy
     * along with the first mismatch position.
     *
     * @param original Original text passage
     * @param typed    User's typed passage
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input text.");
            return;
        }

        int totalChars = original.length();
        int matched = 0;
        int firstMismatchPos = -1;
        char origMismatchChar = ' ';
        char typedMismatchChar = ' ';

        int compareLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < compareLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based position
                origMismatchChar = original.charAt(i);
                typedMismatchChar = typed.charAt(i);
            }
        }

        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = compareLength + 1;
            origMismatchChar = original.length() > compareLength ? original.charAt(compareLength) : ' ';
            typedMismatchChar = typed.length() > compareLength ? typed.charAt(compareLength) : ' ';
        }

        double accuracy = totalChars > 0 ? ((double) matched / totalChars) * 100.0 : 0.0;

        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, totalChars, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, totalChars, accuracy, firstMismatchPos, origMismatchChar, typedMismatchChar);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Typing Speed Test Accuracy Checker ---");
        System.out.println("Test 1:");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\nTest 2:");
        checkTypingAccuracy("coding", "coding");
    }
}

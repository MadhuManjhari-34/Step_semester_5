package core_java.class_problems;

public class FirstNonRepeatingCharacter {

    /**
     * Finds the first non-repeating character in the given text.
     *
     * @param text The input string
     * @return The first non-repeating character, or '\0' if none exists.
     */
    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        // Frequency array covering extended ASCII
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256) {
                frequency[c]++;
            }
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 256 && frequency[c] == 1) {
                return c;
            }
        }

        return '\0';
    }

    public static void displayFirstNonRepeatingChar(String text) {
        char result = findFirstNonRepeatingChar(text);
        System.out.printf("Input: \"%s\"%n", text);
        if (result != '\0') {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--- Unique Letter Hunt Mini-Game ---");
        displayFirstNonRepeatingChar("swiss");
        displayFirstNonRepeatingChar("aabbcc");
        displayFirstNonRepeatingChar("programming");
    }
}

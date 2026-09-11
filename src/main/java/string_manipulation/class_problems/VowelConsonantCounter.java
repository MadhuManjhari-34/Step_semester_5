package string_manipulation.class_problems;

public class VowelConsonantCounter {

    /**
     * Counts vowels and consonants separately, case-insensitive, ignoring spaces.
     *
     * @param text Input string
     */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char lower = Character.toLowerCase(c);

            if (lower >= 'a' && lower <= 'z') {
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d%n", vowels, consonants);
    }

    public static void main(String[] args) {
        System.out.println("--- Vowel & Consonant Counter ---");
        String sample = "Java Programming";
        System.out.println("Input: \"" + sample + "\"");
        System.out.print("Output: ");
        countVowelsAndConsonants(sample);
    }
}

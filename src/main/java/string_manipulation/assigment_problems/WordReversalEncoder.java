package string_manipulation.assigment_problems;

public class WordReversalEncoder {

    /**
     * Reverses each word in a sentence individually while maintaining word order.
     *
     * @param sentence The input sentence with words separated by spaces
     * @return Encoded sentence with each word reversed
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            return null;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Word Reversal Encoder ---");
        String test1 = "hello club";
        System.out.println("Input: \"" + test1 + "\"");
        System.out.println("Output: " + reverseEachWord(test1));

        String test2 = "java programming language";
        System.out.println("\nInput: \"" + test2 + "\"");
        System.out.println("Output: " + reverseEachWord(test2));
    }
}

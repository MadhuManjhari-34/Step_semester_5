package string_manipulation.assigment_problems;

import java.util.*;

public class StopWordFrequencyReport {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    /**
     * Normalizes text, filters stop words, and prints remaining words sorted by frequency descending.
     *
     * @param feedback Input paragraph text
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Normalize: convert to lowercase and strip common punctuation using replace()
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "");

        String[] words = cleaned.trim().split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequencyMap.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Stop-Word-Filtered Word Frequency Report ---");
        String sample = "The mentor was great, the session was great and clear.";
        System.out.println("Feedback: \"" + sample + "\"\n");
        printFilteredWordFrequency(sample);
    }
}

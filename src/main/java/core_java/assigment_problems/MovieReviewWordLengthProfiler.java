package core_java.assigment_problems;

public class MovieReviewWordLengthProfiler {

    /**
     * Splits review into individual words and categorizes them by length:
     * - Short: 1-4 letters
     * - Medium: 5-8 letters
     * - Long: 9+ letters
     *
     * @param review Movie review text
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Strip any surrounding punctuation to get the word's letter length
            String cleaned = word.replaceAll("[^a-zA-Z0-9]", "");
            int len = cleaned.length();

            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("--- Movie Review Word Length Profiler ---");
        String sampleReview = "This movie was absolutely fantastic and thrilling";
        System.out.println("Review: \"" + sampleReview + "\"");
        classifyWordLengths(sampleReview);

        String anotherReview = "A great masterpiece with exceptional acting";
        System.out.println("\nReview: \"" + anotherReview + "\"");
        classifyWordLengths(anotherReview);
    }
}

package core_java.assigment_problems;

public class TrafficSignalStreakAnalyzer {

    /**
     * Scans signal reading sequence and finds the longest continuous streak of the same color.
     *
     * @param signalLog String of signal readings, e.g. "RRGGGYRR"
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Empty signal log.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentColor) {
                currentStreak++;
            } else {
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                currentColor = c;
                currentStreak = 1;
            }
        }

        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, maxStreak);
    }

    public static void main(String[] args) {
        System.out.println("--- Traffic Signal Streak Analyzer ---");
        System.out.println("Test 1 (\"RRGGGYRR\"):");
        findLongestStreak("RRGGGYRR");

        System.out.println("\nTest 2 (\"RRRRYYGG\"):");
        findLongestStreak("RRRRYYGG");

        System.out.println("\nTest 3 (\"YYYYYY\"):");
        findLongestStreak("YYYYYY");
    }
}

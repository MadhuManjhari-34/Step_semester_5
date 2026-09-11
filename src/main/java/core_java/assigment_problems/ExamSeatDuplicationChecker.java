package core_java.assigment_problems;

public class ExamSeatDuplicationChecker {

    /**
     * Scans the assigned seat numbers for duplicates using arrays and loops only.
     *
     * @param seatNumbers Array of seat numbers
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No Seat Numbers Provided");
            return;
        }

        boolean duplicateFound = false;
        boolean[] alreadyReported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) {
                continue;
            }

            boolean isCurrentDuplicate = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isCurrentDuplicate = true;
                    alreadyReported[j] = true;
                }
            }

            if (isCurrentDuplicate) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                duplicateFound = true;
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Exam Hall Seat Duplication Checker ---");
        int[] test1 = {101, 102, 103, 102, 105};
        System.out.println("Test Case 1 ({101, 102, 103, 102, 105}):");
        checkDuplicateSeats(test1);

        System.out.println();
        int[] test2 = {101, 102, 103, 104, 105};
        System.out.println("Test Case 2 ({101, 102, 103, 104, 105}):");
        checkDuplicateSeats(test2);
    }
}

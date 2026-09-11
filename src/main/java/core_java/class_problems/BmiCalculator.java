package core_java.class_problems;

public class BmiCalculator {

    /**
     * Classifies health status based on BMI value.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Generates and prints a formatted corporate wellness report table.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        int n = Math.min(heights.length, weights.length);

        System.out.println("========================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-12s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("========================================================================");

        for (int i = 0; i < n; i++) {
            double height = heights[i];
            double weight = weights[i];
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-10.2f | %-12s%n",
                    (i + 1), height, weight, bmi, status);
        }
        System.out.println("========================================================================");
    }

    public static void main(String[] args) {
        System.out.println("--- Corporate Wellness Program BMI Report ---");
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.78};
        double[] weights = {70.0, 90.0, 62.0, 78.0, 68.0, 42.0, 105.0, 58.0, 85.0, 73.0};

        printWellnessReport(heights, weights);
    }
}

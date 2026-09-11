package string_manipulation.class_problems;

public class CsvStudentRecordParser {

    /**
     * Splits CSV student record line and formats output if exactly 3 fields are present.
     *
     * @param csvLine CSV formatted string "Name,RollNumber,Department"
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, rollNo, dept);
    }

    public static void main(String[] args) {
        System.out.println("--- CSV Student Record Parser ---");
        System.out.println("Valid Input:");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");

        System.out.println("\nInvalid Input:");
        parseStudentRecord("Ananya Verma,CSE");
    }
}

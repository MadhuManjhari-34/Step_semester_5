package string_manipulation.class_problems;

public class FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    /**
     * Validates if a filename has an accepted extension (pdf, docx, zip) case-insensitively.
     *
     * @param filename Name of file
     * @return "Accepted" or "Rejected — invalid file type"
     */
    public static String validateFileExtension(String filename) {
        if (filename == null || filename.lastIndexOf('.') == -1) {
            return "Rejected — invalid file type";
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);

        for (String accepted : ACCEPTED_EXTENSIONS) {
            if (extension.equalsIgnoreCase(accepted)) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println("--- File Extension Validator ---");
        String file1 = "Assignment1.PDF";
        System.out.println(file1 + " -> " + validateFileExtension(file1));

        String file2 = "notes.txt";
        System.out.println(file2 + " -> " + validateFileExtension(file2));

        String file3 = "project_archive.zip";
        System.out.println(file3 + " -> " + validateFileExtension(file3));
    }
}

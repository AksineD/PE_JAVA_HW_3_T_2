import java.util.Scanner;

public class SimpleSecurity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Recursively read 6 characters, one by one.
        // Each readChar call ensures that at least 1 character is provided.
        char c1 = readChar(scanner, 1);
        char c2 = readChar(scanner, 2);
        char c3 = readChar(scanner, 3);
        char c4 = readChar(scanner, 4);
        char c5 = readChar(scanner, 5);
        char c6 = readChar(scanner, 6);

        // Prompt the user for an integer (recursively re-prompts if invalid).
        System.out.print("הכנס מספר שלם: ");
        int inputNumber = readInt(scanner);

        // Calculate the sum of the ASCII values of the 6 characters.
        // We do simple arithmetic addition instead of a loop.
        int sumAscii = c1 + c2 + c3 + c4 + c5 + c6;

        // Extract the tens and hundreds digits from the sum and reverse them.
        int reversed = getReversedDigits(sumAscii);

        // Convert the 6 characters into a single string for printing.
        String sixChars = "" + c1 + c2 + c3 + c4 + c5 + c6;

        // Compare the reversed digits with the user’s input number.
        // If they match, print a welcome message; otherwise, print an error.
        if (reversed == inputNumber) {
            System.out.println("ברוך הבא " + sixChars);
        } else {
            System.out.println("קוד שגוי");
        }

        // Close the scanner to release system resources.
        scanner.close();
    }

    /**
     * Recursively reads a single character from the user.
     * If the user inputs an empty string, it re-prompts.
     *
     * @param scanner A Scanner for reading user input.
     * @param index   Used to label each character request in Hebrew.
     * @return        The first character of the user’s input.
     */
    private static char readChar(Scanner scanner, int index) {
        System.out.print("הכנס תו מספר " + index + ": ");
        String input = scanner.nextLine();

        // If user pressed Enter without typing any character, re-prompt recursively.
        if (input.isEmpty()) {
            System.out.println("לא הוזן תו. נסה שוב.");
            return readChar(scanner, index); // recursion instead of a loop
        }

        // If the user typed more than one character, we only take the first.
        return input.charAt(0);
    }

    /**
     * Recursively reads a valid integer from the user.
     * If the input is not an integer, it discards the invalid input and re-prompts.
     *
     * @param scanner A Scanner for reading user input.
     * @return        A valid integer entered by the user.
     */
    private static int readInt(Scanner scanner) {
        // Check if the next token is an integer; if not, discard and recurse.
        if (!scanner.hasNextInt()) {
            System.out.println("נא להזין מספר שלם בלבד.");
            scanner.nextLine(); // clear invalid input
            return readInt(scanner); // recursion instead of a loop
        }

        int number = scanner.nextInt();
        scanner.nextLine(); // consume the newline after reading an integer
        return number;
    }

    /**
     * Given the sum of ASCII codes, this method extracts the tens and hundreds digits
     * and returns them in reversed order.
     * For example, if sumAscii=394 => tensDigit=9, hundredsDigit=3 => reversed=93.
     *
     * @param sumAscii The sum of ASCII values for the 6 characters.
     * @return         An integer representing the reversed tens and hundreds digits.
     */
    private static int getReversedDigits(int sumAscii) {
        // tens digit of sumAscii
        int tensDigit = (sumAscii / 10) % 10;
        // hundreds digit of sumAscii
        int hundredsDigit = (sumAscii / 100) % 10;
        // Reversed result, e.g., if tens=9 and hundreds=3 => 93
        return tensDigit * 10 + hundredsDigit;
    }
}

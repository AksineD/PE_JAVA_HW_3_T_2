import java.util.Scanner;

public class SimpleSecurity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        processAndDisplayResults(scanner);

        scanner.close();
    }

    /**
     * Recursively reads a single character from the user.
     * If the user inputs an empty string, it re-prompts.
     *
     * @param scanner A Scanner for reading user input.
     * @param index   Used to label each character request in English.
     * @return The first character of the user’s input.
     */
    private static char readChar(Scanner scanner, int index) {
        char character = '\0'; // Initialize with a default value
        boolean valid = false; // Flag to track if a valid character has been entered

        // Keep prompting the user until a valid character is entered
        while (!valid) {
            System.out.print("Enter character number " + index + ": ");
            String input = scanner.nextLine(); // Read user input

            if (!input.isEmpty()) { // Check if the input is not empty
                character = input.charAt(0); // Take the first character
                valid = true; // Valid input, exit the loop
            } else {
                System.out.println("No character entered. Please try again.");
            }
        }

        return character; // Return the valid character
    }

    /**
     * Recursively reads a valid integer from the user.
     * If the input is not an integer, it discards the invalid input and re-prompts.
     *
     * @param scanner A Scanner for reading user input.
     * @return A valid integer entered by the user.
     */
    private static int readInt(Scanner scanner) {
        int number = 0;
        boolean valid = false; // Flag to track if a valid integer has been entered

        // Keep prompting the user until a valid integer is entered
        while (!valid) {
            System.out.print("Enter an integer: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt(); // Read the integer
                scanner.nextLine(); // Consume the newline character
                valid = true; // Valid input, exit the loop
            } else {
                System.out.println("Please enter an integer only.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return number; // Return the valid integer
    }

    /**
     * Given the sum of ASCII codes, this method extracts the tens and hundreds digits
     * and returns them in reversed order.
     * For example, if sumAscii=394 => tensDigit=9, hundredsDigit=3 => reversed=93.
     *
     * @param sumAscii The sum of ASCII values for the 6 characters.
     * @return An integer representing the reversed tens and hundreds digits.
     */
    private static int getReversedDigits(int sumAscii) {
        // tens digit of sumAscii
        int tensDigit = (sumAscii / 10) % 10;
        // hundreds digit of sumAscii
        int hundredsDigit = (sumAscii / 100) % 10;
        // Reversed result, e.g., if tens=9 and hundreds=3 => 93
        return tensDigit * 10 + hundredsDigit;
    }

    /**
     * Processes the input data, calculates the required values,
     * and displays the results to the user.
     *
     * @param scanner The scanner object used for reading input.
     */
    private static void processAndDisplayResults(Scanner scanner) {
        // Recursively read 6 characters, one by one.
        // Each readChar call ensures that at least 1 character is provided.
        char c1 = readChar(scanner, 1);
        char c2 = readChar(scanner, 2);
        char c3 = readChar(scanner, 3);
        char c4 = readChar(scanner, 4);
        char c5 = readChar(scanner, 5);
        char c6 = readChar(scanner, 6);

        // Prompt the user for an integer (recursively re-prompts if invalid).
        System.out.print("Enter an integer: ");
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
            System.out.println("Welcome " + sixChars);
        } else {
            System.out.println("Invalid code");
        }
    }
}
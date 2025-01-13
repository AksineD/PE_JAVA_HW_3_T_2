import java.util.Scanner;

public class SimpleSecurity {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        // Read 6 characters (recursively if invalid)
        char c1 = readChar(scanner, 1);
        char c2 = readChar(scanner, 2);
        char c3 = readChar(scanner, 3);
        char c4 = readChar(scanner, 4);
        char c5 = readChar(scanner, 5);
        char c6 = readChar(scanner, 6);
        System.out.print("הכנס מספר שלם: ");
        int inputNumber =  readInt(scanner);

        // Sum of ASCII codes (no loops - just arithmetic)
        int sumAscii = c1 + c2 + c3 + c4 + c5 + c6;

        int reversed = getReversedDigits(sumAscii);

        // Compare and print result
        String sixChars = "" + c1 + c2 + c3 + c4 + c5 + c6;
        if (reversed == inputNumber) {
            System.out.println("ברוך הבא " + sixChars);
        } else {
            System.out.println("קוד שגוי");
        }

        scanner.close();
    }

    private static char readChar(Scanner scanner, int index) {
        System.out.print("הכנס תו מספר " + index + ": ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println("לא הוזן תו. נסה שוב.");
            return readChar(scanner, index); // recursion instead of a loop
        }
        // If the user typed more than one character, we'll just take the first
        return input.charAt(0);
    }

    private static int readInt(Scanner scanner) {
        // If we do not have an integer next, discard input and recurse
        if (!scanner.hasNextInt()) {
            System.out.println("נא להזין מספר שלם בלבד.");
            scanner.nextLine(); // clear invalid input
            return readInt(scanner); // recursion instead of a loop
        }
        int number = scanner.nextInt();
        scanner.nextLine(); // consume the newline after reading an integer
        return number;
    }
    private static int getReversedDigits(int sumAscii) {
        int tensDigit = (sumAscii / 10) % 10;
        int hundredsDigit = (sumAscii / 100) % 10;
        return tensDigit * 10 + hundredsDigit;
    }
}

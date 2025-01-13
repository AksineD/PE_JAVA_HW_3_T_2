import java.util.Scanner;

public class SimpleSecurity {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        // Read 6 characters (recursively if invalid)
        char c1 = scanner.nextLine().charAt(0);
        char c2 = scanner.nextLine().charAt(0);
        char c3 = scanner.nextLine().charAt(0);
        char c4 = scanner.nextLine().charAt(0);
        char c5 = scanner.nextLine().charAt(0);
        char c6 = scanner.nextLine().charAt(0);
        System.out.print("הכנס מספר שלם: ");
        int inputNumber =  scanner.nextInt();

        // Sum of ASCII codes (no loops - just arithmetic)
        int sumAscii = c1 + c2 + c3 + c4 + c5 + c6;

        // Extract tens & hundreds digits
        int tensDigit = (sumAscii / 10) % 10;
        int hundredsDigit = (sumAscii / 100) % 10;
        int reversed = tensDigit * 10 + hundredsDigit;

        // Compare and print result
        String sixChars = "" + c1 + c2 + c3 + c4 + c5 + c6;
        if (reversed == inputNumber) {
            System.out.println("ברוך הבא " + sixChars);
        } else {
            System.out.println("קוד שגוי");
        }

        scanner.close();
    }
}

import java.util.Scanner;

public class LeapYearChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input year from the user
        int year = getValidIntInput(scanner);

        // Check if the year is a leap year
        boolean isLeapYear = checkLeapYear(year);

        // Display the result
        if (isLeapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        scanner.close();
    }

    // Helper method to get a valid integer input from the user
    private static int getValidIntInput(Scanner scanner) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a year: ");
            try {
                value = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return value;
    }

    // Method to check if a year is a leap year
    private static boolean checkLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}

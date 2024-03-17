import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculationProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu options to the user
        System.out.println("Select an option:");
        System.out.println("1. Calculate the sum of two whole numbers");
        System.out.println("2. Convert user input and round to two decimal points");
        System.out.println("3. Perform calculations on five user input values");

        // Get user's choice from the menu
        int choice = getValidIntInput(scanner, "Enter your choice from the options above: ");

        // Use a switch statement to execute the appropriate method based on user's choice
        switch (choice) {
            case 1:
                calculateSum(scanner);
                break;
            case 2:
                convertInput(scanner);
                break;
            case 3:
                performCalculations(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }

        // Close the scanner to release resources
        scanner.close();
    }

    // Helper method to get a valid integer input from the user
    private static int getValidIntInput(Scanner scanner, String prompt) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }

        return value;
    }

    // Helper method to get a valid double input from the user
    private static double getValidDoubleInput(Scanner scanner, String prompt) {
        double value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }

        return value;
    }

    // Option 1: Calculate the sum of two whole numbers
    private static void calculateSum(Scanner scanner) {
        // Prompt the user to enter the first whole number
        int num1 = getValidIntInput(scanner, "Enter the first whole number: ");

        // Prompt the user to enter the second whole number
        int num2 = getValidIntInput(scanner, "Enter the second whole number: ");

        // Calculate the sum of the two whole numbers
        int sum = num1 + num2;

        // Display the sum of the two whole numbers
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
    }

    // Option 2: Convert user input and round to two decimal points
    private static void convertInput(Scanner scanner) {
        // Prompt the user to enter a value
        double value = getValidDoubleInput(scanner, "Enter a value: ");

        // Round the value to two decimal points using Math.round()
        double roundedValue = Math.round(value * 100.0) / 100.0;

        // Display the rounded value
        System.out.println("The Rounded value of " + value + " is: " + roundedValue);
    }

    // Option 3: Perform calculations on five user input values
    private static void performCalculations(Scanner scanner) {
        // Create an array to store the five user input values
        double[] values = new double[5];

        // Prompt the user to enter five values
        System.out.println("Enter five values:");
        for (int i = 0; i < 5; i++) {
            values[i] = getValidDoubleInput(scanner, "Value " + (i + 1) + ": ");
        }

        // Initialize variables for sum, minimum, and maximum
        double sum = 0;
        double min = values[0];
        double max = values[0];

        // Calculate the sum, minimum, and maximum of the values
        for (double value : values) {
            sum += value;
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        // Calculate the average of the values
        double average = sum / values.length;

        // Calculate the square root of the maximum value
        double squareRoot = Math.sqrt(max);

        // Display the calculated results
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Square root of maximum: " + squareRoot);
    }
}
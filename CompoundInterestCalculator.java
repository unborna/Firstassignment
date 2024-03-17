import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input principal amount
        double principal = getValidDoubleInput(scanner, "Enter the principal amount: ", Double.MAX_VALUE);

        // Input annual interest rate
        double annualInterestRate = getValidDoubleInput(scanner, "Enter the annual interest rate (%): ", 100);

        // Input compounding frequency
        int compoundingFrequency = getValidIntInput(scanner, "Enter the compounding frequency per year (e.g: 1 for annually, 2 for semi-annually, 4 for quarterly, 12 for monthly, etc.): ", 12);

        // Input time period
        int timePeriod = getValidIntInput(scanner, "Enter the time period (Number of period): ", Integer.MAX_VALUE);

        // Input time unit
        String timeUnit = getValidTimeUnit(scanner);

        // Calculate the actual time period based on the time unit
        double actualTimePeriod = calculateActualTimePeriod(timePeriod, timeUnit, compoundingFrequency);

        // Calculate compound interest
        double amount = calculateCompoundInterest(principal, annualInterestRate, compoundingFrequency, actualTimePeriod);

        // Display the result
        System.out.printf("Compound Interest: £%.2f%n", amount - principal);
        System.out.printf("Final Amount: £%.2f%n", amount);

        scanner.close();
    }

    // Helper method to get a valid double input from the user
    private static double getValidDoubleInput(Scanner scanner, String prompt, double max) {
        double value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value < (double) 0 || value > max) {
                    System.out.printf("Invalid input. Please enter a value between %.2f and %.2f.%n", (double) 0, max);
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return value;
    }

    // Helper method to get a valid integer input from the user
    private static int getValidIntInput(Scanner scanner, String prompt, int max) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value < 1 || value > max) {
                    System.out.printf("Invalid input. Please enter a value between %d and %d.%n", 1, max);
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return value;
    }

    // Helper method to get a valid time unit from the user
    private static String getValidTimeUnit(Scanner scanner) {
        String timeUnit = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the time unit (years, months, or days): ");
            timeUnit = scanner.nextLine().toLowerCase();

            if (timeUnit.equals("years") || timeUnit.equals("months") || timeUnit.equals("days")) {
                validInput = true;
            } else {
                System.out.println("Invalid time unit. Please enter 'years', 'months', or 'days'.");
            }
        }

        return timeUnit;
    }

    // Method to calculate the actual time period based on the time unit
    private static double calculateActualTimePeriod(int timePeriod, String timeUnit, int compoundingFrequency) {
        double actualTimePeriod;

        if (timeUnit.equals("years")) {
            actualTimePeriod = timePeriod;
        } else if (timeUnit.equals("months")) {
            actualTimePeriod = (double) timePeriod / 12;
        } else {
            actualTimePeriod = (double) timePeriod / (compoundingFrequency * 365);
        }

        return actualTimePeriod;
    }

    // Method to calculate compound interest
    private static double calculateCompoundInterest(double principal, double annualInterestRate,
                                                    int compoundingFrequency, double timePeriod) {
        double interestRate = annualInterestRate / 100;
        return principal * Math.pow((1 + (interestRate / compoundingFrequency)),
                (compoundingFrequency * timePeriod));
    }
}
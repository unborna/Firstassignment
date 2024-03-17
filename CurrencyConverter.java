import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    // HashMap to store exchange rates with USD as the base currency
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    // HashMap to store the full names of the currencies
    private static final Map<String, String> currencyNames = new HashMap<>();

    public static void main(String[] args) {
        // Initialize exchange rates and currency names for 10 different currencies
        exchangeRates.put("USD", 1.0);
        currencyNames.put("USD", "United States Dollar");
        exchangeRates.put("EUR", 0.85);
        currencyNames.put("EUR", "Euro");
        exchangeRates.put("GBP", 0.72);
        currencyNames.put("GBP", "British Pound Sterling");
        exchangeRates.put("JPY", 110.0);
        currencyNames.put("JPY", "Japanese Yen");
        exchangeRates.put("CAD", 1.25);
        currencyNames.put("CAD", "Canadian Dollar");
        exchangeRates.put("AUD", 1.35);
        currencyNames.put("AUD", "Australian Dollar");
        exchangeRates.put("CHF", 0.91);
        currencyNames.put("CHF", "Swiss Franc");
        exchangeRates.put("CNY", 6.50);
        currencyNames.put("CNY", "Chinese Yuan");
        exchangeRates.put("HKD", 7.85);
        currencyNames.put("HKD", "Hong Kong Dollar");
        exchangeRates.put("SGD", 1.33);
        currencyNames.put("SGD", "Singapore Dollar");

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Display welcome message
        System.out.println("Welcome to the Currency Converter!");

        // Flag to control the conversion loop
        boolean continueConverting = true;

        while (continueConverting) {
            // Display available currencies with their full names
            System.out.println("List of available currencies:");
            for (String currency : exchangeRates.keySet()) {
                System.out.println("- " + currency + " (" + currencyNames.get(currency) + ")");
            }

            // Prompt user for source currency
            String sourceCurrency = getValidCurrencyInput(scanner, "Enter the source currency: ");

            // Prompt user for input amount in the source currency
            double amount = getValidDoubleInput(scanner, "Enter the amount to convert in " + sourceCurrency + ": ");

            // Prompt user for target currency
            String targetCurrency = getValidCurrencyInput(scanner, "Enter the target currency: ");

            // Perform currency conversion
            double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

            // Display the converted amount
            System.out.printf("%.2f in %s (%s) is equal to %.2f in %s (%s)%n",
                    amount, sourceCurrency, currencyNames.get(sourceCurrency),
                    convertedAmount, targetCurrency, currencyNames.get(targetCurrency));

            // Ask user if they want to perform another conversion
            System.out.print("Do you want to perform another conversion? (Y/N): ");
            String choice = scanner.nextLine().toUpperCase();

            // Check user's choice and set the flag accordingly
            if (!choice.equals("Y")) {
                continueConverting = false;
            }
        }

        // Display exit message
        System.out.println("Thank you for using the Currency Converter. Goodbye!");

        // Close the Scanner object
        scanner.close();
    }

    // Helper method to get a valid double input from the user
    private static double getValidDoubleInput(Scanner scanner, String prompt) {
        double value = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            try {
                // Parse user input as a double
                value = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                // Display error message for invalid input
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return value;
    }

    // Helper method to get a valid currency input from the user
    private static String getValidCurrencyInput(Scanner scanner, String prompt) {
        String currency = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            currency = scanner.nextLine().toUpperCase();

            // Check if the entered currency is valid
            if (exchangeRates.containsKey(currency)) {
                validInput = true;
            } else {
                // Display error message for invalid currency
                System.out.println("Invalid currency. Please enter a valid currency.");
            }
        }

        return currency;
    }

    // Method to perform currency conversion
    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        // Convert the amount from the source currency to USD
        double usdAmount = amount / exchangeRates.get(sourceCurrency);
        // Convert the USD amount to the target currency
        return usdAmount * exchangeRates.get(targetCurrency);
    }
}
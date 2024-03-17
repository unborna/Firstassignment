import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class WelcomeMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Read the user's name from input

        String gender = "";
        while (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
            System.out.print("Enter your gender (male/female): ");
            gender = scanner.nextLine(); // Read the user's gender from input
            if (gender.equalsIgnoreCase("m")) {
                gender = "male"; // Convert "m" to "male"
            }
        }

        LocalDate dob = null;
        while (dob == null) {
            System.out.print("Enter your date of birth (YYYY-MM-DD): ");
            String dobString = scanner.nextLine(); // Read the user's date of birth from input
            try {
                dob = LocalDate.parse(dobString); // Parse the date of birth string into a LocalDate object
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again using the YYYY-MM-DD format.");
            }
        }

        LocalDate currentDate = LocalDate.now(); // Get the current date
        int age = Period.between(dob, currentDate).getYears(); // Calculate the user's age

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy"); // Define the date formatting pattern
        String formattedDate = currentDate.format(formatter); // Format the current date as a string

        String pronoun = "";
        if (gender.equalsIgnoreCase("male")) {
            pronoun = "You are a male"; // Set the pronoun based on the user's gender
        } else if (gender.equalsIgnoreCase("female")) {
            pronoun = "You are a female"; // Set the pronoun based on the user's gender
        }

        System.out.println("Welcome " + name + "!  " + pronoun + ", you are " + age + " years old, and today's date is " + formattedDate + ". Have a nice day!"); // Display the welcome message with the user's information
    }
}
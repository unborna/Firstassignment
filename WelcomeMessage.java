import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class WelcomeMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        LocalDate dob = null;
        while (dob == null) {
            System.out.print("Enter your date of birth (YYYY-MM-DD): ");
            String dobString = scanner.nextLine();
            try {
                dob = LocalDate.parse(dobString);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please try again using the YYYY-MM-DD format.");
            }
        }

        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dob, currentDate).getYears();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy");
        String formattedDate = currentDate.format(formatter);

        System.out.println("Welcome " + name + "!, you are " + age + " years old and today's date is " + formattedDate + ". Have a nice day!");
    }
}

// Import the Scanner class from the Java 'utils' library.
// This is like telling the program, "Go get the Scanner tool for us."
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {

        // Create a Scanner object to read input from the keyboard.
        // System ' System.in' means "standard input", which is the keyboard.
        Scanner scanner = new Scanner(System.in);

        // This is our main program loop. It will keep showing the menu until we break out.
        while (true) {
            // Print the menu options for the user.
            System.out.println("\n---Library Kiosk Menu---");
            System.out.println("1. Add a new book:");
            System.out.println("2. Exit");
            System.out.println("Please choose an option (1 or 2): ");

            // Read the User's choice as a number (integer).
            int choice = scanner.nextInt();
            scanner.nextLine();
            // This 'consumes' the leftover Enter press after the number.
            // If we don't do this, it causes a problem on the next input.

            // Check what the user chose.
            if (choice == 1) {
                // *** Option 1, Add a Book ***
                System.out.println("\nLet's add a new book!");

                // Prompt the user for each piece of info and read their input.
                System.out.println("Enter book title: ");
                String title = scanner.nextLine(); //Reads a whole line of text.

                System.out.println("Enter book author: ");
                String author = scanner.nextLine();

                System.out.println("Enter book ISBN: ");
                String isbn = scanner.nextLine();

                // Now, use the input to create a new Book OBJECT.
                Book newBook = new Book(title, author, isbn);

                // Print out the new book to confirm it worked.
                System.out.println("Successfully added: " + newBook);

            } else if (choice == 2) {

                // *** Option 2, Exit ***
                System.out.println("Thanks for using the Library Kiosk. Goodbye!");
                break; // The 'break' keyword exist the while loop, ending the program.

            } else {

                // *** Handle invalid Input ***
                System.out.println("Invalid Choice. Please try again.");
            }
        }
        // Close the scanner to avoid resource leaks (good practice).
        scanner.close();
    }
}
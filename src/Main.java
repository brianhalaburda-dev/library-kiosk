import java.util.ArrayList; // Import the Array List class from the Java 'utils' library.
import java.util.Scanner; // Import the Scanner class from the Java 'utils' library.

public class Main {
    public static void main(String[]args) {
       Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input from the keyboard. System ' System.in' means "standard input", which is the keyboard.

        // 1. Create the list.
        ArrayList<Book> bookList = new ArrayList<>(); // This creates an empty ArrayList that can only hold Book objects. It's created outside the while loops so it persists (isn't reset every loop).

        while(true) {
            System.out.println("\n---Library Kiosk Menu---");
            System.out.println("1. Add a new book");
            System.out.println("2. List all books"); // The new option.
            System.out.println("3. Exit");
            System.out.println("Please choose an option: (1, 2 or 3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1){
                // Option 1. Add a book.
                System.out.println("\nAdd a new book.");

                System.out.println("Enter book title: ");
                String title = scanner.nextLine();
                System.out.println("Enter book author: ");
                String author = scanner.nextLine();
                System.out.println("Enter ISBN: ");
                String isbn = scanner.nextLine();

                Book newBook = new Book(title, author, isbn); // Puts data inside new Book Object.
                bookList.add(newBook); // The 'add' method puts the object into the ArrayList.

                System.out.println("Successfully added: " + newBook);

            } else if (choice == 2){
               // Option 2. List all books.
                System.out.println("\nListing all books.\n");

                if (bookList.isEmpty()) {
                    System.out.println("The library is empty. No books found.");
                } else {
                    for (Book tempBook : bookList) {
                        System.out.println(" - " + tempBook);
                    }
                }

            } else if (choice == 3){
                // Option 3. Exit.
                System.out.println("Thanks for using Library Kiosk. Goodbye.");
                break;

            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}
import java.util.Scanner; // Import the Scanner class from the Java 'utils' library.

public class Main {
    public static void main(String[]args) {
        LibraryService libraryService = AppConfig.getLibraryService();
        // Set up the scanner for user input.
        Scanner scanner = new Scanner(System.in);

        // The main program loop remains largely the same, but now it's much simpler.
        // *** MAIN MENU ***
        while (true) {
            System.out.println("\n---Library Kiosk Menu---");
            System.out.println("0. Exit.");
            System.out.println("\nBook Management:");
            System.out.println("1. Add a new book.");
            System.out.println("2. List all books.");
            System.out.println("3. Delete a book by its ISBN.");
            System.out.println("\nMember Management:");
            System.out.println("4. Register a new member.");
            System.out.println("5. View all registered members.");
            System.out.println("6. Delete a member.");

            System.out.println("\nPlease choose an option (0, 1, 2, 3, 4, 5, or 6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline.

         if (choice==0) { // Exit
             System.out.println("Thank you for using Library Kiosk. Goodbye!");
             break;

         } else if (choice == 1) {
                // Get input and Delegate.
                System.out.println("\nAdd a new book.");
                System.out.println("Enter Book title: ");
                String title = scanner.nextLine();
                System.out.println("Enter book author: ");
                String author = scanner.nextLine();
                System.out.println("Enter book ISBN: ");
                String isbn = scanner.nextLine();

                // All the logic is inside the service. Just call the method.
                libraryService.addNewBook(title, author, isbn);

            } else if (choice == 2) {
                // List all books.
                // Delegate.
                libraryService.listAllBooks();

            } else if (choice==3) {
                /*
                 Delete Book by ISBN.
                 Delegate.
                */
                System.out.println("Enter the ISBN of the book to delete: ");
                String isbn = scanner.nextLine();
                libraryService.deleteBookByIsbn(isbn);

            } else if (choice==4) {
                // Add member.
                System.out.println("\nRegister a new member.");
                System.out.println("Enter Member ID: ");
                String id = scanner.nextLine();
                System.out.println("Enter member name: ");
                String name = scanner.nextLine();
                libraryService.addNewMember(id, name);

            } else if (choice==5) {
                // List members.
                // Delegate.
                libraryService.listAllMembers();
            } else if (choice==6) {
                // Delete member.
                System.out.println("Enter the ID of the member to delete: ");
                String id = scanner.nextLine();
                libraryService.deleteMemberById(id);

            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}
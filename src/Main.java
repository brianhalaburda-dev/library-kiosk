import java.util.Scanner; // Import the Scanner class from the Java 'utils' library.

public class Main {
    public static void main(String[]args) {

        // 1. Choose our "Black Box" Implementation. We are specifically choosing the ArrayList version for now. This is the only place in the code where we mention Book_Repository_ArrayList.
        Book_Repository myChosenRepository = new Book_Repository_ArrayList();

        // 2. Create the service and give it the chosen repository.
        Library_Service libraryService = new Library_Service(myChosenRepository);

        // 3. Setup the scanner for user input.
        Scanner scanner = new Scanner(System.in);

        // The main program loop remains largely the same, but now it's much simpler.
        while (true) {

            System.out.println("\n---Library Kiosk Menu---");
            System.out.println("1. Add a new book.");
            System.out.println("2. List all books.");
            System.out.println("3. Exit.");
            System.out.println("\nPlease choose an option (1, 2, or 3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the leftover newline.

            if (choice == 1) {
                // Get input and Delegate.
                System.out.println("\nLets add a new book.");

                System.out.println("Enter Book title: ");
                String title = scanner.nextLine();
                System.out.println("Enter book author: ");
                String author = scanner.nextLine();
                System.out.println("Enter book ISBN: ");
                String isbn = scanner.nextLine();

                // All the logic is inside the service. Just call the method.
                libraryService.addNewBook(title, author, isbn);

            } else if (choice == 2) {
                // Delegate.
                libraryService.listAllBooks();

            } else if (choice==3) {
                System.out.println("Thank you for using Library Kiosk. Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}
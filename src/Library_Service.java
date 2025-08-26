import java.util.List;

public class Library_Service {

    // This is the Key: The service depends on the Interface, not the specific class. We are holding a reference to the "Contract"
    private final Book_Repository bookRepository;

    // The constructor. This is how we "inject" the specific implementation we want to use. This is called Dependency Injection, and is a core concept for modular design.
    public Library_Service(Book_Repository bookRepository) {

        // We are given a Book_Repository. It could be Book_Repository_ArrayList or Book_Repository_SQL. The service doesn't know or care.
        this.bookRepository = bookRepository;
    }

    // A business logic method to add a new book. It takes the raw data, creates a Book object, and tells the repository to save it.
    public void addNewBook(String title, String author, String isbn) {

        // We could add business rules here later (like e.g., "validate the ISBN format")
        Book newBook = new Book(title, author, isbn);
        bookRepository.save(newBook); // Delegate the storage task to the "Black Box"
        System.out.println("Succesfully added: " + newBook);
    }

    // A business method to list all books.
    public void listAllBooks() {

        // Ask the repository for all books.
        List<Book> allBooks = bookRepository.findAll();

        // Handle the presentation logic (printing to console).
        if (allBooks.isEmpty()) {

            System.out.println("The Library is empty, no books found.");

        } else {

            System.out.println("\n ---Listing All Books---");
            for (Book book : allBooks) {
                System.out.println(" - " + book);
            }
        }
    }
// (We will add a find method later.)
}

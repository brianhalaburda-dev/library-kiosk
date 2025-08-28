import java.util.List;

public class BookManagerService {

    // This is the Key: The service depends on the Interface, not the specific class. We are holding a reference to the "Contract"
    private final BookRepository bookRepository;

    // The constructor. This is how we "inject" the specific implementation we want to use. This is called Dependency Injection, and is a core concept for modular design.
    public BookManagerService(BookRepository bookRepository) {

        // We are given a BookRepository. It could be BookRepository_ArrayList or BookRepository_XSQL. The service doesn't know or care.
        this.bookRepository = bookRepository;
    }

    // ***BOOK MANAGEMENT***
    public void addNewBook(String title, String author, String isbn) {
        // A business logic method to add a new book. It takes the raw data, creates a Book object, and tells the repository to save it.
        // We could add business rules here later (like e.g., "validate the ISBN format")
        Book newBook = new Book(title, author, isbn);
        bookRepository.save(newBook); // Delegate the storage task to the "Black Box"
        System.out.println("Successfully added: " + newBook);
    }

    public void listAllBooks() {
        // A business method to list all books.
        // Ask the repository for all books.
        List<Book> allBooks = bookRepository.findAll();

        // Handle the presentation logic (printing to console).
        if (allBooks.isEmpty()) {
            System.out.println("The Library is empty, no books found.");

        } else {
            System.out.println("\n---Listing All Books---");
            for (Book book : allBooks) {
                System.out.println(" - " + book);
            }
        }
    }

    // (We will add a find method later.)

    public void deleteBookByIsbn(String isbn) {
        // A method for deleting books by ISBN.
        boolean bookWasDeleted = bookRepository.deleteByIsbn(isbn);
        if (bookWasDeleted) {
            System.out.println("Book with ISBN " + isbn + " was deleted.");

        } else {
            System.out.println("No book found with ISBN " + isbn + ". Nothing deleted.");
        }
    }
}
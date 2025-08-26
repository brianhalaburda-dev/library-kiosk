import java.util.ArrayList;
import java.util.List;

public class Book_Repository_ArrayList implements Book_Repository { // This class implements the Book_Repository contract. IntelliJ will show an error if we don't fulfill the promise.
    private final List<Book> bookDatabase = new ArrayList<>(); // This will be the "Fake" database, same ArrayList that we had in Main.

    @Override // This annotation says: I'm implementing the method from the interface.
    public void save(Book book) {
        bookDatabase.add(Book); // This implementation is simple, just add to the list.
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookDatabase); // Return a copy of the list to prevent outside code from modifying our internal list.
    }

    @Override
    public Book findByIsbn(String isbn) {
        for (Book book : bookDatabase) { // Loop through all books to find one with a matching ISBN.
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // Return null if no book was found.
    }
}

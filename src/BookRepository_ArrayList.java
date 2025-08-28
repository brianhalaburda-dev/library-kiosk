import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// The name clearly communicates it's purpose.
public class BookRepository_ArrayList implements BookRepository {
    // This class implements the Book_Repository contract. IntelliJ will show an error if we don't fulfill the promise.
    private final List<Book> bookDatabase = new ArrayList<>();
    // This will be the "Fake" database, same ArrayList that we had in Main.

    @Override // This annotation says: I'm implementing the method from the interface.
    public void save(Book book) {
        bookDatabase.add(book); // This implementation is simple, just add to the list.
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

    @Override
    public boolean deleteByIsbn(String isbn) {

        // Use Iterator to avoid ConcurrentModificationException
        Iterator<Book> iterator = bookDatabase.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

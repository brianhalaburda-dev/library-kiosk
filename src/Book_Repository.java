import java.util.List; // Imports List Class
public interface Book_Repository {
    void save(Book book); // Promise to save a book, void means it doesn't return anything.
    List<Book> findAll(); // Promise to find All books, and return them in a list.
    Book findByIsbn(String isbn); // Promise to find just one book by it's ISBN, or return null if not found.
}

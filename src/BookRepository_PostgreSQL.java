/* This implementation requires a PostgresSQL database created as follows.

-- 1. Connect to your PostgresSQL server and create a database for the library
        CREATE DATABASE library_kiosk;

        -- 2. Connect to the new database
        \c library_kiosk

        -- 3. Create a table to store our books
        CREATE TABLE books (
        id SERIAL PRIMARY KEY,         -- An auto-incrementing unique ID
        title VARCHAR(255) NOT NULL,   -- Book title, max 255 characters
        author VARCHAR(255) NOT NULL,  -- Author name
        isbn VARCHAR(20) UNIQUE        -- ISBN code, must be unique
        );
 */


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository_PostgreSQL implements BookRepository {

    // Database connection details - These would eventually come from a config file.
    private final String url = "jdbc:postgresql://localhost:5432/library_kiosk";
    private final String user = "mac";
    private final String password = "qwert";

    // Helper method to get a connection to the database.
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void save(Book book) {

        // The SQL command to insert a new book. The '?' are placeholders for parameters.
        String sql = "INSERT INTO books (title, author, isbn) VALUES (?, ?, ?)";

        // 'try-with-resources' automatically closes the Connection and PreparedStatement
        // when the 'try' block is finished, even if an error occurs.
        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the values for the placeholders. Replaces the placeholders ('?').
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getIsbn());

            // Execute the SQL command.
            pstmt.executeUpdate();
            System.out.println("Book saved to database.");

        } catch (SQLException e) {
            // If something goes wrong, print the error.
            System.out.println("Error saving book: " + e.getMessage());
        }
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

            // Loop through each row in the result set.
            while (rs.next()) {

                // For each row, create a new Book object from the data.
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching books> " + e.getMessage());
        }
        return books;
    }
    @Override
    public Book findByIsbn(String isbn) {
        String sql = "SELECT * FROM books WHERE isbn = ?";
        Book book = null;

        try (Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("isbn")
                );
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error finding book by ISBN: " + e.getMessage());
        }
        return book;
    }
}

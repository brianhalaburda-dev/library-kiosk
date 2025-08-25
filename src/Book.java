public class Book {
    //These are the properties (attributes) of a Book.
    // 'private' means nothing outside this class can access them directly.
    private String title;
    private String author;
    private String isbn;

    //This is a constructor. A special method used to create a new Book object.
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // These are Getter methods. They provide public access to read the private properties.
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getIsbn(){
        return isbn;
    }

    // This method returns a readable representation of the Book object.
    // It's automatically called when you print an object, e.g., System.out.println(book);
    @Override
    public String toString() {
        return "Book: " + title + " by " + author + " (ISBN: " + isbn + ")";
    }
}

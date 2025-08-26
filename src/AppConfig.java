public class AppConfig {
    // This is the single, central place where we decide which implementation to use.
    public static BookRepository getBookRepository() {
        // For now, we chose the ArrayList implementation.
        return new BookRepository_ArrayList();
    }

    // We also create the service here, already injected with the chosen repository.
    public static LibraryService getLibraryService() {
        BookRepository repository = getBookRepository();
        return new LibraryService(repository);
    }
}

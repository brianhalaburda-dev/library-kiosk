public class AppConfig {
    // This is the single, central place where we decide which implementation to use.
    public static BookRepository getBookRepository() {
        // For now, we chose the ArrayList implementation.
        return new BookRepository_PostgreSQL();
    }

    public static MemberRepository getMemberRepository() {
        return new MemberRepository_ArrayList();
    }

    // We also create the service here, already injected with the chosen repository.
    public static LibraryService getLibraryService() {
        BookRepository bookRepository = getBookRepository();
        MemberRepository memberRepository = getMemberRepository();
        return new LibraryService(bookRepository, memberRepository);


    }

}

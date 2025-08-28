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
    public static BookManagerService getBookManagerService() {
        BookRepository bookRepository = getBookRepository();
        return new BookManagerService(bookRepository);
    }

    // We also create the service here, already injected with the chosen repository.
    public static MemberManagerService getMemberManagerService() {
        MemberRepository memberRepository = getMemberRepository();
        return new MemberManagerService(memberRepository);

    }

}

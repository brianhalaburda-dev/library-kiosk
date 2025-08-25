
public class Main {
    public static void main(String[]args) {
        System.out.println("Library System Booted Up:");

        // This is the magic line. We are creating an OBJECT from the CLASS.
        // 'new' is the keyword that actually builds the object in the computer's memory.
        // We are passing the title, author, and ISBN to the Book's Constructor.
        Book myFirstBook = new Book(
                "The Hitchhiker's Guide to the Galaxy",
                "Douglas Adamas",
                "9780345391803");

        // Now let's print it. The 'toString()' method we wrote will be called automatically.
        System.out.println("Created: " + myFirstBook);

        // Let's use the getter method to get just the title.
        System.out.println("Just the title: " + myFirstBook.getTitle());
    }
}
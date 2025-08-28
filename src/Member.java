public class Member {
    private final String id; // Unique member ID (e.g., M001).
    private final String name;
    // Later, we can add a List<Book> borrowedBooks here.

    // The constructor (Special method for creating objects).
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter methods. (Provide public access to the Object private properties).
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // toString method. (Returns a readable representation of the Object when called using System.out.println).
    @Override
    public String toString() {
        return "Member (ID: " + id + ") " + name + "." ;
    }
}

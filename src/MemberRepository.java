import java.util.List; // Import List class.

public interface MemberRepository {
    void save(Member member); // Promise to save members, doesn't return anything .
    List<Member> findAll(); // Promise to show members in a List,
    Member findById(String id); // Promise to find a member by ID, returns null on unsuccessful attempt.
    boolean deleteMemberById(String id); // Returns true if a Member was actually deleted.
}

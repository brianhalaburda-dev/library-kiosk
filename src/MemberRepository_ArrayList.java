// Import Classes
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemberRepository_ArrayList implements MemberRepository {
    private final List<Member> memberDatabase = new ArrayList<>();

    @Override // Save a new member.
    public void save(Member member) {
        memberDatabase.add(member); // Adds member to the ArrayList.
    }

    @Override // Show all the registered members.
    public List<Member> findAll() {
        return new ArrayList<>(memberDatabase); // Returns a copy of the original ArrayList, to not compromise the original.
    }

    @Override // Find member by ID number.
    public Member findById(String id) {
        for (Member member : memberDatabase) { // Loop through all members on the ArrayList.
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null; // Return null if no member was found.
    }

    @Override
    public boolean deleteMemberById(String id) {
        Iterator<Member> iterator = memberDatabase.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}

import java.util.List;

public class MemberManagerService {

    // This is the Key: The service depends on the Interface, not the specific class. We are holding a reference to the "Contract"
    private final MemberRepository memberRepository;

    // The constructor. This is how we "inject" the specific implementation we want to use. This is called Dependency Injection, and is a core concept for modular design.
    public MemberManagerService(MemberRepository memberRepository) {

        // We are given a MemberRepository. It could be MemberRepository_ArrayList or BookRepository_XSQL. The service doesn't know or care.
        this.memberRepository = memberRepository;
    }

    //***MEMBER MANAGEMENT***
    public void addNewMember(String id, String name) {
        // Logic to add a new member.
        Member newMember = new Member(id, name);
        memberRepository.save(newMember); // Delegate storage.
        System.out.println("Succesfully added: " + newMember);
    }

    public void listAllMembers() {
        // Method to list all members.
        List<Member> allMembers = memberRepository.findAll();

        // Presentation logic.
        if (allMembers.isEmpty()) {
            System.out.println("No registered members found.");
        } else {
            System.out.println("\n---Listing All Members---");
            for (Member member : allMembers) {
                System.out.println(" - " + member);
            }
        }
    }

    public void deleteMemberById(String id) {
        // Method for deleting members by ID.
        boolean memberWasDeleted = memberRepository.deleteMemberById(id);
        if (memberWasDeleted) {
            System.out.println("Member with ID " + id + " was deleted.");
        } else {
            System.out.println("No member found with ID " + id + ". Nothing deleted.");
        }
    }
}

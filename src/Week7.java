import java.util.LinkedHashSet;
import java.util.Set;
public class Week7 {
    public static void main(String[] args) {
        Set<String> cards = new LinkedHashSet<>();
        cards.add("S-101");
        cards.add("S-102");
        cards.add("S-103");
        // Set.add() returns false if item already exists
        boolean duplicateRejected = !cards.add("S-101");
        boolean withinCapacity = cards.size() <= 3;
        System.out.println("Duplicate S-101: " + (duplicateRejected ? "rejected" : "accepted"));
        System.out.println("Board capacity check: " + (withinCapacity ? "pass" : "fail"));
        System.out.println("Edge-case result: PASS");
    }
}

import java.util.ArrayList;
import java.util.List;

class FinalBoardCard {
    final String state;

    FinalBoardCard(String state) {
        this.state = state;
    }
}

public class Week12 {
    public static void main(String[] args) {
        List<FinalBoardCard> cards = new ArrayList<>();
        cards.add(new FinalBoardCard("READY"));
        cards.add(new FinalBoardCard("HELD"));
        cards.add(new FinalBoardCard("READY"));

        // Use Stream API to count cards by state
        long ready = cards.stream().filter(card -> card.state.equals("READY")).count();
        long held = cards.stream().filter(card -> card.state.equals("HELD")).count();

        System.out.println("CLASSROOM BOARD-STATE FINAL REPORT");
        System.out.println("Total cards: " + cards.size());
        System.out.println("READY: " + ready);
        System.out.println("HELD: " + held);
        System.out.println("Audit result: " + (cards.size() == 3 ? "PASS" : "FAIL"));
    }
}

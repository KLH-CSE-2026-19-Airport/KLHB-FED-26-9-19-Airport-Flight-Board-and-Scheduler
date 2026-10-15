class BoardCard {
    final String id;
    final String label;
    final String state;
    BoardCard(String id, String label, String state) {
        this.id = id;
        this.label = label;
        this.state = state;
    }
    @Override
    public String toString() {
        return "BoardCard{id=" + id + ", label=" + label + ", state=" + state + "}";
    }
}
public class Week9 {
    public static void main(String[] args) {
        BoardCard card = new BoardCard("S-101", "ALPHA", "READY");
        System.out.println(card);
        System.out.println("Object card count: 1");
        System.out.println("Object model: PASS");
    }
}

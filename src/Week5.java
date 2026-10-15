public class Week5 {
    // Formats and renders card display string
    static String showCard(String slot, String label, String state) {
        return "showCard(" + slot + ") -> " + label + " " + state;
    }
    // Predicate checking validity of a state
    static boolean knownState(String state) {
        return state.equals("READY") || state.equals("HELD") || state.equals("CLOSED");
    }
    public static void main(String[] args) {
        System.out.println(showCard("S-103", "GAMMA", "READY"));
        System.out.println("knownState(READY) -> " + knownState("READY"));
        System.out.println("Method check complete.");
    }
}

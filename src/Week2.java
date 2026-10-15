public class Week2 {
    // Validates slots: only S-101, S-102, or S-103 are permitted
    static boolean validSlot(String slot) {
        return slot.matches("S-10[1-3]");
    }
    // Validates state labels: only READY, HELD, or CLOSED
    static boolean knownState(String state) {
        return state.equals("READY") || state.equals("HELD") || state.equals("CLOSED");
    }
    public static void main(String[] args) {
        System.out.println("Slot S-104: " + (validSlot("S-104") ? "accepted" : "rejected"));
        System.out.println("Slot S-102: " + (validSlot("S-102") ? "accepted" : "rejected"));
        System.out.println("State UNKNOWN: " + (knownState("UNKNOWN") ? "accepted" : "rejected"));
    }
}

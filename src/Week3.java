public class Week3 {
    // Uses switch expression to ensure only permitted states are kept
    static String normalise(String state) {
        return switch (state) {
            case "READY", "HELD", "CLOSED" -> state;
            default -> "CLOSED";
        };
    }
    public static void main(String[] args) {
        System.out.println("S-101 -> " + normalise("READY"));
        System.out.println("S-102 -> " + normalise("HELD"));
        System.out.println("Decision rules checked: 2");
    }
}

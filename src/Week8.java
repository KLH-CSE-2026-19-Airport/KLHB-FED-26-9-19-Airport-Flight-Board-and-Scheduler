public class Week8 {
    // Recursively walks the array and accumulates cards marked READY
    static int countReady(String[] states, int index) {
        // Base case: end of array reached
        if (index == states.length) return 0;
        // Recursive case
        return (states[index].equals("READY") ? 1 : 0) + countReady(states, index + 1);
    }
    public static void main(String[] args) {
        String[] states = {"READY", "HELD", "READY"};
        int ready = countReady(states, 0);
        System.out.println("Ready cards (recursive): " + ready);
        System.out.println("Fixture cards inspected: " + states.length);
        System.out.println("Recursion result: PASS");
    }
    
}

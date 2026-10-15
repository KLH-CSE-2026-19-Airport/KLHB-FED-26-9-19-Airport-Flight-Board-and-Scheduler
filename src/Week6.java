public class Week6 {
    // Linear search: returns index if found, or -1 if not found
    static int find(String[] slots, String target) {
        for (int index = 0; index < slots.length; index++) {
            if (slots[index].equals(target)) return index;
        }
        return -1;
    }
    public static void main(String[] args) {
        String[] slots = {"S-101", "S-102", "S-103"};
        int found = find(slots, "S-103");
        int missing = find(slots, "S-999");
        System.out.println("S-103 found at index " + found);
        System.out.println("S-999 " + (missing < 0 ? "not found" : "found"));
        System.out.println("Array search complete.");
    }
}

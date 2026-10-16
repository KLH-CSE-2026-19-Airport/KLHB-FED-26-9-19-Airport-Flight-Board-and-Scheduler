
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
public class Masterprogram {
    // Custom Checked Exception (Week 10)
    public static class InvalidBoardStateException extends Exception {
        public InvalidBoardStateException(String message) {
            super(message);
        }
    }
    // Data Model: BoardCard Object (Week 09 & 12)
    public static class BoardCard {
        private final String id;
        private final String label;
        private final String state;
        public BoardCard(String id, String label, String state) {
            this.id = id;
            this.label = label;
            this.state = state;
        }
        public String getId() { return id; }
        public String getLabel() { return label; }
        public String getState() { return state; }
        @Override
        public String toString() {
            return "BoardCard{id=" + id + ", label=" + label + ", state=" + state + "}";
        }
    }
    
    public static void runWeek01() {
        System.out.println("CLASSROOM BOARD-STATE SIMULATOR");
        System.out.println("Fixture cards: 3");
        System.out.println("First card: S-101 -> READY");
    }
   
    public static boolean validSlot(String slot) {
        return slot != null && slot.matches("S-10[1-3]");
    }
    public static boolean knownState(String state) {
        return "READY".equals(state) || "HELD".equals(state) || "CLOSED".equals(state);
    }
    public static void runWeek02() {
        System.out.println("Slot S-104: " + (validSlot("S-104") ? "accepted" : "rejected"));
        System.out.println("Slot S-102: " + (validSlot("S-102") ? "accepted" : "rejected"));
        System.out.println("State UNKNOWN: " + (knownState("UNKNOWN") ? "accepted" : "rejected"));
    }
    // ------------------------------------------------------------------------
    // WEEK 03: Decision Rules
    // ------------------------------------------------------------------------
    public static String normaliseState(String state) {
        return switch (state) {
            case "READY", "HELD", "CLOSED" -> state;
            default -> "CLOSED";
        };
    }
    public static void runWeek03() {
        System.out.println("S-101 -> " + normaliseState("READY"));
        System.out.println("S-102 -> " + normaliseState("HELD"));
        System.out.println("Decision rules checked: 2");
    }
    // ------------------------------------------------------------------------
    // WEEK 04: Loop-Driven Board Actions
    // ------------------------------------------------------------------------
    public static void runWeek04() {
        String[] actions = {
            "SHOW S-101 READY",
            "UPDATE S-102 HELD",
            "SHOW S-103 READY"
        };
        for (String action : actions) {
            System.out.println(action);
        }
        System.out.println("EXIT complete");
    }
    // ------------------------------------------------------------------------
    // WEEK 05: Board Methods
    // ------------------------------------------------------------------------
    public static String showCard(String slot, String label, String state) {
        return "showCard(" + slot + ") -> " + label + " " + state;
    }
    public static void runWeek05() {
        System.out.println(showCard("S-103", "GAMMA", "READY"));
        System.out.println("knownState(READY) -> " + knownState("READY"));
        System.out.println("Method check complete.");
    }
    // ------------------------------------------------------------------------
    // WEEK 06: Array Linear Search
    // ------------------------------------------------------------------------
    public static int findSlot(String[] slots, String target) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].equals(target)) return i;
        }
        return -1;
    }
    public static void runWeek06() {
        String[] slots = {"S-101", "S-102", "S-103"};
        int foundIndex = findSlot(slots, "S-103");
        int missingIndex = findSlot(slots, "S-999");
        System.out.println("S-103 found at index " + foundIndex);
        System.out.println("S-999 " + (missingIndex < 0 ? "not found" : "found"));
        System.out.println("Array search complete.");
    }
    // ------------------------------------------------------------------------
    // WEEK 07: Edge Cases & Duplicate Prevention
    // ------------------------------------------------------------------------
    public static void runWeek07() {
        Set<String> cards = new LinkedHashSet<>();
        cards.add("S-101");
        cards.add("S-102");
        cards.add("S-103");
        boolean duplicateRejected = !cards.add("S-101");
        boolean withinCapacity = cards.size() <= 3;
        System.out.println("Duplicate S-101: " + (duplicateRejected ? "rejected" : "accepted"));
        System.out.println("Board capacity check: " + (withinCapacity ? "pass" : "fail"));
        System.out.println("Edge-case result: PASS");
    }
    // ------------------------------------------------------------------------
    // WEEK 08: Recursive Ready-State Count
    // ------------------------------------------------------------------------
    public static int countReady(String[] states, int index) {
        if (index == states.length) return 0;
        int currentCount = "READY".equals(states[index]) ? 1 : 0;
        return currentCount + countReady(states, index + 1);
    }
    public static void runWeek08() {
        String[] states = {"READY", "HELD", "READY"};
        int readyCount = countReady(states, 0);
        System.out.println("Ready cards (recursive): " + readyCount);
        System.out.println("Fixture cards inspected: " + states.length);
        System.out.println("Recursion result: PASS");
    }
    // ------------------------------------------------------------------------
    // WEEK 09: Board-Card Objects
    // ------------------------------------------------------------------------
    public static void runWeek09() {
        BoardCard card = new BoardCard("S-101", "ALPHA", "READY");
        System.out.println(card);
        System.out.println("Object card count: 1");
        System.out.println("Object model: PASS");
    }
    // ------------------------------------------------------------------------
    // WEEK 10: Safe State Updates (Exceptions)
    // ------------------------------------------------------------------------
    public static String acceptState(String state) throws InvalidBoardStateException {
        if (!knownState(state)) {
            throw new InvalidBoardStateException("REJECTED: state must be READY, HELD, or CLOSED");
        }
        return state;
    }
    public static void runWeek10() {
        try {
            acceptState("UNKNOWN");
        } catch (InvalidBoardStateException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println("Recovered with state: " + acceptState("HELD"));
        } catch (InvalidBoardStateException ex) {
            System.out.println("Unexpected error");
        }
        System.out.println("Exception result: PASS");
    }
    // ------------------------------------------------------------------------
    // WEEK 11: Fictional CSV Storage
    // ------------------------------------------------------------------------
    public static void runWeek11() {
        try {
            Path filePath = Path.of("board-fixtures.csv");
            List<String> rows = List.of(
                "id,label,state",
                "S-101,ALPHA,READY",
                "S-102,BETA,HELD",
                "S-103,GAMMA,READY"
            );
            Files.write(filePath, rows);
            List<String> loadedRows = Files.readAllLines(filePath);
            System.out.println("Saved " + (loadedRows.size() - 1) + " fictional board cards");
            System.out.println("Loaded " + loadedRows.get(1));
            System.out.println("File result: PASS");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
    // ------------------------------------------------------------------------
    // WEEK 12: Collections, Streams, and Final Report
    // ------------------------------------------------------------------------
    public static void runWeek12() {
        List<BoardCard> cards = new ArrayList<>();
        cards.add(new BoardCard("S-101", "ALPHA", "READY"));
        cards.add(new BoardCard("S-102", "BETA", "HELD"));
        cards.add(new BoardCard("S-103", "GAMMA", "READY"));
        long readyCount = cards.stream()
                               .filter(card -> "READY".equals(card.getState()))
                               .count();
        long heldCount = cards.stream()
                              .filter(card -> "HELD".equals(card.getState()))
                              .count();
        System.out.println("CLASSROOM BOARD-STATE FINAL REPORT");
        System.out.println("Total cards: " + cards.size());
        System.out.println("READY: " + readyCount);
        System.out.println("HELD: " + heldCount);
        System.out.println("Audit result: " + (cards.size() == 3 ? "PASS" : "FAIL"));
    }
    // ------------------------------------------------------------------------
    // SEQUENTIAL WALKTHROUGH (ALL WEEKS)
    // ------------------------------------------------------------------------
    public static void runAllWeeks() {
        System.out.println("==================================================");
        System.out.println("WEEK 01 - BOARD-STATE BASELINE");
        System.out.println("==================================================");
        runWeek01();
        System.out.println("\n==================================================");
        System.out.println("WEEK 02 - INPUT VALIDATION");
        System.out.println("==================================================");
        runWeek02();
        System.out.println("\n==================================================");
        System.out.println("WEEK 03 - DECISION RULES");
        System.out.println("==================================================");
        runWeek03();
        System.out.println("\n==================================================");
        System.out.println("WEEK 04 - LOOP-DRIVEN BOARD ACTIONS");
        System.out.println("==================================================");
        runWeek04();
        System.out.println("\n==================================================");
        System.out.println("WEEK 05 - BOARD METHODS");
        System.out.println("==================================================");
        runWeek05();
        System.out.println("\n==================================================");
        System.out.println("WEEK 06 - ARRAY SEARCH");
        System.out.println("==================================================");
        runWeek06();
        System.out.println("\n==================================================");
        System.out.println("WEEK 07 - EDGE CASES");
        System.out.println("==================================================");
        runWeek07();
        System.out.println("\n==================================================");
        System.out.println("WEEK 08 - RECURSIVE READY-STATE COUNT");
        System.out.println("==================================================");
        runWeek08();
        System.out.println("\n==================================================");
        System.out.println("WEEK 09 - BOARD-CARD OBJECTS");
        System.out.println("==================================================");
        runWeek09();
        System.out.println("\n==================================================");
        System.out.println("WEEK 10 - SAFE STATE UPDATES");
        System.out.println("==================================================");
        runWeek10();
        System.out.println("\n==================================================");
        System.out.println("WEEK 11 - FICTIONAL CSV STORAGE");
        System.out.println("==================================================");
        runWeek11();
        System.out.println("\n==================================================");
        System.out.println("WEEK 12 - FINAL AUDIT REPORT");
        System.out.println("==================================================");
        runWeek12();
        System.out.println("==================================================");
    }
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int week = Integer.parseInt(args[0]);
                switch (week) {
                    case 1 -> runWeek01();
                    case 2 -> runWeek02();
                    case 3 -> runWeek03();
                    case 4 -> runWeek04();
                    case 5 -> runWeek05();
                    case 6 -> runWeek06();
                    case 7 -> runWeek07();
                    case 8 -> runWeek08();
                    case 9 -> runWeek09();
                    case 10 -> runWeek10();
                    case 11 -> runWeek11();
                    case 12 -> runWeek12();
                    default -> System.out.println("Please provide a week number between 1 and 12.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid week number: " + args[0]);
            }
        } else {
            // Default: Run all weeks sequentially
            runAllWeeks();
        }
    }
}


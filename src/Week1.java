public class Week1 {
    
    public static void main(String[] args) {
        // Step 1: Define simulator title and fixed card count
        String simulatorTitle = "CLASSROOM BOARD-STATE SIMULATOR";
        int fixtureCards = 3;
        // Step 2: Define first fictitious card state
        String cardId = "S-101";
        String cardState = "READY";
        System.out.println(simulatorTitle);
        System.out.println("Fixture cards: " + fixtureCards);
        System.out.println("First card: " + cardId + " -> " + cardState);
    }
}


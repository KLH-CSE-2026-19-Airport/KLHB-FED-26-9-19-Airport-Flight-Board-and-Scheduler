public class Week4 {
    public static void main(String[] args) {
        String[] actions = {"SHOW S-101 READY", "UPDATE S-102 HELD", "SHOW S-103 READY"};
        
        // Loop through each action and display it
        for (String action : actions) {
            System.out.println(action);
        }
        System.out.println("EXIT complete");
    }
}

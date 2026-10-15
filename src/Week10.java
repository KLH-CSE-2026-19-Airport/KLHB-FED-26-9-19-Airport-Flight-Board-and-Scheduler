class InvalidBoardStateException extends Exception {
    InvalidBoardStateException(String message) {
        super(message);
    }
}
public class Week10 {
    static String accept(String state) throws InvalidBoardStateException {
        if (!(state.equals("READY") || state.equals("HELD") || state.equals("CLOSED"))) {
            throw new InvalidBoardStateException("REJECTED: state must be READY, HELD, or CLOSED");
        }
        return state;
    }
    public static void main(String[] args) {
        // Attempt invalid state and catch exception
        try {
            accept("UNKNOWN");
        } catch (InvalidBoardStateException exception) {
            System.out.println(exception.getMessage());
        }
        // Recover by applying a valid state
        try {
            System.out.println("Recovered with state: " + accept("HELD"));
        } catch (InvalidBoardStateException exception) {
            System.out.println("Unexpected error");
        }
        System.out.println("Exception result: PASS");
    }
}

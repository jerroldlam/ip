package duke.function;

public class CommandParser {
    private static final String BYE_COMMAND = "bye";
    private static final String LIST_COMMAND = "list";
    private static final String DONE_COMMAND = "done";

    public static boolean userEnteredBye(String userInput) {
        return userInput.equalsIgnoreCase(BYE_COMMAND);
    }

    public static boolean userEnteredList(String userInput) {
        return userInput.equalsIgnoreCase(LIST_COMMAND);
    }

    public static boolean userEnteredDone(String userInput) {
        return userInput.toLowerCase().startsWith(DONE_COMMAND);
    }
}

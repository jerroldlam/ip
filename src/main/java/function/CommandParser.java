package function;

public class CommandParser {

    public static boolean userEnteredBye(String userInput) {
        return userInput.equalsIgnoreCase("bye");
    }

    public static boolean userEnteredList(String userInput) {
        return userInput.equalsIgnoreCase("list");
    }

    public static boolean userEnteredDone(String userInput) {
        return userInput.toLowerCase().startsWith("done");
    }
}

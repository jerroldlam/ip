package duke.function;

public class CommandParser {
    private static final String BYE_COMMAND = "bye";
    private static final String LIST_COMMAND = "list";
    private static final String DONE_COMMAND = "done";
    private static final String FIND_COMMAND = "find";
    private static final String DELETE_COMMAND = "delete";
    private static final String EVENT_COMMAND = "event";
    private static final String DEADLINE_COMMAND = "deadline";
    private static final String TODO_COMMAND = "todo";

    /**
     * Returns true if user input requests for the "bye" command,
     * else return false.
     *
     * @param userInput string of userInput
     * @return boolean
     */
    public static boolean userEnteredBye(String userInput) {
        return userInput.equalsIgnoreCase(BYE_COMMAND);
    }

    /**
     * Returns true if user input requests for the "list" command,
     * else return false.
     *
     * @param userInput string of userInput
     * @return boolean
     */
    public static boolean userEnteredList(String userInput) {
        return userInput.equalsIgnoreCase(LIST_COMMAND);
    }

    /**
     * Returns true if user input requests for the "done" command,
     * else return false.
     *
     * @param userInput
     * @return
     */
    public static boolean userEnteredDone(String userInput) {
        return userInput.toLowerCase().startsWith(DONE_COMMAND);
    }

    /**
     * Returns true if user input requests for the "delete" command,
     * else returns false.
     *
     * @param userInput
     * @return
     */
    public static boolean userEnteredDelete(String userInput) {
        return userInput.toLowerCase().startsWith(DELETE_COMMAND);
    }

    /**
     * Returns true if user input requests for the "find" command,
     * else returns false.
     *
     * @param userInput
     * @return
     */
    public static boolean userEnteredFind (String userInput) {
        return(userInput.toLowerCase().startsWith(FIND_COMMAND));
    }

    /**
     * Returns true if user input requests for the add tasks command,
     * else returns false.
     *
     * @param userInput
     * @return
     */
    public static boolean userEnteredTask (String userInput) {
        return (userInput.toLowerCase().startsWith(DEADLINE_COMMAND) ||
                userInput.toLowerCase().startsWith(EVENT_COMMAND) ||
                userInput.toLowerCase().startsWith(TODO_COMMAND));
    }
}

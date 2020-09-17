package duke.function;

public class Ui {

    /**
     * Prints welcome message for User during entry.
     */
    public static void showWelcomeMessage() {
        System.out.println("--------------------Waking Duke up-------------------");
        System.out.println("Hello...");
        System.out.println("You have woken me up...");
        System.out.println("What can I do for you?");
        System.out.println("----------------------------------------------------");
    }

    /**
     * Prints exit message for User during exit.
     */
    public static void showExitMessage() {
        System.out.println("----------------------------------------------------");
        System.out.println("Bye.");
        System.out.println("I'm going back to sleep.");
        System.out.println("------------Duke has gone back to sleep--------------");
    }

    /**
     * Prints error message for User.
     *
     * @param errorMessage message to print out for User.
     */
    public static void printErrorMessage(String errorMessage) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(errorMessage);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}

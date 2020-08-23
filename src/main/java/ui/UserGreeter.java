package ui;

public class UserGreeter {

    /**
     * Prints welcome message for User during entry.
     * ASCII ART from unknown author at https://pastebin.com/LPDM7dA0
     */
    public static void greetEntry() {
        System.out.println("----------------------------------------------------");
        System.out.println("    　　∧_∧               Hello...");
        System.out.println("      (  ･ω･)             You have woken me up...");
        System.out.println("  　 ＿|　⊃／(＿＿_         What can I do for you?");
        System.out.println("  ／　 └-(＿＿＿_／");
        System.out.println("  ￣￣￣￣￣￣￣");
        System.out.println("----------------------------------------------------");
    }

    /**
     * Prints exit message for User during exit.
     * ASCII ART from unknown author at https://pastebin.com/LPDM7dA0
     */
    public static void greetExit() {
        System.out.println("----------------------------------------------------");
        System.out.println("    　 ＜⌒／ヽ-､_＿_       Bye.");
        System.out.println("    ／＜_/＿＿＿＿／        I'm going back to sleep.");
        System.out.println("    ￣￣￣￣￣￣￣");
        System.out.println("----------------------------------------------------");
    }
}

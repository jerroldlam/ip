package function;

public class UserGreeter {

    /**
     * Prints welcome message for User during entry.
     * ASCII ART adapted from unknown author at https://pastebin.com/LPDM7dA0
     */
    public static void greetEntry() {
        System.out.println("--------------------Waking Cid up---------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("    　　∧_∧               Hello...");
        System.out.println("      (  ･ω･)             You have woken me up...");
        System.out.println("  　 ＿|　⊃／(＿＿_         What can I do for you?");
        System.out.println("  ／　 └-(＿＿＿_／");
        System.out.println("  ￣￣￣￣￣￣￣");
        System.out.println("----------------------------------------------------");
    }

    /**
     * Prints exit message for User during exit.
     * ASCII ART adapted from unknown author at https://pastebin.com/LPDM7dA0
     */
    public static void greetExit() {
        System.out.println("----------------------------------------------------");
        System.out.println("    　 ＜⌒／ヽ-､_＿_       Bye.");
        System.out.println("    ／＜_/＿＿＿＿／        I'm going back to sleep.");
        System.out.println("    ￣￣￣￣￣￣￣");
        System.out.println("----------------------------------------------------");
        System.out.println("------------Cid has gone back to sleep--------------");
    }

    /**
     * Prints error message for User.
     * ASCII ART adapted from unknown author at https://pastebin.com/LPDM7dA0
     *
     * @param errorMessage message to print out for User.
     */
    public static void printError(String errorMessage) {
        System.out.println("----------------------------------------------------");
        System.out.println("    　　∧_∧");
        System.out.println("      (  oωo)");
        System.out.println("  　 ＿|　⊃／(＿＿_");
        System.out.println("   ／　└-(＿＿＿_／");
        System.out.println("   ￣￣￣￣￣￣￣");
        System.out.println(errorMessage);
        System.out.println("----------------------------------------------------");
    }
}

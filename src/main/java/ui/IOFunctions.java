package ui;

import java.io.IOException;

public class IOFunctions {
    public static void greetEntry() throws IOException {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void greetExit() throws IOException {
        System.out.println("Bye! Hope to see you again soon!");
    }
}

import java.util.Scanner;
import static ui.UserGreeter.*;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;

        System.out.println("-----------------------");
        greetEntry();
        System.out.println("-----------------------");
        while (true) {
            line = in.nextLine();
            if (!line.equals("bye")) {
                System.out.println(line);
            } else {
                break;
            }
        }
        greetExit();
        System.out.println("-----------------------");
    }
}

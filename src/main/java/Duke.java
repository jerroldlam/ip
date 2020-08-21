import java.util.ArrayList;
import java.util.Scanner;
import static ui.UserGreeter.*;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String userInput;
        ArrayList<String> listArray = new ArrayList<String>();

        greetEntry();

        while (true) {
            userInput = in.nextLine();
            if (userInput.equals("bye")) {
                break;

            } else if (userInput.equals("list")) {
                for (int listIndex = 1; listIndex <= listArray.size(); listIndex++) {
                    System.out.println(listIndex + ". " + listArray.get(listIndex - 1));
                }
            } else {
                listArray.add(userInput);
                System.out.println("added: " + userInput);
            }
        }
        greetExit();
    }
}

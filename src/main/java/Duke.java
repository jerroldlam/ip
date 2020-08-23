import java.util.Scanner;
import static ui.UserGreeter.greetEntry;
import static ui.UserGreeter.greetExit;
import function.TaskList;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskList userTaskList = new TaskList();
        String userInput;
        
        greetEntry();

        while (true) {
            userInput = in.nextLine();
            if (userInput.equals("bye")) {
                break;
            } else if (userInput.equals("list")) {
                userTaskList.printTaskList();
            } else if (userInput.contains("done")) {
                userTaskList.setTaskComplete(userInput);
            } else {
                userTaskList.addTask(userInput);
            }
        }
        greetExit();
    }
}

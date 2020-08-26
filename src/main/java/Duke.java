import java.util.Scanner;
import static function.UserGreeter.greetEntry;
import static function.UserGreeter.greetExit;
import function.TaskList;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskList userTaskList = new TaskList();
        String userInput;
        
        greetEntry();

        while (true) {
            userInput = in.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                userTaskList.printTaskList();
            } else if (userInput.toLowerCase().contains("done")) {
                userTaskList.setTaskComplete(userInput);
            } else {
                userTaskList.addTask(userInput);
            }
        }
        greetExit();
    }
}

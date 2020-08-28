import java.util.Scanner;
import static function.UserGreeter.showWelcomeMessage;
import static function.UserGreeter.showExitMessage;
import function.TaskList;

public class Duke {
    public static void main(String[] args) {
        TaskList userTaskList = new TaskList();
        String userInput;
        
        showWelcomeMessage();
        while (true) {
            userInput = getUserInput();
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
        showExitMessage();
    }

    public static String getUserInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}

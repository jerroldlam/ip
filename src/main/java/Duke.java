import java.util.Scanner;
import static function.CommandParser.userEnteredBye;
import static function.CommandParser.userEnteredDone;
import static function.CommandParser.userEnteredList;
import static function.UserGreeter.showWelcomeMessage;
import static function.UserGreeter.showExitMessage;
import function.TaskList;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskList userTaskList = new TaskList();
        String userInput;
        
        showWelcomeMessage();

        while (true) {
            userInput = in.nextLine();
            if (userEnteredBye(userInput)) {
                break;
            } else if (userEnteredList(userInput)) {
                userTaskList.printTaskList();
            } else if (userEnteredDone(userInput)) {
                userTaskList.setTaskComplete(userInput);
            } else {
                userTaskList.addTask(userInput);
            }
        }
        showExitMessage();
    }
}

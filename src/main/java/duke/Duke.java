package duke;

import java.util.Scanner;
import static duke.function.CommandParser.userEnteredBye;
import static duke.function.CommandParser.userEnteredDone;
import static duke.function.CommandParser.userEnteredList;
import static duke.function.CommandParser.userEnteredFind;
import static duke.function.CommandParser.userEnteredDelete;
import static duke.function.CommandParser.userEnteredTask;
import static duke.function.Ui.showWelcomeMessage;
import static duke.function.Ui.showExitMessage;
import static duke.function.Ui.showHelpMessage;
import static duke.function.Ui.printErrorMessage;
import duke.function.TaskList;

/**
 * Represents the main Duke program which contains task tracking capabilities
 */
public class Duke {

    public static final String ERROR_INVALID_COMMAND = "INVALID COMMAND ENTERED";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskList userTaskList = new TaskList();
        String userInput;
        
        showWelcomeMessage();
        userTaskList.loadTaskList();

        while (true) {
            showHelpMessage();
            userInput = in.nextLine();
            if (userEnteredBye(userInput)) {
                break;
            } else if (userEnteredList(userInput)) {
                userTaskList.printTaskList();
            } else if (userEnteredDone(userInput)) {
                userTaskList.setTaskComplete(userInput);
            } else if (userEnteredDelete(userInput)) {
                userTaskList.deleteTask(userInput);
            } else if (userEnteredFind(userInput)) {
                userTaskList.findTask(userInput);
            } else if (userEnteredTask(userInput)) {
                userTaskList.addTask(userInput);
            } else {
                printErrorMessage(ERROR_INVALID_COMMAND);
            }
        }
        userTaskList.saveTaskList();
        showExitMessage();
    }
}

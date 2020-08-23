import java.util.ArrayList;
import java.util.Scanner;
import static ui.UserGreeter.greetEntry;
import static ui.UserGreeter.greetExit;
import model.Task;

public class Duke {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Task> taskArrayList = new ArrayList<Task>();
        String userInput;
        
        greetEntry();

        while (true) {
            userInput = in.nextLine();
            if (userInput.equals("bye")) {
                break;

            } else if (userInput.equals("list")) {
                System.out.println("Here is your current task list!");
                System.out.println("Hope you are on target!");
                for (int listIndex = 1; listIndex <= taskArrayList.size(); listIndex++) {
                    Task currentTask = taskArrayList.get(listIndex - 1);
                    System.out.print(listIndex + ". ");

                    if (currentTask.isTaskDone()) {
                        System.out.print("[✓] ");
                    } else {
                        System.out.print("[✗] ");
                    }
                    System.out.println(currentTask.getTaskName());
                }
            } else if (userInput.contains("done")) {
                String userInputNumber = userInput.substring(userInput.indexOf(" ") + 1);
                int taskNumberCompleted = Integer.parseInt(userInputNumber);
                taskArrayList.get(taskNumberCompleted - 1).setTaskDone(true);
                System.out.println("Oh jolly! You finally completed this:");
                System.out.println("  [✓] " + taskArrayList.get(taskNumberCompleted - 1).getTaskName());
            } else {
                Task newTask = new Task(userInput);
                taskArrayList.add(newTask);
                System.out.println("New task added: " + userInput);
                System.out.println("I'll keep track of it for you!");
            }
        }
        greetExit();
    }
}

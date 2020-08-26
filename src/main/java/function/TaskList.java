package function;

import model.Task;
import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> taskArrayList = new ArrayList<>();
    private int totalNumberOfTasks;
    private int numberOfCompletedTasks;

    public TaskList() {
        setTotalNumberOfTasks(0);
        setNumberOfCompleteTasks(0);
    }

    public int getTotalNumberOfTasks() {
        return totalNumberOfTasks;
    }

    public void setTotalNumberOfTasks(int totalNumberOfTasks) {
        this.totalNumberOfTasks = totalNumberOfTasks;
    }

    public int getNumberOfCompleteTasks() {
        return numberOfCompletedTasks; }

    public void setNumberOfCompleteTasks(int numberOfCompletedTasks) {
        this.numberOfCompletedTasks = numberOfCompletedTasks;
    }

    /**
     * Prints current state of task list with the tasks and completeness.
     * If task list is empty, it will inform the user of an empty task list.
     */
    public void printTaskList() {
        if (taskArrayList.isEmpty()) {
            System.out.println("You have no tasks yet!");
            return;
        } else {
            System.out.println("Here is your current task list!");
            System.out.println("You have " + getTotalNumberOfTasks() + " task"
                    + ((getTotalNumberOfTasks()>1)? "s" :"") + " on your list!");
            System.out.println("You have completed " + getNumberOfCompleteTasks() +" of them.");
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
        }
    }

    /**
     * Takes a string of userInput and sets as name of a new task.
     * Then, Adds the instance of the new task into taskArrayList.
     *
     * @param userInput name of new task.
     */
    public void addTask(String userInput) {
        Task newTask = new Task(userInput);
        taskArrayList.add(newTask);
        setTotalNumberOfTasks(getTotalNumberOfTasks()+1);
        System.out.println("New task added: " + userInput);
        System.out.println("I'll keep track of it for you!");
    }

    /**
     * Takes a string of userInput in the format of "done X", where X is an integer marking the task index
     * of the task that the user wants to indicate as done. Find the corresponding index from int X and
     * sets the task's boolean isDone to be true.
     *
     * @param userInput user's input in the format "done x"
     */
    public void setTaskComplete(String userInput) {
        String userInputNumber = userInput.substring(userInput.indexOf(" ") + 1);
        try {
            int taskNumberCompleted = Integer.parseInt(userInputNumber);
            try {
                taskArrayList.get(taskNumberCompleted - 1).setTaskDone(true);
                setNumberOfCompleteTasks(getNumberOfCompleteTasks()+1);
                System.out.println("Oh jolly! You finally completed this:");
                System.out.println("  [✓] " + taskArrayList.get(taskNumberCompleted - 1).getTaskName());
            } catch (Exception noSuchTaskException) {
                System.out.println("There's no such task to finish! Check your list!");
            }
        } catch (Exception notAnIntegerException) {
            System.out.println("Please put an integer after done.");
        }
    }
}

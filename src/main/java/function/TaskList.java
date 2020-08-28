package function;

import java.util.ArrayList;
import model.Deadline;
import model.Event;
import model.Task;
import model.TaskType;
import model.ToDo;
import static function.UserGreeter.printError;

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
            printError("You have no tasks yet!");
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
                currentTask.printTask();
                System.out.print("\n");
            }
        }
    }

    /**
     * Takes a string of userInput and determines the TaskType intended.
     * Creates an instance of the new TaskType,
     * then, add the instance of the new task into taskArrayList.
     *
     * @param userInput name of new task.
     */
    public void addTask(String userInput) {
        TaskType newTaskType = getInputTaskType(userInput);
        Task newEntry;

        switch (newTaskType) {
        case EVENT:
            String eventName = getInputTaskName(userInput);
            String period = getInputDetails(userInput);
            newEntry = new Event(eventName,period);
            break;
        case DEADLINE:
            String deadlineName = getInputTaskName(userInput);
            String deadlineBy = getInputDetails(userInput);
            newEntry = new Deadline(deadlineName,deadlineBy);
            break;
        case TODO:
            int nameStartPoint = userInput.indexOf(" ");
            String toDoName = userInput.substring(nameStartPoint);
            newEntry = new ToDo(toDoName);
            break;
        default:
            printError("Error adding task. I only have todo, deadline and event.");
            return;
        }
        taskArrayList.add(newEntry);
        setTotalNumberOfTasks(getTotalNumberOfTasks()+1);
        System.out.println("New task added: ");
        newEntry.printTask();
        System.out.println("\nI'll keep track of it for you!");
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
                Task currentTask = taskArrayList.get(taskNumberCompleted - 1);
                currentTask.setTaskDone(true);
                setNumberOfCompleteTasks(getNumberOfCompleteTasks()+1);
                System.out.println("Oh jolly! You finally completed this:");
                currentTask.printTask();
                System.out.print("\n");
            } catch (Exception noSuchTaskException) {
                printError("There's no such task to finish! Check your list!");
            }
        } catch (Exception notAnIntegerException) {
            printError("Please put an integer after done.");
        }
    }

    /**
     * Takes a string of userInput and returns an enumeration TaskType corresponding to the userInput.
     * Returns null if userInput does not match any TaskType.
     * userInput is case-insensitive.
     *
     * @param userInput of one word from the user
     * @return TaskType of userInput
     */
    public TaskType getTaskType (String userInput) {
        TaskType currentTaskType;

        switch (userInput.toUpperCase()) {
        case "TODO" :
            currentTaskType =  TaskType.TODO;
            break;
        case "DEADLINE" :
            currentTaskType = TaskType.DEADLINE;
            break;
        case "EVENT" :
            currentTaskType = TaskType.EVENT;
            break;
        default:
            currentTaskType = null;
        }
        return currentTaskType;
    }

    /**
     * Processes the userInput and returns the TaskType of the userInput
     *
     * @param userInput of any length where the first word is the TaskType intended
     * @return TaskType of userInput
     */
    public TaskType getInputTaskType (String userInput) {
        String[] inputTaskType = userInput.split(" ");
        return (getTaskType(inputTaskType[0]));
    }

    /**
     * Process userInput and returns intended taskName
     *
     * @param userInput user's input
     * @return String taskName - name of task
     */
    public String getInputTaskName (String userInput) {
        int nameStartPoint = userInput.indexOf(" ");
        int nameEndPoint = userInput.indexOf("/");
        return userInput.substring(nameStartPoint,nameEndPoint);
    }

    /**
     * Process userInput and returns intended details
     *
     * @param userInput user's input
     * @return String details - details of task to be attached
     */
    public String getInputDetails (String userInput) {
        int nameEndPoint = userInput.indexOf("/");
        String roughDetails = userInput.substring(nameEndPoint);
        int detailStartPoint = roughDetails.indexOf(" ") + 1;
        return roughDetails.substring(detailStartPoint);
    }
}

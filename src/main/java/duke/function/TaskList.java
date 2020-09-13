package duke.function;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import duke.model.Deadline;
import duke.model.Event;
import duke.model.Task;
import duke.model.TaskType;
import duke.model.ToDo;
import static duke.function.UserGreeter.printErrorMessage;

public class TaskList {
    private final String ERROR_NO_TASK = "You have no tasks yet!";
    private final String ERROR_ADDING_TASK = "Error adding task. I only have todo, deadline and event.";
    private final String ERROR_NO_SUCH_TASK = "There's no such task to finish! Check your list!";
    private final String ERROR_NO_INTEGER_DONE = "Please put an integer after done.";
    private final String ERROR_NO_DETAILS = "The details entered are wrong!";
    private final String COMPLETE_TASK_MESSAGE = "Oh jolly! You finally completed this:";
    private final String DELETE_TASK_MESSAGE = "OK! I have removed this task for you:";
    private final String EVENT_MARKER = "/at";
    private final String DEADLINE_MARKER = "/by";
    private final String DIVIDER_LINE = "----------------------------------------------------";
    private ArrayList<Task> taskArrayList;
    private FileIO textFile = new FileIO("tasklist.txt");
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
        if (taskListNotEmpty(taskArrayList)) {
            printTaskListHeader();
            printTaskListBody();
        } else {
            printErrorMessage(ERROR_NO_TASK);
        }
    }

    /**
     * Checks if taskArrayList is empty
     *
     * @param taskArrayList ArrayList of user's tasks
     * @return boolean of whether it is not empty
     */
    public boolean taskListNotEmpty (ArrayList<Task> taskArrayList) {
        return !(taskArrayList.isEmpty());
    }

    /**
     * Prints the content of the task list with respective list index, task symbol, done symbol
     * and description.
     */
    public void printTaskListBody() {
        for (int listIndex = 1; listIndex <= taskArrayList.size(); listIndex++) {
            Task currentTask = taskArrayList.get(listIndex - 1);
            System.out.print(listIndex + ". ");
            System.out.println(currentTask.toString());
        }
        System.out.println(DIVIDER_LINE);
    }

    /**
     * Prints header of the task list with total number of tasks and number of completed tasks.
     */
    public void printTaskListHeader() {
        System.out.println(DIVIDER_LINE);
        System.out.println("Here is your current task list!");
        System.out.println("You have " + getTotalNumberOfTasks() + " task"
                + ((getTotalNumberOfTasks()>1)? "s" : "") + " on your list!");
        System.out.println("You have completed " + getNumberOfCompleteTasks() +" of them.");
        System.out.println("Hope you are on target!");
    }

    /**
     * Takes a string of userInput and determines the TaskType intended.
     * Creates an instance of the new TaskType,
     * then, add the instance of the new task into taskArrayList.
     *
     * @param userInput name of new task.
     */
    public void addTask(String userInput) {
        try {
            TaskType newTaskType = getInputTaskType(userInput);
            Task newEntry;

            if (taskTypeIsValid(newTaskType)) {
                switch (newTaskType) {
                case EVENT:
                    String eventName = getInputTaskName(userInput);
                    String period = getInputDetails(userInput,EVENT_MARKER);
                    newEntry = new Event(eventName, period);
                    break;
                case DEADLINE:
                    String deadlineName = getInputTaskName(userInput);
                    String deadlineBy = getInputDetails(userInput,DEADLINE_MARKER);
                    newEntry = new Deadline(deadlineName, deadlineBy);
                    break;
                case TODO:
                    int nameStartPoint = userInput.indexOf(" ") + 1;
                    String toDoName = userInput.substring(nameStartPoint);
                    newEntry = new ToDo(toDoName);
                    break;
                default:
                    printErrorMessage(ERROR_ADDING_TASK);
                    return;
                }
                taskArrayList.add(newEntry);
                printAddTaskSuccessfully(newEntry);
            } else {
                printErrorMessage(ERROR_ADDING_TASK);
            }
        } catch (StringIndexOutOfBoundsException e) {
            printErrorMessage(ERROR_NO_DETAILS);
        }
    }

    /**
     * Checks if task type is valid
     *
     * @param type type to be checked
     * @return boolean of validity
     */
    public boolean taskTypeIsValid (TaskType type) {
        return !(type == null);
    }

    /**
     * Prints a confirmation message of adding a newEntry successfully by echoing the entry of the task.
     *
     * @param newEntry object of Task or its subclasses.
     */
    public void printAddTaskSuccessfully(Task newEntry) {
        System.out.println(DIVIDER_LINE);
        setTotalNumberOfTasks(getTotalNumberOfTasks()+1);
        System.out.println("New task added:");
        System.out.println("\t" + newEntry.toString());
        System.out.println("I'll keep track of it for you!");
        System.out.println(DIVIDER_LINE);
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
            Task currentTask = taskArrayList.get(taskNumberCompleted - 1);
            currentTask.setTaskDone(true);
            setNumberOfCompleteTasks(getNumberOfCompleteTasks() + 1);
            printCompleteTaskSuccessfully(currentTask);
        } catch (NumberFormatException e) {
            printErrorMessage(ERROR_NO_INTEGER_DONE);
        } catch (IndexOutOfBoundsException e) {
            printErrorMessage(ERROR_NO_SUCH_TASK);
        }
    }

    /**
     * Prints a confirmation message of successfully setting a task as complete
     * and echoes the task.
     *
     * @param currentTask Task that was completed
     */
    public void printCompleteTaskSuccessfully(Task currentTask) {
        System.out.println(DIVIDER_LINE);
        System.out.println(COMPLETE_TASK_MESSAGE);
        System.out.println("\t" + currentTask.toString());
        System.out.println(DIVIDER_LINE);
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
        int nameStartPoint = userInput.indexOf(" ") + 1;
        int nameEndPoint = userInput.indexOf("/") - 1;
        return userInput.substring(nameStartPoint,nameEndPoint);
    }

    /**
     * Process userInput and returns intended details
     *
     * @param userInput user's input
     * @return String details - details of task to be attached
     */
    public String getInputDetails (String userInput, String splitter) {
        int nameEndPoint = userInput.indexOf(splitter);
        String roughDetails = userInput.substring(nameEndPoint);
        int detailStartPoint = roughDetails.indexOf(" ") + 1;
        return roughDetails.substring(detailStartPoint);
    }

    /**
     * Deletes a task of the user's input
     *
     * @param userInput input of user
     */
    public void deleteTask (String userInput) {
        String userInputNumber = userInput.substring(userInput.indexOf(" ") + 1);
        try {
            int taskNumberToRemove = Integer.parseInt(userInputNumber);
            Task taskToDelete = taskArrayList.get(taskNumberToRemove - 1);
            taskArrayList.remove(taskNumberToRemove - 1);

            if (taskToDelete.isTaskDone()) {
                setNumberOfCompleteTasks(getNumberOfCompleteTasks() - 1);
            }

            setTotalNumberOfTasks(getTotalNumberOfTasks() - 1);
            printDeleteTaskSuccessfully(taskToDelete);
        } catch (NumberFormatException e) {
            printErrorMessage(ERROR_NO_INTEGER_DONE);
        } catch (IndexOutOfBoundsException e) {
            printErrorMessage(ERROR_NO_SUCH_TASK);
        }
    }

    /**
     * Acknowledges successful deletion of task by echoing task deleted
     *
     * @param taskToDelete task that was deleted
     */
    public void printDeleteTaskSuccessfully(Task taskToDelete) {
        System.out.println(DIVIDER_LINE);
        System.out.println(DELETE_TASK_MESSAGE);
        System.out.println("\t" + taskToDelete.toString());
        System.out.println("You have " + getTotalNumberOfTasks() + " task"
                + ((getTotalNumberOfTasks() > 1) ? "s" : "") + " on your list!");
        System.out.println(DIVIDER_LINE);
    }

    /**
     * Saves current task list into text file
     */
    public void saveTaskList() {
        try {
            textFile.saveAsTextFile(taskArrayList);
            printSaveTextFileSuccessfully();
        } catch (IOException e) {
            printErrorMessage("ERROR SAVING TASKS");
        }
    }

    /**
     * Loads tasklist from text file
     */
    public void loadTaskList() {
        try {
            System.out.println("Loading Text File........");
            taskArrayList = textFile.loadTextFile();
            printLoadTextFileSuccessfully();
            populateTaskListStatistics();
        } catch (FileNotFoundException e){
            printErrorMessage(textFile.getFileName() + " does not exist!");
            taskArrayList = new ArrayList<>();
        }
    }

    /**
     * Iterates through the task list and populates total number of tasks
     * and number of completed tasks
     */
    public void populateTaskListStatistics() {
        int[] taskListStatistics;
        taskListStatistics = getTaskListStatistics(taskArrayList);
        setTotalNumberOfTasks(taskListStatistics[0]);
        setNumberOfCompleteTasks(taskListStatistics[1]);
    }

    /**
     * Computes total number of tasks and total number of completed tasks
     *
     * @param taskArrayList ArrayList of tasks to be computed
     * @return Integer array where index 0 represents total task count
     *          and index 1 represents completed task count
     */
    public int[] getTaskListStatistics (ArrayList<Task> taskArrayList) {
        int[] result = {0,0};
        for (Task t : taskArrayList) {
            result[0] += 1;
            if (t.isTaskDone()) {
                result[1] += 1;
            }
        }
        return result;
    }

    /**
     * Acknowledges successful saving of text file
     */
    public void printSaveTextFileSuccessfully () {
        System.out.println(DIVIDER_LINE);
        System.out.println("Task list saved successfully as " + textFile.getFileName());
    }

    /**
     * Acknowledges successful loading of text file
     */
    public void printLoadTextFileSuccessfully () {
        System.out.println("Loaded Tasks Successfully from " + textFile.getFileName());
        System.out.println(DIVIDER_LINE);
    }
}

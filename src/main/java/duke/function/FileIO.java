package duke.function;

import duke.model.Task;
import duke.model.TaskType;
import duke.model.Deadline;
import duke.model.ToDo;
import duke.model.Event;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static duke.function.Ui.printErrorMessage;

public class FileIO {
    private final String ERROR_DATE_FORMAT = "The date format should be in YYYY-MM-DD, which are all integers.";
    private final String ERROR_LOADING_TEXT_FILE = "List Loading terminated.";
    private final String EVENT_SYMBOL = "[E]";
    private final String TODO_SYMBOL = "[T]";
    private final String DEADLINE_SYMBOL = "[D]";
    private final String TEXT_DIVIDER = " | ";
    private final String NEW_LINE = "\n";
    private final String TEXT_DIVIDER_REGEX = " \\| ";
    private String fileName;

    public FileIO (String fileName) {
        setFileName(fileName);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Saves taskListArray to text file
     *
     * @param taskArrayList ArrayList of Tasks
     * @throws IOException
     */
    public void saveAsTextFile (ArrayList<Task> taskArrayList) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        String inputToWrite = "";

        for (Task task : taskArrayList) {
            inputToWrite += getTaskAsText(task);
        }
        fw.write(inputToWrite);
        fw.close();
    }

    /**
     * Takes in Task and formats it into a readable format for text file
     * @param task task to be formatted
     * @return taskLine to be written
     */
    public String getTaskAsText(Task task) {
        String taskLine = "";
        taskLine += task.getTaskSymbol() + TEXT_DIVIDER;
        taskLine += (task.isTaskDone()) ? "1" : "0";
        taskLine += TEXT_DIVIDER;
        taskLine += task.getTaskName();
        if (!task.getTaskType().equals(TaskType.TODO)) {
            taskLine += TEXT_DIVIDER;
            taskLine += task.getDetails();
        }
        taskLine += NEW_LINE;
        return taskLine;
    }

    /**
     * Loads text file of fileName to populate taskArrayList
     *
     * @return taskArrayList
     * @throws FileNotFoundException
     */
    public ArrayList<Task> loadTextFile() throws FileNotFoundException {
        File inputFile = new File(fileName);
        Scanner fileScanner = new Scanner(inputFile);
        ArrayList<Task> taskArrayList = new ArrayList<>();
        String inputLine;
        String[] processedLine;
        String taskType;
        String isDone;
        String description;
        String timeDetails = "";
        Task newTaskToAdd = null;

        try {
            while (fileScanner.hasNextLine()) {
                inputLine = fileScanner.nextLine();
                processedLine = inputLine.split(TEXT_DIVIDER_REGEX);
                taskType = processedLine[0];
                isDone = processedLine[1];
                description = processedLine[2];

                if (processedLine.length == 4) {
                    timeDetails = processedLine[3];
                }

                switch (taskType) {
                case TODO_SYMBOL:
                    newTaskToAdd = new ToDo(description);
                    break;
                case EVENT_SYMBOL:
                    newTaskToAdd = new Event(description, timeDetails);
                    break;
                case DEADLINE_SYMBOL:
                    LocalDate deadlineDate = LocalDate.parse(timeDetails);
                    newTaskToAdd = new Deadline(description, deadlineDate);
                    break;
                default:
                    //Task Type Error
                    break;
                }
                if (isDone.equals("1")) {
                    newTaskToAdd.setTaskDone(true);
                }
                taskArrayList.add(newTaskToAdd);
            }
            return taskArrayList;
        } catch (DateTimeParseException e) {
            printErrorMessage(ERROR_DATE_FORMAT);
        }
        System.out.println(ERROR_LOADING_TEXT_FILE);
        return taskArrayList;
    }
}

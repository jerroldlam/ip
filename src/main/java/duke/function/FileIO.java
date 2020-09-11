package duke.function;

import duke.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    private final String EVENT_SYMBOL = "[E]";
    private final String TODO_SYMBOL = "[T]";
    private final String DEADLINE_SYMBOL = "[D]";
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

    public void saveAsTextFile (ArrayList<Task> taskArrayList) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        String inputToWrite = "";

        for (Task task : taskArrayList) {
            inputToWrite += task.getTaskSymbol();
            inputToWrite += " | ";
            inputToWrite += (task.isTaskDone()) ? "1" : "0";
            inputToWrite += " | ";
            inputToWrite += task.getTaskName();
            if (!task.getTaskType().equals(TaskType.TODO)) {
                inputToWrite += " | ";
                inputToWrite += task.getDetails();
            }
            inputToWrite += "\n";
        }
        fw.write(inputToWrite);
        fw.close();
    }

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

        while (fileScanner.hasNextLine()) {
            inputLine = fileScanner.nextLine();
            processedLine = inputLine.split(" \\| ");
            taskType = processedLine[0];
            isDone = processedLine[1];
            description = processedLine[2];

            if (processedLine.length == 4)
            {
                timeDetails = processedLine[3];
            }

            switch (taskType) {
            case TODO_SYMBOL:
                newTaskToAdd = new ToDo(description);
                break;
            case EVENT_SYMBOL:
                newTaskToAdd = new Event(description,timeDetails);
                break;
            case DEADLINE_SYMBOL:
                newTaskToAdd = new Deadline(description,timeDetails);
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
    }
}

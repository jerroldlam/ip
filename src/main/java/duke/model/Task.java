package duke.model;

/**
 * Represents a task to be stored. This object can store the name of the task as a string and the completion status
 * of the task as a boolean. A true boolean result indicates the task is completed, while a false boolean result
 * indicates an incomplete task.
 */
public abstract class Task {
    private final String DONE_SYMBOL = "[✓]";
    private final String UNDONE_SYMBOL = "[✗]";
    private String taskName;
    private boolean taskDone;

    public Task(String taskName) {
        setTaskName(taskName);
        setTaskDone(false);
    }

    public abstract String getTaskSymbol();

    public abstract TaskType getTaskType();

    public abstract String getDetails();

    public String getTaskName() {
        return taskName;
    }

    public String getDoneSymbol() {
        if (this.isTaskDone()) {
            return DONE_SYMBOL;
        } else {
            return UNDONE_SYMBOL;
        }
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isTaskDone() {
        return taskDone;
    }

    public void setTaskDone(boolean taskDone) {
        this.taskDone = taskDone;
    }

    @Override
    public String toString() {
        return getDoneSymbol() + " " +  getTaskName();
    }
}

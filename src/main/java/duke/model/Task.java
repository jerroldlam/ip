package duke.model;

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

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isTaskDone() {
        return taskDone;
    }

    public void setTaskDone(boolean taskDone) {
        this.taskDone = taskDone;
    }

    public String getDoneSymbol() {
        if (this.isTaskDone()) {
            return DONE_SYMBOL;
        } else {
            return UNDONE_SYMBOL;
        }
    }



    @Override
    public String toString() {
        return getDoneSymbol() + " " +  getTaskName();
    }
}

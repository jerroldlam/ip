package duke.model;

/**
 * Represents a subclass of task.
 */
public class ToDo extends Task {
    private final String TODO_SYMBOL = "[T]";

    public ToDo(String taskName) {
        super(taskName);
    }

    @Override
    public String getTaskSymbol() {
        return TODO_SYMBOL;
    }

    @Override
    public TaskType getTaskType() {
        return TaskType.TODO;
    }

    @Override
    public String getDetails() {
        return "";
    }

    @Override
    public String toString() {
        return TODO_SYMBOL + super.toString();
    }
}

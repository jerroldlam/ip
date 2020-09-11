package duke.model;

public class Deadline extends Task {
    private final String DEADLINE_SYMBOL = "[D]";
    private String deadlineBy;

    public Deadline(String taskName,String deadlineBy) {
        super(taskName);
        setDeadlineBy(deadlineBy);
    }

    public String getDeadlineBy() {
        return deadlineBy;
    }

    public void setDeadlineBy(String deadlineBy) {
        this.deadlineBy = deadlineBy;
    }

    @Override
    public String getTaskSymbol() {
        return DEADLINE_SYMBOL;
    }

    @Override
    public TaskType getTaskType() {
        return TaskType.DEADLINE;
    }

    @Override
    public String getDetails() {
        return getDeadlineBy();
    }

    @Override
    public String toString() {
        return DEADLINE_SYMBOL + super.toString() + " (by: " + getDeadlineBy() + ")";
    }
}

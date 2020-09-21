package duke.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represent a subclass of Task, called Deadline. It extends task by storing the deadline of the task in a LocalDate
 * format.
 */
public class Deadline extends Task {
    private final String DEADLINE_SYMBOL = "[D]";
    private LocalDate deadlineBy;

    public Deadline(String taskName,LocalDate deadlineBy) {
        super(taskName);
        setDeadlineBy(deadlineBy);
    }

    public LocalDate getDeadlineBy() {
        return deadlineBy;
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
        return getDeadlineBy().toString();
    }

    public void setDeadlineBy(LocalDate deadlineBy) {
        this.deadlineBy = deadlineBy;
    }

    @Override
    public String toString() {
        return DEADLINE_SYMBOL + super.toString() + " (by: " +
                getDeadlineBy().format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}

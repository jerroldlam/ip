package duke.model;

public class Event extends Task {
    private final String EVENT_SYMBOL = "[E]";
    private String period;

    public Event(String taskName,String period) {
        super(taskName);
        setPeriod(period);
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String getTaskSymbol() {
        return EVENT_SYMBOL;
    }

    @Override
    public TaskType getTaskType() {
        return TaskType.EVENT;
    }

    @Override
    public String getDetails() {
        return getPeriod();
    }

    @Override
    public String toString() {
        return EVENT_SYMBOL + super.toString() + " (at: " + getPeriod() + ")";
    }
}

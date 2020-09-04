package duke.model;

public class ToDo extends Task {
    private final String TODO_SYMBOL = "[T]";

    public ToDo(String taskName) {
        super(taskName);
    }

    @Override
    public String toString() {
        return TODO_SYMBOL + super.toString();
    }
}

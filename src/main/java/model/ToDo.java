package model;

public class ToDo extends Task {
    private final String TODO_SYMBOL = "[T]";

    public ToDo(String taskName) {
        super(taskName);
    }

    @Override
    public void printTask() {
        System.out.print(TODO_SYMBOL);
        super.printTask();
        System.out.print("\n");
    }
}

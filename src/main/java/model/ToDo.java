package model;

public class ToDo extends Task {
    public ToDo(String taskName) {
        super(taskName);
    }

    @Override
    public void printTask() {
        System.out.print("[T]");
        super.printTask();
    }
}

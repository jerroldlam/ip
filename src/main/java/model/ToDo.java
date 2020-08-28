package model;

import model.Task;

public class ToDo extends Task {
    public ToDo(String taskName) {
        super(taskName);
    }

    @Override
    public void printTask() {
        System.out.print("[T]");
        super.printTask();
        System.out.print("\n");
    }
}

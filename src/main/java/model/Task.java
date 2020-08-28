package model;

public class Task {
    private String taskName;
    private boolean taskDone;

    public Task(String taskName) {
        setTaskName(taskName);
        setTaskDone(false);
    }

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
        String symbol;
        if (this.isTaskDone()) {
            symbol ="[✓]";
        } else {
            symbol = "[✗]";
        }
        return symbol;
    }

    public void printTask() {
        System.out.print(getDoneSymbol() + this.getTaskName());
    }
}

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

    public void printTask() {
        if (this.isTaskDone()) {
            System.out.print("[✓]");
        } else {
            System.out.print("[✗]");
        }
        System.out.print(this.getTaskName());
    }
}

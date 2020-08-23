package model;

/**
 * Class Task that stores the name of the task as a string and whether the task is done
 *
 * @param String taskName stores name of the task
 * @param boolean taskDone stores if the task is completed
 */
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
}

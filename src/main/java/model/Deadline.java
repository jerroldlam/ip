package model;

public class Deadline extends Task {
    protected String deadlineBy;

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
    public void printTask() {
        System.out.print("[D]");
        super.printTask();
        System.out.print("(by: " + getDeadlineBy() + ")" + "\n");
    }
}

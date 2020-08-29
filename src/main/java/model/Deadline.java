package model;

public class Deadline extends Task {
    private final String DEADLINE_SYMBOL = "[D]";
    private String deadlineBy;

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
        System.out.print(DEADLINE_SYMBOL);
        super.printTask();
        System.out.print("(by: " + getDeadlineBy() + ")" + "\n");
    }
}

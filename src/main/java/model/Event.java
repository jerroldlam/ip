package model;

public class Event extends Task {
    protected String period;

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
    public void printTask() {
        System.out.print("[E]");
        super.printTask();
        System.out.print("(at: " + getPeriod() + ")");
    }
}

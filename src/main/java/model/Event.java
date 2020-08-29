package model;

public class Event extends Task {
    private final String EVENT_SYMBOL = "[E]";
    private String period;

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
        System.out.print(EVENT_SYMBOL);
        super.printTask();
        System.out.print("(at: " + getPeriod() + ")" +"\n");
    }
}

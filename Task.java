public class Task {
    private String description;
    private boolean isCompleted;
    private Task next;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
        this.next = null;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public Task getNext() {
        return next;
    }

    public void setNext(Task next) {
        this.next = next;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description + " - " + (isCompleted ? "Completed" : "Pending");
    }
}

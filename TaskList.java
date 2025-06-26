public class TaskList {
    private Task head;
    private int size;

    public TaskList() {
        this.head = null;
        this.size = 0;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);

        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newTask);
        }
        size++;
        System.out.println("Task added: " + description);
    }

    public boolean markTaskCompleted(String description) {
        Task current = head;

        while (current != null) {
            if (current.getDescription().equalsIgnoreCase(description)) {
                current.markCompleted();
                System.out.println("Task marked as completed: " + description);
                return true;
            }
            current = current.getNext();
        }
        System.out.println("Task not found: " + description);
        return false;
    }

    public void printAllTasks() {
        if (head == null) {
            System.out.println("  No tasks found.");
            return;
        }

        Task current = head;
        int taskNumber = 1;

        while (current != null) {
            System.out.println("  " + taskNumber + ". " + current.toString());
            current = current.getNext();
            taskNumber++;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class TaskList {
    private String ownerName;
    private Task head;
    private int size;

    public TaskList(String ownerName) {
        this.ownerName = ownerName;
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
        System.out.println("Task added: " + description + " --- for user: " + ownerName);
    }

    public boolean markTaskCompleted(String description) {
        Task current = head;

        while (current != null) {
            if (current.getDescription().equalsIgnoreCase(description)) {
                current.markCompleted();
                System.out.println("\nTask marked as completed: " + description + " --- belonging to: " + ownerName);
                return true;
            }
            current = current.getNext();
        }
        System.out.println("Task not found: " + description);
        return false;
    }

    public int countCompletedTasks() {
        int count = 0;
        Task current = head;
        while (current != null) {
            if (current.isCompleted()) count++;
            current = current.getNext();
        }
        return count;
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

    public Task getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

public class User {
    private String name;
    private TaskList todoList;

    public User(String name) {
        this.name = name;
        this.todoList = new TaskList(name);
    }

    public void addTask(String description) {
        todoList.addTask(description);
    }

    public boolean markTaskCompleted(String description) {
        return todoList.markTaskCompleted(description);
    }

    public void printAllTasks() {
        System.out.println("\n=== " + name + "'s To-Do List ===");
        todoList.printAllTasks();
        System.out.println("\nTotal tasks: " + todoList.getSize());
    }

    public String getName() {
        return name;
    }

    public TaskList getTodoList() {
        return todoList;
    }

    public void printTaskDescriptionsOnly() {
        Task current = todoList.getHead();
        int count = 1;

        if (current == null) {
            System.out.println("  (no tasks found)");
            return;
        }

        while (current != null) {
            System.out.println("  " + count + ". " + current.getDescription());
            current = current.getNext();
            count++;
        }
    }

}

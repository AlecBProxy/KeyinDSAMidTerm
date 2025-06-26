public class User {
    private String name;
    private TaskList todoList;

    public User(String name) {
        this.name = name;
        this.todoList = new TaskList();
    }

    public void addTask(String description) {
        todoList.addTask(description);
    }

    // Mark a task as completed in this user's to-do list
    public boolean markTaskCompleted(String description) {
        return todoList.markTaskCompleted(description);
    }

    public void printAllTasks() {
        System.out.println("\n=== " + name + "'s To-Do List ===");
        todoList.printAllTasks();
        System.out.println("Total tasks: " + todoList.getSize());
    }

    public String getName() {
        return name;
    }

    public TaskList getTodoList() {
        return todoList;
    }
}

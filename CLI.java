import java.util.Scanner;

public class CLI {
    private static final int MAX_USERS = 10;
    private static User[] users = new User[MAX_USERS];
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("===   To-Do List CLI Manager ===");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new user");
            System.out.println("2. Add a task to a user");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. View a user's tasks");
            System.out.println("5. View all users and task stats");
            System.out.println("6. Exit");

            System.out.print("> ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.print("\nEnter new username: ");
                    String newUser = scanner.nextLine();
                    createUser(newUser);
                    break;

                case "2":
                    displayUserList();
                    System.out.print("Enter username to add task to: ");
                    String userAdd = scanner.nextLine();
                    User uAdd = findUser(userAdd);
                    if (uAdd != null) {
                        System.out.print("Enter task description: ");
                        String taskDesc = scanner.nextLine();
                        uAdd.addTask(taskDesc);
                    } else {
                        System.out.println("\nUser not found.");
                    }
                    break;

                case "3":
                    displayUserList();
                    System.out.print("Enter username to mark task completed: ");
                    String userComplete = scanner.nextLine();
                    User uComplete = findUser(userComplete);
                    if (uComplete != null) {
                        System.out.println("\nUser's tasks:");
                        uComplete.printTaskDescriptionsOnly();

                        System.out.print("Enter task description to mark complete: ");
                        String taskToMark = scanner.nextLine();
                        uComplete.markTaskCompleted(taskToMark);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case "4":
                    displayUserList();
                    System.out.print("Enter username to view tasks: ");
                    String userView = scanner.nextLine();
                    User uView = findUser(userView);
                    if (uView != null) {
                        uView.printAllTasks();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case "5":
                    printStats();
                    break;

                case "6":
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    public static boolean createUser(String name) {
        if (userCount >= MAX_USERS) {
            System.out.println("Cannot create user: Max users reached.");
            return false;
        }

        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                System.out.println("User already exists.");
                return false;
            }
        }

        users[userCount++] = new User(name);
        System.out.println("User created: " + name);
        return true;
    }

    public static User findUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null;
    }

    public static void displayUserList() {
        System.out.println("\nCurrent Users:");
        if (userCount == 0) {
            System.out.println("  (none yet)");
        } else {
            for (int i = 0; i < userCount; i++) {
                System.out.println("  - " + users[i].getName());
            }
        }
    }

    public static void printStats() {
        System.out.println("\nStats:");
        int totalTasks = 0;
        int completedTasks = 0;

        for (int i = 0; i < userCount; i++) {
            TaskList tasks = users[i].getTodoList();
            int size = tasks.getSize();
            int completed = tasks.countCompletedTasks();
            System.out.println("• " + users[i].getName() + ": " + size + " tasks (" + completed + " completed)");
            totalTasks += size;
            completedTasks += completed;
        }

        System.out.println("\nTotal users: " + userCount);
        System.out.println("Total tasks: " + totalTasks);
        System.out.println("Completed tasks: " + completedTasks);
    }
}

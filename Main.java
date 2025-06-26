public class Main {
    private static final int MAX_USERS = 10;
    private static User[] users = new User[MAX_USERS]; // Array to store users
    private static int userCount = 0;

    public static void main(String[] args) {
        System.out.println("=== To-Do List Manager ===\n");

        // Create users and add them to the array
        createUser("Alec");
        createUser("Alan");
        createUser("Alice");

        System.out.println("\n--- Adding Tasks ---");

        // Test set data
        addTaskToUser("Alec", "Buy groceries");
        addTaskToUser("Alec", "Walk the dog");
        addTaskToUser("Alec", "Finish sprint work");

        addTaskToUser("Alan", "Call mom");
        addTaskToUser("Alan", "Fix bicycle");

        addTaskToUser("Alice", "Log work items in journal");
        addTaskToUser("Alice", "Practice drums");
        addTaskToUser("Alice", "Debug branch");

        System.out.println("\n--- Initial Task Lists ---");
        printAllUserTasks();

        System.out.println("\n--- Marking Tasks as Completed ---");

        markUserTaskCompleted("Alice", "Practice drums");
        markUserTaskCompleted("Alice", "Debug branch");
        markUserTaskCompleted("Alan", "Fix bicycle");
        markUserTaskCompleted("Alec", "Walk the dog");

        // Try to mark a non-existent task (to demonstrate error handling)
        markUserTaskCompleted("Alice", "Non-existent task");

        System.out.println("\n--- Updated Task Lists ---");
        printAllUserTasks();

        System.out.println("\n--- Program Information ---");
        printProgramInformation();
    }

    public static boolean createUser(String name) {
        if (userCount >= MAX_USERS) {
            System.out.println("Cannot create user: Maximum user limit reached");
            return false;
        }

        // Check if user already exists
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                System.out.println("User already exists: " + name);
                return false;
            }
        }

        users[userCount] = new User(name);
        userCount++;
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

    public static boolean addTaskToUser(String userName, String taskDescription) {
        User user = findUser(userName);
        if (user != null) {
            user.addTask(taskDescription);
            return true;
        } else {
            System.out.println("User not found: " + userName);
            return false;
        }
    }

    public static boolean markUserTaskCompleted(String userName, String taskDescription) {
        User user = findUser(userName);
        if (user != null) {
            return user.markTaskCompleted(taskDescription);
        } else {
            System.out.println("User not found: " + userName);
            return false;
        }
    }

    public static void printAllUserTasks() {
        if (userCount == 0) {
            System.out.println("No users found.");
            return;
        }

        for (int i = 0; i < userCount; i++) {
            users[i].printAllTasks();
        }
    }

    public static void printProgramInformation() {
        System.out.println("Total users: " + userCount);

        int totalTasks = 0;

        // Revisit for further development
        int completedTasks = 0;

        for (int i = 0; i < userCount; i++) {
            TaskList userTasks = users[i].getTodoList();
            totalTasks += userTasks.getSize();

            System.out.println(users[i].getName() + " has " + userTasks.getSize() + " tasks");
        }

        System.out.println("Total tasks across all users: " + totalTasks);
    }
}
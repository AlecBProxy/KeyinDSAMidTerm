#  To-Do List Manager (Java)

This project is a simple To-Do List Manager that demonstrates the use of **arrays** and **singly linked lists** in Java. Each user has their own to-do list of tasks stored as a linked list, allowing for dynamic task management per user.

---

##  How to Use

There are **two ways** to run the program:

### 1. `Main.java` – Demo Mode
Runs a scripted version of the application that:
- Creates sample users
- Adds predefined tasks
- Marks a few tasks as complete
- Prints out user and task statistics

Optimal for evaluating and quickly showing that the program works.

---

### 2. `CLI.java` – Interactive Mode
Runs an interactive Command-Line Interface that lets you:
- Create users
- Add tasks to specific users
- Mark specific tasks as completed
- View tasks by user
- View global stats

Optimal for trying the program yourself, testing edge cases, or demoing features live.

---

## Why Linked Lists?

This project uses **singly linked lists** to store each user's tasks. Here's why that's important:

- Tasks can be added dynamically without worrying about array resizing.
- Efficient sequential traversal is used when printing, marking complete, or adding a task.

### Structure:
- `User[]` (array of users)
  - Each `User` has a `TaskList` (singly linked list)
    - Each `Task` node contains a description, completion status, and a pointer to the next task.

---

## Classes Summary

| Class       | Responsibility |
|-------------|----------------|
| `Main`      | Hardcoded test run |
| `CLI`       | * Additional interactive menu-based interface |
| `User`      | Stores name and task list |
| `Task`      | Represents a task (with next node) |
| `TaskList`  | Manages the linked list logic (add, complete, print) |

---

## Features Implemented

- [x] Create users and store them in an array
- [x] Ensure usernames are unique
- [x] Add tasks to a user's linked list
- [x] Mark tasks as completed
- [x] Print all tasks with completion status
- [x] Optional CLI interface for interactive use
- [x] Task and user statistics reporting

---

## Notes

- The program has a cap of 10 users for simplicity.
- All task interactions rely on **exact string matches** for descriptions.
- Error handling is included for user and task lookup.

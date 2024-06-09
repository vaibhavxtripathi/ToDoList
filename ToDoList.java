import java.util.Scanner;
import java.util.ArrayList;


public class ToDoList {
    static ArrayList<String> todolist = new ArrayList<>();
    static ArrayList<ArrayList<String>> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Todo list");
            System.out.println("choice");
            System.out.println("1. create todo list");
            System.out.println("2. use todo list");
            System.out.println("3. remove todo list");
            System.out.println("4. quit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    use();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void create() {
        System.out.print("Give name: ");
        String name = sc.nextLine();
        todolist.add(name);
        ArrayList<String> task_list = new ArrayList<>();
        System.out.print("Add a task: ");
        String task = sc.nextLine();
        task_list.add(task);
        tasks.add(task_list);

        spec_list(todolist.size() - 1);
    }

    public static void use() {
        if (todolist.isEmpty()) {
            System.out.println("No To-Do Lists found!");
            return;
        }

        System.out.println("Available todo lists:");
        for (int i = 0; i< todolist.size(); i++) {
            System.out.println((i + 1) + ". " + todolist.get(i));
        }

        System.out.print("Choose list number: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();  

        if (index < 0 || index >= todolist.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        spec_list(index);
    }

    public static void spec_list(int index) {
        ArrayList<String> sel_tasks = tasks.get(index);

        while (true) {
            System.out.println("choice");
            System.out.println("1. add task");
            System.out.println("2. remove task");
            System.out.println("3. mark as completed ✅");
            System.out.println("4. quit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Add a task: ");
                    String task = sc.nextLine();
                    sel_tasks.add(task);
                    break;
                case 2:
                    if (sel_tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                        break;
                    }
                    System.out.println("List of tasks:");
                    for (int i = 0; i < sel_tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + sel_tasks.get(i));
                    }
                    System.out.print("Choose task number to remove: ");
                    int task_index = sc.nextInt() - 1;
                    sc.nextLine();  

                    if (task_index < 0 || task_index >= sel_tasks.size()) {
                        System.out.println("Invalid choice!");
                    } 
                    else {
                        System.out.println("Task removed!");
                        sel_tasks.remove(task_index);
                    }
                    break;
                case 3:
                    if (sel_tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                        break;
                    }
                    System.out.println("List of tasks:");
                    for (int i = 0; i < sel_tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + sel_tasks.get(i));
                    }
                    System.out.print("Choose task number to mark as completed: ");
                    int index1 = sc.nextInt() - 1;
                    sc.nextLine();  
                    if (index1 < 0 || index1 >= sel_tasks.size()) {
                        System.out.println("Invalid choice!");
                    } else {
                        System.out.println("Task marked as completed.");
                        sel_tasks.remove(index1);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void remove() {
        if (todolist.isEmpty()) {
            System.out.println("No todo lists available.");
            return;
        }

        System.out.println("List of todo lists:");
        for (int i = 0; i < todolist.size(); i++) {
            System.out.println((i + 1) + ". " + todolist.get(i));
        }

        System.out.print("Choose list number to remove: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();  

        if (index < 0 || index >= todolist.size()) {
            System.out.println("Invalid choice!");
        } else {
            todolist.remove(index);
            tasks.remove(index);
            System.out.println("Todo list removed.");
        }
    }
}

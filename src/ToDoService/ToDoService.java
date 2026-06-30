package ToDoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ToDoService {
    public static List<Task> tasks = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();
    private final Scanner sc;

    public ToDoService(Scanner sc) {
        this.sc = sc;
    }

    public Task addTask(Category category) {

        System.out.print("Task Title:-");
        String title = sc.nextLine();
        System.out.println();
        System.out.print("description:-");
        String description = sc.nextLine();
        System.out.print("dueDate:-");
        LocalDate dueDate = LocalDate.parse(sc.nextLine());
        Status status = null;
        Status[] statuses = Status.values();
        while (true) {
            System.out.println("Choose Status");

            for (int i = 0; i < statuses.length; i++) {
                System.out.println((i + 1) + ". " + statuses[i]);
            }
            int choice = sc.nextInt();
            if (0 <= (choice - 1) && (choice - 1) < Status.values().length) {
                status = Status.values()[choice - 1];
                break;
            }
            System.out.println("Enter a valid status");
        }

        Task task = new Task(title, description, dueDate, category, status);
        return task;
    }


    public static void showTask(List<Task> tasks) {
        int index = 0;
        for (Task t : tasks) {
            System.out.println((index + 1) + ":-" + t);
            index++;
        }
    }


    public static void removeTask(Scanner sc) {

        while (true) {
            System.out.println("Choose the task to remove");
            ToDoService.showTask(ToDoService.tasks);
            int choice = sc.nextInt();
            if (0 <= (choice - 1) && (choice - 1) < tasks.size()) {
                tasks.remove(choice - 1);
                break;
            }
            System.out.println("Enter a valid choice!!!!!");
        }
        System.out.println("Task removed....👍");


    }

    public static void createCategory(Scanner sc){

        System.out.println("Enter the new category name");
        String category = sc.nextLine();
        categories.add(new Category(category));
    }
    public static void showCategory(Scanner sc){
        if(categories.isEmpty()) {
            System.out.println("First add category then create task");
            ToDoService.createCategory(sc);
        }
        int index = 0;
        for (Category c : categories) {
            System.out.println((index + 1) + ":-" + c);
            index++;
        }
    }

    public static void sortDueDate(){
//        System.out.print("Enter the due date:-");
//        LocalDate dueDate=LocalDate.parse(sc.nextLine());
        Comparator <Task> com = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getDueDate().isAfter(o2.getDueDate())?1:-1;
            }
        };
        tasks.sort(com);
        showTask(tasks);
    }


    public static void sortCategory() {

        Comparator<Task> com = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getCategory()
                        .getName()
                        .compareToIgnoreCase(
                                o2.getCategory().getName()
                        );
            }
        };

        tasks.sort(com);
        showTask(tasks);
    }


    public static void sortStatus() {

        Comparator<Task> com = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getStatus().compareTo(o2.getStatus());
            }
        };

        tasks.sort(com);
        showTask(tasks);

    }

    public static void filterByCategory(Scanner sc) {

        if (tasks.isEmpty()) {
            System.out.println("No Tasks Available.");
            return;
        }

        System.out.println("Choose Category");
        showCategory(sc);

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > categories.size()) {
            System.out.println("Invalid Choice");
            return;
        }

        Category selectedCategory = categories.get(choice - 1);

        List<Task> filteredTasks = tasks.stream()
                .filter(task -> task.getCategory()
                        .getName()
                        .equalsIgnoreCase(selectedCategory.getName()))
                .toList();

        if (filteredTasks.isEmpty()) {
            System.out.println("No Tasks Found.");
        } else {
            showTask(filteredTasks);
        }
    }

    public static void filterByStatus(Scanner sc) {

        if (tasks.isEmpty()) {
            System.out.println("No Tasks Available.");
            return;
        }

        Status[] statuses = Status.values();

        System.out.println("Choose Status");

        for (int i = 0; i < statuses.length; i++) {
            System.out.println((i + 1) + ". " + statuses[i]);
        }

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > statuses.length) {
            System.out.println("Invalid Choice");
            return;
        }

        Status selectedStatus = statuses[choice - 1];

        List<Task> filteredTasks = tasks.stream()
                .filter(task -> task.getStatus() == selectedStatus)
                .toList();

        if (filteredTasks.isEmpty()) {
            System.out.println("No Tasks Found.");
        } else {
            showTask(filteredTasks);
        }
    }
}



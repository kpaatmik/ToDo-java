import ToDoService.ToDoService;
import ToDoService.Category;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to ToDo service");
    ToDoService toDo = new ToDoService(sc);
    while(true) {
        System.out.println("1.Add Task");
        System.out.println("2.Remove Task");
        System.out.println("3.Show Tasks");
        System.out.println("4.Add category");
        System.out.println("5 Sort Task");
        System.out.println("6. Filter Task");
        System.out.print("choose the service you want:-");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice) {
            case 1:
                Category category;
                while (true) {
                    System.out.println("Choose the category");
                    ToDoService.showCategory(sc);
                    int catchoice = sc.nextInt();
                    sc.nextLine();
                    if (0 <= (catchoice - 1) && (catchoice - 1) < ToDoService.categories.size()) {
                        category = ToDoService.categories.get(catchoice - 1);
                        break;
                    }
                    System.out.println("Enter a valid choice!!!!!");
                }

                ToDoService.tasks.add(toDo.addTask(category));
                System.out.println("Task added sucessfully😉😉......");
                break;

            case 2:
                ToDoService.removeTask(sc);
                break;
            case 3:
                ToDoService.showTask(ToDoService.tasks);
                break;
            case 4:
                ToDoService.createCategory(sc);
                break;
            case 5:

                while (true) {

                    System.out.println("\nSort Tasks By");
                    System.out.println("1. Due Date");
                    System.out.println("2. Category");
                    System.out.println("3. Status");
                    System.out.println("4. Back");

                    System.out.print("Enter your choice: ");

                    int sortChoice = sc.nextInt();
                    sc.nextLine();

                    switch (sortChoice) {

                        case 1:
                            ToDoService.sortDueDate();
                            break;

                        case 2:
                            ToDoService.sortCategory();
                            break;

                        case 3:
                            ToDoService.sortStatus();
                            break;

                        case 4:
                            break;

                        default:
                            System.out.println("Invalid Choice");
                            continue;
                    }

                    if (sortChoice == 4) {
                        break;
                    }
                }

                break;
            case 6:

                while (true) {

                    System.out.println("\nFilter Tasks By");
                    System.out.println("1. Category");
                    System.out.println("2. Status");
                    System.out.println("3. Back");

                    System.out.print("Enter your choice: ");

                    int filterChoice = sc.nextInt();
                    sc.nextLine();

                    switch (filterChoice) {

                        case 1:
                            ToDoService.filterByCategory(sc);
                            break;

                        case 2:
                            ToDoService.filterByStatus(sc);
                            break;

                        case 3:
                            break;

                        default:
                            System.out.println("Invalid Choice");
                            continue;
                    }

                    if (filterChoice == 3) {
                        break;
                    }
                }

                break;
            default:
                System.out.println("Enter a valid service option🤷‍♂️🤷‍♂️🤷‍♂️🤷‍♂️......");



        }
    }

    }
}
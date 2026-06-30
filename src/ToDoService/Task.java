package ToDoService;

import java.time.*;
public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private Category category;
    private Status status;

    public Task() {
    }

    public Task(String title, String description, LocalDate dueDate, Category category, Status status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", category=" + category +
                ", status=" + status +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public Status getStatus() {
        return status;
    }
}

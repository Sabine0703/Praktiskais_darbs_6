package com.company;

public class ToDoItem {

    private String description;
    private Priority priority;
    public boolean completed;

    ToDoItem(String description, Priority priority, boolean completed) {
        this.description = description;
        this.priority = priority;
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean getCompleted() { return completed; }

    public boolean markCompletion(boolean completed) {
        this.completed = completed;
        return completed;
    }

    @Override
    public String toString() {
        String completedValue = (completed == true)?"Yes":"No";
        return "ToDoItem[ " +
                "Description: '" + description + '\'' +
                ", Priority: " + priority +
                ", Completed: " + completedValue +
                " ]";
    }
}

package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class ToDoItems {
    public String title;
    private List<ToDoItem> toDoItems = new ArrayList<>();

    public void addToDoItem(ToDoItem toDoItem){
        this.toDoItems.add(toDoItem);
    }

    public void displayItems(){
        System.out.println("#################### ToDo List ####################");
        System.out.println("\"" + this.title + "\"");
        for( int i = 0; i < this.toDoItems.size(); i++ )
        {
            ToDoItem item = this.toDoItems.get(i);
            int itemNumber = i + 1;
            String completedItem = "No";
            if(item.completed)
            {
                completedItem = "Yes";
            }
            System.out.println(itemNumber + ": " + item.getDescription() + " " + item.getPriority() + " ( Completed: " + completedItem + ")");
        }
        System.out.println("####################################################");
    }

    public void displayCompletedItems(){
        System.out.println("################ Completed ToDo Items ################");
        for( int i=0; i < this.toDoItems.size(); i++)
        {
            ToDoItem oneItem = this.toDoItems.get(i);

            if(oneItem.getCompleted()) {
                System.out.println(oneItem.toString());
            }
        }
        System.out.println("####################################################");
    }

    public void displayUncompletedItems(){
        System.out.println("################ Uncompleted ToDo Items ################");
        for( int i=0; i < this.toDoItems.size(); i++)
        {
            ToDoItem oneItem = this.toDoItems.get(i);

            if(oneItem.getCompleted() == false) {
                System.out.println(oneItem.toString());
            }
        }
        System.out.println("####################################################");
    }

    public boolean markCompletion(int itemNumber, boolean completed){

        ToDoItem selectedItem = this.toDoItems.get(itemNumber - 1);
        try
        {
            System.out.println(completed);
            selectedItem.markCompletion(completed);
        }
        catch (IndexOutOfBoundsException exc)
        {
            return false;
        }
        System.out.println(selectedItem.toString());
        return true;
    }

    public void sortByPriority(){

        HashMap<Enum, ToDoItem> hashMap = new HashMap<Enum, ToDoItem>();
        for( int i=0; i < this.toDoItems.size(); i++)
        {
            ToDoItem oneItem = this.toDoItems.get(i);
            hashMap.put(oneItem.getPriority(), oneItem);
        }

        // sort from Low -> High
        Collections.sort(toDoItems, Comparator.comparing(ToDoItem::getPriority));

        System.out.println("################ Sorted ToDo Items ################");
        for( int i=0; i < this.toDoItems.size(); i++)
        {
            ToDoItem oneItem = this.toDoItems.get(i);
            System.out.println(oneItem.toString());
        }
        System.out.println("####################################################");
    }
}
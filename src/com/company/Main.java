package com.company;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.company.Priority.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please, enter your \"ToDo list\" name:");
        Scanner scanner = new Scanner(System.in);

        String listName = scanner.nextLine();

        while( listName.equalsIgnoreCase(""))
        {
            System.out.println("Please, enter your \"ToDo list\" name:");
            listName = scanner.nextLine();
        }

        ToDoItems items = new ToDoItems();
        items.title = listName;

        // default 5 items
        ToDoItem item = new ToDoItem("Nomazgāt auto", HIGH, false);
        items.addToDoItem(item);
        ToDoItem item2 = new ToDoItem("Iznest virtuves atkritumus", HIGH, false);
        items.addToDoItem(item2);
        ToDoItem item3 = new ToDoItem("Iztīrīt garāžu", LOW, false);
        items.addToDoItem(item3);
        ToDoItem item4 = new ToDoItem("Izmazgāt logus", LOW, false);
        items.addToDoItem(item4);
        ToDoItem item5 = new ToDoItem("Izsaukt santehniķi", MEDIUM, false);
        items.addToDoItem(item5);

        boolean chooseAction = true;

        while(chooseAction)
        {
            System.out.println();
            System.out.println("Please choose action:");
            System.out.println("1. Add ToDo item");
            System.out.println("2. Mark completion");
            System.out.println("3. Display all ToDo items");
            System.out.println("4. Display all completed ToDo items");
            System.out.println("5. Display all uncompleted ToDo items");
            System.out.println("6. Group by priority and display list");
            System.out.println("**** Enter 'exit' to stop the program.");

            String action = scanner.nextLine();

            switch( action )
            {
                case "1":

                    boolean doAddItem = true;

                    do{
                        System.out.println("Please add description:");
                        String description = scanner.nextLine();

                        System.out.println("Please add priority [LOW, MEDIUM, HIGH]:");
                        Priority priority = null;
                        String enteredPriority = scanner.nextLine();

                        while (!enteredPriority.equalsIgnoreCase("low") && !enteredPriority.equalsIgnoreCase("medium") && !enteredPriority.equalsIgnoreCase("high")) {
                            System.out.println("Please add priority [LOW, MEDIUM, HIGH]:");
                            enteredPriority = scanner.nextLine();
                        }
                        priority = Priority.valueOf(enteredPriority.toUpperCase());

                        ToDoItem addItem = new ToDoItem(description, priority, false);
                        items.addToDoItem(addItem);

                        System.out.println("Add next item? y/n");
                        String answer = scanner.nextLine();

                        if(answer.equalsIgnoreCase("n"))
                        {
                            doAddItem = false;
                        }
                    }
                    while( doAddItem );
                    break;
                case "2":
                    int itemNumber;
                    String completed;
                    boolean completion = false;
                    boolean markedCompleted = false;

                    do{
                        System.out.println("Enter item number:");

                        while(!scanner.hasNextInt())
                        {
                            System.out.println("Enter item number:");
                            scanner.nextLine();
                        }
                        itemNumber = scanner.nextInt();
                        scanner.nextLine(); // clear line

                        System.out.println("Enter item completion \"Yes / No\":");
                        completed = scanner.nextLine();

                        while(!completed.equalsIgnoreCase("yes") && !completed.equalsIgnoreCase("no"))
                        {
                            System.out.println("Enter item completion text \"Yes / No\":");
                            completed = scanner.nextLine();
                        }

                        if(completed.equalsIgnoreCase("yes"))
                        {
                            completion = true;
                        }

                        markedCompleted = items.markCompletion(itemNumber, completion);
                    }
                    while(markedCompleted == false);
                    break;
                case "3":
                    items.displayItems();
                    break;
                case "4":
                    items.displayCompletedItems();
                    break;
                case "5":
                    items.displayUncompletedItems();
                    break;
                case "6":
                    items.sortByPriority();
                    break;
                case "exit":
                    //chooseAction = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose action, enter 1 - 6 or 'exit'!");
                    break;
            }
        }
    }
}

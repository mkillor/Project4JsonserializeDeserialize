/*
Benton Amon
Project 3
 */


package com.company.Amon;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Methods

    // Menu
    static void menu() {
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) List all tasks of a certain priority.");
        System.out.println("(0) Exit.");
    }

    // Add a task
    static ArrayList<Item> addATask(ArrayList<Item> a) {
        Scanner input = new Scanner(System.in);
        Item task = new Item();

        System.out.println("Enter the new task's name: ");
        String title = input.nextLine();
        task.setTitle(title);

        System.out.println("Enter the new task's description: ");
        String description = input.nextLine();
        task.setDescription(description);

        System.out.println("Enter the new task's priority: ");
        int priority = input.nextInt();
        if (priority < 0) {
            priority = 0;
        }
        if (priority > 5) {
            priority = 5;
        }
        task.setPriority(priority);

        a.add(task);
        return a;
    }

    // Remove a Task
    static ArrayList<Item> removeTask(ArrayList<Item> a) {

        int b;
        Scanner input = new Scanner(System.in);

        System.out.println("What task would you like to remove?");
        b = input.nextInt();
        a.remove(b);
        return a;
    }

    // Update a Task
    static ArrayList<Item> updateTask(ArrayList<Item> taskList) {

        Scanner input = new Scanner(System.in);
        int editIndex;

        System.out.println("Please enter an index value of task to update: ");
        editIndex = input.nextInt();
        input.nextLine();

        System.out.println("Enter the new task's name: ");
        String newName = input.nextLine();

        System.out.println("Enter the new task's description: ");
        String newDescription = input.nextLine();

        System.out.println("Enter the new task's priority: ");
        int newPriority = input.nextInt();
        input.nextLine();

        Item selectedTask = taskList.get(editIndex);

        taskList.add(new Item(newName, newDescription, newPriority));
        taskList.remove(selectedTask);

        return taskList;
    }

    // Display all tasks
    static void displayAllTasks(ArrayList<Item> taskList) {

        int i=0;
        for(int y=5; y>=0; y--) {
            for (Item a : taskList) {
                if(y == a.getPriority()) {
                    System.out.println("Task Index: " + i + " | " + a);
                    i++;
                }
            }
        }
    }

    // Display all tasks of a certain Priority
    static void displayPriority(ArrayList<Item> taskList) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        int priority;

        System.out.println("Enter a level of priority: ");
        priority = input.nextInt();
        if (priority < 0) {
            priority = 0;
        }
        if (priority > 5) {
            priority = 5;
        }
        for (Item a : taskList) {
            if (priority == a.getPriority()) {
                System.out.println(a);
            }
            i++;
        }
    }

    // Exit the Program
    static void exitProgram() {
        System.exit(0);
    }

    // ------------

    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);

        ArrayList<Item> taskList = new ArrayList<>();
        int i=0; // Use this to set the Task Index
        String userInput = "-1";

        while (!userInput.equals("0")) {
            Scanner input = new Scanner(System.in);
            try {
                menu();
                userInput = input.nextLine();


                switch (userInput) {
                    case "1":
                        addATask(taskList);
                        i++;
                        break;
                    case "2":
                        removeTask(taskList);
                        break;
                    case "3":
                        updateTask(taskList);
                        break;
                    case "4":
                        displayAllTasks(taskList);
                        break;
                    case "5":
                        displayPriority(taskList);
                        break;
                    case "0":
                        exitProgram();
                        break;
                    default:
                        System.out.println("Please enter a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data type, please try again.");

            } catch (Exception e) {
                System.out.println("Something went wrong! Try again.");
            }
        }

    }
}

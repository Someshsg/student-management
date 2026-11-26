package com.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Search Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                while (!sc.hasNextInt()) {
                    System.out.print("Please enter a number: ");
                    sc.next();
                }
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> addStudent(sc);
                    case 2 -> viewStudents();
                    case 3 -> searchStudent(sc);
                    case 4 -> deleteStudent(sc);
                    case 5 -> System.out.println("Goodbye!");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 5);
        }
    }

    private static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = readInt(sc);
        if (students.stream().anyMatch(s -> s.getId() == id)) {
            System.out.println("A student with this ID already exists.");
            return;
        }
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter course: ");
        String course = sc.nextLine().trim();
        students.add(new Student(id, name, course));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
    }

    private static void searchStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        int id = readInt(sc);
        students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Student not found."));
    }

    private static void deleteStudent(Scanner sc) {
        System.out.print("Enter student ID: ");
        int id = readInt(sc);
        boolean removed = students.removeIf(s -> s.getId() == id);
        System.out.println(removed ? "Student deleted." : "Student not found.");
    }

    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }
}

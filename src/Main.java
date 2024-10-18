import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement(5);

        while (true){
            System.out.println("\nStudent Management Menu: ");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Sort Student by Marks");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option (1-7): ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    // Add student
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = scanner.nextDouble();
                    studentManagement.addStudent(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    // Remove student
                    Student removedStudent = studentManagement.removeStudent();
                    if (removedStudent != null) {
                        System.out.println("Removed student: " + removedStudent);
                    } else {
                        System.out.println("No student to remove.");
                    }
                    break;

                case 3:
                    // Update student marks
                    scanner.nextLine();
                    System.out.print("Enter Student ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();
                    studentManagement.updateStudent(updateId, newMarks);
                    break;

                case 4:
                    // Search student by ID
                    scanner.nextLine();
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student found = studentManagement.searchStudent(searchId);
                    if (found != null) {
                        System.out.println("Found student: " + found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    // Sort students by marks
                    if (studentManagement.isEmpty()){
                        System.out.println("No Students to sort.");
                    }else {
                        studentManagement.sortStudent();
                        System.out.println("Students sorted by marks successfully!");

                        System.out.println("Sorted Students: ");
                        studentManagement.displayStudent();
                    }
                    break;


                case 6:
                    // Display all students
                    System.out.println("All students:");
                    studentManagement.displayStudent();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        }
    }
}
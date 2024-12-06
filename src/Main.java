import java.util.Scanner;

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
                    if (id.isEmpty()) {
                        throw new IllegalArgumentException("Student ID cannot be empty.");
                    }
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) {
                        throw new IllegalArgumentException("Student Name cannot be empty.");
                    }
                    System.out.print("Enter Student Marks: ");
                    double marks = scanner.nextDouble();
                    if (marks < 0 || marks > 10) {
                        throw new IllegalArgumentException("Marks must be between 0 and 10.");
                    }
                    studentManagement.addStudent(new Student(id, name, marks));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    // Remove student
                    System.out.print("Enter Student ID to remove: ");
                    scanner.nextLine();  // Consume newline
                    String removeId = scanner.nextLine();
                    Student removedStudent = studentManagement.searchStudent(removeId);
                    if (removedStudent != null) {
                        studentManagement.removeStudent();
                        System.out.println("Student removed successfully!");
                    }
                    break;

                case 3:
                    // Update student marks
                    System.out.print("Enter Student ID to update: ");
                    scanner.nextLine();  // Consume newline
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();
                    if (newMarks < 0 || newMarks > 10) {
                        throw new IllegalArgumentException("Marks must be between 0 and 10.");
                    }
                    studentManagement.updateStudent(updateId, newMarks);
                    break;

                case 4:
                    // Search student by ID
                    System.out.print("Enter Student ID to search: ");
                    scanner.nextLine();  // Consume newline
                    String searchId = scanner.nextLine();
                    Student foundStudent = studentManagement.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
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
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // Exit the program

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

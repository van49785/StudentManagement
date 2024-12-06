import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class StudentManagement {

    private StudentStack studentStack;

    public StudentManagement(int size) {
        studentStack = new StudentStack(size);
    }



    public void addStudent(Student student) {
        if (studentStack.size() >= studentStack.maxSize) {
            System.out.println("Stack is full. Cannot add more students.");
            return; // Exit without adding the student
        }
        studentStack.push(student);
    }

    public Student removeStudent() {
        if (studentStack.isEmpty()) {
            System.out.println("No student to remove. The stack is empty.");
            return null;
        }
        return studentStack.pop();
    }

    public void updateStudent(String id, double newMark) {
        // temporary store students in an array
        boolean found = false;
        Student[] tempArr = new Student[studentStack.size()];
        int count = 0;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                student.setMarks(newMark); // update mark
                found = true;
            }
            tempArr[count++] = student; // store student in tempArr
        }

        for (int i = count - 1; i >= 0; i--) {
            studentStack.push(tempArr[i]);
        }

        if (found) {
            System.out.println("Student marks updated successfully");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public Student searchStudent(String id) {
        Student[] tempArr = new Student[studentStack.size()];
        int count = 0;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId().equals(id)) {
                // Found the student, push it back to the stack and return it
                for (int i = count - 1; i >= 0; i--) {
                    studentStack.push(tempArr[i]);
                }
                return student; // Return the found student
            }
            tempArr[count++] = student; // Store student in tempArr
        }

        // If not found, restore all students back to the stack
        for (int i = count - 1; i >= 0; i--) {
            studentStack.push(tempArr[i]);
        }
        System.out.println("Student with ID " + id + " not found.");
        return null;
    }

    public void sortStudent(){
        Student[] tempArr = new Student[studentStack.size()];
        int count = 0;

        while(!studentStack.isEmpty()){
            tempArr[count++] = studentStack.pop();
        }

        Arrays.sort(tempArr, Comparator.comparingDouble(Student::getMarks));

        for (int i = count - 1; i >= 0; i--){
            studentStack.push(tempArr[i]);
        }
    }


    public void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(students, low, high);
            quickSort(students, low, pivotIndex - 1);
            quickSort(students, pivotIndex + 1, high);
        }
    }

    private int partition(Student[] students, int low, int high) {
        double pivot = students[high].getMarks();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (students[j].getMarks() < pivot) {
                i++;
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;
        return i + 1;
    }

    public void displayStudent(){
        Student[] tempArr = new Student[studentStack.size()];
        int count = 0;

        while (!studentStack.isEmpty()){
            Student student = studentStack.pop();
            System.out.println(student);
            tempArr[count++] = student;
        }

        for (int i = count - 1; i >= 0; i--){
            studentStack.push(tempArr[i]);
        }
    }

    public boolean isEmpty() {
        return studentStack.isEmpty();
    }

    // Cũ: Sắp xếp sinh viên theo Bubble Sort
    public void bubbleSort(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getMarks() > students[j + 1].getMarks()) {
                    // Swap the students
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // Mới: Phương thức đo thời gian sắp xếp với số lượng học sinh lớn
    public void measureSortTime() {
        int numStudents = 10000;  // Ví dụ số lượng học sinh

        // Tạo sinh viên ngẫu nhiên
        Student[] students = generateRandomStudents(numStudents);

        // Đo thời gian sắp xếp Bubble Sort
        long bubbleStartTime = System.nanoTime();
        bubbleSort(students);  // Chạy Bubble Sort
        long bubbleEndTime = System.nanoTime();
        long bubbleSortDuration = bubbleEndTime - bubbleStartTime;

        // Tạo lại sinh viên ngẫu nhiên cho Quick Sort
        students = generateRandomStudents(numStudents);

        // Đo thời gian sắp xếp Quick Sort
        long quickStartTime = System.nanoTime();
        quickSort(students, 0, students.length - 1);  // Chạy Quick Sort
        long quickEndTime = System.nanoTime();
        long quickSortDuration = quickEndTime - quickStartTime;

        // Hiển thị kết quả
        System.out.println("Bubble Sort Execution Time: " + bubbleSortDuration + " nanoseconds");
        System.out.println("Quick Sort Execution Time: " + quickSortDuration + " nanoseconds");
    }

    private Student[] generateRandomStudents(int numStudents) {
        Random random = new Random();
        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            double marks = 0 + (10 - 0) * random.nextDouble();  // Điểm số từ 0 đến 10
            students[i] = new Student("ID" + i, "Student" + i, marks);
        }
        return students;
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement(10);

//        sm.addStudent(new Student("001", "Alice", 9.0));
//        sm.addStudent(new Student("002", "Bob", 7.5));
//        sm.addStudent(new Student("003", "Charlie", 8.0));
//
//        sm.displayStudent();
//        sm.updateStudent("002", 8.8);
//        sm.displayStudent();
//
//        Student found = sm.searchStudent("002");
//        if (found != null) {
//            System.out.println("Found student: " + found);
//        }

        sm.measureSortTime();
    }

}



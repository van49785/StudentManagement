import java.util.Comparator;
import java.util.Arrays;

public class StudentManagement {

    private StudentStack studentStack;

    public StudentManagement(int size) {
        studentStack = new StudentStack(size);
    }

    public void addStudent(Student student){
        studentStack.push(student);
    }

    public Student removeStudent(){
        return studentStack.pop();
    }

    public void updateStudent(String id, double newMark){
        // temporary store students in an array
        boolean found = false;
        Student[] tempArr = new Student[studentStack.size()];
        int count = 0;

        while (!studentStack.isEmpty()){
            Student student = studentStack.pop();
            if (student.getId().equals(id)){
                student.setMarks(newMark); // update mark
                found = true;
            }
            tempArr[count++] = student; //store student in tempArr
        }

        for (int i = count - 1; i >= 0; i--){
            studentStack.push(tempArr[i]);
        }

        if (found){
            System.out.println("Student marks updated successfully");
        }else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public Student searchStudent(String id){

        Student[] tempArr = new Student[studentStack.size()];
        int count = 0;
        Student studentFound = null;

        while (!studentStack.isEmpty()){
            Student student = studentStack.pop();
            if(student.getId().equals(id)){
                studentFound = student;
            }
            tempArr[count++] = student;
        }

        for (int i = count - 1; i >= 0; i--){
            studentStack.push(tempArr[i]);
        }
        return studentFound;
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

    public boolean isEmpty(){
        return studentStack.isEmpty();
    }
}




























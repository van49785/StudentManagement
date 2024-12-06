public class StudentStack {

    int maxSize;
    private static Student[] stackArray;
    private static int top;

    public StudentStack(int size) {
        this.maxSize = size;
        this.stackArray = new Student[maxSize];
        this.top = -1; // stack is initially empty
    }

    public void push(Student student){

        if(top < maxSize - 1){
            stackArray[++top] = student;
        }
        else {
            System.out.println("Stack is full. Cannot add more students");
        }
    }

    public Student pop(){
        if (top >= 0){
            return stackArray[top--];
        }else {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
    }

    public Student peek(){
        if (top >= 0){
            return stackArray[top];
        }else {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public int size(){
        return top + 1;
    }
}



























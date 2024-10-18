public class Student {

    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public double getMarks() { return marks; }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getRanking(){

        if (marks < 5) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}




























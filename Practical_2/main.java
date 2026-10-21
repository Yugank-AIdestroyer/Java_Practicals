class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person {
    protected int rollNo;
    protected String course;

    public Student(String name, int age, int rollNo, String course) {
        super(name, age);
        this.rollNo = rollNo;
        this.course = course;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Roll No: " + rollNo + ", Course: " + course);
    }
}

class GraduateStudent extends Student {
    private String thesisTopic;

    public GraduateStudent(String name, int age, int rollNo, String course, String thesisTopic) {
        super(name, age, rollNo, course);
        this.thesisTopic = thesisTopic;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("The topic is: " + thesisTopic);
    }
}

class Faculty extends Person {
    private String subject;
    private double salary;

    public Faculty(String name, int age, String subject, double salary) {
        super(name, age);
        this.subject = subject;
        this.salary = salary;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject + ", Salary: " + salary);
    }
}

public class Practical2 {
    public static void main(String[] args) {
        Student s = new Student("Shyam", 20, 101, "B.tech");
        GraduateStudent gs = new GraduateStudent("Ram", 23, 201, "B.tech", "OOPS & Java");
        Faculty f = new Faculty("Dr. Sharma", 42, "Java Programming", 65000.0);

        s.displayInfo();
        gs.displayInfo();
        f.displayInfo();
    }
}

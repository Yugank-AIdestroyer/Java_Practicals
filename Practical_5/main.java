class Course {
    String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }
}

class Student {
    String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public void enroll(Course c) {
        System.out.println(studentName + " is associated with course " + c.courseName);
    }
}

class Teacher {
    String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }
}

class Department {
    String deptName;
    Teacher teacher;

    public Department(String deptName, Teacher teacher) {
        this.deptName = deptName;
        this.teacher = teacher;
    }

    public void showDepartment() {
        System.out.println("Department: " + deptName + ", Teacher: " + teacher.teacherName);
    }
}

class College {
    String collegeName;
    private Department compDept;

    public College(String collegeName, Teacher t) {
        this.collegeName = collegeName;
        this.compDept = new Department("Computer Science", t);
    }

    public void showCollege() {
        System.out.println("College: " + collegeName);
        compDept.showDepartment();
    }
}

public class Practical5 {
    public static void main(String[] args) {
        Course c = new Course("OOPS & Java");
        Student st = new Student("Ankit");
        st.enroll(c);

        Teacher t = new Teacher("Prof. Verma");
        College col = new College("Echleon Institute of Technology", t);
        col.showCollege();

        System.out.println("Association: Student and Course have independent lifecycles.");
        System.out.println("Aggregation: Teacher can exist even if Department is destroyed.");
        System.out.println("Composition: Department is created inside College and dies with College.");
    }
}

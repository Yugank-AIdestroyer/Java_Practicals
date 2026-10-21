 interface Payable {
    double getPaymentAmount();
}

interface Printable {
    void printDetails();
}

abstract class Employee {
    protected int empId;
    protected String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public void showBasicInfo() {
        System.out.println("Employee ID: " + empId + ", Name: " + name);
    }

    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee implements Payable, Printable {
    private double monthlySalary;

    public FullTimeEmployee(int empId, String name, double monthlySalary) {
        super(empId, name);
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary() {
        return monthlySalary;
    }

    public double getPaymentAmount() {
        return calculateSalary();
    }

    public void printDetails() {
        showBasicInfo();
        System.out.println("Full Time Salary: " + getPaymentAmount());
    }
}

class PartTimeEmployee extends Employee implements Payable, Printable {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int empId, String name, int hoursWorked, double hourlyRate) {
        super(empId, name);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    public double getPaymentAmount() {
        return calculateSalary();
    }

    public void printDetails() {
        showBasicInfo();
        System.out.println("Part Time Salary: " + getPaymentAmount());
    }
}

public class Practical4 {
    public static void main(String[] args) {
        FullTimeEmployee fte = new FullTimeEmployee(1, "Neha", 45000.0);
        PartTimeEmployee pte = new PartTimeEmployee(2, "Vikram", 40, 500.0);

        fte.printDetails();
        pte.printDetails();
    }
}

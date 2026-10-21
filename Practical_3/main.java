class Shape {
    public double area(double side) {
        return side * side;
    }

    public double area(double length, double width) {
        return length * width;
    }

    public void draw() {
        System.out.println("Drawing a generic shape");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing Circle with area: " + (3.14 * radius * radius));
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public void draw() {
        System.out.println("Drawing Rectangle with area: " + (length * width));
    }
}

public class Practical3 {
    public static void main(String[] args) {
        Shape baseShape = new Shape();
        System.out.println("Square Area: " + baseShape.area(5.0));
        System.out.println("Rectangle Area: " + baseShape.area(4.0, 6.0));

        Shape s1 = new Circle(3.0);
        Shape s2 = new Rectangle(4.0, 5.0);

        s1.draw();
        s2.draw();
    }
}

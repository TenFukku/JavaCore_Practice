public class Circle extends Shape {
    private double radius;
    private static final double PI = 3.14159;
    
    public Circle(double radius) {
        super(radius * 2, radius * 2); 
        this.radius = radius;
    }
    
    public double getArea() {
        return PI * radius * radius;
    }
    
    public double getCircumference() {
        return 2 * radius * PI;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
        this.width = radius * 2;
        this.height = radius * 2;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Circle - Radius: " + radius + ", Diameter: " + (radius * 2));
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }
} 
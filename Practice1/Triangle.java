public class Triangle extends Shape {
    
    public Triangle(double base, double height) {
        super(base, height);
    }
    
    public double getArea() {
        return (width * height) / 2;
    }
    
    public double getPerimeter() {
        double hypotenuse = Math.sqrt(width * width + height * height);
        return width + height + hypotenuse;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Triangle - Base: " + width + ", Height: " + height);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
} 
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Bài tập 1 ===");
        System.out.println("=== Shape Inheritance Demo ===\n");
        
        // Tạo và hiển thị Shape object
        System.out.println("1. Basic Shape:");
        Shape shape = new Shape(10, 5);
        shape.displayInfo();
        System.out.println();
        
        // Tạo và hiển thị Rectangle object
        System.out.println("2. Rectangle:");
        Rectangle rectangle = new Rectangle(8, 6);
        rectangle.displayInfo();
        System.out.println();
        
        // Tạo và hiển thị Circle object
        System.out.println("3. Circle:");
        Circle circle = new Circle(5);
        circle.displayInfo();
        System.out.println();
        
        // Tạo và hiển thị Triangle object (bonus)
        System.out.println("4. Triangle:");
        Triangle triangle = new Triangle(6, 8);
        triangle.displayInfo();
        System.out.println();
        
        // Minh họa tính đa hình
        System.out.println("=== Minh hoa tinh da hinh ===");
        Shape[] shapes = new Shape[4];
        shapes[0] = new Shape(3, 4);
        shapes[1] = new Rectangle(5, 7);
        shapes[2] = new Circle(3);
        shapes[3] = new Triangle(4, 6);
        
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Shape " + (i + 1) + ":");
            shapes[i].displayInfo();
            System.out.println();
        }
    }
} 
/**
 * Case Study 1: Drawing Shape Factory
 * Reference: Slides 6 & 7 in slide.md
 * 
 * Demonstrates the Factory Method pattern applied to geometric shape creation.
 */

// Product Interface
interface Shape {
    void draw();
}

// Concrete Product 1: Rectangle
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

// Concrete Product 2: Square
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

// Concrete Product 3: Circle
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

// Concrete Creator / Factory
class ShapeFactory {

    // Factory method to get object of type Shape
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

// Client Demo Class
public class DrawingFactoryDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        System.out.println("=== Drawing Factory Method Demo ===");

        // Get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        if (shape1 != null) {
            shape1.draw();
        }

        // Get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        if (shape2 != null) {
            shape2.draw();
        }

        // Get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");
        if (shape3 != null) {
            shape3.draw();
        }
    }
}

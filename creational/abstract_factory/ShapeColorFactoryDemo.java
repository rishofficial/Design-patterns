/**
 * Case Study 4: Shape and Color Abstract Factory Demo
 * Reference: Slides 31-33 in slide.md
 * 
 * Demonstrates a "Factory of Factories" producing ShapeFactory or ColorFactory.
 */

// Product 1 Interface: Shape
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() { System.out.println("Inside Circle::draw() method."); }
}

class Rectangle implements Shape {
    @Override
    public void draw() { System.out.println("Inside Rectangle::draw() method."); }
}

class Square implements Shape {
    @Override
    public void draw() { System.out.println("Inside Square::draw() method."); }
}

// Product 2 Interface: Color
interface Color {
    void fill();
}

class Red implements Color {
    @Override
    public void fill() { System.out.println("Inside Red::fill() method."); }
}

class Green implements Color {
    @Override
    public void fill() { System.out.println("Inside Green::fill() method."); }
}

class Blue implements Color {
    @Override
    public void fill() { System.out.println("Inside Blue::fill() method."); }
}

// Abstract Factory Class
abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}

// Concrete Factory 1: Shape Factory
class ShapeFactory extends AbstractFactory {
    @Override
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

    @Override
    public Color getColor(String color) {
        return null; // ShapeFactory does not produce colors
    }
}

// Concrete Factory 2: Color Factory
class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        return null; // ColorFactory does not produce shapes
    }

    @Override
    public Color getColor(String colorType) {
        if (colorType == null) {
            return null;
        }
        if (colorType.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (colorType.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (colorType.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }
}

// Factory Producer (Factory of Factories)
class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice == null) {
            return null;
        }
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}

// Client Demo Class (AbstractFactoryPatternDemo)
public class ShapeColorFactoryDemo {

    public static void main(String[] args) {
        System.out.println("=== Shape & Color Abstract Factory Demo ===");

        // Get Shape Factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        // Get Circle
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        if (shape1 != null) shape1.draw();

        // Get Rectangle
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        if (shape2 != null) shape2.draw();

        // Get Color Factory
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        // Get Red
        Color color1 = colorFactory.getColor("RED");
        if (color1 != null) color1.fill();

        // Get Green
        Color color2 = colorFactory.getColor("GREEN");
        if (color2 != null) color2.fill();
    }
}

/**
 * Fundamental Object-Oriented UML Relationships Demo
 * Reference: Slide 2 in slide.md
 * 
 * Demonstrates the four core UML relationships discussed in Slide 2:
 * 1. Generalization (Inheritance/Realization)
 * 2. Aggregation ("is part of" - weak relationship, independent lifetimes)
 * 3. Composition ("is entirely made of" - strong relationship, dependent lifetimes)
 * 4. Dependency ("uses" - temporary usage)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ============================================================================
// 1. GENERALIZATION EXAMPLE
// Shape (interface) <- RectangularShape (abstract) <- Rectangle (concrete)
// ============================================================================

interface Shape {
    double calculateArea();
}

abstract class RectangularShape implements Shape {
    protected int width;
    protected int height;

    public RectangularShape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    public boolean contains(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }
}

class Rectangle extends RectangularShape {
    public Rectangle(int x, int y) {
        super(x, y);
    }

    public double distance(Rectangle r) {
        // Distance calculation between rectangle dimensions
        return Math.sqrt(Math.pow(this.width - r.width, 2) + Math.pow(this.height - r.height, 2));
    }
}

// ============================================================================
// 2. AGGREGATION EXAMPLE ("is part of" - open diamond ◇—)
// Engine (1) ◇— (1) Car
// Engine can exist independently of Car
// ============================================================================

class Engine {
    private String model;

    public Engine(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}

class Car {
    private Engine engine; // Reference to external Engine

    // Aggregation: Engine is passed in from outside
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        System.out.println("Car started with aggregated Engine model: " + engine.getModel());
    }
}

// ============================================================================
// 3. COMPOSITION EXAMPLE ("is entirely made of" - filled diamond ◆—)
// Page (*) ◆— (1) Book
// Book manages and owns the lifetime of Page objects
// ============================================================================

class Page {
    private int pageNumber;
    private String content;

    public Page(int pageNumber, String content) {
        this.pageNumber = pageNumber;
        this.content = content;
    }

    public void readPage() {
        System.out.println("  Page " + pageNumber + ": " + content);
    }
}

class Book {
    private String title;
    private List<Page> pages; // Composition: Pages created & owned inside Book

    public Book(String title, String[] chapterContents) {
        this.title = title;
        this.pages = new ArrayList<>();
        // Composition: Book instantiates its own Page objects
        for (int i = 0; i < chapterContents.length; i++) {
            pages.add(new Page(i + 1, chapterContents[i]));
        }
    }

    public void readBook() {
        System.out.println("Reading Book '" + title + "' (Total pages: " + pages.size() + "):");
        for (Page page : pages) {
            page.readPage();
        }
    }
}

// ============================================================================
// 4. DEPENDENCY EXAMPLE ("uses" - dashed line --->)
// Lottery ---> Random
// Lottery temporarily uses Random to generate numbers
// ============================================================================

class Lottery {
    // Dependency: Uses java.util.Random temporarily inside method
    public List<Integer> drawWinningNumbers(Random randomGenerator, int count, int maxNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(randomGenerator.nextInt(maxNumber) + 1);
        }
        return numbers;
    }
}

// ============================================================================
// CLIENT DEMO CLASS
// ============================================================================
public class UmlRelationshipsDemo {

    public static void main(String[] args) {
        System.out.println("=== Fundamental UML Relationships Demo ===");

        // 1. Test Generalization
        System.out.println("\n[1. Generalization Test]");
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle(15, 25);
        System.out.println("Rectangle 1 Area: " + r1.calculateArea());
        System.out.println("Rectangle 1 Contains (5, 5)? " + r1.contains(5, 5));
        System.out.println("Distance between r1 and r2: " + String.format("%.2f", r1.distance(r2)));

        // 2. Test Aggregation
        System.out.println("\n[2. Aggregation Test]");
        Engine V6Engine = new Engine("V6 Turbo 3.5L");
        Car myCar = new Car(V6Engine); // Engine passed into Car
        myCar.startCar();
        System.out.println("Engine exists independently: " + V6Engine.getModel());

        // 3. Test Composition
        System.out.println("\n[3. Composition Test]");
        String[] chapters = {
            "Introduction to Design Patterns",
            "UML Relationships in Depth",
            "Creational Pattern Implementations"
        };
        Book designBook = new Book("Design Patterns 101", chapters);
        designBook.readBook();

        // 4. Test Dependency
        System.out.println("\n[4. Dependency Test]");
        Lottery lottery = new Lottery();
        Random rng = new Random(42); // Seeded random for reproducible output
        List<Integer> winningNumbers = lottery.drawWinningNumbers(rng, 6, 49);
        System.out.println("Lottery Winning Numbers: " + winningNumbers);
    }
}

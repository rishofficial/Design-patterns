/**
 * Canonical Factory Method Pattern Demo
 * Reference: Slide 5 in slide.md
 * 
 * Demonstrates the exact abstract UML solution structure of the Factory Method pattern:
 * - Abstract Creator (#factoryMethod(): Product, +anOperation())
 * - Abstract Product
 * - ConcreteCreator (+factoryMethod(): Product)
 * - ConcreteProduct
 */

// Abstract Product
abstract class Product {
    public abstract String getName();
    public abstract void execute();
}

// Concrete Product A
class ConcreteProductA extends Product {
    @Override
    public String getName() {
        return "ConcreteProductA";
    }

    @Override
    public void execute() {
        System.out.println("Executing features of " + getName());
    }
}

// Concrete Product B
class ConcreteProductB extends Product {
    @Override
    public String getName() {
        return "ConcreteProductB";
    }

    @Override
    public void execute() {
        System.out.println("Executing features of " + getName());
    }
}

// Abstract Creator
abstract class Creator {
    // Protected Factory Method
    protected abstract Product factoryMethod();

    // Template operation that uses the product returned by factoryMethod
    public void anOperation() {
        System.out.println("Creator: Initializing operation workflow...");
        Product product = factoryMethod();
        System.out.println("Creator: Working with product [" + product.getName() + "]");
        product.execute();
    }
}

// Concrete Creator A
class ConcreteCreatorA extends Creator {
    @Override
    protected Product factoryMethod() {
        return new ConcreteProductA();
    }
}

// Concrete Creator B
class ConcreteCreatorB extends Creator {
    @Override
    protected Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// Client Demo Class
public class GenericFactoryMethodDemo {

    public static void main(String[] args) {
        System.out.println("=== Canonical Factory Method Abstract Solution Demo ===");

        System.out.println("\n[Client invoking ConcreteCreatorA]");
        Creator creatorA = new ConcreteCreatorA();
        creatorA.anOperation();

        System.out.println("\n[Client invoking ConcreteCreatorB]");
        Creator creatorB = new ConcreteCreatorB();
        creatorB.anOperation();
    }
}

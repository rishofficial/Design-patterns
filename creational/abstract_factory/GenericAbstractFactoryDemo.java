/**
 * Canonical Abstract Factory Pattern Demo
 * Reference: Slide 18 in slide.md
 * 
 * Demonstrates the exact abstract UML solution structure of the Abstract Factory pattern:
 * - CanonicalAbstractFactory interface (CreateProductA(), CreateProductB())
 * - ConcreteFactory1, ConcreteFactory2
 * - AbstractProductA (ProductA1, ProductA2)
 * - AbstractProductB (ProductB1, ProductB2)
 */

// Abstract Product A Interface
interface AbstractProductA {
    void performTaskA();
}

class ProductA1 implements AbstractProductA {
    @Override
    public void performTaskA() {
        System.out.println("ProductA1: Performing task A variant 1.");
    }
}

class ProductA2 implements AbstractProductA {
    @Override
    public void performTaskA() {
        System.out.println("ProductA2: Performing task A variant 2.");
    }
}

// Abstract Product B Interface
interface AbstractProductB {
    void performTaskB();
    void interactWith(AbstractProductA productA);
}

class ProductB1 implements AbstractProductB {
    @Override
    public void performTaskB() {
        System.out.println("ProductB1: Performing task B variant 1.");
    }

    @Override
    public void interactWith(AbstractProductA productA) {
        System.out.println("ProductB1 interacting with " + productA.getClass().getSimpleName());
    }
}

class ProductB2 implements AbstractProductB {
    @Override
    public void performTaskB() {
        System.out.println("ProductB2: Performing task B variant 2.");
    }

    @Override
    public void interactWith(AbstractProductA productA) {
        System.out.println("ProductB2 interacting with " + productA.getClass().getSimpleName());
    }
}

// Canonical Abstract Factory Interface
interface CanonicalAbstractFactory {
    AbstractProductA createProductA();
    AbstractProductB createProductB();
}

// Concrete Factory 1
class ConcreteFactory1 implements CanonicalAbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

// Concrete Factory 2
class ConcreteFactory2 implements CanonicalAbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

// Client
class Client {
    private AbstractProductA productA;
    private AbstractProductB productB;

    public Client(CanonicalAbstractFactory factory) {
        this.productA = factory.createProductA();
        this.productB = factory.createProductB();
    }

    public void run() {
        productA.performTaskA();
        productB.performTaskB();
        productB.interactWith(productA);
    }
}

// Client Demo Class
public class GenericAbstractFactoryDemo {

    public static void main(String[] args) {
        System.out.println("=== Canonical Abstract Factory Solution Demo ===");

        System.out.println("\n[Client initialized with ConcreteFactory1]");
        Client client1 = new Client(new ConcreteFactory1());
        client1.run();

        System.out.println("\n[Client initialized with ConcreteFactory2]");
        Client client2 = new Client(new ConcreteFactory2());
        client2.run();
    }
}

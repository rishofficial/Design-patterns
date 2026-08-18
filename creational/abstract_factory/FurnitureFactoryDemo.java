/**
 * Case Study 2: Furniture Shop Simulator (Abstract Factory)
 * Reference: Slides 19-22 in slide.md
 * 
 * Demonstrates creating matching style variants (Victorian, Modern) for furniture product families.
 */

// Product 1: Chair Interface
interface Chair {
    boolean hasLegs();
    void sitOn();
}

// Concrete Product 1A: Victorian Chair
class VictorianChair implements Chair {
    @Override
    public boolean hasLegs() { return true; }

    @Override
    public void sitOn() {
        System.out.println("Sitting on an ornate Victorian Chair with carved wooden legs.");
    }
}

// Concrete Product 1B: Modern Chair
class ModernChair implements Chair {
    @Override
    public boolean hasLegs() { return false; }

    @Override
    public void sitOn() {
        System.out.println("Sitting on a minimalist, sleek Modern Chair.");
    }
}

// Product 2: Sofa Interface
interface Sofa {
    boolean hasLegs();
    void layOn();
}

// Concrete Product 2A: Victorian Sofa
class VictorianSofa implements Sofa {
    @Override
    public boolean hasLegs() { return true; }

    @Override
    public void layOn() {
        System.out.println("Laying down on a velvet Victorian Sofa.");
    }
}

// Concrete Product 2B: Modern Sofa
class ModernSofa implements Sofa {
    @Override
    public boolean hasLegs() { return false; }

    @Override
    public void layOn() {
        System.out.println("Laying down on a low-profile Modern Sofa.");
    }
}

// Product 3: Coffee Table Interface
interface CoffeeTable {
    boolean hasLegs();
    void placeItems();
}

// Concrete Product 3A: Victorian Coffee Table
class VictorianCoffeeTable implements CoffeeTable {
    @Override
    public boolean hasLegs() { return true; }

    @Override
    public void placeItems() {
        System.out.println("Placing tea set on a Victorian mahogany Coffee Table.");
    }
}

// Concrete Product 3B: Modern Coffee Table
class ModernCoffeeTable implements CoffeeTable {
    @Override
    public boolean hasLegs() { return true; }

    @Override
    public void placeItems() {
        System.out.println("Placing laptop on a tempered glass Modern Coffee Table.");
    }
}

// Abstract Factory
interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CoffeeTable createCoffeeTable();
}

// Concrete Factory 1: Victorian Furniture Factory
class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() { return new VictorianChair(); }

    @Override
    public Sofa createSofa() { return new VictorianSofa(); }

    @Override
    public CoffeeTable createCoffeeTable() { return new VictorianCoffeeTable(); }
}

// Concrete Factory 2: Modern Furniture Factory
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() { return new ModernChair(); }

    @Override
    public Sofa createSofa() { return new ModernSofa(); }

    @Override
    public CoffeeTable createCoffeeTable() { return new ModernCoffeeTable(); }
}

// Client Demo Class
public class FurnitureFactoryDemo {

    public static void main(String[] args) {
        System.out.println("=== Furniture Shop Abstract Factory Demo ===");

        // Order Victorian Style Set
        System.out.println("\n[Customer Order: Victorian Furniture Family]");
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        Chair vChair = victorianFactory.createChair();
        Sofa vSofa = victorianFactory.createSofa();
        CoffeeTable vTable = victorianFactory.createCoffeeTable();
        vChair.sitOn();
        vSofa.layOn();
        vTable.placeItems();

        // Order Modern Style Set
        System.out.println("\n[Customer Order: Modern Furniture Family]");
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair mChair = modernFactory.createChair();
        Sofa mSofa = modernFactory.createSofa();
        CoffeeTable mTable = modernFactory.createCoffeeTable();
        mChair.sitOn();
        mSofa.layOn();
        mTable.placeItems();
    }
}

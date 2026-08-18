/**
 * Case Study 3: Honda Car Factory (Abstract Factory)
 * Reference: Slide 30 in slide.md
 * 
 * Demonstrates generating vehicle component families (Engine, Transmission) for Honda Civic and Accord models.
 */

// Product 1: Engine Interface
interface Engine {
    void start();
}

// Concrete Product 1A: Civic Engine
class CivicEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Starting 2.0L 4-Cylinder i-VTEC Civic Engine.");
    }
}

// Concrete Product 1B: Accord Engine
class AccordEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Starting 1.5L Turbocharged Accord Engine.");
    }
}

// Product 2: Transmission Interface
interface Transmission {
    void shift();
}

// Concrete Product 2A: Civic Transmission
class CivicTrans implements Transmission {
    @Override
    public void shift() {
        System.out.println("Engaging Civic 6-Speed Manual Transmission.");
    }
}

// Concrete Product 2B: Accord Transmission
class AccordTrans implements Transmission {
    @Override
    public void shift() {
        System.out.println("Engaging Accord Continuously Variable Transmission (CVT).");
    }
}

// Abstract Factory
interface HondaFactory {
    Engine createEngine();
    Transmission createTrans();
}

// Concrete Factory 1: Civic Factory
class CivicFactory implements HondaFactory {
    @Override
    public Engine createEngine() {
        return new CivicEngine();
    }

    @Override
    public Transmission createTrans() {
        return new CivicTrans();
    }
}

// Concrete Factory 2: Accord Factory
class AccordFactory implements HondaFactory {
    @Override
    public Engine createEngine() {
        return new AccordEngine();
    }

    @Override
    public Transmission createTrans() {
        return new AccordTrans();
    }
}

// Client Demo Class
public class HondaCarFactoryDemo {

    public static void main(String[] args) {
        System.out.println("=== Honda Car Assembly Abstract Factory Demo ===");

        // Assemble Honda Civic
        System.out.println("\n[Assembly Line: Honda Civic]");
        HondaFactory civicFactory = new CivicFactory();
        Engine civicEngine = civicFactory.createEngine();
        Transmission civicTrans = civicFactory.createTrans();
        civicEngine.start();
        civicTrans.shift();

        // Assemble Honda Accord
        System.out.println("\n[Assembly Line: Honda Accord]");
        HondaFactory accordFactory = new AccordFactory();
        Engine accordEngine = accordFactory.createEngine();
        Transmission accordTrans = accordFactory.createTrans();
        accordEngine.start();
        accordTrans.shift();
    }
}

/**
 * Case Study 4: Logistics Management App
 * Reference: Slide 12 in slide.md
 * 
 * Demonstrates refactoring coupled logistics code to the Factory Method pattern.
 * Enables adding sea transportation (Ship) alongside land transportation (Truck) seamlessly.
 */

// Product Interface
interface Transport {
    void deliver();
}

// Concrete Product 1: Truck
class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver cargo by land in a box truck.");
    }
}

// Concrete Product 2: Ship
class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver cargo by sea in a container ship.");
    }
}

// Abstract Creator
abstract class Logistics {

    // Factory Method
    public abstract Transport createTransport();

    // Business Logic relying on Factory Method
    public void planDelivery() {
        Transport transport = createTransport();
        System.out.print("Logistics Plan: ");
        transport.deliver();
    }
}

// Concrete Creator 1: Road Logistics
class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

// Concrete Creator 2: Sea Logistics
class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}

// Client Demo Class
public class LogisticsDemo {

    public static void main(String[] args) {
        System.out.println("=== Logistics Management Factory Demo ===");

        // Road Logistics Delivery
        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();

        // Sea Logistics Delivery
        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
    }
}

/**
 * Case Study 1: Complex Computer Assembly Builder
 * Reference: Slide 43 in slide.md
 * 
 * Demonstrates the Builder pattern for step-by-step construction of complex Computer objects.
 */

// Complex Product Class
class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String os;
    private boolean isBluetoothEnabled;
    private boolean isWifiEnabled;

    // Setters called by Builder
    public void setCpu(String cpu) { this.cpu = cpu; }
    public void setRam(String ram) { this.ram = ram; }
    public void setStorage(String storage) { this.storage = storage; }
    public void setGpu(String gpu) { this.gpu = gpu; }
    public void setOs(String os) { this.os = os; }
    public void setBluetoothEnabled(boolean bluetoothEnabled) { isBluetoothEnabled = bluetoothEnabled; }
    public void setWifiEnabled(boolean wifiEnabled) { isWifiEnabled = wifiEnabled; }

    @Override
    public String toString() {
        return "Computer Specifications:\n" +
               "  - CPU: " + cpu + "\n" +
               "  - RAM: " + ram + "\n" +
               "  - Storage: " + storage + "\n" +
               "  - GPU: " + gpu + "\n" +
               "  - OS: " + os + "\n" +
               "  - Bluetooth: " + (isBluetoothEnabled ? "Yes" : "No") + "\n" +
               "  - Wi-Fi: " + (isWifiEnabled ? "Yes" : "No");
    }
}

// Builder Interface
interface ComputerBuilder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    void buildGPU();
    void buildOS();
    void buildConnectivity();
    Computer getComputer();
}

// Concrete Builder 1: High-End Gaming PC
class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() { computer.setCpu("Intel Core i9-14900K 24-Core"); }

    @Override
    public void buildRAM() { computer.setRam("64GB DDR5 6000MHz RGB"); }

    @Override
    public void buildStorage() { computer.setStorage("2TB NVMe PCIe 4.0 SSD"); }

    @Override
    public void buildGPU() { computer.setGpu("NVIDIA GeForce RTX 4090 24GB GDDR6X"); }

    @Override
    public void buildOS() { computer.setOs("Windows 11 Pro 64-bit"); }

    @Override
    public void buildConnectivity() {
        computer.setBluetoothEnabled(true);
        computer.setWifiEnabled(true);
    }

    @Override
    public Computer getComputer() { return this.computer; }
}

// Concrete Builder 2: Office Workstation PC
class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildCPU() { computer.setCpu("Intel Core i5-13400 10-Core"); }

    @Override
    public void buildRAM() { computer.setRam("16GB DDR4 3200MHz"); }

    @Override
    public void buildStorage() { computer.setStorage("512GB M.2 NVMe SSD"); }

    @Override
    public void buildGPU() { computer.setGpu("Integrated Intel UHD Graphics 730"); }

    @Override
    public void buildOS() { computer.setOs("Windows 11 Home"); }

    @Override
    public void buildConnectivity() {
        computer.setBluetoothEnabled(false);
        computer.setWifiEnabled(true);
    }

    @Override
    public Computer getComputer() { return this.computer; }
}

// Director Class
class ComputerDirector {
    public void constructComputer(ComputerBuilder builder) {
        builder.buildCPU();
        builder.buildRAM();
        builder.buildStorage();
        builder.buildGPU();
        builder.buildOS();
        builder.buildConnectivity();
    }
}

// Client Demo Class
public class BuilderPatternDemo {

    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        System.out.println("=== Computer Assembly Builder Pattern Demo ===");

        // Build a High-End Gaming PC
        System.out.println("\n[Assembling Gaming Workstation]");
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructComputer(gamingBuilder);
        Computer gamingPC = gamingBuilder.getComputer();
        System.out.println(gamingPC);

        // Build an Office PC
        System.out.println("\n[Assembling Office Desktop]");
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.constructComputer(officeBuilder);
        Computer officePC = officeBuilder.getComputer();
        System.out.println(officePC);
    }
}

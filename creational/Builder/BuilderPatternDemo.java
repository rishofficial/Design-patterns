/**
 * Case Study 1: Complex Computer Assembly Builder
 * Reference: Slide 43 in slide.md
 * 
 * Demonstrates the Builder pattern for step-by-step construction of complex Computer objects.
 * Shows that all builder steps/methods are OPTIONAL and can be omitted without causing errors.
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
               "  - CPU: " + (cpu != null ? cpu : "[None/Default]") + "\n" +
               "  - RAM: " + (ram != null ? ram : "[Omitted - No RAM installed]") + "\n" +
               "  - Storage: " + (storage != null ? storage : "[None/Default]") + "\n" +
               "  - GPU: " + (gpu != null ? gpu : "[Omitted - Integrated/None]") + "\n" +
               "  - OS: " + (os != null ? os : "[None/Default]") + "\n" +
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

// Concrete Builder 1: High-End Gaming PC (Sets all components)
class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

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

// Concrete Builder 2: Barebones Server Builder (OMITS RAM and GPU building steps!)
class BarebonesServerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildCPU() { computer.setCpu("AMD EPYC 7763 64-Core Server Processor"); }

    @Override
    public void buildRAM() {
        // Intentionally OMITTED! Client will insert RAM modules separately.
        System.out.println("  [Builder Note]: buildRAM step omitted. Server built without pre-installed RAM.");
    }

    @Override
    public void buildStorage() { computer.setStorage("4TB Enterprise NVMe U.2 SSD"); }

    @Override
    public void buildGPU() {
        // Intentionally OMITTED! Servers run headless.
    }

    @Override
    public void buildOS() { computer.setOs("Ubuntu Server 24.04 LTS"); }

    @Override
    public void buildConnectivity() {
        computer.setWifiEnabled(false);
        computer.setBluetoothEnabled(false);
    }

    @Override
    public Computer getComputer() { return this.computer; }
}

// Modern Method-Chaining Fluent Builder (Direct Client-controlled Optional Steps)
class FluentComputerBuilder {
    private Computer computer = new Computer();

    public FluentComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public FluentComputerBuilder setRam(String ram) {
        computer.setRam(ram);
        return this;
    }

    public FluentComputerBuilder setStorage(String storage) {
        computer.setStorage(storage);
        return this;
    }

    public FluentComputerBuilder setGpu(String gpu) {
        computer.setGpu(gpu);
        return this;
    }

    public FluentComputerBuilder setOs(String os) {
        computer.setOs(os);
        return this;
    }

    public Computer build() {
        return this.computer;
    }
}

// Director Class
class ComputerDirector {
    public void constructFullComputer(ComputerBuilder builder) {
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

        // 1. Full Build (Gaming PC)
        System.out.println("\n[1. Full Assembly: Gaming Workstation]");
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructFullComputer(gamingBuilder);
        System.out.println(gamingBuilder.getComputer());

        // 2. Omitted Steps Build (Barebones Server omitting RAM & GPU)
        System.out.println("\n[2. Partial Assembly: Barebones Server (RAM & GPU Omitted)]");
        ComputerBuilder serverBuilder = new BarebonesServerBuilder();
        director.constructFullComputer(serverBuilder);
        System.out.println(serverBuilder.getComputer());

        // 3. Modern Fluent Builder with Selective Optional Methods
        System.out.println("\n[3. Fluent Builder Assembly: Custom PC without buildRAM step]");
        Computer customPC = new FluentComputerBuilder()
                .setCpu("Apple M3 Max")
                .setStorage("1TB Unified Storage")
                .setOs("macOS Sequoia")
                // Notice: setRam() and setGpu() are completely OMITTED here!
                .build();
        System.out.println(customPC);
    }
}

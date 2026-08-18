/**
 * Case Study 1: Cross-Platform GUI Framework (Abstract Factory)
 * Reference: Slides 23, 25-29 in slide.md
 * 
 * Demonstrates creating families of UI components (Button, Checkbox) for Windows and macOS.
 */

// Product Family 1 Interface: Button
interface Button {
    void paint();
}

// Concrete Product 1A: Windows Button
class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in native Windows style.");
    }
}

// Concrete Product 1B: macOS Button
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in native macOS style.");
    }
}

// Product Family 2 Interface: Checkbox
interface Checkbox {
    void paint();
}

// Concrete Product 2A: Windows Checkbox
class WinCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in native Windows style.");
    }
}

// Concrete Product 2B: macOS Checkbox
class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in native macOS style.");
    }
}

// Abstract Factory Interface
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory 1: Windows Factory
class WinFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

// Concrete Factory 2: macOS Factory
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client Application
class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

// Client Demo Class (ApplicationConfigurator)
public class GuiFactoryDemo {

    public static void main(String[] args) {
        System.out.println("=== Cross-Platform GUI Abstract Factory Demo ===");

        // Test Windows Factory
        System.out.println("\n[Configuration: Windows OS]");
        GUIFactory winFactory = new WinFactory();
        Application winApp = new Application(winFactory);
        winApp.paint();

        // Test macOS Factory
        System.out.println("\n[Configuration: macOS]");
        GUIFactory macFactory = new MacFactory();
        Application macApp = new Application(macFactory);
        macApp.paint();
    }
}

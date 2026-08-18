/**
 * Case Study 5: Cross-Platform Dialog Framework
 * Reference: Slides 13 & 14 in slide.md
 * 
 * Demonstrates the Factory Method pattern for rendering UI dialogs across operating systems.
 */

// Product Interface
interface Button {
    void render();
    void onClick(String action);
}

// Concrete Product 1: Windows Button
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("<Button> Rendered native Windows-style button.");
    }

    @Override
    public void onClick(String action) {
        System.out.println("Windows Button Clicked! Action executed: " + action);
    }
}

// Concrete Product 2: HTML/Web Button
class HTMLButton implements Button {
    @Override
    public void render() {
        System.out.println("<button class='web-btn'>Rendered HTML Web button.</button>");
    }

    @Override
    public void onClick(String action) {
        System.out.println("HTML Button Clicked! JS event triggered: " + action);
    }
}

// Abstract Creator
abstract class Dialog {

    // Factory Method
    public abstract Button createButton();

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
        okButton.onClick("closeDialog");
    }
}

// Concrete Creator 1: Windows Dialog
class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

// Concrete Creator 2: Web Dialog
class WebDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}

// Client Demo Class
public class DialogDemo {

    private static Dialog dialog;

    public static void main(String[] args) {
        System.out.println("=== Cross-Platform Dialog Factory Demo ===");

        // Simulate Windows OS environment
        System.out.println("\n[Environment: Windows OS]");
        dialog = new WindowsDialog();
        dialog.renderWindow();

        // Simulate Web Browser environment
        System.out.println("\n[Environment: Web Browser]");
        dialog = new WebDialog();
        dialog.renderWindow();
    }
}

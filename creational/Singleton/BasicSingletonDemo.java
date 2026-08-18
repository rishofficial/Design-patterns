/**
 * Canonical Singleton Class Demo
 * Reference: Slide 37 in slide.md
 * 
 * Demonstrates the exact UML class diagram structure for SingletonClass:
 * - instance: SingletonClass (private static field)
 * - SingletonClass() (private constructor)
 * + getInstance(): SingletonClass (public static creation method)
 */

class SingletonClass {
    // Private static field for storing single instance
    private static SingletonClass instance = null;

    // Private constructor
    private SingletonClass() {
        System.out.println("SingletonClass: Private constructor invoked.");
    }

    // Public static method for getting instance
    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("SingletonClass: Executing method on instance [" + Integer.toHexString(hashCode()) + "]");
    }
}

// Client Demo Class
public class BasicSingletonDemo {

    public static void main(String[] args) {
        System.out.println("=== Canonical Singleton Class Solution Demo ===");

        System.out.println("\nRequesting SingletonClass instance for the first time:");
        SingletonClass s1 = SingletonClass.getInstance();
        s1.showMessage();

        System.out.println("\nRequesting SingletonClass instance for the second time:");
        SingletonClass s2 = SingletonClass.getInstance();
        s2.showMessage();

        System.out.println("\nChecking if both references refer to the same object:");
        System.out.println("s1 == s2 : " + (s1 == s2));
    }
}

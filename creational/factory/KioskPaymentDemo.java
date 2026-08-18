/**
 * Case Study 2: Kiosk Payment Processor Factory
 * Reference: Slide 8 in slide.md
 * 
 * Demonstrates the Factory Method pattern for creating payment processors in a Kiosk.
 */

// Product Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Concrete Product 1: Cash Payment
class Cash implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + String.format("%.2f", amount) + ". Dispensing receipt.");
    }
}

// Concrete Product 2: Coupon Payment
class Coupon implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Applying promotional coupon code for value $" + String.format("%.2f", amount) + ".");
    }
}

// Concrete Product 3: Credit Card Payment
class CreditCard implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Contacting bank gateway for Credit Card charge of $" + String.format("%.2f", amount) + ".");
    }
}

// Creator / Factory
class GetPayment {

    // Factory method to obtain PaymentProcessor instance
    public PaymentProcessor getProcessor(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("CASH")) {
            return new Cash();
        } else if (type.equalsIgnoreCase("COUPON")) {
            return new Coupon();
        } else if (type.equalsIgnoreCase("CREDITCARD")) {
            return new CreditCard();
        }
        return null;
    }
}

// Client Demo Class (Kiosk Application)
public class KioskPaymentDemo {

    public static void main(String[] args) {
        GetPayment paymentFactory = new GetPayment();

        System.out.println("=== Kiosk Payment Factory Demo ===");

        // Process a cash payment
        PaymentProcessor cashProc = paymentFactory.getProcessor("CASH");
        if (cashProc != null) {
            cashProc.processPayment(25.50);
        }

        // Process a credit card payment
        PaymentProcessor cardProc = paymentFactory.getProcessor("CREDITCARD");
        if (cardProc != null) {
            cardProc.processPayment(149.99);
        }

        // Process a coupon redemption
        PaymentProcessor couponProc = paymentFactory.getProcessor("COUPON");
        if (couponProc != null) {
            couponProc.processPayment(10.00);
        }
    }
}

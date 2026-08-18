# Demo: Software Design Principles (Payment Gateway Example)

## Overview
This directory contains introductory foundational examples demonstrating core Object-Oriented design principles prior to introducing Creational Design Patterns:
- **Tight Coupling vs. Decoupling**
- **Programming to an Interface, not an Implementation**
- **Dependency Injection**

---

## Code Files & Analysis

### 1. Bad Payment Example ([BadPaymentExample.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/demo/BadPaymentExample.java))
- **Concept**: Anti-pattern demonstration (Tight Coupling).
- **Key Issues**:
  - `CheckoutService` directly instantiates a concrete dependency (`BkashPaymentGateway paymentGateway = new BkashPaymentGateway()`).
  - Cannot support alternative payment options (e.g. Nagad, Credit Card, PayPal) without modifying and recompiling `CheckoutService`.
  - Cannot unit test `CheckoutService` in isolation without connecting to the real payment gateway.

### 2. Interface Payment Example ([InterfacePaymentExample.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/demo/InterfacePaymentExample.java))
- **Concept**: Good Object-Oriented design ("Program to an Interface").
- **Key Improvements**:
  - Introduces `PaymentGateway` interface (`void pay(double amount)`).
  - Concrete classes (`BkashPaymentGateway`, `NagadPaymentGateway`, `FakePaymentGateway`) implement `PaymentGateway`.
  - `CheckoutService2` receives the `PaymentGateway` dependency via its constructor (**Dependency Injection**).
  - Open for extension, closed for modification (Open/Closed Principle): New gateways can be added without changing `CheckoutService2`.

---

## How to Run Demos

```bash
# Compile demo files
javac demo/*.java

# Run Bad Payment Example
java -cp demo BadPaymentExample

# Run Interface Payment Example
java -cp demo InterfacePaymentExample
```

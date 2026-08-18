# Factory Method Pattern

## Overview & Intent
The **Factory Method Pattern** defines an interface for creating an object, but allows subclasses to decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

- **Source Reference**: Slides 4–16 of [slide.md](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/slide.md)

---

## UML Structure

```
         +-----------------+
         |     Creator     |
         +-----------------+
         | +anOperation()  |
         | #factoryMethod()|
         +--------+--------+
                  ^
                  | (extends)
         +--------+--------+               +------------------+
         | ConcreteCreator | «create» ---->|  ConcreteProduct |
         +-----------------+               +--------+---------+
         | +factoryMethod()|                        | (implements)
         +-----------------+                        v
                                           +------------------+
                                           |     Product      |
                                           +------------------+
```

---

## Case Studies & Implementations

This folder contains five complete, executable Java implementations for all Factory Method cases mentioned in the slides:

### 1. Shape Drawing Factory ([DrawingFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/DrawingFactoryDemo.java))
- **Source**: Slides 6 & 7
- **Description**: Demonstrates creating geometric shapes (`Circle`, `Rectangle`, `Square`) via `ShapeFactory.getShape(String shapeType)`.
- **Run Command**:
  ```bash
  javac creational/factory/DrawingFactoryDemo.java
  java -cp creational/factory DrawingFactoryDemo
  ```

### 2. Kiosk Payment Processor Factory ([KioskPaymentDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/KioskPaymentDemo.java))
- **Source**: Slide 8
- **Description**: Demonstrates payment processing delegation (`Cash`, `Coupon`, `CreditCard`) via `GetPayment.getProcessor(String type)`.
- **Run Command**:
  ```bash
  javac creational/factory/KioskPaymentDemo.java
  java -cp creational/factory KioskPaymentDemo
  ```

### 3. Electricity Billing Plan Factory ([BillingDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/BillingDemo.java))
- **Source**: Slides 9–11
- **Description**: Demonstrates rate calculation and billing across plans (`DomesticPlan`, `CommercialPlan`, `InstitutionalPlan`) via `GetPlanFactory`.
- **Run Command**:
  ```bash
  javac creational/factory/BillingDemo.java
  java -cp creational/factory BillingDemo
  ```

### 4. Logistics Management App ([LogisticsDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/LogisticsDemo.java))
- **Source**: Slide 12
- **Description**: Solves coupling issues when adding new delivery channels (`Truck` vs `Ship`) by introducing abstract `Logistics` creator subclasses (`RoadLogistics`, `SeaLogistics`).
- **Run Command**:
  ```bash
  javac creational/factory/LogisticsDemo.java
  java -cp creational/factory LogisticsDemo
  ```

### 5. Cross-Platform UI Dialog Framework ([DialogDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/DialogDemo.java))
- **Source**: Slides 13–14
- **Description**: Cross-platform UI button rendering (`WindowsButton` vs `HTMLButton`) deferred to `WindowsDialog` and `WebDialog`.
- **Run Command**:
  ```bash
  javac creational/factory/DialogDemo.java
  java -cp creational/factory DialogDemo
  ```

---

## Pros and Cons

| Pros | Cons |
| :--- | :--- |
| **Avoids tight coupling** between creator and concrete products. | Code volume increases due to requiring multiple new subclasses. |
| **Single Responsibility Principle**: Centralizes product creation code. | Best introduced into existing creator hierarchies. |
| **Open/Closed Principle**: Easily introduces new product variants. | |

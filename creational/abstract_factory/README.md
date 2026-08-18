# Abstract Factory Pattern

## Overview & Intent
The **Abstract Factory Pattern** provides an interface for creating families of related or dependent objects without specifying their concrete classes. It is often referred to as a *"factory of factories"*.

- **Source Reference**: Slides 17–35 of [slide.md](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/slide.md)

---

## UML Structure

```
                         +-------------------+
                         |  AbstractFactory  |
                         +-------------------+
                         | +createProductA() |
                         | +createProductB() |
                         +---------+---------+
                                   ^
                                   | (implements)
             +---------------------+---------------------+
             |                                           |
+------------+------------+                 +------------+------------+
|     ConcreteFactory1    |                 |     ConcreteFactory2    |
+-------------------------+                 +-------------------------+
| +createProductA(): A1   |                 | +createProductA(): A2   |
| +createProductB(): B1   |                 | +createProductB(): B2   |
+------------+------------+                 +------------+------------+
             |                                           |
   «instantiates»                             «instantiates»
             v                                           v
    ProductA1, ProductB1                        ProductA2, ProductB2
```

---

## Case Studies & Implementations

This folder contains four complete, executable Java implementations for all Abstract Factory cases mentioned in the slides:

### 1. Cross-Platform GUI Framework ([GuiFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/GuiFactoryDemo.java))
- **Source**: Slides 23, 25–29
- **Description**: Demonstrates abstract products (`Button`, `Checkbox`) created by OS-specific factories (`WinFactory`, `MacFactory`) and configured at application launch.
- **Run Command**:
  ```bash
  javac creational/abstract_factory/GuiFactoryDemo.java
  java -cp creational/abstract_factory GuiFactoryDemo
  ```

### 2. Furniture Shop Simulator ([FurnitureFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/FurnitureFactoryDemo.java))
- **Source**: Slides 19–22
- **Description**: Solves furniture style mismatch (Victorian vs Modern) across product families (`Chair`, `Sofa`, `CoffeeTable`) via `VictorianFurnitureFactory` and `ModernFurnitureFactory`.
- **Run Command**:
  ```bash
  javac creational/abstract_factory/FurnitureFactoryDemo.java
  java -cp creational/abstract_factory FurnitureFactoryDemo
  ```

### 3. Honda Car Factory ([HondaCarFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/HondaCarFactoryDemo.java))
- **Source**: Slide 30
- **Description**: Demonstrates creating matching car components (`Engine`, `Transmission`) for Civic and Accord vehicle models via `CivicFactory` and `AccordFactory`.
- **Run Command**:
  ```bash
  javac creational/abstract_factory/HondaCarFactoryDemo.java
  java -cp creational/abstract_factory HondaCarFactoryDemo
  ```

### 4. Shape & Color Abstract Factory ([ShapeColorFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/ShapeColorFactoryDemo.java))
- **Source**: Slides 31–33
- **Description**: Demonstrates `FactoryProducer` returning `ShapeFactory` (`Circle`, `Rectangle`, `Square`) or `ColorFactory` (`Red`, `Green`, `Blue`) extending `AbstractFactory`.
- **Run Command**:
  ```bash
  javac creational/abstract_factory/ShapeColorFactoryDemo.java
  java -cp creational/abstract_factory ShapeColorFactoryDemo
  ```

---

## Pros and Cons

| Pros | Cons |
| :--- | :--- |
| **Guarantees compatibility** of products from the same factory. | **Higher complexity**: Requires creating many new interfaces and classes. |
| **Avoids tight coupling** between concrete products and client code. | **Difficult to extend product family**: Adding a new product type requires modifying `AbstractFactory` and all implementations. |
| **Single Responsibility & Open/Closed Principles** supported. | |

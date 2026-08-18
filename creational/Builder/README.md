# Builder Pattern

## Overview & Intent
The **Builder Pattern** separates the construction of a complex object from its representation so that the same construction process can create different representations.

- **Source Reference**: Slide 43 of [slide.md](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/slide.md)

---

## UML Structure

```
                      +-------------------+
                      |     Director      |
                      +-------------------+
                      | +construct()      |
                      +---------+---------+
                                | (uses)
                                v
                      +-------------------+
                      |      Builder      | (Interface)
                      +-------------------+
                      | +buildPartA()     |
                      | +buildPartB()     |
                      | +getResult()      |
                      +---------+---------+
                                ^
                                | (implements)
             +------------------+------------------+
             |                                     |
+------------+------------+           +------------+------------+
|  GamingComputerBuilder  |           |   OfficeComputerBuilder |
+-------------------------+           +-------------------------+
| +buildPartA()           |           | +buildPartA()           |
| +buildPartB()           |           | +buildPartB()           |
| +getResult(): Computer  |           | +getResult(): Computer  |
+------------+------------+           +------------+------------+
             |                                     |
             +------------------+------------------+
                                | «creates»
                                v
                      +-------------------+
                      |     Computer      | (Complex Product)
                      +-------------------+
```

---

## Case Study & Implementation

This folder contains a complete, executable Java implementation for the Builder pattern:

### 1. Complex Computer Assembly Builder ([BuilderPatternDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Builder/BuilderPatternDemo.java))
- **Source**: Slide 43
- **Description**: Demonstrates building complex objects (`Computer`) with optional/varied hardware configurations (`GamingComputerBuilder` vs `OfficeComputerBuilder`) orchestrated by a `ComputerDirector`.
- **Run Command**:
  ```bash
  javac creational/Builder/BuilderPatternDemo.java
  java -cp creational/Builder BuilderPatternDemo
  ```

---

## Pros and Cons

| Pros | Cons |
| :--- | :--- |
| **Step-by-step Construction**: Allows constructing objects incrementally. | **Increased Code Volume**: Requires creating dedicated Builder classes for products. |
| **Separation of Assembly Logic**: `Director` handles construction steps; Product encapsulates data. | |
| **Supports Immutable Objects**: Fields can be set during construction before returning final instance. | |

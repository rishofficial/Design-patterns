# Builder Pattern

## Overview & Intent
The **Builder Pattern** separates the construction of a complex object from its representation so that the same construction process can create different representations.

- **Source Reference**: Slides 43–47 of [slide.md](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/slide.md)

---

## Key Feature: Optional Building Steps
A primary advantage of the Builder pattern is that **all construction steps are optional**.

- Calling or omitting steps like `buildRAM()` or `.setRam()` **does not cause any error**.
- Unset fields safely retain default fallback values (e.g. `null`, default values, or `false`).
- Prevents **Telescoping Constructor anti-patterns** (`new Computer(cpu, ram, storage, null, null, false, true)`).

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
|  GamingComputerBuilder  |           |        CarBuilder         |
+-------------------------+           +-------------------------+
| +buildPartA()           |           | +BuildBody()            |
| +buildPartB()           |           | +InsertWheels()         |
| +getResult(): Computer  |           | +GetVehicle(): Product  |
+------------+------------+           +------------+------------+
```

---

## Case Studies & Implementations

This folder contains three complete, executable Java implementations for all Builder pattern cases in the slides:

### 1. Complex Computer Assembly Builder ([BuilderPatternDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Builder/BuilderPatternDemo.java))
- **Source**: Slide 43
- **Description**: Demonstrates full builds, partial builds (omitting `RAM` & `GPU`), and Modern Fluent Builder method chaining.
- **Run Command**:
  ```bash
  javac creational/Builder/BuilderPatternDemo.java
  java -cp creational/Builder BuilderPatternDemo
  ```

### 2. Vehicle Assembly Builder ([VehicleBuilderDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Builder/VehicleBuilderDemo.java))
- **Source**: Slide 44
- **Description**: Assembles different vehicle representations (`Car` vs `MotorCycle`) using `IBuilder` and `VehicleDirector`.
- **Run Command**:
  ```bash
  javac creational/Builder/VehicleBuilderDemo.java
  java -cp creational/Builder VehicleBuilderDemo
  ```

### 3. CD Media Pack Builder ([CDBuilderDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Builder/CDBuilderDemo.java))
- **Source**: Slide 47
- **Description**: Assembles `Sony` and `Samsung` CD media packs using `CDBuilder`, `CDType`, and abstract `Company`/`CD` interfaces.
- **Run Command**:
  ```bash
  javac creational/Builder/CDBuilderDemo.java
  java -cp creational/Builder CDBuilderDemo
  ```

---

## Comparison: Abstract Factory vs Builder

| Aspect | Abstract Factory | Builder |
| :--- | :--- | :--- |
| **Primary Purpose** | Create families of related objects | Construct a complex object step by step |
| **Focus** | *Which* objects to create | *How* to create an object |
| **Complexity** | Simple or moderately complex | Complex with many optional parts |
| **Construction Process** | Hidden from client | Exposed as a sequence of building steps |
| **Product Type** | Multiple related products | Usually one complex product |
| **Client Involvement** | Selects a factory family | Controls building sequence (directly or via Director) |

---

## Pros and Cons

| Pros | Cons |
| :--- | :--- |
| **Optional Steps**: Call only the construction steps needed; omit unused parts effortlessly. | **Increased Code Volume**: Requires creating dedicated Builder classes for products. |
| **Prevents Telescoping Constructors**: Avoids giant constructors full of `null` arguments. | |
| **Supports Immutable Objects**: Fields set step-by-step before finalizing product. | |

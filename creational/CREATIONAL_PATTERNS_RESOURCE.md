# Creational Design Patterns & Object-Oriented Principles — Comprehensive Resource

This document serves as a complete reference guide and resource for the course material extracted from [slide.md](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/slide.md) and [lecture.pdf](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/demo/lecture.pdf). It outlines foundational Object-Oriented design principles, pattern intents, UML representations, pros and cons, and direct links to standalone executable Java code implementations.

---

## Table of Contents
0. [Foundational Object-Oriented Principles (`demo/` folder)](#0-foundational-object-oriented-principles-demo-folder)
1. [Foundational UML Relationships (`uml_foundations/` folder)](#1-foundational-uml-relationships-uml_foundations-folder)
2. [Factory Method Pattern (`factory/` folder)](#2-factory-method-pattern-factory-folder)
   - [Intent & Problem Statement](#factory-method-intent--problem-statement)
   - [UML Class Structure](#factory-method-uml-class-structure)
   - [Case Implementations](#factory-method-case-implementations)
   - [Pros & Cons](#factory-method-pros--cons)
3. [Abstract Factory Pattern (`abstract_factory/` folder)](#3-abstract-factory-pattern-abstract_factory-folder)
   - [Intent & Problem Statement](#abstract-factory-intent--problem-statement)
   - [UML Class Structure](#abstract-factory-uml-class-structure)
   - [Case Implementations](#abstract-factory-case-implementations)
   - [Pros & Cons](#abstract-factory-pros--cons)
4. [Singleton Pattern (`Singleton/` folder)](#4-singleton-pattern-singleton-folder)
   - [Intent & Problem Statement](#singleton-intent--problem-statement)
   - [UML Class Structure](#singleton-uml-class-structure)
   - [Implementation Guidelines](#singleton-implementation-guidelines)
   - [Case Implementations](#singleton-case-implementations)
   - [Pros & Cons](#singleton-pros--cons)
5. [Builder Pattern (`Builder/` folder)](#5-builder-pattern-builder-folder)
   - [Intent & Problem Statement](#builder-intent--problem-statement)
   - [UML Class Structure](#builder-uml-class-structure)
   - [Case Implementations](#builder-case-implementations)
   - [Abstract Factory vs. Builder Comparison](#abstract-factory-vs-builder-comparison)
   - [Pros & Cons](#builder-pros--cons)

---

## 0. Foundational Object-Oriented Principles (`demo/` folder)

Before introducing Creational Patterns, the course establishes core Object-Oriented principles in [sessionals/demo/](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/demo/):

- **Tight Coupling vs. Decoupling**:
  - *Problem*: Directly referencing concrete classes makes systems rigid and fragile to change.
  - *Implementation*: [BadPaymentExample.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/demo/BadPaymentExample.java) demonstrates `CheckoutService` tightly bound to `BkashPaymentGatewayDirect`.
- **Program to an Interface, Not an Implementation**:
  - *Principle*: High-level modules should depend on abstractions (interfaces), allowing runtime substitution.
  - *Implementation*: [InterfacePaymentExample.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/demo/InterfacePaymentExample.java) defines `PaymentGateway` interface (`BkashPaymentGateway`, `NagadPaymentGateway`, `FakePaymentGateway`) injected into `CheckoutService2`.
- **Documentation**: [demo/README.md](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/demo/README.md).

---

## 1. Foundational UML Relationships (`uml_foundations/` folder)

Introduced in **Slide 2**, Creational Patterns build upon fundamental Object-Oriented relationships implemented in [UmlRelationshipsDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/uml_foundations/UmlRelationshipsDemo.java) (see [uml_foundations/README.md](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/uml_foundations/README.md)):

- **Generalization (Inheritance/Realization)**:
  - Concept: Class extension (`extends`) or interface realization (`implements`).
  - Example: `Shape` (interface) ← `RectangularShape` (abstract) ← `Rectangle` (concrete).
- **Aggregation ("is part of" — weak ownership)**:
  - Concept: Container object holds references to component objects, but components can exist independently.
  - Representation: Open diamond `◇—`
  - Example: `Car` `◇—` `Engine` (Engine can exist outside a specific car).
- **Composition ("is entirely made of" — strong ownership)**:
  - Concept: Container manages lifetime of component objects. If container is destroyed, components are destroyed.
  - Representation: Filled diamond `◆—`
  - Example: `Book` `◆—` `Page` (Pages do not exist independently of the book).
- **Dependency ("uses")**:
  - Concept: One class uses another temporarily (e.g., method parameter or local variable).
  - Representation: Dashed arrow `┄┄→`
  - Example: `Lottery` `┄┄→` `Random`.

---

## 2. Factory Method Pattern (`factory/` folder)

### Factory Method Intent & Problem Statement
- **Intent**: Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
- **Problem**: A framework/application needs to standardize architectural object creation without tightly coupling client code to specific concrete product classes.

### Factory Method UML Class Structure
- `Creator` (Abstract Class): Declares abstract `factoryMethod(): Product` and implements core logic `anOperation()`.
- `ConcreteCreator`: Overrides `factoryMethod()` to return a specific `ConcreteProduct`.
- `Product` (Interface/Abstract Class): Defines product interface.
- `ConcreteProduct`: Implements the `Product` interface.

### Factory Method Case Implementations

All code cases are fully implemented as standalone executable Java files in [creational/factory/](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/):

1. **Canonical Abstract Solution UML** ([GenericFactoryMethodDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/GenericFactoryMethodDemo.java))
   - *Slide 5*: Canonical implementation of `Creator`, `ConcreteCreatorA/B`, `Product`, `ConcreteProductA/B`.

2. **Drawing Shape Factory** ([DrawingFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/DrawingFactoryDemo.java))
   - *Slides 6–7*: `ShapeFactory` instantiates `Circle`, `Rectangle`, or `Square` based on parameters without revealing creation logic to `FactoryPatternDemo`.

3. **Kiosk Payment Factory** ([KioskPaymentDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/KioskPaymentDemo.java))
   - *Slide 8*: `GetPayment` returns concrete implementations (`Cash`, `Coupon`, `CreditCard`) for `Kiosk` checkout operations.

4. **Electricity Billing Factory** ([BillingDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/BillingDemo.java))
   - *Slides 9–11*: `GetPlanFactory` constructs specific plan objects (`DomesticPlan`, `CommercialPlan`, `InstitutionalPlan`) extending abstract `Plan`. `GenerateBill` computes bill amounts dynamically.

5. **Logistics Management App** ([LogisticsDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/LogisticsDemo.java))
   - *Slide 12*: Demonstrates refactoring from a single `Truck` codebase to support `Ship` logistics via abstract creator `Logistics` (`RoadLogistics` vs. `SeaLogistics`).

6. **Cross-Platform UI Dialog** ([DialogDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/factory/DialogDemo.java))
   - *Slides 13–14*: UI framework deferring button creation (`WindowsButton` vs `HTMLButton`) via `WindowsDialog` and `WebDialog` creators.

### Factory Method Pros & Cons
- **Pros**:
  - Avoids tight coupling between creator and concrete products.
  - *Single Responsibility Principle*: Product creation code is isolated in one place.
  - *Open/Closed Principle*: New product types can be added without breaking client code.
- **Cons**:
  - Requires introducing new subclasses for each new product type, increasing code hierarchy complexity.

---

## 3. Abstract Factory Pattern (`abstract_factory/` folder)

### Abstract Factory Intent & Problem Statement
- **Intent**: Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
- **Problem**: Applications need to work with multiple product families (e.g., UI themes, cross-platform UI components, OS-specific drivers) ensuring created products are compatible.

### Abstract Factory UML Class Structure
- `AbstractFactory` (Interface): Declares creation methods for each product type in the family (`createProductA()`, `createProductB()`).
- `ConcreteFactory1`, `ConcreteFactory2`: Implement creation methods to produce family-specific variants.
- `AbstractProductA`, `AbstractProductB`: Define product interface families.
- `Client`: Uses factory and product interfaces exclusively.

### Abstract Factory Case Implementations

All code cases are fully implemented as standalone executable Java files in [creational/abstract_factory/](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/):

1. **Canonical Abstract Solution UML** ([GenericAbstractFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/GenericAbstractFactoryDemo.java))
   - *Slide 18*: Canonical implementation of `CanonicalAbstractFactory`, `ConcreteFactory1/2`, `AbstractProductA/B`, `ProductA1/A2/B1/B2`.

2. **Cross-Platform GUI Factory** ([GuiFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/GuiFactoryDemo.java))
   - *Slides 23, 25–29*: `GUIFactory` creates variants of `Button` and `Checkbox` for Windows (`WinFactory`) and macOS (`MacFactory`).

3. **Furniture Shop Simulator** ([FurnitureFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/FurnitureFactoryDemo.java))
   - *Slides 19–22*: Product family consisting of `Chair`, `Sofa`, and `CoffeeTable` produced across style variants (`VictorianFurnitureFactory` vs `ModernFurnitureFactory`).

4. **Honda Car Factory** ([HondaCarFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/HondaCarFactoryDemo.java))
   - *Slide 30*: `HondaFactory` interface implemented by `CivicFactory` and `AccordFactory` producing matching `Engine` and `Transmission` components.

5. **Shape & Color Factory of Factories** ([ShapeColorFactoryDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/abstract_factory/ShapeColorFactoryDemo.java))
   - *Slides 31–33*: `FactoryProducer` yields `ShapeFactory` or `ColorFactory`, generating `Shape` (`Circle`, `Rectangle`, `Square`) or `Color` (`Red`, `Green`, `Blue`) products.

### Abstract Factory Pros & Cons
- **Pros**:
  - Guarantees product compatibility within product families.
  - Avoids tight coupling between concrete products and client code.
  - Adheres to Single Responsibility Principle and Open/Closed Principle.
- **Cons**:
  - Extending product families with *new product types* requires modifying the `AbstractFactory` interface and all concrete factory implementations.

---

## 4. Singleton Pattern (`Singleton/` folder)

### Singleton Intent & Problem Statement
- **Intent**: Ensure a class has only one instance, and provide a global point of access to it.
- **Problem**: Shared application resources (e.g., database connections, logger instances, thread pools) require exactly one coordinator instance while enabling lazy initialization.

### Singleton UML Class Structure
- `SingletonClass`:
  - `- instance: SingletonClass` (private static field)
  - `- SingletonClass()` (private constructor)
  - `+ getInstance(): SingletonClass` (public static accessor)

### Singleton Implementation Guidelines
1. Private static field to hold the single instance.
2. Private constructor to block external instantiation.
3. Public static method (`getInstance()`) providing lazy initialization on first call.
4. Thread-safety considerations (double-checked locking or eager initialization).

### Singleton Case Implementations

All code cases are fully implemented as standalone executable Java files in [creational/Singleton/](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Singleton/):

1. **Canonical Singleton Class UML** ([BasicSingletonDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Singleton/BasicSingletonDemo.java))
   - *Slide 37*: Canonical `SingletonClass` implementation.

2. **DB Connection Manager** ([DbConnectionDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Singleton/DbConnectionDemo.java))
   - *Slide 38*: `DbConnection` lazy singleton managing access to database driver resources.

3. **Thread-Safe Double-Checked Singleton** ([ThreadSafeSingletonDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Singleton/ThreadSafeSingletonDemo.java))
   - *Slides 36–37, 39–42*: Thread-safe double-checked locking Singleton with volatile reference and multi-threaded concurrency validation test in `main`.

### Singleton Pros & Cons
- **Pros**:
  - Guaranteed single instance across application lifetime.
  - Global access point with lazy initialization saving system resources.
- **Cons**:
  - Can violate Single Responsibility Principle by managing lifecycle and domain behavior simultaneously.
  - Can introduce global state, complicating unit testing and mocking.

---

## 5. Builder Pattern (`Builder/` folder)

### Builder Intent & Problem Statement
- **Intent**: Separate the construction of a complex object from its representation so that the same construction process can create different representations. Parse a complex representation, create one of several targets.
- **Problem**: Construction of complex objects with many optional parameters leads to anti-patterns like telescoping constructors (`Product(a, b, c, d, e, f, ...)`).

### Builder UML Class Structure
- `Builder` / `IBuilder` (Interface): Specifies steps to build components of a complex object.
- `ConcreteBuilder`: Implements assembly steps and provides a method to retrieve the completed product.
- `Director`: Coordinates assembly order using a `Builder` instance.
- `Product`: The complex object being built.

### Builder Case Implementations

Implemented in [creational/Builder/](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Builder/):

1. **Complex Computer Assembly Builder** ([BuilderPatternDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Builder/BuilderPatternDemo.java))
   - *Slide 43*: Demonstrates step construction, omitting optional steps (`RAM` & `GPU`), and Modern Fluent Builder chaining.

2. **Vehicle Assembly Builder** ([VehicleBuilderDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Builder/VehicleBuilderDemo.java))
   - *Slide 44*: Demonstrates building `Car` and `MotorCycle` representations using `IBuilder` and `VehicleDirector`.

3. **CD Media Pack Builder** ([CDBuilderDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Builder/CDBuilderDemo.java))
   - *Slide 47*: Demonstrates assembling `Sony` and `Samsung` CD media packs using `CDBuilder`, `CDType`, and `Packing` interfaces.

### Abstract Factory vs. Builder Comparison

| Aspect | Abstract Factory | Builder |
| :--- | :--- | :--- |
| **Primary Purpose** | Create families of related objects | Construct a complex object step by step |
| **Focus** | *Which* objects to create | *How* to create an object |
| **Complexity** | Simple or moderately complex | Complex with many optional parts |
| **Construction Process** | Hidden from client | Exposed as a sequence of building steps |
| **Product Type** | Multiple related products | Usually one complex product |
| **Client Involvement** | Selects a factory family | Controls building sequence (directly or via Director) |

### Builder Pros & Cons
- **Pros**:
  - Step-by-step object construction allowing varying representation.
  - Reusable assembly code via `Director`.
  - Isolates complex construction code from business logic.
- **Cons**:
  - Requires creating multiple new builder classes, increasing overall codebase volume.

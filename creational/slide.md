# Creational Design Patterns — Course Slide Reference

## Slide 1 — Title
**Creational Patterns**

---

## Slide 2 — UML Revisited

- **Generalization**: Shape (interface, `+calculateArea():double`) ← RectangularShape (abstract, `-width:int`, `-height:int`, `/area:double`, `+calculateArea():double`, `+contains(x:int,y:int):bool`) ← Rectangle (`+Rectangle(x:int,y:int)`, `+distance(r:Rectangle):double`)
- **Aggregation ("is part of")**: Engine (1) ◇— (1) Car
- **Composition ("is entirely made of")**: Page (*) ◆— (1) Book
- **Dependency ("uses")**: Lottery ┄┄→ Random

---

## Slide 3 — Creational Patterns to be Covered

- Factory method
- Abstract factory
- Builder
- Singleton

Examples taken from:
- https://refactoring.guru/design-patterns
- https://javatechonline.com/java-design-patternsjava/
- https://www.tutorialspoint.com/design_pattern/
- https://www.javatpoint.com/design-patterns-in-java

---

## Slide 4 — Factory Method

**Intent** — Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.

**Problem**
- A framework needs to standardize the architectural model for a range of applications, but allow for individual applications to define their own domain objects and provide for their instantiation.
- Enable the creator to defer product creation to sub-class.

---

## Slide 5 — Solution (Factory Method)

UML:
- `Creator` (abstract): `#factoryMethod():Product`, `+anOperation()`
- `Product` (abstract)
- `Creator` "«use»" → `Product`
- `ConcreteCreator` extends `Creator`: `+factoryMethod():Product`
- `ConcreteCreator` "«create»" → `ConcreteProduct`
- `ConcreteProduct` extends `Product`

---

## Slide 6 — Example: Drawing

UML only:
- `<<interface>> Shape` : `+draw()`
- `Circle +draw()`, `Rectangle +draw()`, `Square +draw()` all implement `Shape`
- `ShapeFactory +drawShape(type):Shape`
- `Client`

---

## Slide 7 — Code (Drawing example)

```java
public interface Shape { 
    void draw(); 
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method."); 
    }
}
// Similar implementation for Square and Circle

public class ShapeFactory {
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }		
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}
```

---

## Slide 8 — Example: Kiosk

UML only:
- `<<interface>> PaymentProcessor`: `+processPayment()`
- `Cash +processPayment()`, `Coupon +processPayment()`, `CreditCard +processPayment()` all implement `PaymentProcessor`
- `GetPayment +getProcessor(type):PaymentProcessor`
- `Kiosk`

---

## Slide 9 — Factory (Billing diagram)

UML:
- `Plan` («abstract class»): `#rate:double`, `+getRate():void`, `+calculateBill(int units):void`
- `DomesticPlan`, `CommercialPlan`, `InstitutionalPlan` all extend `Plan`, each `+getRate():void`
- `GenerateBill +main():void` → "asks" → `GetPlanFactory +getPlan():Plan` → "creates" → the three plan subclasses

---

## Slide 10 — Code (Billing: Plan + subclasses)

```java
import java.io.*;
abstract class Plan{
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }
}

class DomesticPlan extends Plan{
    public void getRate(){
        rate=3.50;	
    }
}

class CommercialPlan extends Plan{
    public void getRate(){
        rate=7.50;
    }
}

class InstitutionalPlan extends Plan{
    public void getRate(){
        rate=5.50;
    }
}
```

---

## Slide 11 — Code (Billing: GetPlanFactory + GenerateBill)

```java
class GetPlanFactory{
    public Plan getPlan(String planType){
        if(planType == null){
            return null;
        }
        if(planType.equalsIgnoreCase("DOMESTICPLAN")) {
            return new DomesticPlan();
        } 
        else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){
            return new CommercialPlan();
        } 
        else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}

import java.io.*;
class GenerateBill{
    public static void main(String args[])throws IOException{
        GetPlanFactory planFactory = new GetPlanFactory();
        System.out.print("Enter the name of plan for which the bill will be generated: ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String planName=br.readLine();
        System.out.print("Enter the number of units for bill will be calculated: ");
        int units=Integer.parseInt(br.readLine());
        Plan p = planFactory.getPlan(planName);
        System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");
        p.getRate();
        p.calculateBill(units);
    }
}
```

---

## Slide 12 — Logistics Usecase

- Imagine creating a logistics management app starting with `Truck`.
- Sea logistics requires `Ship`. Factory method allows extending without tight coupling.

---

## Slide 13 — Cross-platform Dialog

UML & Pseudocode for `WindowsDialog`, `WebDialog`, `WindowsButton`, `HTMLButton`.

---

## Slide 14 — Extension via Factory Method

Extending framework UI with `RoundButton` and `UIWithRoundButtons`.

---

## Slide 15 & 16 — Factory Method Consequences & Pros/Cons

- Pros: Avoids tight coupling, Single Responsibility Principle, Open/Closed Principle.
- Cons: Increased subclass count.

---

## Slide 17 — Abstract Factory

**Intent** — Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

---

## Slide 18 — Solution (Abstract Factory)

UML: `AbstractFactory` (`CreateProductA()`, `CreateProductB()`), `ConcreteFactory1`, `ConcreteFactory2`, `AbstractProductA`, `AbstractProductB`.

---

## Slides 19–22 — Furniture Shop Problem & Solution

Families of products (`Chair`, `Sofa`, `CoffeeTable`) across style variants (`Victorian`, `Modern`).

---

## Slides 23–29 — Cross-Platform GUI Example

`GUIFactory` (`WinFactory`, `MacFactory`), `Button` (`WinButton`, `MacButton`), `Checkbox` (`WinCheckbox`, `MacCheckbox`), `Application`.

---

## Slide 30 — Car Factory Example

`HondaFactory` (`CivicFactory`, `AccordFactory`), `Engine`, `Transmission`.

---

## Slides 31–33 — Shape & Color Abstract Factory

`AbstractFactory`, `ShapeFactory`, `ColorFactory`, `FactoryProducer`.

---

## Slides 34–35 — Abstract Factory Consequences & Pros/Cons

- Pros: Product compatibility, loose coupling, SRP, OCP.
- Cons: Hard to introduce new product types.

---

## Slides 36–42 — Singleton Pattern

- Intent, UML (`SingletonClass`), `DbConnection` example, Implementation steps, Applicability, Pros/Cons.

---

## Slide 43 — Builder Pattern

**Intent** — Separate the construction of a complex object from its representation so that the same construction process can create different representations. Parse a complex representation, create one of several targets.

**Problem** — Creating elements of a complex aggregate where specifications exist on secondary storage and representations need to be built in primary storage.

---

## Slide 44 — Vehicle Builder Example

```java
// Builders common interface
interface IBuilder {
    void BuildBody();
    void InsertWheels();
    void AddHeadlights();
    Product GetVehicle();
}

class Product {
    private LinkedList<String> parts = new LinkedList<String>();
    public void Add(String part) { parts.add(part); }
    public void Show() {
        for (String part : parts) System.out.println(part);
    }
}

class Car implements IBuilder {
    private Product product = new Product();
    @Override public void BuildBody() { product.Add("This is a body of a Car"); }
    @Override public void InsertWheels() { product.Add("4 wheels are added"); }
    @Override public void AddHeadlights() { product.Add("2 Headlights are added"); }
    @Override public Product GetVehicle() { return product; }
}

class MotorCycle implements IBuilder {
    private Product product = new Product();
    @Override public void BuildBody() { product.Add("This is a body of a Motorcycle"); }
    @Override public void InsertWheels() { product.Add("2 wheels are added"); }
    @Override public void AddHeadlights() { product.Add("1 Headlight is added"); }
    @Override public Product GetVehicle() { return product; }
}

class Director {
    private IBuilder myBuilder;
    public void Construct(IBuilder builder) {
        myBuilder = builder;
        myBuilder.BuildBody();
        myBuilder.InsertWheels();
        myBuilder.AddHeadlights();
    }
}
```

---

## Slide 45 — Comparison: Abstract Factory vs Builder

| Aspect | Abstract Factory | Builder |
| :--- | :--- | :--- |
| **Primary purpose** | Create families of related objects | Construct a complex object step by step |
| **Focus** | Which objects to create | How to create an object |
| **Complexity of product** | Usually simple or moderately complex | Usually complex with many optional parts |
| **Construction process** | Hidden from client | Exposed as a sequence of building steps |
| **Product type** | Multiple related products | Usually one complex product |
| **Client involvement** | Client selects a factory | Client controls building sequence (directly or through Director) |

---

## Slide 46 — Decision Guidelines & Scenarios

- Use **Abstract Factory** when: Multiple product families, object compatibility required, construction process not important, swapping product families.
- Use **Builder** when: Object is complex, many optional parameters, construction occurs in stages, different sequences produce different representations.

---

## Slide 47 — CD Media Builder Example

```java
public interface Packing {
    public String pack();
    public int price();
}

public abstract class CD implements Packing {
    public abstract String pack();
}

public abstract class Company extends CD {
    public abstract int price();
}

public class Sony extends Company {
    @Override public int price() { return 20; }
    @Override public String pack() { return "Sony CD"; }
}

public class Samsung extends Company {
    @Override public int price() { return 15; }
    @Override public String pack() { return "Samsung CD"; }
}

public class CDType {
    private List<Packing> items = new ArrayList<Packing>();
    public void addItem(Packing packs) { items.add(packs); }
    public void getCost() {
        for (Packing packs : items) packs.price();
    }
    public void showItems() {
        for (Packing packing : items) {
            System.out.println("CD name : " + packing.pack() + ", Price : " + packing.price());
        }
    }
}

public class CDBuilder {
    public CDType buildSonyCD() {
        CDType cds = new CDType();
        cds.addItem(new Sony());
        return cds;
    }

    public CDType buildSamsungCD() {
        CDType cds = new CDType();
        cds.addItem(new Samsung());
        return cds;
    }
}

public class BuilderDemo {
    public static void main(String args[]) {
        CDBuilder cdBuilder = new CDBuilder();
        CDType cdType1 = cdBuilder.buildSonyCD();
        cdType1.showItems();
        CDType cdType2 = cdBuilder.buildSamsungCD();
        cdType2.showItems();
    }
}
```

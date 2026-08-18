# Foundational Object-Oriented UML Relationships

## Overview
This directory documents and implements the four foundational Object-Oriented UML relationships introduced in **Slide 2** of [slide.md](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/slide.md). Understanding these relationships is essential for mastering Creational Design Patterns.

---

## The 4 UML Relationships

### 1. Generalization (Inheritance / Realization)
- **Concept**: Represents an *"is a"* relationship between classes via extension (`extends`) or interface realization (`implements`).
- **Slide 2 Structure**: `Shape` (interface) ← `RectangularShape` (abstract) ← `Rectangle` (concrete).
- **Notation**: Solid line with an open arrowhead pointing to the parent/interface.

### 2. Aggregation ("is part of" — Weak Relationship)
- **Concept**: A container object holds references to component objects, but components can exist independently outside the container lifecycle.
- **Slide 2 Structure**: `Engine` (1) ◇— (1) `Car`.
- **Notation**: Line with an open diamond `◇—` at the container end.

### 3. Composition ("is entirely made of" — Strong Relationship)
- **Concept**: A container object manages the creation, ownership, and destruction of its component objects. Components cannot exist without the container.
- **Slide 2 Structure**: `Page` (*) ◆— (1) `Book`.
- **Notation**: Line with a filled diamond `◆—` at the container end.

### 4. Dependency ("uses" — Temporary Relationship)
- **Concept**: One class temporarily depends on another class during method execution (e.g. passed as a parameter or instantiated as a local variable).
- **Slide 2 Structure**: `Lottery` ┄┄→ `Random`.
- **Notation**: Dashed line with an arrowhead `┄┄→`.

---

## How to Run the Demo

```bash
javac creational/uml_foundations/UmlRelationshipsDemo.java
java -cp creational/uml_foundations UmlRelationshipsDemo
```

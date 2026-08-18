# Singleton Pattern

## Overview & Intent
The **Singleton Pattern** ensures a class has only one instance, and provides a global point of access to it.

- **Source Reference**: Slides 36–42 of [slide.md](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/slide.md)

---

## UML Structure

```
+-----------------------------------+
|          SingletonClass           |
+-----------------------------------+
| - instance: SingletonClass        |
+-----------------------------------+
| - SingletonClass()                |
| + getInstance(): SingletonClass   |
+-----------------------------------+
```

---

## Key Implementation Guidelines
1. **Private Static Instance Reference**: Stores the unique single instance.
2. **Private Constructor**: Prevents instantiation using the `new` operator from outside the class.
3. **Public Static Getter Method**: Controls access to the single instance and performs lazy initialization when called for the first time.
4. **Thread Safety (Double-Checked Locking)**: Uses `volatile` and `synchronized` blocks in multi-threaded environments.

---

## Case Studies & Implementations

This folder contains two complete, executable Java implementations for the Singleton cases in the slides:

### 1. Database Connection Manager Singleton ([DbConnectionDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Singleton/DbConnectionDemo.java))
- **Source**: Slide 38
- **Description**: Demonstrates lazy initialization of a database connection instance via `DbConnection.getDbConnection()`.
- **Run Command**:
  ```bash
  javac creational/Singleton/DbConnectionDemo.java
  java -cp creational/Singleton DbConnectionDemo
  ```

### 2. Thread-Safe Double-Checked Singleton ([ThreadSafeSingletonDemo.java](file:///home/rish/Desktop/2-2/Software%20engineering/sessionals/creational/Singleton/ThreadSafeSingletonDemo.java))
- **Source**: Slides 36–37, 39–42
- **Description**: Demonstrates double-checked locking using a `volatile` reference, validated with multi-threaded concurrent execution test.
- **Run Command**:
  ```bash
  javac creational/Singleton/ThreadSafeSingletonDemo.java
  java -cp creational/Singleton ThreadSafeSingletonDemo
  ```

---

## Pros and Cons

| Pros | Cons |
| :--- | :--- |
| **Guaranteed Single Instance**: Ensures strictly 1 object instance exists. | Violates **Single Responsibility Principle**: Manages lifecycle & behavior simultaneously. |
| **Global Access Point**: Accessible from anywhere in the program safely. | Harder to **unit test** due to static global state. |
| **Lazy Initialization**: Created only on first request, conserving resources. | |

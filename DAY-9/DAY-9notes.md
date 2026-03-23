# 📘 Day 9 Learning – Java Core + Multithreading + Design Patterns

---

# 🧩 Design Patterns in Java

Design Patterns are **proven solutions** to common problems in software design. They are not code, but **blueprints** that help us write **clean, scalable, and maintainable applications**.

✨ Why use Design Patterns?

* 🔁 Reusability
* 🧼 Clean code
* 🔗 Loose coupling
* 📈 Scalability

---

## 🧠 Mind Map – Design Patterns

```
Design Patterns
│
├── 🏗️ Creational
│   ├── Singleton
│   ├── Factory
│   └── Builder
│
├── 🧱 Structural
│   ├── Adapter
│   ├── Decorator
│   └── Facade
│
└── 🔄 Behavioral
    ├── Observer
    ├── Strategy
    └── Command
```

---

# 🔒 Singleton Pattern

## 📌 Definition

Ensures **only one instance** of a class exists and provides a **global access point**.

---

## 🌍 Real-Life Example

* 🗄️ Database connection
* 🖨️ Printer spooler
* ⚙️ Configuration manager

---

## 💻 Code

```java
class Singleton {

    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

---

## 🧠 Mind Map – Singleton

```
Singleton
│
├── 🔐 Private Constructor
├── 📦 Static Instance
├── 🌐 Global Access
└── ⚠️ Thread Safety (Important)
```

---

# 🏭 Factory Pattern

## 📌 Definition

Creates objects **without exposing creation logic**.

---

## 🌍 Real-Life Example

* 🍔 Food ordering system
* 💳 Payment system (UPI, Card, Cash)
* 📩 Notification system (Email, SMS)

---

## 💻 Code

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw(){
        System.out.println("Circle");
    }
}

class ShapeFactory {
    public static Shape getShape(String type){
        if(type.equals("circle")) return new Circle();
        return null;
    }
}
```

---

## 🧠 Mind Map – Factory

```
Factory Pattern
│
├── 🎯 Hide Object Creation
├── 🔗 Loose Coupling
├── 🧩 Uses Interface
└── ➕ Easy to Extend
```

---

# 🏗️ Builder Pattern

## 📌 Definition

Used to create **complex objects step-by-step**.

---

## 🌍 Real-Life Example

* 🏠 Building a house
* 🍔 Custom burger
* 👤 User object with many fields

---

## 💻 Code

```java
class User {

    private String name;
    private int age;

    private User(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
    }

    static class Builder {

        private String name;
        private int age;

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
```

---

## 🧠 Mind Map – Builder

```
Builder Pattern
│
├── 🧩 Complex Object Creation
├── 🔄 Step-by-step Building
├── 📖 Readable Code
└── 🚫 Avoid Constructor Confusion
```

---

# ⚛️ Atomic Classes

## 📌 Definition

Provide **thread-safe operations without using locks**.

---

## 🌍 Real-Life Example

* 👥 Counting users
* 📊 Hit counter

---

## 💻 Code

```java
AtomicInteger count = new AtomicInteger(0);
count.incrementAndGet();
```

---

## 🧠 Mind Map – Atomic

```
Atomic Classes
│
├── ⚡ Lock-Free
├── 🔄 CAS (Compare & Swap)
├── 🚀 High Performance
└── 📦 Package: java.util.concurrent.atomic
```

---

# 🔁 volatile vs synchronized

---

## 🔹 volatile

📌 Ensures **visibility only**

* 🔄 Updates visible across threads
* 🚫 No locking
* 🚫 No atomicity

---

## 🔹 synchronized

📌 Ensures **mutual exclusion**

* 🔒 Only one thread at a time
* ✔ Visibility + Atomicity
* 🐢 Slightly slower

---

## ⚖️ Difference Table

```
volatile
│
├── ✔ Visibility
├── ❌ No Atomicity
└── ⚡ Fast

synchronized
│
├── ✔ Visibility
├── ✔ Atomicity
└── 🔒 Locking
```

---

# 🧠 Java Memory Model (JMM)

## 📌 Definition

Defines how **threads interact with memory** and ensures **data consistency**.

---

## 🧠 Structure

```
JMM
│
├── 🧠 Main Memory
│   └── Shared variables
│
└── 🧵 Thread Memory
    └── Local copies
```

---

## 🌍 Real-Life Example

```
Two employees working on same file:
One updates → other still sees old version ❌
```

👉 This is **visibility problem**

---

## ✅ Solution (JMM ensures)

* 👀 Visibility
* 🔄 Ordering
* ⚖️ Atomicity

---

## 🔗 Happens-Before Rule

```
If A happens-before B
→ B will see all changes of A
```

---

## 🧠 Mind Map – JMM

```
Java Memory Model
│
├── 🧠 Main Memory
├── 🧵 Thread Memory
├── ⚠️ Visibility Issue
│
└── ✅ Solutions
    ├── volatile
    ├── synchronized
    └── locks
```

---

# 🎯 Final Interview Quick Revision

```
Singleton  → One object only
Factory    → Hide object creation
Builder    → Complex object creation
Atomic     → Thread-safe without locks
volatile   → Visibility only
synchronized → Visibility + Atomicity
JMM        → Thread-memory interaction
```

---

# 📌 Pro Tip for Interview

👉 Always explain in this flow:

1. Definition
2. Real-life example
3. Code (if asked)
4. Key points


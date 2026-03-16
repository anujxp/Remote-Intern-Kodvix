# 1️⃣ Variables & Scope in Java

A **variable** is a container that stores data.

Example:

```java
int age = 21;
```

In Java there are **three types of variables based on scope**:

1️⃣ Local Variable
2️⃣ Instance Variable
3️⃣ Static Variable

---

# 1. Local Variables

A **local variable** is declared **inside a method, constructor, or block**.

It is accessible **only within that method**.

---

## Example

```java
class LocalVariableExample {

    public void show() {

        int x = 10;  // local variable

        System.out.println("Local variable x = " + x);
    }

    public static void main(String[] args) {

        LocalVariableExample obj = new LocalVariableExample();
        obj.show();

    }
}
```

---

## What happens in memory

When method `show()` starts:

```
Stack Memory
-------------
x = 10
```

When method finishes:

```
x is destroyed
```

Local variables **exist only during method execution**.

---

## Another Example (Scope)

```java
class LocalScopeExample {

    public static void main(String[] args) {

        int a = 10;

        if (true) {

            int b = 20;

            System.out.println(a); // valid
            System.out.println(b); // valid

        }

        System.out.println(a); // valid
        // System.out.println(b); // ERROR

    }
}
```

Because **b exists only inside the if block**.

---

# Interview Answer (Local Variable)

> A local variable is declared inside a method, constructor, or block and its scope is limited to that method or block. It is stored in stack memory and is destroyed once the method execution completes.

---

# 2️⃣ Instance Variables

An **instance variable** is declared **inside a class but outside methods**.

Each object has **its own copy**.

---

## Example

```java
class Student {

    int id;        // instance variable
    String name;   // instance variable

}
```

Now create objects:

```java
public class InstanceVariableExample {

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();

        s1.id = 1;
        s1.name = "Anuj";

        s2.id = 2;
        s2.name = "Rahul";

        System.out.println(s1.id + " " + s1.name);
        System.out.println(s2.id + " " + s2.name);

    }

}
```

Output:

```
1 Anuj
2 Rahul
```

---

## Memory Explanation

```
Heap Memory
------------------
Student Object 1
id = 1
name = Anuj

Student Object 2
id = 2
name = Rahul
```

Each object has **separate instance variables**.

---

# Interview Answer (Instance Variable)

> Instance variables are declared inside a class but outside methods. They belong to an object, and each object has its own copy. These variables are stored in heap memory.

---

# 3️⃣ Static Variables

A **static variable belongs to the class rather than the object**.

Only **one copy exists for the entire class**.

---

## Example

```java
class Student {

    int id;
    String name;

    static String college = "GHSC";

}
```

Program:

```java
public class StaticVariableExample {

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();

        s1.id = 1;
        s1.name = "Anuj";

        s2.id = 2;
        s2.name = "Rahul";

        System.out.println(s1.id + " " + s1.name + " " + Student.college);
        System.out.println(s2.id + " " + s2.name + " " + Student.college);

    }
}
```

Output:

```
1 Anuj GHSC
2 Rahul GHSC
```

Both objects share the same **college variable**.

---

## Memory Structure

```
Method Area / Class Area
-------------------------
college = GHSC
```

```
Heap
-----------
Student Object 1
id
name

Student Object 2
id
name
```

---

# Interview Answer (Static Variable)

> A static variable belongs to the class rather than an object. Only one copy of the variable exists and it is shared among all instances of the class. It is stored in the class memory area.

---

# Comparison Table

| Variable | Declared       | Memory     | Copy             |
| -------- | -------------- | ---------- | ---------------- |
| Local    | inside method  | stack      | new every method |
| Instance | inside class   | heap       | per object       |
| Static   | static keyword | class area | one copy         |

---

# 2️⃣ Type Casting in Java

Type casting means **converting one data type into another**.

Example:

```
int → double
double → int
```

There are **two types of casting**:

1️⃣ Implicit (Automatic)
2️⃣ Explicit (Manual)

---

# 1. Implicit Casting (Widening)

Java automatically converts **smaller type → larger type**.

Example:

```java
public class ImplicitCastingExample {

    public static void main(String[] args) {

        int a = 10;

        double b = a; // automatic conversion

        System.out.println("Value of b: " + b);

    }

}
```

Output:

```
10.0
```

---

## Conversion Hierarchy

```
byte
  ↓
short
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

This is called **Widening Conversion**.

No data loss occurs.

---

# 2. Explicit Casting (Narrowing)

When converting **larger type → smaller type**, Java requires **manual casting**.

---

## Example

```java
public class ExplicitCastingExample {

    public static void main(String[] args) {

        double a = 10.75;

        int b = (int) a;

        System.out.println("Value of b: " + b);

    }

}
```

Output:

```
10
```

Decimal part removed.

---

# Example Showing Data Loss

```java
public class DataLossExample {

    public static void main(String[] args) {

        int number = 130;

        byte b = (byte) number;

        System.out.println(b);

    }

}
```

Output:

```
-126
```

Because **byte range is -128 to 127**.

---

# Interview Answer (Type Casting)

> Type casting is the process of converting one data type into another. Java supports two types of casting: implicit casting, where smaller data types are automatically converted to larger data types, and explicit casting, where larger data types are manually converted to smaller data types using a cast operator.

---

# Scenario-Based Interview Question

### Question

What happens here?

```java
int a = 10;
double b = a;
```

Answer:

> This is implicit casting where the integer value is automatically converted into a double because double has a larger range.

---

### Question

What happens here?

```java
double x = 20.5;
int y = (int) x;
```

Answer:

> This is explicit casting where the double value is manually converted to an integer, resulting in loss of the decimal part.

---

# One-Line Interview Summary

Variables:

> Java variables can be local, instance, or static depending on their scope and lifetime.

Type Casting:

> Type casting in Java is the process of converting one data type to another and can be implicit (automatic) or explicit (manual).



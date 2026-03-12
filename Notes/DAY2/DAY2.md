

# 1. JVM Heap Structure

## What is Heap Memory?

**Heap memory** is the runtime memory area in the JVM where **objects and instance variables are stored**.

Whenever you create an object using `new`, the memory is allocated in the **heap**.

Example:

```java
Student s = new Student();
```

Here the `Student` object is created in **heap memory**.

Heap memory is managed by the **Garbage Collector (GC)**.

---

# Structure of Heap Memory

Modern JVM divides heap into **three major parts**:

1️⃣ Young Generation
2️⃣ Old Generation
3️⃣ Metaspace

---

## Heap Structure Overview

![Image](https://miro.medium.com/1%2Aiu2q9yLXLqIQ7skX8uhFkw.png)

![Image](https://i.sstatic.net/uDdEk.png)

![Image](https://miro.medium.com/v2/resize%3Afit%3A1400/1%2AZTxD3ajfto1--aNKwlLL0Q.png)

![Image](https://itzsrv.com/static/55998773d3933af1327d3560a71ff975/083f8/jvm-mem.png)

---

# 1. Young Generation

Young generation stores **newly created objects**.

Most objects in Java are **short-lived**, so they are first placed in this area.

Young generation has **three parts**:

* **Eden Space**
* **Survivor Space S0**
* **Survivor Space S1**

### Object Allocation Flow

```
New Object → Eden
```

If the object survives GC:

```
Eden → Survivor (S0 / S1)
```

After surviving multiple GCs:

```
Survivor → Old Generation
```

---

# 2. Old Generation (Tenured Generation)

This area stores **long-lived objects**.

Objects that survive multiple **minor garbage collections** move here.

Examples:

* Application caches
* Static objects used throughout the application

Garbage collection here is called:

**Major GC / Full GC**

This GC is **slow and expensive**.

---

# 3. Metaspace

Metaspace stores **class metadata** such as:

* Class structure
* Method information
* Static variables
* Runtime constant pool

Important difference:

Before Java 8 it was **PermGen**.

From **Java 8 onward it became Metaspace**, which is stored in **native memory instead of heap**.

Advantages:

* No fixed memory limit
* Better memory management

---

# Complete Object Lifecycle

```
Object Created
     ↓
Eden Space
     ↓
Minor GC
     ↓
Survivor Space
     ↓
After multiple cycles
     ↓
Old Generation
     ↓
Major GC
     ↓
Object removed
```

---

# Interview Answer (JVM Heap Structure)

If interviewer asks:

**"Explain JVM Heap structure."**

Answer:

> JVM heap memory is divided into three main regions: Young Generation, Old Generation, and Metaspace. Newly created objects are first allocated in the Young Generation, specifically in the Eden space. If objects survive minor garbage collection cycles, they move to Survivor spaces and eventually to the Old Generation where long-lived objects reside. Metaspace stores class metadata and replaced PermGen from Java 8 onwards. Garbage collection mainly occurs in these regions to reclaim unused memory.

---

# 2. G1 Garbage Collector (Overview)

## What is Garbage Collection?

Garbage Collection is the **automatic process of removing unused objects from memory**.

Java uses **different GC algorithms**, such as:

* Serial GC
* Parallel GC
* CMS
* **G1 GC (Most popular)**

---

# What is G1 GC?

**G1 (Garbage First) Garbage Collector** is a modern GC designed for **large heap sizes and low pause times**.

It was introduced in **Java 7** and became **default GC in Java 9**.

---

# Traditional GC Problem

Earlier collectors divided heap into:

```
Young + Old
```

But scanning the **entire heap** caused long pauses.

---

# G1 GC Solution

G1 divides heap into **many small regions instead of large generations**.

Each region can belong to:

* Eden
* Survivor
* Old

---

## G1 GC Structure

![Image](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/G1GettingStarted/images/HeapStructure.png)

![Image](https://opensource.com/sites/default/files/2022-07/g1.png)

![Image](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/G1GettingStarted/images/slide9.png)

![Image](https://imgopt.infoq.com/fit-in/3000x4000/filters%3Aquality%2885%29/filters%3Ano_upscale%28%29/articles/tuning-tips-G1-GC/en/resources/fig1.jpg)

Heap is divided into **small equal regions** (like blocks).

Example:

```
Region 1
Region 2
Region 3
Region 4
```

Some regions hold young objects, some hold old objects.

---

# How G1 GC Works

### Step 1: Object Allocation

Objects are created in **Eden regions**.

---

### Step 2: Minor GC

G1 identifies regions with **most garbage first**.

It cleans those regions first.

This is why it is called:

**Garbage First Collector**

---

### Step 3: Region Cleanup

Instead of cleaning entire heap:

```
GC cleans selected regions
```

This reduces pause time.

---

### Step 4: Compaction

G1 also performs **memory compaction**.

Meaning:

Objects are rearranged to remove **fragmentation**.

---

# Advantages of G1 GC

1️⃣ Predictable pause time
2️⃣ Works well with large heaps
3️⃣ Region-based cleaning
4️⃣ Avoids long GC pauses

---

# Interview Answer (G1 GC)

If interviewer asks:

**"Explain G1 Garbage Collector."**

Answer:

> G1 Garbage Collector is a server-style garbage collector designed for large heap sizes and low pause times. It divides the heap into multiple regions instead of fixed generations. During garbage collection, it prioritizes regions with the most garbage, which is why it is called Garbage First. This approach reduces pause times and improves memory management compared to traditional collectors.

---

# 3. Memory Leak vs OutOfMemoryError

This is a **very common interview question**.

---

# Memory Leak

A **memory leak occurs when objects are no longer needed but are still referenced**, so the garbage collector cannot remove them.

Example:

```java
List list = new ArrayList();

while(true){
    list.add(new Object());
}
```

Objects keep accumulating in memory.

GC cannot remove them because they are still referenced in `list`.

Result:

```
Memory keeps increasing
```

---

# OutOfMemoryError (OOM)

This occurs when **JVM cannot allocate more memory**.

Example:

```
Heap space is completely full
```

Error:

```
java.lang.OutOfMemoryError: Java heap space
```

---

# Difference Table

| Feature     | Memory Leak                     | OutOfMemoryError           |
| ----------- | ------------------------------- | -------------------------- |
| Meaning     | unused objects still referenced | JVM cannot allocate memory |
| Cause       | bad coding practice             | memory exhaustion          |
| GC behavior | GC cannot remove objects        | GC tries but fails         |
| Result      | slow memory growth              | application crash          |

---

# Interview Answer (Memory Leak vs OOM)

If interviewer asks:

**"What is the difference between memory leak and OutOfMemoryError?"**

Answer:

> A memory leak occurs when objects that are no longer needed are still referenced in the program, preventing the garbage collector from reclaiming their memory. Over time, this leads to memory exhaustion and may eventually cause an OutOfMemoryError, which occurs when the JVM cannot allocate additional memory for new objects.

---

# Scenario-Based Interview Questions

These are **very commonly asked in senior interviews**.

---

# Scenario 1

**Question**

Your application memory usage keeps increasing but GC runs normally. What could be the issue?

Answer:

> This could indicate a memory leak where objects are still referenced in the application and therefore cannot be garbage collected.

---

# Scenario 2

**Question**

Your application suddenly crashes with:

```
OutOfMemoryError: Java heap space
```

What will you do?

Answer:

Steps:

1️⃣ Check heap size
2️⃣ Analyze heap dump
3️⃣ Use tools like:

* VisualVM
* JProfiler
* Eclipse MAT

4️⃣ Identify objects consuming memory

---

# Scenario 3

**Question**

Why is G1 GC preferred for large applications?

Answer:

> Because G1 GC divides heap into multiple regions and collects garbage from the most garbage-heavy regions first, which helps maintain predictable pause times and improves performance for large heap applications.

---

# One-Liner Interview Summary

**JVM Heap Structure**

> JVM heap is divided into Young Generation, Old Generation, and Metaspace where objects are allocated and managed by the garbage collector.

**G1 GC**

> G1 Garbage Collector divides heap into regions and collects regions with the most garbage first to reduce pause times.

**Memory Leak**

> Memory leak occurs when unused objects are still referenced and cannot be garbage collected.

**OutOfMemoryError**

> OutOfMemoryError occurs when the JVM cannot allocate additional memory for new objects.

---

✅ If you want, I can also explain **extremely tricky Java interview questions** like:

* **Why String is immutable**
* **Why HashMap is not thread safe**
* **How ConcurrentHashMap works internally**
* **ClassLoader working**
* **Java object creation inside JVM (deep)**

These are **very frequently asked in Java backend interviews.**








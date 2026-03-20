# 🚀 Java Collection Framework – Complete Notes (Day 5)

## 📌 Overview

The Java Collection Framework (JCF) provides a unified architecture to store, manage, and process groups of objects efficiently. It includes interfaces, implementations, and utility algorithms.

---

# 🧩 16.1 Collection Framework Overview

* Provides dynamic data structures
* Improves performance and reusability
* Part of `java.util` package

### Hierarchy (Simplified)

```
Iterable → Collection → List / Set / Queue
Map (separate hierarchy)
```

---

# 📚 16.2 Interfaces & Implementations

## List

Ordered, allows duplicates, index-based access

* ArrayList → Fast access
* LinkedList → Fast insert/delete
* Vector → Thread-safe (legacy)
* Stack → LIFO operations

## Set

No duplicates, order depends on implementation

* HashSet → No order
* LinkedHashSet → Maintains order
* TreeSet → Sorted order

## Queue / Deque

Used for processing elements

* PriorityQueue → Priority-based
* ArrayDeque → Double-ended operations

## Map

Key-value pairs, keys are unique

* HashMap → No order
* LinkedHashMap → Maintains order
* TreeMap → Sorted keys
* Hashtable → Thread-safe (legacy)

---

# ⚡ 16.7 Hashing Concepts

Hashing converts a key into a hash code for fast storage and retrieval.

* `hashCode()` → Generates integer value
* `equals()` → Compares objects logically

### HashMap Working

1. Calculate hashCode
2. Convert to bucket index
3. Store key-value pair
4. Handle collisions using chaining/tree

* Average Complexity → O(1)

---

# 🔁 16.8 Iteration Techniques

## Iterator

* Forward traversal
* Methods: `hasNext()`, `next()`, `remove()`

## ListIterator

* Forward + backward traversal
* Allows modification

## for-each

* Simplest iteration
* Read-only traversal

---

# 🔃 16.9 Sorting

## Comparable

* Defines natural ordering
* Uses `compareTo()`

## Comparator

* Custom sorting
* Uses `compare()`

---

# 🛠️ 16.10 Collections Utility Class

Useful static methods:

* `sort()`
* `reverse()`
* `shuffle()`
* `max()` / `min()`
* `binarySearch()`

---

# 📌 16.11 Important Methods

Common:

* `add()`, `remove()`, `contains()`
* `size()`, `isEmpty()`, `clear()`

Map-specific:

* `put()`, `get()`, `containsKey()`

---

# ⚠️ 16.12 Fail-Fast vs Fail-Safe

## Fail-Fast

* Throws exception on modification
* Example: ArrayList

## Fail-Safe

* Works on copy
* No exception
* Example: Concurrent collections

---

# 📊 16.13 Performance

| Operation | ArrayList | LinkedList | HashMap | TreeMap  |
| --------- | --------- | ---------- | ------- | -------- |
| Access    | O(1)      | O(n)       | O(1)    | O(log n) |
| Insert    | O(n)      | O(1)       | O(1)    | O(log n) |
| Delete    | O(n)      | O(1)       | O(1)    | O(log n) |

---

# ⚙️ 16.14 Internal Working

* ArrayList → Dynamic array
* LinkedList → Doubly linked list
* HashMap → Buckets + hashing
* HashSet → Uses HashMap internally
* TreeMap/TreeSet → Red-Black Tree

---

# 🧠 Quick Revision (1-Page Summary)

* List → Ordered, duplicates allowed

* Set → Unique elements

* Queue → FIFO processing

* Deque → Double-ended

* Map → Key-value pairs

* HashMap → Fast (O(1))

* TreeMap → Sorted (O(log n))

* Iterator → Forward

* ListIterator → Bi-directional

* for-each → Simple

* Comparable → Default sorting

* Comparator → Custom sorting

* Fail-Fast → Exception on modification

* Fail-Safe → No exception

---

# 🎯 Key Takeaways

* Choose collection based on use-case
* Hashing is core for performance
* Sorting and iteration are essential for real applications
* Understanding internal working helps in interviews




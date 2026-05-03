# Array Data Structure - Complete Explanation with Search Algorithms

**Video Link:** https://www.youtube.com/watch?v=1N38hM3DV-Y  
**Video Title:** Array data structure (Complete explanation with Search algorithms)

---

## Table of Contents
1. [Introduction](#introduction)
2. [What is an Array?](#what-is-an-array)
3. [Memory Allocation](#memory-allocation)
4. [Advantages of Arrays](#advantages-of-arrays)
5. [Disadvantages of Arrays](#disadvantages-of-arrays)
6. [Array Operations](#array-operations)
   - [Insertion](#insertion)
   - [Deletion](#deletion)
7. [Searching in Arrays](#searching-in-arrays)
   - [Linear Search](#linear-search)
   - [Binary Search](#binary-search)
8. [Time Complexity Analysis](#time-complexity-analysis)
9. [Key Takeaways](#key-takeaways)
10. [Common Mistakes to Avoid](#common-mistakes-to-avoid)

---

## Introduction

Arrays are one of the **most fundamental data structures** in computer science and programming. They provide a contiguous block of memory that allows us to store multiple elements of the same data type and access them efficiently.

Understanding arrays is crucial because:
- They form the foundation for understanding more complex data structures
- Many algorithms rely on array operations
- They are widely used in practical applications
- They have excellent cache performance due to memory locality

---

## What is an Array?

### Definition
An **array** is a collection of elements (values or variables) of the **same data type** stored in **contiguous memory locations**.

### Declaration and Initialization

```java
// Example 1: Declaring variables without array
int a = 10;
int b = 20;
long c = 30;
char d = 'X';
```

When we declare multiple variables like above, they are scattered in memory at different locations. This becomes problematic when:
- We need to store 1000 values
- We need to access values in a structured way
- We need to perform operations on all values

### Solution: Using Arrays

```java
// Instead of declaring 1000 variables individually:
// int a, b, c, d, ... (not practical!)

// We use an array:
int[] arr = new int[10];  // Array of size 10
// or
long[] longArr = new long[5];
```

### How Array Declaration Works

When you declare an array:
```java
int[] myArray = new int[10];
```

The computer:
1. **Allocates contiguous memory blocks** - All 10 elements stored sequentially
2. **Stores starting address** - First element's memory address is known
3. **Calculates any element's address** - Using formula: `Address = BaseAddress + (index × sizeOfDataType)`

---

## Memory Allocation

### Visual Representation

```
Without Array (Scattered Memory):
┌────────┐ ┌────────┐ ┌────────┐ ┌────────┐
│   a    │ │   b    │ │   c    │ │   d    │
│  (int) │ │  (int) │ │ (long) │ │ (char) │
└────────┘ └────────┘ └────────┘ └────────┘
Address: 1000  2004  3008  4012 (Different locations)

With Array (Contiguous Memory):
┌────┬────┬────┬────┬────┬────┬────┬────┬────┬────┐
│ 0  │ 1  │ 2  │ 3  │ 4  │ 5  │ 6  │ 7  │ 8  │ 9  │
└────┴────┴────┴────┴────┴────┴────┴────┴────┴────┘
Address: 1000 1004 1008 1012 1016 1020 1024 1028 1032 1036
(Sequential memory locations, 4 bytes per int)
```

### Advantage: Efficient Addressing

If base address = 1000 and we want element at index 5:
```
Address of arr[5] = 1000 + (5 × 4) = 1020
```

This calculation happens automatically and is **O(1) - Constant Time!**

---

## Advantages of Arrays

### 1. **Random Access** ⭐
- Can access any element directly using its index
- Time complexity: **O(1)** - Constant time
- Example: `arr[5]` directly gives the 5th element

```
Array: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
Index:   0   1   2   3   4   5   6   7   8    9

To get element 60:
arr[5] → 60 (instant, no searching required)
```

### 2. **Cache Friendly**
- Elements are stored in contiguous memory
- When accessing one element, neighboring elements are loaded into CPU cache
- Subsequent accesses to nearby elements are much faster
- This is called **Spatial Locality** - huge performance benefit!

### 3. **Memory Efficient**
- No extra memory for pointers (unlike linked lists)
- Direct memory usage - only stores the actual data

---

## Disadvantages of Arrays

### 1. **Fixed Size** ❌
- Size is determined at declaration time
- Cannot dynamically increase or decrease the array size
- Once declared, size is immutable

```java
int[] arr = new int[10];  // Can store exactly 10 elements

// If you want 11 elements, you CANNOT do this:
arr[10] = 100;  // ERROR! Index out of bounds

// You must create a new array:
int[] newArr = new int[11];
// Copy all old elements to new array
for(int i = 0; i < arr.length; i++) {
    newArr[i] = arr[i];
}
// Add new element
newArr[10] = 100;
// Old array is discarded, newArr becomes your array
```

### 2. **Expensive Insertion and Deletion** ⚠️
- Inserting at the beginning requires shifting all elements
- Deleting an element also requires shifting remaining elements
- Time complexity: **O(n)** - where n is the number of elements

**Example - Inserting at the Beginning:**
```
Original Array: [1, 2, 3, 4, 5]

To insert 0 at the beginning:
Step 1: [5, 1, 2, 3, 4]  ← shift 4
Step 2: [4, 5, 1, 2, 3]  ← shift 3
Step 3: [3, 4, 5, 1, 2]  ← shift 2
Step 4: [2, 3, 4, 5, 1]  ← shift 1
Step 5: [0, 2, 3, 4, 5]  ← insert 0

Note: We had to shift all 5 elements! = O(n) operation
```

### 3. **Memory Wastage**
- If you declare array of size 100 but use only 10 elements, 90 spaces are wasted
- Memory allocated upfront, not released if not needed

---

## Array Operations

### Insertion

#### Case 1: Insert at the End
```java
int[] arr = {1, 2, 3};
int[] newArr = new int[4];
for(int i = 0; i < arr.length; i++) {
    newArr[i] = arr[i];
}
newArr[3] = 4;  // Insert at end
// Time Complexity: O(n) - need to copy all elements
```

#### Case 2: Insert at a Specific Position
```java
int[] arr = {1, 2, 3, 4, 5};
// Insert 99 at position 2
int[] newArr = new int[6];

// Copy elements before insertion point
for(int i = 0; i < 2; i++) {
    newArr[i] = arr[i];  // [1, 2]
}

// Insert new element
newArr[2] = 99;

// Copy remaining elements (shifted by 1)
for(int i = 2; i < arr.length; i++) {
    newArr[i + 1] = arr[i];  // [99, 3, 4, 5]
}
// Result: [1, 2, 99, 3, 4, 5]
// Time Complexity: O(n)
```

### Deletion

#### Case 1: Delete from the End
```java
int[] arr = {1, 2, 3, 4, 5};
int[] newArr = new int[4];
for(int i = 0; i < newArr.length; i++) {
    newArr[i] = arr[i];
}
// Time Complexity: O(n)
```

#### Case 2: Delete from a Specific Position
```java
int[] arr = {1, 2, 3, 4, 5};
// Delete element at position 2 (value 3)
int[] newArr = new int[4];

// Copy elements before deletion point
for(int i = 0; i < 2; i++) {
    newArr[i] = arr[i];  // [1, 2]
}

// Copy remaining elements (shifted left by 1)
for(int i = 3; i < arr.length; i++) {
    newArr[i - 1] = arr[i];  // [4, 5]
}
// Result: [1, 2, 4, 5]
// Time Complexity: O(n)
```

---

## Searching in Arrays

### Linear Search

#### What is Linear Search?

**Linear Search** is the simplest searching algorithm. It checks each element in the array sequentially from the beginning until the target element is found.

#### Algorithm
```
1. Start from the first element
2. Compare with target element
3. If match found, return index
4. If not match, move to next element
5. Repeat until element found or array ends
6. If not found, return -1
```

#### Pseudocode
```
function linearSearch(arr[], n, x):
    for i from 0 to n-1:
        if arr[i] == x:
            return i
    return -1
```

#### Example
```
Array: [5, 2, 8, 1, 9, 3, 7]
Search for: 9

Step 1: Check arr[0] = 5 ≠ 9 ✗
Step 2: Check arr[1] = 2 ≠ 9 ✗
Step 3: Check arr[2] = 8 ≠ 9 ✗
Step 4: Check arr[3] = 1 ≠ 9 ✗
Step 5: Check arr[4] = 9 = 9 ✓ (Found! Return index 4)

Time Complexity: O(n) where n = 7
```

#### Time Complexity Analysis
- **Best Case:** O(1) - Element is at first position
- **Average Case:** O(n) - Element is at middle position
- **Worst Case:** O(n) - Element is at last position or not found

---

### Binary Search

#### What is Binary Search?

**Binary Search** is a highly optimized searching algorithm that works on **sorted arrays**. It divides the search space in half with each comparison.

#### Key Requirement
⚠️ **The array MUST be sorted!**
- Ascending order (1, 2, 3, 4, 5) OR
- Descending order (5, 4, 3, 2, 1)

#### How Binary Search Works

**The Strategy:**
1. Find the middle element
2. Compare target with middle element:
   - If equal → Found! Return index
   - If target < middle → Ignore right half, search left half
   - If target > middle → Ignore left half, search right half
3. Repeat process on the remaining half until found or no elements left

#### Step-by-Step Example
```
Sorted Array: [1, 3, 5, 7, 9, 11, 13, 15]
Search for: 7

Initial state:
left = 0, right = 7
Array:   [1, 3, 5, 7, 9, 11, 13, 15]
Index:    0  1  2  3  4   5   6   7

Step 1:
mid = (0 + 7) / 2 = 3
arr[3] = 7 = target ✓
Found at index 3!
Comparisons: 1
```

#### Another Example
```
Sorted Array: [1, 3, 5, 7, 9, 11, 13, 15]
Search for: 11

Step 1:
left = 0, right = 7, mid = 3
arr[3] = 7 < 11
→ Ignore left half, search right (11 > 7)
Update: left = 4, right = 7

Step 2:
left = 4, right = 7, mid = 5
arr[5] = 11 = target ✓
Found at index 5!
Comparisons: 2

Efficiency: Instead of checking all 8 elements (linear search),
we found it in just 2 comparisons!
```

#### When Element is NOT Found
```
Sorted Array: [1, 3, 5, 7, 9, 11, 13, 15]
Search for: 10

Step 1: mid = 3, arr[3] = 7 < 10, left = 4

Step 2: mid = 5, arr[5] = 11 > 10, right = 4

Step 3: mid = 4, arr[4] = 9 < 10, left = 5

Now: left = 5, right = 4 (left > right)
Loop terminates → Return -1 (Element not found)
Comparisons: 3
```

#### Pseudocode
```
function binarySearch(arr[], x, n):
    left = 0
    right = n - 1
    
    while left <= right:
        mid = (left + right) / 2
        
        if arr[mid] == x:
            return mid
        else if arr[mid] < x:
            left = mid + 1  (ignore left half)
        else:
            right = mid - 1  (ignore right half)
    
    return -1  (not found)
```

#### Time Complexity Analysis

**Best Case:** O(1)
- Target is at middle position

**Average Case:** O(log n)
- After each comparison, search space reduces by half

**Worst Case:** O(log n)
- Element at end or not found

**Why O(log n)?**
```
For array of size n, we can divide:
  n elements   → 1 comparison → n/2 elements remain
  n/2 elements → 1 comparison → n/4 elements remain
  n/4 elements → 1 comparison → n/8 elements remain
  ...
  1 element    → 1 comparison → Found!

Total comparisons = log₂(n)

Example:
n = 1000000 (1 million)
Maximum comparisons needed = log₂(1000000) ≈ 20

Linear search would need up to 1 million comparisons!
Binary search needs only ~20 comparisons!
```

---

## Time Complexity Analysis

### Comparison Table

| Operation | Array | Time Complexity |
|-----------|-------|-----------------|
| Access | Direct by index | **O(1)** |
| Search (Unsorted) | Linear Search | **O(n)** |
| Search (Sorted) | Binary Search | **O(log n)** |
| Insertion | At end (with resizing) | **O(n)** |
| Insertion | At beginning | **O(n)** |
| Deletion | At end | **O(n)** |
| Deletion | At beginning | **O(n)** |

### Graphical Comparison: Linear Search vs Binary Search

```
Operations vs Array Size

Linear Search:     y = n
Binary Search:     y = log₂(n)

Size=10:    Linear≈10    Binary≈3.3
Size=100:   Linear≈100   Binary≈6.6
Size=1000:  Linear≈1000  Binary≈10
Size=100K:  Linear≈100K  Binary≈16.6

Binary search is DRAMATICALLY faster for large arrays!
```

---

## Key Takeaways

### ✅ When to Use Arrays:
1. When you need **fast random access** to elements
2. When size is **known and fixed** beforehand
3. When **memory locality** is important (performance)
4. When working with **sorted data** (for binary search)

### ✅ Key Concepts:
- Arrays provide **O(1) random access** using index
- **Contiguous memory** allows efficient caching
- **Fixed size** is both advantage (efficiency) and disadvantage (inflexibility)
- **Linear Search:** O(n) - works on unsorted arrays
- **Binary Search:** O(log n) - requires sorted array but much faster
- **Insertions/Deletions:** O(n) - requires shifting elements

### ✅ Memory Model:
```
Address of arr[i] = BaseAddress + (i × sizeof(DataType))

This formula makes array access O(1)!
```

---

## Common Mistakes to Avoid

### ❌ Mistake 1: Array Index Out of Bounds
```java
int[] arr = new int[5];  // Valid indices: 0, 1, 2, 3, 4
arr[5] = 10;  // ERROR! ArrayIndexOutOfBoundsException
```

### ❌ Mistake 2: Binary Search on Unsorted Array
```java
int[] unsorted = {5, 2, 8, 1, 9};  // Not sorted!
// Binary search will give WRONG results!
// Always check if array is sorted before using binary search
```

### ❌ Mistake 3: Modifying Array While Iterating
```java
int[] arr = {1, 2, 3, 4, 5};
for(int i = 0; i < arr.length; i++) {
    // DON'T resize arr here
    arr = new int[arr.length + 1];  // Can cause issues!
}
```

### ❌ Mistake 4: Forgetting Base Case in Recursion
```java
// If using recursive binary search
int recursiveBinarySearch(int[] arr, int left, int right, int x) {
    if(left > right) return -1;  // Don't forget this base case!
    
    int mid = (left + right) / 2;
    if(arr[mid] == x) return mid;
    else if(arr[mid] > x) return recursiveBinarySearch(arr, left, mid-1, x);
    else return recursiveBinarySearch(arr, mid+1, right, x);
}
```

---

## Practice Problems

### Easy
1. Find the sum of all elements in array
2. Find the maximum element
3. Implement linear search
4. Count occurrences of a number

### Medium
1. Implement binary search
2. Find first and last occurrence of element (sorted array)
3. Find peak element (element greater than neighbors)
4. Search in rotated sorted array

### Hard
1. Median of two sorted arrays
2. K-closest elements to given value
3. Count elements in range (sorted array)

---

## Summary

Arrays are one of the most important data structures with:
- **O(1) random access** - access any element instantly
- **O(n) search** on unsorted array using linear search
- **O(log n) search** on sorted array using binary search
- Fixed size that cannot be changed after creation
- Contiguous memory for efficient caching

Understanding arrays deeply will help you master more advanced data structures and algorithms!

---

**Version:** 1.0  
**Date Created:** May 3, 2026  
**Status:** Complete Study Guide


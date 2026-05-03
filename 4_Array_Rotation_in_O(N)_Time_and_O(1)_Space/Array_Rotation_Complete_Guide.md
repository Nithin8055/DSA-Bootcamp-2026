# Array Rotation in O(N) Time and O(1) Space - Complete Guide

**Video Link:** https://www.youtube.com/watch?v=ytEmPvnFKkE  
**Video Title:** Rotate Array | Rotation of Array in O(N) Time Complexity and O(1) Space Complexity LeetCode Solution

---

## Table of Contents
1. [Introduction](#introduction)
2. [Problem Statement](#problem-statement)
3. [Key Concepts](#key-concepts)
4. [Approach: Reverse Algorithm](#approach-reverse-algorithm)
5. [Algorithm Explanation](#algorithm-explanation)
6. [Time & Space Complexity](#time--space-complexity)
7. [Implementation](#implementation)
8. [Example Walkthrough](#example-walkthrough)
9. [Edge Cases](#edge-cases)
10. [Tips & Tricks](#tips--tricks)
11. [Practice Problems](#practice-problems)

---

## Introduction

Array rotation is a **frequently asked interview question** that tests your understanding of:
- Array manipulation techniques
- In-place operations
- Optimal algorithm design
- Time and space complexity optimization

The challenge is to **rotate an array left by k positions** while maintaining:
- **O(N) Time Complexity** - Linear time
- **O(1) Space Complexity** - No extra space (in-place)

This guide covers an elegant **reverse-based algorithm** that achieves both goals.

---

## Problem Statement

### Given
- An array of integers
- A value `k` representing the number of positions to rotate left

### Task
Rotate the array **left by k positions** using O(N) time and O(1) space.

### Example
```
Input:  [1, 2, 3, 4, 5], k = 2
Output: [3, 4, 5, 1, 2]

Explanation:
- Original: [1, 2, 3, 4, 5]
- After rotating left by 2: Elements [1, 2] move to the end
- Result: [3, 4, 5, 1, 2]
```

### Why This Matters
- **Interview Question:** Very common in top tech companies
- **Practical Use:** Data streaming, circular buffers, deque operations
- **Complexity Challenge:** O(N) time with O(1) space is non-trivial

---

## Key Concepts

### What is Array Rotation?

**Left Rotation by k:**
- Take first k elements and move them to the end
- Shift remaining elements to the beginning

```
Rotate Left by k=2:
[1, 2, 3, 4, 5]
     ↓
[3, 4, 5, 1, 2]

- [1, 2] moves to end
- [3, 4, 5] shifts to beginning
```

### Naive Approaches (Why They Don't Work)

#### Approach 1: Using Extra Array (O(N) space) ❌
```java
// Bad - uses O(N) extra space
int[] temp = new int[n];
for (int i = 0; i < n; i++) {
    temp[i] = arr[(i + k) % n];
}
for (int i = 0; i < n; i++) {
    arr[i] = temp[i];
}
// Space Complexity: O(N) - violates requirement!
```

#### Approach 2: Rotating One by One (O(N*k) time) ❌
```java
// Bad - rotates element by element
for (int i = 0; i < k; i++) {
    // Move one element to end
    int first = arr[0];
    for (int j = 0; j < n - 1; j++) {
        arr[j] = arr[j + 1];
    }
    arr[n - 1] = first;
}
// Time Complexity: O(N*K) - inefficient!
```

#### Why These Don't Meet Requirements
- Extra array approach uses O(N) space
- Element-by-element approach uses O(N*K) time
- We need **both** O(N) time AND O(1) space

---

## Approach: Reverse Algorithm

### The Elegant Solution: Three Reverses

The key insight: **Use array reversal to rotate without extra space!**

### Algorithm Steps

```
Original Array: [1, 2, 3, 4, 5], k = 2

Step 1: Reverse first k elements
        [1, 2] → [2, 1]
        Result: [2, 1, 3, 4, 5]

Step 2: Reverse remaining elements
        [3, 4, 5] → [5, 4, 3]
        Result: [2, 1, 5, 4, 3]

Step 3: Reverse entire array
        [2, 1, 5, 4, 3] → [3, 4, 5, 1, 2]
        Result: [3, 4, 5, 1, 2] ✓

This is our answer!
```

### Why This Works - Mathematical Proof

Let's understand the reverse-based approach:

```
Original: A B C D E  (where A=[1,2], B=[3,4,5])
We want:  B A        (Result: [3,4,5,1,2])

Step 1: Reverse A
        A' B         ([2,1] [3,4,5])

Step 2: Reverse B  
        A' B'        ([2,1] [5,4,3])

Step 3: Reverse all
        (A'B')' = BA  ([3,4,5,1,2]) ✓

Mathematical property:
(A'B')' = B''A'' = BA ✓
```

---

## Algorithm Explanation

### Detailed Step-by-Step

#### Step 1: Reverse First k Elements
```
Purpose: Reverse the subarray from index 0 to k-1
Implementation: Two-pointer approach (i++ from start, j-- from k-1)

Array: [1, 2, 3, 4, 5], k = 2
       [0] [1] [2] [3] [4]

Initial:  i=0, j=1
Swap: arr[0] ↔ arr[1]  →  [2, 1, 3, 4, 5]
i=1, j=0: i > j, stop

Result: [2, 1, 3, 4, 5]
```

#### Step 2: Reverse Remaining Elements
```
Purpose: Reverse the subarray from index k to n-1
Implementation: Two-pointer approach (i++ from k, j-- from n-1)

Array: [2, 1, 3, 4, 5], k = 2, n = 5
       [0] [1] [2] [3] [4]

Initial:  i=2, j=4
Swap: arr[2] ↔ arr[4]  →  [2, 1, 5, 4, 3]
i=3, j=3: i >= j, stop

Result: [2, 1, 5, 4, 3]
```

#### Step 3: Reverse Entire Array
```
Purpose: Reverse the complete array
Implementation: Two-pointer approach (i++ from 0, j-- from n-1)

Array: [2, 1, 5, 4, 3]
       [0] [1] [2] [3] [4]

Initial:  i=0, j=4
Swap: arr[0] ↔ arr[4]  →  [3, 1, 5, 4, 2]
i=1, j=3
Swap: arr[1] ↔ arr[3]  →  [3, 4, 5, 1, 2]
i=2, j=2: i >= j, stop

Result: [3, 4, 5, 1, 2] ✓ ANSWER!
```

---

## Time & Space Complexity

### Analysis

| Aspect | Value | Reason |
|--------|-------|--------|
| **Time Complexity** | **O(N)** | Three separate reversal operations, each O(N) |
| **Space Complexity** | **O(1)** | Only using two pointers for reversal, no extra arrays |
| **Auxiliary Space** | Constant | Only i, j variables for two-pointer reversal |

### Breakdown
```
Operation 1 - Reverse first k elements:   O(k)
Operation 2 - Reverse last n-k elements:  O(n-k)
Operation 3 - Reverse entire array:       O(n)
─────────────────────────────────────────
Total:                                      O(n) ✓
```

### Why O(1) Space?
- ✅ No additional arrays created
- ✅ Only two pointers (i, j) used
- ✅ In-place modification of original array
- ✅ Meets the strict space requirement

---

## Implementation

### Java Code

```java
/**
 * Solution: Array Rotation using Reverse Algorithm
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class ArrayRotation {
    
    /**
     * Helper function to reverse array elements between indices i and j
     * @param arr Array to reverse
     * @param i Start index (inclusive)
     * @param j End index (inclusive)
     */
    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            // Swap elements at i and j
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;  // Move from start towards center
            j--;  // Move from end towards center
        }
    }
    
    /**
     * Main function to rotate array left by k positions
     * @param arr Array to rotate
     * @param k Number of positions to rotate left
     */
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        
        // Handle edge case: k might be greater than array length
        k = k % n;  // Equivalent rotation
        
        // If k is 0 or n, array remains unchanged
        if (k == 0) {
            return;
        }
        
        // Step 1: Reverse first k elements
        reverse(arr, 0, k - 1);
        
        // Step 2: Reverse remaining elements (from k to n-1)
        reverse(arr, k, n - 1);
        
        // Step 3: Reverse entire array
        reverse(arr, 0, n - 1);
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    // Main method with test cases
    public static void main(String[] args) {
        System.out.println("=== Array Rotation - O(N) time, O(1) space ===\n");
        
        // Test Case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println("Test Case 1:");
        System.out.println("Original array: ");
        printArray(arr1);
        System.out.println("Rotate left by " + k1);
        rotateLeft(arr1, k1);
        System.out.println("Result: ");
        printArray(arr1);
        System.out.println("Expected: [3, 4, 5, 1, 2]\n");
        
        // Test Case 2
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        int k2 = 3;
        System.out.println("Test Case 2:");
        System.out.println("Original array: ");
        printArray(arr2);
        System.out.println("Rotate left by " + k2);
        rotateLeft(arr2, k2);
        System.out.println("Result: ");
        printArray(arr2);
        System.out.println("Expected: [4, 5, 6, 7, 1, 2, 3]\n");
        
        // Test Case 3
        int[] arr3 = {1, 2, 3};
        int k3 = 1;
        System.out.println("Test Case 3:");
        System.out.println("Original array: ");
        printArray(arr3);
        System.out.println("Rotate left by " + k3);
        rotateLeft(arr3, k3);
        System.out.println("Result: ");
        printArray(arr3);
        System.out.println("Expected: [2, 3, 1]\n");
    }
}
```

---

## Example Walkthrough

### Complete Example: Rotate [1, 2, 3, 4, 5] left by 2

```
INITIAL STATE:
Array: [1, 2, 3, 4, 5]
k = 2
n = 5

STEP 1: Reverse first k (k=2) elements [0 to 1]
─────────────────────────────────────────────
i=0, j=1
Swap arr[0] ↔ arr[1]: [1, 2, 3, 4, 5] → [2, 1, 3, 4, 5]
i=1, j=0: i >= j, stop reversing

Current array: [2, 1, 3, 4, 5]

STEP 2: Reverse elements from k to n-1 [2 to 4]
───────────────────────────────────────────────
i=2, j=4
Swap arr[2] ↔ arr[4]: [2, 1, 3, 4, 5] → [2, 1, 5, 4, 3]
i=3, j=3: i >= j, stop reversing

Current array: [2, 1, 5, 4, 3]

STEP 3: Reverse entire array [0 to 4]
──────────────────────────────────────
i=0, j=4
Swap arr[0] ↔ arr[4]: [2, 1, 5, 4, 3] → [3, 1, 5, 4, 2]
i=1, j=3
Swap arr[1] ↔ arr[3]: [3, 1, 5, 4, 2] → [3, 4, 5, 1, 2]
i=2, j=2: i >= j, stop reversing

Current array: [3, 4, 5, 1, 2] ✓

FINAL RESULT: [3, 4, 5, 1, 2]
```

---

## Edge Cases

### Case 1: k = 0 (No rotation)
```
Input:  [1, 2, 3, 4, 5], k = 0
Output: [1, 2, 3, 4, 5]
Reason: No elements to rotate
```

### Case 2: k = n (Full rotation)
```
Input:  [1, 2, 3, 4, 5], k = 5
Output: [1, 2, 3, 4, 5]
Reason: After rotating by array length, back to original
```

### Case 3: k > n (Multiple rotations)
```
Input:  [1, 2, 3], k = 5
Equivalent to: k = 5 % 3 = 2
Output: [3, 1, 2]
```

### Case 4: Single element array
```
Input:  [1], k = 10
Output: [1]
Reason: Single element rotation has no effect
```

### Case 5: Empty array
```
Input:  [], k = 5
Output: []
Reason: Empty array remains empty
```

---

## Tips & Tricks

### 1. Handle k > n
Always use `k = k % n` to handle cases where k exceeds array length:
```java
k = k % n;
if (k == 0) return;  // Optimization: skip if no rotation needed
```

### 2. Understanding the Reverse Pattern
```
Why reverse works for rotation:

Consider: [A B C D E] rotate left by 2

Mathematical insight:
- Reverse [A B]:         [B' A']  = [B A]
- Reverse [C D E]:       [B A E' D' C'] = [B A E D C]
- Reverse all:           [C D E A B] ✓

General formula:
reverse(0, k-1) + reverse(k, n-1) + reverse(0, n-1) = left rotate by k
```

### 3. Two-Pointer Reversal Pattern
```java
private static void reverse(int[] arr, int i, int j) {
    while (i < j) {
        // Standard swap
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
}
```

### 4. Array is Modified In-Place
```java
// Important: The original array is modified
int[] arr = {1, 2, 3, 4, 5};
rotateLeft(arr, 2);
// arr is now [3, 4, 5, 1, 2] - modified in-place!
```

### 5. Why This is O(1) Space
```
- No new array created: O(1) ✓
- Only two variables (i, j) used: O(1) ✓
- No recursion (no call stack): O(1) ✓
- Direct array manipulation: O(1) ✓
```

---

## Practice Problems

### Level 1: Easy

**Problem 1.1:** Rotate Right by k
```
Given: [1, 2, 3, 4, 5], k = 2
Find: [4, 5, 1, 2, 3]
Hint: Similar to left rotation, adjust logic
```

**Problem 1.2:** Find Rotation Count
```
Given rotated array, find k
Example: [3, 4, 5, 1, 2] → k = 2
Hint: Use pivot point logic
```

### Level 2: Medium

**Problem 2.1:** Search in Rotated Array
```
Find target in rotated sorted array
Time: O(log N), Space: O(1)
Hint: Use binary search with rotation awareness
```

**Problem 2.2:** Find Minimum in Rotated Array
```
Given: [4, 5, 6, 7, 0, 1, 2]
Find: Minimum element (0)
Hint: Modified binary search
```

### Level 3: Hard

**Problem 3.1:** Rotate Matrix 90 Degrees
```
Rotate 2D matrix without extra space
Time: O(N²), Space: O(1)
Hint: Use similar reverse technique layer by layer
```

**Problem 3.2:** Maximize Array Value After Rotation**
```
Rotate array to maximize sum of i*arr[i]
Time: O(N), Space: O(1)
Hint: Mathematical analysis of rotation impact
```

---

## Key Takeaways

### ✅ What You Learned
1. **Reverse Algorithm** - Elegant technique for array rotation
2. **Optimal Complexity** - O(N) time with O(1) space
3. **Two-Pointer Pattern** - Core technique for in-place operations
4. **Mathematical Insight** - Understanding why reverse works

### ✅ Why This Matters
- Common interview question
- Tests algorithm optimization skills
- Teaches in-place modification techniques
- Foundation for advanced array operations

### ✅ When to Use
- LeetCode Problem 189: Rotate Array
- Data structure optimization challenges
- When space is limited but time is flexible
- Circular buffer implementations

---

## Common Mistakes to Avoid

### ❌ Mistake 1: Using Extra Array
```java
// WRONG - violates O(1) space requirement
int[] temp = new int[n];
// ...
```

### ❌ Mistake 2: Element-by-Element Rotation
```java
// WRONG - O(N*K) time complexity
for (int i = 0; i < k; i++) {
    // rotate once...
}
```

### ❌ Mistake 3: Not Handling k > n
```java
// WRONG - may cause index out of bounds
// Should use: k = k % n;
```

### ❌ Mistake 4: Modifying Array Incorrectly
```java
// WRONG - creates new array instead of modifying
arr = rotateLeft(arr, k);
// RIGHT - passes reference and modifies in-place
rotateLeft(arr, k);
```

---

## Related Problems & Topics

### Similar Array Manipulation
- Array reversal (used in this solution)
- String reversal (same technique)
- Palindrome checking
- Array permutation

### Advanced Topics
- Circular arrays and deques
- Minimum rotations to transform array
- Block rotation algorithm
- Juggling algorithm for rotation

---

## Summary

### The Reverse Algorithm at a Glance

```
Problem: Rotate array left by k, O(N) time, O(1) space

Solution: Three reversals
┌─────────────────────────────────────┐
│ 1. Reverse [0, k-1]                 │
│ 2. Reverse [k, n-1]                 │
│ 3. Reverse [0, n-1]                 │
└─────────────────────────────────────┘

Result: Array rotated left by k ✓

Time: O(N) - Linear time
Space: O(1) - Constant space (in-place)
```

This elegant approach combines mathematical insight with practical optimization to solve a common interview problem efficiently!

---

**Version:** 1.0  
**Date Created:** May 3, 2026  
**Status:** Complete Study Guide


# Array Rotation - Complete Implementation Guide

**Video Link:** https://www.youtube.com/watch?v=ytEmPvnFKkE  
**Tutorial:** Array Rotation in O(N) Time and O(1) Space  
**Date Created:** May 3, 2026

---

## 📚 Files in This Directory

### Documentation
- **Array_Rotation_Complete_Guide.md** - Complete theoretical explanation with examples
- **README.md** - This file (quick reference and implementation guide)

### Java Code Examples
- **ArrayRotation.java** - Main optimal implementation (Reverse Algorithm)
- **ArrayRotationAlternativeApproaches.java** - Shows why reverse is better than alternatives

---

## 🚀 Quick Start

### Compile
```bash
javac ArrayRotation.java
javac ArrayRotationAlternativeApproaches.java
```

### Run
```bash
# Run main implementation with test cases
java ArrayRotation

# Run comparison of all approaches
java ArrayRotationAlternativeApproaches
```

---

## 📋 Problem Summary

### Problem Statement
Rotate an array left by k positions with:
- **Time Complexity:** O(N) - Linear time
- **Space Complexity:** O(1) - Constant space (in-place)

### Example
```
Input:  [1, 2, 3, 4, 5], k = 2
Output: [3, 4, 5, 1, 2]
```

---

## 💡 The Optimal Solution

### Algorithm: Three Reversals

```
Step 1: Reverse first k elements
        [1, 2] → [2, 1]

Step 2: Reverse remaining elements
        [3, 4, 5] → [5, 4, 3]

Step 3: Reverse entire array
        [2, 1, 5, 4, 3] → [3, 4, 5, 1, 2]
```

### Why This Works

```
Mathematical Insight:
Original: [A B C D E] where A=[1,2], B=[3,4,5]
Goal:     [B A] = [3,4,5,1,2]

Process:
1. Reverse A:        [A' B] = [2,1,3,4,5]
2. Reverse B:        [A' B'] = [2,1,5,4,3]
3. Reverse all:      (A'B')' = BA = [3,4,5,1,2] ✓

Property: (A'B')' = B''A'' = BA
```

---

## 🎯 Key Features

### ✅ Advantages
- **O(N) Time:** Linear time complexity
- **O(1) Space:** No extra array needed
- **In-place:** Modifies original array directly
- **Elegant:** Uses mathematical insight
- **Interview Ready:** Optimal solution

### 📊 Complexity Comparison

| Approach | Time | Space | Best For |
|----------|------|-------|----------|
| Brute Force | O(N*K) | O(1) | Very small K |
| Extra Array | O(N) | O(N) | When space available |
| **Reverse ✓** | **O(N)** | **O(1)** | **All cases** |

---

## 💻 Implementation Details

### Main Function Signature
```java
public static void rotateLeft(int[] arr, int k)
```

### Parameters
- `arr`: Array to rotate (modified in-place)
- `k`: Number of positions to rotate left

### Important Notes
1. **k > n:** Automatically handled with `k = k % n`
2. **k = 0:** Returns immediately (no rotation needed)
3. **Empty array:** Handled safely
4. **Modifies in-place:** Original array is changed

---

## 🧪 Test Cases

All test cases included in `ArrayRotation.java`:

1. ✅ Basic rotation [1,2,3,4,5] with k=2
2. ✅ Larger array [1-7] with k=3
3. ✅ Single position rotation
4. ✅ k > n handling
5. ✅ k = 0 (no rotation)
6. ✅ k = n (full rotation)
7. ✅ Single element array
8. ✅ Right rotation
9. ✅ Large array (100 elements)
10. ✅ Two element array

---

## 📖 How to Use

### Basic Usage
```java
int[] arr = {1, 2, 3, 4, 5};
ArrayRotation.rotateLeft(arr, 2);
// arr is now [3, 4, 5, 1, 2]
```

### With Custom Values
```java
int[] arr = {10, 20, 30, 40, 50};
int k = 1;
ArrayRotation.rotateLeft(arr, k);
// arr is now [20, 30, 40, 50, 10]
```

### Rotate Right
```java
int[] arr = {1, 2, 3, 4, 5};
ArrayRotation.rotateRight(arr, 2);
// arr is now [4, 5, 1, 2, 3]
```

---

## 🔍 Understanding the Algorithm

### Step-by-Step Walkthrough

#### Input: [1, 2, 3, 4, 5], k = 2

**Step 1: Reverse [0, k-1] = [0, 1]**
```
i=0, j=1
Swap: arr[0] ↔ arr[1]
Result: [2, 1, 3, 4, 5]
```

**Step 2: Reverse [k, n-1] = [2, 4]**
```
i=2, j=4
Swap: arr[2] ↔ arr[4]  →  [2, 1, 5, 4, 3]
i=3, j=3: stop
Result: [2, 1, 5, 4, 3]
```

**Step 3: Reverse [0, n-1] = [0, 4]**
```
i=0, j=4
Swap: arr[0] ↔ arr[4]  →  [3, 1, 5, 4, 2]
i=1, j=3
Swap: arr[1] ↔ arr[3]  →  [3, 4, 5, 1, 2]
i=2, j=2: stop
Result: [3, 4, 5, 1, 2] ✓
```

---

## ⚠️ Edge Cases

### Handled Cases
- ✅ k = 0 (no rotation)
- ✅ k = n (full rotation)
- ✅ k > n (normalized with modulo)
- ✅ Single element array
- ✅ Two element array
- ✅ Large arrays (100+)
- ✅ Empty array

---

## 🎓 Learning Points

### What You Learn
1. **In-place operations** - Modify without extra space
2. **Two-pointer technique** - Core algorithm pattern
3. **Mathematical insight** - Why reversal works
4. **Complexity optimization** - Trade-offs analysis
5. **Interview patterns** - Optimal solution thinking

### Interview Tips
- Explain why you choose reverse over extra array
- Discuss edge cases and k > n handling
- Show understanding of time/space trade-offs
- Demonstrate two-pointer pattern mastery

---

## 📚 Related Topics

### Similar Problems
- String reversal
- Array permutation
- Circular buffer rotation
- Deque operations

### Advanced Topics
- Block rotation algorithm
- Juggling algorithm
- Minimum rotations to get sorted array
- Rotate matrix 90°

---

## ✅ Verification

All programs tested and verified:
- ✓ Compilation successful
- ✓ All test cases passing
- ✓ Edge cases handled
- ✓ Correct output verified

---

## 🎊 Summary

| Aspect | Details |
|--------|---------|
| **Algorithm** | Three reversals |
| **Time** | O(N) |
| **Space** | O(1) |
| **Method** | In-place |
| **Interview** | ⭐⭐⭐⭐⭐ |
| **Difficulty** | Medium |
| **Topic** | Array Manipulation |

---

## 📝 Notes

- All code includes detailed comments
- Test cases demonstrate all scenarios
- Alternative approaches shown for comparison
- Perfect for interview preparation

---

**Happy Learning! 🚀**

Created: May 3, 2026  
Status: Complete & Tested ✅


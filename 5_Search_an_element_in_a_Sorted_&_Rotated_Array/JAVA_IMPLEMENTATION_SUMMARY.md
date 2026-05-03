# Search an Element in a Sorted & Rotated Array - Implementation Summary

**Date:** May 3, 2026  
**Status:** ✅ Complete and Tested

---

## 📋 Overview

This directory contains **3 comprehensive Java programs** that illustrate the complete concept of searching an element in a sorted and rotated array, along with detailed explanations and multiple approaches.

---

## 📁 Files Created

### 1. **SearchInRotatedArray.java** (Main Implementation)
**Purpose:** Core implementation with multiple approaches

**What it includes:**
- ✅ **Approach 1: Optimal (Two Binary Searches)** - O(log n) time, O(1) space
  - `searchOptimal()` - Main method using two binary searches
  - `findRotationPoint()` - Finds the pivot point
  - `binarySearch()` - Standard binary search implementation

- ✅ **Approach 2: Single Pass Binary Search** - O(log n) time, O(1) space
  - `searchSinglePass()` - Combined search without finding pivot first

- ✅ **Approach 3: Linear Search** - O(n) time, O(1) space
  - `searchLinear()` - Brute force approach for comparison

**Test Cases:** 8 comprehensive test cases covering:
- Basic element search
- Element in first half
- Element in second half
- Element not found
- No rotation (already sorted)
- Element at beginning
- Element at end
- Single element array
- Two element array

**Compilation & Execution:**
```bash
cd "D:\projects\DSA Bootcamp 2026\5_Search_an_element_in_a_Sorted_&_Rotated_Array"
javac SearchInRotatedArray.java
java SearchInRotatedArray
```

---

### 2. **RotatedArrayAdvanced.java** (Advanced Variations)
**Purpose:** Extended problems and related concepts

**What it includes:**
- ✅ **Problem 1: Find Minimum Element** 
  - `findMin()` - O(log n) time using binary search

- ✅ **Problem 2: Count Rotations**
  - `countRotations()` - Calculate how many times the array was rotated
  - Formula: `rotations = n - (index of minimum)`

- ✅ **Problem 3: Search with Duplicates**
  - `searchWithDuplicates()` - Handle arrays with duplicate elements
  - Strategy: Shrink search space when unable to determine sorted half

- ✅ **Problem 4: Find All Occurrences**
  - `findAllOccurrences()` - Find first and last occurrence
  - Returns all indices where element is found

- ✅ **Problem 5: Array Rotation Visualization**
  - `rotateArray()` - Demonstrates how array rotation works
  - Visual understanding of rotation mechanics

**Example Output:**
```
--- Problem 1: Find Minimum Element ---
Array: [9, 10, 12, 5, 6, 7, 8]
Minimum Element: 5

--- Problem 2: Count Number of Rotations ---
Number of Rotations: 4

--- Problem 3: Search in Array with Duplicates ---
Search for 7: 5

--- Problem 5: Array Rotation Visualization ---
Original Array: [1, 2, 3, 4, 5]
After 2 Rotations: [4, 5, 1, 2, 3]
After 4 Rotations: [2, 3, 4, 5, 1]
```

**Compilation & Execution:**
```bash
javac RotatedArrayAdvanced.java
java RotatedArrayAdvanced
```

---

### 3. **SearchInRotatedArrayWalkthrough.java** (Educational Walkthrough)
**Purpose:** Step-by-step execution traces for learning

**What it includes:**
- ✅ **Detailed Algorithm Explanation** (10 key points)
  - Problem description
  - Key insights
  - Examples and visualizations
  - Complexity analysis
  - Common mistakes to avoid

- ✅ **Traced Execution** with detailed logging
  - `searchWithTrace()` - Main search with full trace output
  - `findRotationPointWithTrace()` - Shows pivot-finding iterations
  - `binarySearchWithTrace()` - Shows binary search iterations

- ✅ **5 Complete Walkthroughs:**
  1. Element found in first half
  2. Element found in second half
  3. Element not found
  4. Array not rotated
  5. Single element array

**Example Output (Walkthrough):**
```
=== SEARCH TRACE ===
Array: [9, 10, 12, 5, 6, 7, 8]
Target Key: 10

STEP 1: Finding Rotation Point
Iteration 1:
  left=0(arr[0]=9), mid=3(arr[3]=5), right=6(arr[6]=8)
  → Found: arr[3]=5 < arr[2]=12
  → Rotation point at index 3

STEP 2: Searching in First Sorted Part
Searching in range [0 to 2]
  Iteration 1:
    left=0, mid=1, right=2
    Values: arr[0]=9, arr[1]=10, arr[2]=12
    ✓ FOUND: arr[1] = 10
✓ Found at index: 1
```

**Compilation & Execution:**
```bash
javac SearchInRotatedArrayWalkthrough.java
java SearchInRotatedArrayWalkthrough
```

---

## 🎯 Key Concepts Illustrated

### 1. **Rotation Concept**
```
Original Sorted Array:  [5, 6, 7, 8, 9, 10, 12]
After 4 rotations:      [9, 10, 12, 5, 6, 7, 8]
                        └─ Sorted ─┘ └─ Sorted ─┘
```

### 2. **Pivot Point**
- The index where the sorted order breaks
- Maximum element before pivot > first element after pivot
- In `[9, 10, 12, 5, 6, 7, 8]`, pivot is at index 3

### 3. **Binary Search Decision**
```
if (arr[mid] >= arr[left]) {
    // Left half is sorted → pivot is in right half
    left = mid + 1;
} else {
    // Right half is sorted → pivot is in left half
    right = mid - 1;
}
```

### 4. **Time Complexity**
| Operation | Complexity | Reason |
|-----------|-----------|--------|
| Find Pivot | O(log n) | Binary search divides array in half each iteration |
| Search Element | O(log n) | Binary search on sorted portion |
| Total | O(log n) | Two O(log n) operations = O(log n) overall |

### 5. **Space Complexity**
| Aspect | Complexity |
|--------|-----------|
| Variables | O(1) |
| Recursion Stack | O(1) (iterative approach) |
| Extra Data Structures | None |
| **Total** | **O(1)** |

---

## 💡 Common Mistakes Avoided

✅ **Mistake 1:** Off-by-one errors in pivot boundaries
- Solution: Use `findRotationPointWithTrace()` to debug

✅ **Mistake 2:** Not handling non-rotated arrays
- Solution: Check if `arr[left] < arr[right]` first

✅ **Mistake 3:** Incorrect comparison operators
- Solution: Use `>=` not just `>` in half-sorted checks

✅ **Mistake 4:** Only checking one half
- Solution: Check first part, then second part if not found

✅ **Mistake 5:** Forgetting edge cases
- Solution: Test with single elements, empty arrays, duplicates

---

## 🚀 How to Use These Files

### For Learning:
1. **Start with:** `SearchInRotatedArrayWalkthrough.java`
   - Read the algorithm explanation
   - Follow the walkthroughs step-by-step
   - Understand how binary search works

2. **Then:** `SearchInRotatedArray.java`
   - Study the main approaches
   - Compare optimal vs single-pass vs linear
   - Review the test cases

3. **Finally:** `RotatedArrayAdvanced.java`
   - Learn related problems
   - Understand how to adapt the algorithm
   - See how to handle edge cases

### For Interview Preparation:
- Practice explaining the algorithm from `Walkthrough` file
- Be able to implement the Optimal approach
- Discuss time/space complexity trade-offs
- Explain why this is better than linear search

### For Reference:
- Use these files as templates for similar problems
- Reference the walkthroughs when stuck
- Copy the approach patterns for other binary search problems

---

## 📊 Execution Results Summary

### ✅ SearchInRotatedArray.java Results
```
Test Case 1: Basic Example [9, 10, 12, 5, 6, 7, 8], key=10
  ✓ Optimal Approach: 1
  ✓ Single Pass: 1
  ✓ Linear Search: 1

Test Case 2: Element in Second Half [9, 10, 12, 5, 6, 7, 8], key=6
  ✓ Optimal Approach: 4
  ✓ Single Pass: 4
  ✓ Linear Search: 4

Test Case 3: Element Not Found [9, 10, 12, 5, 6, 7, 8], key=15
  ✓ Optimal Approach: -1
  ✓ Single Pass: -1
  ✓ Linear Search: -1

Test Case 4: No Rotation [5, 6, 7, 8, 9, 10, 12], key=8
  ✓ Optimal Approach: 3
  ✓ Single Pass: 3
  ✓ Linear Search: 3

Test Case 5: Element at Beginning [9, 10, 12, 5, 6, 7, 8], key=9
  ✓ Optimal Approach: 0
  ✓ Single Pass: 0
  ✓ Linear Search: 0

Test Case 6: Element at End [9, 10, 12, 5, 6, 7, 8], key=8
  ✓ Optimal Approach: 6
  ✓ Single Pass: 6
  ✓ Linear Search: 6

Test Case 7: Single Element [5], key=5
  ✓ All Approaches: 0

Test Case 8: Two Elements [3, 1], key=3
  ✓ All Approaches: 0
```

### ✅ RotatedArrayAdvanced.java Results
```
Problem 1: Find Minimum Element in [9, 10, 12, 5, 6, 7, 8]
  Result: 5 ✓

Problem 2: Count Rotations in [9, 10, 12, 5, 6, 7, 8]
  Original: [5, 6, 7, 8, 9, 10, 12]
  Result: 4 rotations ✓

Problem 3: Search with Duplicates in [5, 7, 7, 7, 7, 7, 7, 7, 9, 10, 12]
  Search 7: 5 ✓
  Search 5: 0 ✓
  Search 12: 10 ✓
  Search 15: -1 ✓

Problem 4: Find All Occurrences of 5 in [5, 5, 5, 5, 6, 7, 8]
  Result: [0, 1, 2, 3] ✓

Problem 5: Array Rotation Visualization
  Original: [1, 2, 3, 4, 5]
  After 2 rotations: [4, 5, 1, 2, 3] ✓
  After 4 rotations: [2, 3, 4, 5, 1] ✓
```

### ✅ SearchInRotatedArrayWalkthrough.java Results
```
Algorithm Explanation: ✓ Complete with 10 key points
Walkthrough 1 - Element in First Half: ✓ Traced correctly
Walkthrough 2 - Element in Second Half: ✓ Traced correctly
Walkthrough 3 - Element Not Found: ✓ Traced correctly
Walkthrough 4 - Array Not Rotated: ✓ Traced correctly
Walkthrough 5 - Single Element: ✓ Traced correctly
```

---

## 🔗 Related Documentation

- **Markdown Guide:** `Search_in_Sorted_Rotated_Array_Complete_Guide.md`
  - Comprehensive explanation of concepts
  - Examples and test cases
  - Practice problems
  - Tips and tricks

- **Video Reference:** https://www.youtube.com/watch?v=ODE4S75WD8s
  - Original tutorial video
  - Source of algorithm explanation

---

## 📈 Complexity Comparison

| Approach | Time | Space | Use Case |
|----------|------|-------|----------|
| Optimal (Two Binary Searches) | O(log n) | O(1) | **Recommended - Best balance** |
| Single Pass Binary Search | O(log n) | O(1) | Alternative - Single iteration |
| Linear Search | O(n) | O(1) | Understanding only - Inefficient |

---

## ✨ Code Quality

- ✅ Well-commented code explaining each step
- ✅ Comprehensive test cases
- ✅ Error handling for edge cases
- ✅ Clear variable names and structure
- ✅ Follows Java naming conventions
- ✅ No compiler errors or warnings
- ✅ All programs execute successfully

---

## 🎓 Learning Outcomes

After studying these files, you should understand:

1. ✅ How array rotation works
2. ✅ Why binary search can be used on rotated arrays
3. ✅ How to find the rotation point (pivot)
4. ✅ How to determine which half contains the target
5. ✅ Time and space complexity analysis
6. ✅ Multiple approaches to the same problem
7. ✅ Edge cases and how to handle them
8. ✅ How to adapt the algorithm for variations (duplicates, find min, etc.)
9. ✅ How to trace and debug the algorithm
10. ✅ Interview-ready explanations and code

---

**Version:** 1.0  
**Created:** May 3, 2026  
**Status:** ✅ All Tests Passing  
**Ready for:** Learning, Interview Preparation, Reference



# Time Complexity Practice Problems with Solutions

## Problem Set 1: Basic Loop Analysis

### Problem 1.1: Simple Counter Loop
```java
for(int i = 0; i < n; i++) {
    System.out.println(i);
}
```
**Question:** What is the time complexity?

**Solution:**
- Loop runs from i=0 to i=n-1
- Total iterations: n
- Each iteration: O(1)
- **Time Complexity: O(n)**

---

### Problem 1.2: Nested Loops
```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```
**Question:** What is the time complexity?

**Solution:**
- Outer loop: n iterations
- Inner loop: n iterations for each outer loop iteration
- Total: n × n = n²
- **Time Complexity: O(n²)**

---

### Problem 1.3: Triangular Pattern
```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < i; j++) {
        sum += arr[i][j];
    }
}
```
**Question:** What is the time complexity?

**Solution:**
- When i=0: inner loop runs 0 times
- When i=1: inner loop runs 1 time
- When i=2: inner loop runs 2 times
- ...
- When i=n-1: inner loop runs n-1 times
- Total: 0+1+2+...+(n-1) = n(n-1)/2
- **Time Complexity: O(n²)**

---

### Problem 1.4: Dividing Loop
```java
for(int i = n; i > 1; i /= 2) {
    count++;
}
```
**Question:** What is the time complexity?

**Solution:**
- i values: n → n/2 → n/4 → n/8 → ... → 1
- How many times do we divide by 2?
- n / 2^k = 1 → 2^k = n → k = log₂(n)
- **Time Complexity: O(log n)**

---

### Problem 1.5: Sequential Loops (NOT Nested)
```java
for(int i = 0; i < n; i++) {
    sum += arr[i];
}

for(int j = 0; j < n; j++) {
    for(int k = 0; k < n; k++) {
        product *= arr[j][k];
    }
}
```
**Question:** What is the time complexity?

**Solution:**
- First loop: O(n)
- Second nested loop: O(n²)
- Total: O(n) + O(n²) = O(n²)
- When adding complexities, take the higher one
- **Time Complexity: O(n²)**

---

## Problem Set 2: Recursive Algorithms

### Problem 2.1: Simple Recursion
```java
void printN(int n) {
    if(n == 0) return;
    System.out.println(n);
    printN(n - 1);
}
```
**Question:** What is the time complexity?

**Solution:**
- Each call reduces n by 1
- Call stack: n, n-1, n-2, ..., 1, 0
- Total calls: n
- Each call: O(1)
- **Time Complexity: O(n)**

---

### Problem 2.2: Binary Recursion (Like Fibonacci)
```java
int fib(int n) {
    if(n <= 1) return n;
    return fib(n-1) + fib(n-2);
}
```
**Question:** What is the time complexity?

**Solution:**
- Recurrence: T(n) = T(n-1) + T(n-2)
- Each call branches into 2 calls
- Tree grows exponentially
- T(n) < 2*T(n-1) < 2²*T(n-2) < ... < 2ⁿ
- **Time Complexity: O(2ⁿ)** ❌ VERY BAD

**Optimization:**
Use Dynamic Programming (memoization):
```java
int fib(int n, int[] memo) {
    if(n <= 1) return n;
    if(memo[n] != -1) return memo[n];
    memo[n] = fib(n-1, memo) + fib(n-2, memo);
    return memo[n];
}
```
- Each value calculated once
- **Optimized Time Complexity: O(n)** ✅ GREAT

---

### Problem 2.3: Logarithmic Recursion (Binary Search)
```java
int binarySearch(int[] arr, int target, int left, int right) {
    if(left > right) return -1;
    int mid = left + (right - left) / 2;
    if(arr[mid] == target) return mid;
    if(arr[mid] < target) return binarySearch(arr, target, mid+1, right);
    return binarySearch(arr, target, left, mid-1);
}
```
**Question:** What is the time complexity?

**Solution:**
- Each call halves search space
- Recurrence: T(n) = T(n/2) + O(1)
- Depth of recursion: log₂(n)
- Each level: O(1) work
- **Time Complexity: O(log n)**

---

## Problem Set 3: Complex Patterns

### Problem 3.1: Nested Loops with Different Sizes
```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < i; j++) {
        for(int k = 0; k < m; k++) {
            operation();
        }
    }
}
```
**Question:** What is the time complexity?

**Solution:**
- Outer loop: n iterations
- Middle loop: varies 0 to n (triangular)
- Inner loop: m iterations
- Total: (0+1+2+...+n) × m = (n(n-1)/2) × m = O(n²m)
- **Time Complexity: O(n²m)**

---

### Problem 3.2: Loop with Division in Nested Structure
```java
for(int i = 1; i <= n; i++) {
    for(int j = 1; j <= i; j *= 2) {
        operation();
    }
}
```
**Question:** What is the time complexity?

**Solution:**
- Outer loop: n iterations
- Inner loop for each i: j goes 1 → 2 → 4 → 8 → ... → i
  - This is log₂(i) iterations
- For i=1: log(1) = 0
- For i=2: log(2) = 1
- For i=3: log(3) ≈ 1.58
- For i=n: log(n)
- Total: log(1) + log(2) + ... + log(n) = O(n log n)
- **Time Complexity: O(n log n)**

---

### Problem 3.3: Power Growth (Double Exponential)
```java
for(int i = 2; i < n; i = i * i) {
    operation();
}
```
**Question:** What is the time complexity?

**Solution:**
- i values: 2 → 4 → 16 → 256 → 65536 → ...
- i = 2^(2^k) where k = 0, 1, 2, 3, ...
- Condition: 2^(2^k) < n
- Take log: 2^k < log(n)
- Take log: k < log(log(n))
- **Time Complexity: O(log log n)**

---

## Problem Set 4: Real-World Algorithms

### Problem 4.1: Bubble Sort
```java
void bubbleSort(int[] arr) {
    int n = arr.length;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n - 1 - i; j++) {
            if(arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
            }
        }
    }
}
```
**Question:** What is the time complexity?

**Solution:**
- Outer loop: n times
- Inner loop: n-1, then n-2, then n-3, ... (triangular)
- Total: n + (n-1) + (n-2) + ... + 1 = n(n+1)/2
- **Time Complexity: O(n²)**

---

### Problem 4.2: Merge Sort (Divide and Conquer)
```java
void mergeSort(int[] arr, int left, int right) {
    if(left < right) {
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);  // O(n)
    }
}
```
**Question:** What is the time complexity?

**Solution:**
- Recurrence: T(n) = 2*T(n/2) + O(n)
- Using Master Theorem: a=2, b=2, f(n)=n
- log_b(a) = log₂(2) = 1
- f(n) = n = Θ(n)
- This is case 2 of Master Theorem
- **Time Complexity: O(n log n)**

---

### Problem 4.3: Quick Sort (Average Case)
```java
void quickSort(int[] arr, int left, int right) {
    if(left < right) {
        int pivot = partition(arr, left, right);  // O(n)
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
}
```
**Question:** What is the time complexity (average case)?

**Solution:**
- Best/Average: Partitions divide array evenly
- Recurrence: T(n) = 2*T(n/2) + O(n)
- This is same as Merge Sort
- **Average Time Complexity: O(n log n)**
- Worst case (bad pivot): O(n²)

---

## Problem Set 5: Tricky Cases

### Problem 5.1: Determine the Complexity
```java
int result = 0;
for(int i = 0; i < n; i++) {
    for(int j = i; j < n; j++) {
        result += arr[i][j];
    }
}
```
**Question:** What is the time complexity?

**Solution:**
- When i=0: j goes from 0 to n-1 (n iterations)
- When i=1: j goes from 1 to n-1 (n-1 iterations)
- When i=2: j goes from 2 to n-1 (n-2 iterations)
- ...
- Total: n + (n-1) + (n-2) + ... + 1 = n(n+1)/2
- **Time Complexity: O(n²)**

---

### Problem 5.2: Sequential Sorting
```java
Arrays.sort(arr1);  // O(n log n) for array of size n
Arrays.sort(arr2);  // O(m log m) for array of size m
Arrays.sort(arr3);  // O(k log k) for array of size k
```
**Question:** What is the total time complexity?

**Solution:**
- First sort: O(n log n)
- Second sort: O(m log m)
- Third sort: O(k log k)
- Total: O(n log n) + O(m log m) + O(k log k)
- **Time Complexity: O(n log n + m log m + k log k)**
- If n=m=k, then O(n log n)

---

### Problem 5.3: String Concatenation
```java
String result = "";
for(int i = 0; i < n; i++) {
    result += str[i];  // String concatenation in Java
}
```
**Question:** What is the time complexity?

**Solution:**
- String concatenation in Java creates a new String object
- First iteration: 1 operation
- Second: copies 1 + 1 = 2 characters
- Third: copies 2 + 1 = 3 characters
- i-th: copies i characters
- Total: 1 + 2 + 3 + ... + n = n(n+1)/2
- **Time Complexity: O(n²)** ❌ SLOW!

**Optimization:**
```java
StringBuilder result = new StringBuilder();
for(int i = 0; i < n; i++) {
    result.append(str[i]);  // O(1) amortized
}
```
- **Optimized Time Complexity: O(n)** ✅ FAST

---

## Answer Key Summary

| Problem | Complexity | Explanation |
|---------|-----------|-------------|
| 1.1 Simple Loop | O(n) | Runs n times |
| 1.2 Nested | O(n²) | n × n |
| 1.3 Triangular | O(n²) | n(n-1)/2 |
| 1.4 Dividing | O(log n) | Halves each time |
| 1.5 Sequential | O(n²) | Take max of O(n) + O(n²) |
| 2.1 Linear Recursion | O(n) | n calls, each O(1) |
| 2.2 Binary Recursion | O(2^n) | Branches exponentially |
| 2.2 Optimized | O(n) | DP avoids recalculation |
| 2.3 Binary Search | O(log n) | Halves search space |
| 3.1 Complex Nested | O(n²m) | Triangular × m |
| 3.2 Log Nested | O(n log n) | Sum of logs |
| 3.3 Power Growth | O(log log n) | Square repeatedly |
| 4.1 Bubble Sort | O(n²) | Triangular nested loops |
| 4.2 Merge Sort | O(n log n) | Divide & conquer |
| 4.3 Quick Sort Avg | O(n log n) | Even splits |
| 5.1 Triangular | O(n²) | j starts from i |
| 5.2 Sequential Sorts | O(n log n + m log m + k log k) | Sum of operations |
| 5.3 String Concat | O(n²) | Copies grow |
| 5.3 Optimized | O(n) | StringBuilder |

---

## Practice Challenge

Try to determine the complexity of these on your own:

**Challenge 1:**
```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < m; j++) {
        operation();
    }
}
```
Answer: O(nm)

**Challenge 2:**
```java
while(n > 1) {
    n = n / 3;
    operation();
}
```
Answer: O(log₃ n) = O(log n)

**Challenge 3:**
```java
for(int i = 1; i <= n; i++) {
    for(int j = 1; j <= n; j += i) {
        operation();
    }
}
```
Answer: O(n log n)

---

## Key Takeaways

✅ **Master basic patterns first** (simple, nested, triangular, logarithmic)
✅ **Recognize when loops divide** (log n complexity)
✅ **Recognize recursive branching** (exponential growth)
✅ **Use optimization** (DP for recursion, StringBuilder for strings)
✅ **Apply Master Theorem** (for complex recurrences)
✅ **Always consider real-world impact** (O(2^n) is unusable)

---

## Practice Method

1. **Cover the solution**
2. **Try the problem yourself**
3. **Compare your answer**
4. **Understand the reasoning**
5. **Try similar problems**
6. **Teach someone else**

Repeat until mastered!

Good luck! 🚀


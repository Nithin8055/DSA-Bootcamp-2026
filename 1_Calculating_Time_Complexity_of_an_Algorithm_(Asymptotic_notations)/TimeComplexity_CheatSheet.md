# Quick Reference: Time Complexity Cheat Sheet

## Asymptotic Notations at a Glance

| Notation | Name | Meaning | Use Case |
|----------|------|---------|----------|
| O(f(n)) | Big-O | Upper bound | **WORST CASE** (use this!) |
| Θ(f(n)) | Theta | Exact bound | Precise analysis |
| Ω(f(n)) | Omega | Lower bound | Best case |

## Growth Order (Fastest to Slowest)

```
O(1)           ← BEST (constant time)
O(log log n)   ← Double logarithmic
O(log n)       ← Logarithmic
O(√n)          ← Square root
O(n)           ← Linear
O(n log n)     ← Linear logarithmic
O(n²)          ← Quadratic
O(n³)          ← Cubic
O(2ⁿ)          ← WORST (exponential - avoid!)
```

## Simplification Rules

```
Rule 1: Drop Constants
  5n + 10     →  O(n)
  100n        →  O(n)
  1000        →  O(1)

Rule 2: Drop Lower Terms
  n³ + n² + n     →  O(n³)
  n log n + n     →  O(n log n)
  n² + 5n + 10    →  O(n²)

Rule 3: Keep Only Highest Power
  f(n) = 3n⁴ + 5n² + 2n + 1  →  O(n⁴)
```

## Loop Pattern Recognition

### Pattern 1: Simple Loop → O(n)
```java
for(int i = 0; i < n; i++) {
    // Statement runs n times
}
// Complexity: O(n)
```

### Pattern 2: Nested Loop → O(n²)
```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        // Statement runs n*n times
    }
}
// Complexity: O(n²)
```

### Pattern 3: Triangular Loop → O(n²)
```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < i; j++) {
        // Runs 1+2+3+...+n = n(n-1)/2 times
    }
}
// Complexity: O(n²)
```

### Pattern 4: Logarithmic Loop → O(log n)
```java
for(int i = n; i > 1; i /= 2) {
    // Loop variable: n → n/2 → n/4 → ... → 1
    // Runs log₂(n) times
}
// Complexity: O(log n)
```

### Pattern 5: Power Growth Loop → O(log log n) ⭐
```java
for(int i = 2; i < n; i = i*i) {
    // Loop variable: 2 → 4 → 16 → 256 → ...
    // Each iteration squares i
    // i values: 2^(2^k) where k = 0,1,2,...
}
// Complexity: O(log log n)
```

## Common Algorithm Complexities

### Searching
- Linear Search: O(n)
- Binary Search: O(log n)
- Hash Table Lookup: O(1) average

### Sorting
- Bubble Sort: O(n²)
- Selection Sort: O(n²)
- Insertion Sort: O(n²)
- Merge Sort: O(n log n)
- Quick Sort: O(n log n) average, O(n²) worst
- Heap Sort: O(n log n)

### Data Structures
- Array Access: O(1)
- Array Search: O(n)
- Array Insertion: O(n)
- Linked List Access: O(n)
- Linked List Insertion: O(1) (if position known)
- Hash Table: O(1) average, O(n) worst

### Recursive Algorithms
- Linear Recursion: O(n)
- Binary Recursion (Fibonacci naive): O(2ⁿ)
- Binary Recursion (Merge Sort): O(n log n)
- Tree Traversal: O(n)

## The Fibonacci Trap ⚠️

### Naive Recursion - O(2ⁿ) TERRIBLE!
```java
int fib(int n) {
    if(n <= 1) return n;
    return fib(n-1) + fib(n-2);  // Recalculates same values!
}
```
Performance: n=40 → ~1 TRILLION calls (unusable)

### Dynamic Programming - O(n) AMAZING!
```java
int fib(int n) {
    int[] dp = new int[n+1];
    dp[0]=0; dp[1]=1;
    for(int i=2; i<=n; i++) {
        dp[i] = dp[i-1] + dp[i-2];  // Use stored values
    }
    return dp[n];
}
```
Performance: n=40 → 40 operations (instant)

## Interview Tips

### When Asked "What's the Time Complexity?"

1. **Identify Loop Structure**
   - Simple loop → O(n)
   - Nested loop → O(n²)
   - Divide-by-2 → O(log n)

2. **Write Iteration Count**
   - n, n², 1+2+3+...+n, log n, etc.

3. **Simplify**
   - Drop constants
   - Drop lower terms
   - Keep highest power

4. **Explain Briefly**
   - "The outer loop runs n times, inner loop runs n times, so O(n²)"

5. **Mention Worst Case**
   - "In the worst case, it's O(n)"

### Red Flags in Code

🚩 Nested loops → Likely O(n²) or worse
🚩 Recursive calls in branches → Likely O(2ⁿ)
🚩 No clear termination in loops → Might be O(n²) or O(n log n)
🚩 Sorting without optimization → Likely O(n²)

## Quick Decision Tree

```
Does the input size shrink/halve each iteration?
├─ YES → O(log n)
└─ NO
    └─ Is it a simple loop?
        ├─ YES → O(n)
        └─ NO
            └─ Are there nested loops?
                ├─ YES → O(n²) or O(n^k)
                └─ NO
                    └─ Is it recursive with branching?
                        ├─ YES (2+ branches) → O(2ⁿ)
                        └─ YES (1 branch) → O(n)
```

## Remember

✅ Always analyze **WORST CASE**
✅ Drop constants and lower terms
✅ Identify loop patterns
✅ O(1) < O(log n) < O(n) < O(n²) < O(2ⁿ)
✅ Exponential = exponentially bad
✅ Dynamic Programming often reduces exponential to polynomial
❌ Don't forget to analyze space complexity too!

---

**Practice:** Run `java TimeComplexityIllustration` to see all concepts in action!


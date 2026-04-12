# 📘 Time Complexity & Asymptotic Notations (MASTER NOTES)

---

# 🔹 1. Problem Understanding

Given a problem **P**, there can be multiple algorithms:

- A1
- A2
- A3

👉 Goal: Choose BEST algorithm

### Criteria:
- ⏱ Time Complexity
- 💾 Space Complexity

👉 Best = Minimum Time + Minimum Space

---

# 🔹 2. What is Time Complexity?

Time Complexity = Growth of execution time with respect to input size (n)

❗ Important:
- NOT actual seconds
- NOT machine dependent
- Only growth matters

---

# 🔹 3. Linear Search (Core Example)

```java
for(int i = 0; i < arr.length; i++) {
    if(arr[i] == x)
        return true;
}
return false;
```

---

# 🔹 4. Types of Cases

## ✅ Best Case
- Element at index 0
- Comparisons = 1
👉 O(1)

---

## ❌ Worst Case ⭐ MOST IMPORTANT
- Element at last OR not present
- Comparisons = n
👉 O(n)

---

## ⚖️ Average Case
- Element somewhere in middle
👉 ~ O(n)

---

## 🔥 KEY INSIGHT
👉 Always analyze **Worst Case**

Because:
- Gives guarantee
- Safe for real-world systems

---

# 🔹 5. Asymptotic Notations

Used to represent time mathematically

---

## 🔸 Theta (θ) → Exact

θ(f(n)) = exact growth

Example:
θ(n²)

---

## 🔸 Big-O (O) → Upper Bound

O(f(n)) ≥ actual time

👉 Used for WORST CASE

Example:
O(n³), O(n⁴), O(n¹⁰⁰)

---

## 🔸 Omega (Ω) → Lower Bound

Ω(f(n)) ≤ actual time

👉 BEST CASE

---

# 🔹 6. Order of Growth (VERY IMPORTANT)

Example:
f(n) = c*n³ + d*n² + e*n + f

👉 For large n:
- n³ dominates everything

👉 Final:
θ(n³), O(n³), Ω(n³)

---

# 🔹 7. Rules for Simplification

### Rule 1: Ignore constants
5n → O(n)

### Rule 2: Ignore lower terms
n³ + n² → O(n³)

### Rule 3: Take dominant term
Highest power wins

---

# 🔹 8. Growth Order (FULL ORDER)

O(1)  
< O(log log n)  
< O(log n)  
< O(√n)  
< O(n)  
< O(n log n)  
< O(n²)  
< O(n³)  
< O(2ⁿ)

---

# 🔹 9. Loop Analysis (CORE)

---

## 🔸 Case 1: Simple Loop

```java
for(int i = 0; i < n; i++)
```

👉 Runs n times  
👉 O(n)

---

## 🔸 Case 2: Nested Loop

```java
for(int i=0;i<n;i++)
  for(int j=0;j<n;j++)
```

👉 n * n  
👉 O(n²)

---

## 🔸 Case 3: Triangular Loop

```java
for(int i=0;i<n;i++)
  for(int j=0;j<i;j++)
```

👉 n(n-1)/2  
👉 O(n²)

---

## 🔸 Case 4: Logarithmic Loop

```java
for(int i=n; i>1; i/=2)
```

👉 n → n/2 → n/4  
👉 O(log n)

---

## 🔸 Case 5: Power Growth Loop (IMPORTANT)

```java
for(int i=2; i<n; i = i*i)
```

### Step analysis:
i values:
2 → 2² → 2⁴ → 2⁸ → ...

i = 2^(2^k)

Condition:
2^(2^k) < n

Take log:
2^k < log n

Take log again:
k < log(log n)

👉 FINAL:
O(log log n)

---

# 🔹 10. General Trick (IMPORTANT)

If loop is confusing:

1. Track values of variable
2. Write sequence
3. Convert to equation
4. Solve using logs

---

# 🔹 11. Fibonacci Complexity (CRITICAL)

```java
int fib(int n){
    if(n<=1) return n;
    return fib(n-1) + fib(n-2);
}
```

---

## 🔸 Recurrence

T(n) = T(n-1) + T(n-2)

---

## 🔸 Key Observation

fib(n-2) < fib(n-1)

So:

T(n) < 2T(n-1)

---

## 🔸 Expand

T(n) < 2T(n-1)  
< 2²T(n-2)  
< 2³T(n-3)  
...  
< 2ⁿ

---

## 🔸 Final

👉 O(2ⁿ)

---

# 🔹 12. Important Observations

- More recursion → more branching → higher complexity
- Tree grows exponentially

---

# 🔹 13. Common Mistakes

❌ Ignoring worst case  
❌ Not simplifying expression  
❌ Confusing log and log log  

---

# 🔹 14. Interview Strategy

Always:

1. Identify loop pattern
2. Write iterations
3. Simplify
4. Explain reasoning

---

# 🧪 Practice

### Q1
```java
for(int i=1; i<n; i*=2)
```

### Q2
```java
for(int i=1; i<n; i=i*i)
```

---

# 🚀 Final Thought

👉 Time Complexity = Backbone of DSA

If you master this:
- Problem solving becomes easier
- Interview confidence increases

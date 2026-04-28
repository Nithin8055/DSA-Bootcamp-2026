/**
 * TIME COMPLEXITY & ASYMPTOTIC NOTATIONS - COMPREHENSIVE JAVA ILLUSTRATION
 *
 * This program demonstrates all key concepts from the Time Complexity Master Notes:
 * 1. Linear Search (Best, Worst, Average Case)
 * 2. Asymptotic Notations (O, Θ, Ω)
 * 3. Order of Growth
 * 4. Loop Pattern Analysis
 * 5. Recurrence Relations (Fibonacci)
 *
 * Author: DSA Bootcamp 2026
 */

public class TimeComplexityIllustration {

    // ...existing code...

    // Helper method for Java 8 compatibility
    private static String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * LINEAR SEARCH: Searches for an element in an array
     *
     * BEST CASE: O(1) - Element found at index 0 → only 1 comparison
     * WORST CASE: O(n) - Element at last position or not present → n comparisons
     * AVERAGE CASE: O(n) - Element somewhere in middle → average n/2 comparisons
     *
     * KEY INSIGHT: We analyze WORST CASE because:
     *              - Provides guaranteed upper bound
     *              - Safe for real-world systems
     */
    public static boolean linearSearch(int[] arr, int target) {
        // We use Big-O notation to describe worst case: O(n)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true; // BEST CASE: Found immediately at i=0 → O(1)
            }
        }
        return false; // WORST CASE: Loop runs n times → O(n)
    }

    // ============================================================================
    // SECTION 2: ASYMPTOTIC NOTATIONS
    // ============================================================================

    /**
     * BIG-O (O) → UPPER BOUND - Worst Case
     * Represents maximum growth rate
     * Example: O(n³), O(n²), O(n)
     *
     * THETA (Θ) → EXACT GROWTH - Tight bound
     * Represents exact growth rate
     * Example: Θ(n²)
     *
     * OMEGA (Ω) → LOWER BOUND - Best Case
     * Represents minimum growth rate
     * Example: Ω(1), Ω(log n)
     */

    /**
     * RULE 1: Ignore Constants
     * 5n → O(n)
     * 1000n + 500 → O(n)
     *
     * The constant multiplier doesn't matter for large n
     */
    public static void constantIgnoranceDemo() {
        System.out.println("\n=== RULE 1: Ignore Constants ===");
        System.out.println("5n, 10n, 1000n → All simplify to O(n)");
        System.out.println("Why? Constants don't dominate growth for large n");
    }

    /**
     * RULE 2: Ignore Lower Terms
     * n³ + n² + n → O(n³)
     *
     * Higher power terms dominate lower power terms
     */
    public static void lowerTermsIgnoranceDemo() {
        System.out.println("\n=== RULE 2: Ignore Lower Terms ===");
        System.out.println("n³ + n² + n → Dominant term is n³ → O(n³)");
        System.out.println("Why? n³ grows much faster than n² or n for large n");
    }

    /**
     * RULE 3: Take Dominant Term
     * The highest power term determines overall complexity
     */
    public static void dominantTermDemo() {
        System.out.println("\n=== RULE 3: Dominant Term Rules ===");
        System.out.println("f(n) = c*n³ + d*n² + e*n + f");
        System.out.println("→ n³ dominates everything");
        System.out.println("→ Final complexity: O(n³)");
    }

    /**
     * ORDER OF GROWTH - Complete Hierarchy
     * This represents from fastest to slowest growth:
     *
     * O(1) < O(log log n) < O(log n) < O(sqrt n) < O(n) < O(n log n) < O(n^2) < O(n^3) < O(2^n)
     */
    public static void orderOfGrowthDemo() {
        System.out.println("\n=== ORDER OF GROWTH (SLOWEST to FASTEST) ===");
        String[] complexities = {
            "O(1)        - Constant",
            "O(log log n) - Double logarithmic",
            "O(log n)     - Logarithmic",
            "O(sqrt n)    - Square root",
            "O(n)         - Linear",
            "O(n log n)   - Linear logarithmic",
            "O(n^2)       - Quadratic",
            "O(n^3)       - Cubic",
            "O(2^n)       - Exponential (SLOWEST)"
        };

        for (String complexity : complexities) {
            System.out.println(complexity);
        }

        System.out.println("\nExample: For n=1000:");
        System.out.println("O(1)    -> 1 operation");
        System.out.println("O(log n) -> ~10 operations");
        System.out.println("O(n)    -> 1,000 operations");
        System.out.println("O(n^2)   -> 1,000,000 operations");
        System.out.println("O(2^n)   -> 10^301 operations (IMPOSSIBLE!)");
    }

    // ============================================================================
    // SECTION 3: LOOP PATTERN ANALYSIS
    // ============================================================================

    /**
     * CASE 1: SIMPLE LOOP - O(n)
     * Loop runs exactly n times
     */
    public static void simpleLoopDemo(int n) {
        System.out.println("\n=== CASE 1: Simple Loop - O(n) ===");
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
        }
        System.out.println("Loop runs " + count + " times for n=" + n);
        System.out.println("Time Complexity: O(n)");
    }

    /**
     * CASE 2: NESTED LOOP - O(n²)
     * Outer loop: n times
     * Inner loop: n times
     * Total: n * n = O(n²)
     */
    public static void nestedLoopDemo(int n) {
        System.out.println("\n=== CASE 2: Nested Loop - O(n²) ===");
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }
        System.out.println("Loop runs " + count + " times for n=" + n);
        System.out.println("Calculation: n * n = " + n + " * " + n + " = " + count);
        System.out.println("Time Complexity: O(n²)");
    }

    /**
     * CASE 3: TRIANGULAR LOOP - O(n²)
     * Outer loop: n times
     * Inner loop: varies from 0 to i (triangular pattern)
     * Total: 0 + 1 + 2 + ... + (n-1) = n(n-1)/2 = O(n²)
     *
     * Common in: Bubble Sort, Selection Sort
     */
    public static void triangularLoopDemo(int n) {
        System.out.println("\n=== CASE 3: Triangular Loop - O(n²) ===");
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                count++;
            }
        }
        int expected = n * (n - 1) / 2;
        System.out.println("Loop runs " + count + " times for n=" + n);
        System.out.println("Calculation: n(n-1)/2 = " + n + "*" + (n-1) + "/2 = " + expected);
        System.out.println("Time Complexity: O(n²)");
    }

    /**
     * CASE 4: LOGARITHMIC LOOP - O(log n)
     * Variable is divided by 2 in each iteration
     *
     * Iterations:
     * i: n → n/2 → n/4 → n/8 → ... → 1
     *
     * Total iterations: log₂(n)
     *
     * Common in: Binary Search
     */
    public static void logarithmicLoopDemo(int n) {
        System.out.println("\n=== CASE 4: Logarithmic Loop - O(log n) ===");
        int count = 0;
        System.out.print("i values: " + n);
        for (int i = n; i > 1; i /= 2) {
            count++;
            System.out.print(" → " + (i / 2));
        }
        System.out.println();
        System.out.println("Loop runs " + count + " times for n=" + n);
        System.out.println("Mathematical: log₂(" + n + ") ≈ " + (int)(Math.log(n) / Math.log(2)));
        System.out.println("Time Complexity: O(log n)");
    }

    /**
     * CASE 5: POWER GROWTH LOOP - O(log log n)
     * Variable grows as power of 2: i = i*i
     *
     * CRITICAL ANALYSIS:
     * i values: 2 -> 2^2 -> 2^4 -> 2^8 -> 2^16 -> ...
     *           2^1 -> 2^2 -> 2^4 -> 2^8 -> ...
     *           2^(2^0) -> 2^(2^1) -> 2^(2^2) -> 2^(2^3) -> ...
     *
     * General form: i = 2^(2^k) where k = 0,1,2,3,...
     *
     * Condition: 2^(2^k) < n
     * Take log:  2^k < log(n)
     * Take log:  k < log(log(n))
     *
     * Therefore: O(log log n)
     */
    public static void powerGrowthLoopDemo(int n) {
        System.out.println("\n=== CASE 5: Power Growth Loop - O(log log n) ===");
        int count = 0;
        System.out.print("i values: ");
        for (int i = 2; i < n; i = i * i) {
            System.out.print(i + " → ");
            count++;
        }
        System.out.println("STOP");
        System.out.println("Loop runs " + count + " times for n=" + n);
        System.out.println("\nAnalysis:");
        System.out.println("i = 2^(2^k) where k = 0,1,2,...");
        System.out.println("Condition: 2^(2^k) < n");
        System.out.println("Take log: 2^k < log(n)");
        System.out.println("Take log: k < log(log(n))");
        System.out.println("Time Complexity: O(log log n)");
    }

    /**
     * GENERAL TRICK FOR CONFUSING LOOPS:
     * 1. Track values of loop variable
     * 2. Write sequence of values
     * 3. Convert to mathematical equation
     * 4. Solve using logarithms
     */
    public static void generalTrickDemo() {
        System.out.println("\n=== GENERAL TRICK FOR COMPLEX LOOPS ===");
        System.out.println("Steps:");
        System.out.println("1. Track loop variable values through iterations");
        System.out.println("2. Write the sequence");
        System.out.println("3. Find mathematical pattern");
        System.out.println("4. Use logarithms to solve");
        System.out.println("\nExample: for(int i=2; i<n; i=i*i)");
        System.out.println("Step 1: Values are 2, 4, 16, 256, ...");
        System.out.println("Step 2: Sequence = 2^1, 2^2, 2^4, 2^8, ...");
        System.out.println("Step 3: Pattern = 2^(2^k)");
        System.out.println("Step 4: 2^(2^k) < n → 2^k < log(n) → k < log(log(n))");
        System.out.println("Result: O(log log n)");
    }

    // ============================================================================
    // SECTION 4: FIBONACCI - EXPONENTIAL COMPLEXITY
    // ============================================================================

    /**
     * NAIVE FIBONACCI - O(2^n) EXPONENTIAL COMPLEXITY
     *
     * Recurrence Relation:
     * T(n) = T(n-1) + T(n-2) + O(1)
     *
     * Key Observation:
     * T(n) < T(n-1) + T(n-1) = 2*T(n-1)
     *
     * Expansion:
     * T(n) < 2*T(n-1)
     *      < 2^2*T(n-2)
     *      < 2^3*T(n-3)
     *      ...
     *      < 2^n
     *
     * Final Complexity: O(2^n) - EXPONENTIAL!
     *
     * Why is this bad?
     * - For n=40: ~1,099,511,627,776 function calls (over 1 TRILLION!)
     * - For n=50: Will take years to compute
     */
    public static int naiveFibonacci(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }

        // Recursive calls create exponential tree
        // Each call spawns 2 more calls
        return naiveFibonacci(n - 1) + naiveFibonacci(n - 2);
    }

    /**
     * Count function calls in naive Fibonacci to visualize exponential growth
     */
    private static long callCount = 0;

    public static long naiveFibonacciWithCounting(int n) {
        callCount++;
        if (n <= 1) {
            return n;
        }
        return naiveFibonacciWithCounting(n - 1) + naiveFibonacciWithCounting(n - 2);
    }

    /**
     * OPTIMIZED FIBONACCI - O(n) LINEAR COMPLEXITY
     * Using Dynamic Programming (Memoization)
     *
     * Instead of recalculating same values:
     * - fib(3) is calculated multiple times in naive approach
     * - We store results in array and reuse them
     *
     * Complexity: O(n) - Each value calculated once
     * Space: O(n) - Need array to store values
     */
    public static int dpFibonacci(int n) {
        // Base case
        if (n <= 1) {
            return n;
        }

        // Memoization array
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // Calculate each value once
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * SPACE OPTIMIZED FIBONACCI - O(n) time, O(1) space
     * Since we only need previous two values
     */
    public static int spacedOptimizedFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    public static void fibonacciComplexityDemo() {
        System.out.println("\n=== FIBONACCI COMPLEXITY ANALYSIS ===");
        System.out.println("\nRecurrence Relation: T(n) = T(n-1) + T(n-2)");
        System.out.println("\nKey Insight:");
        System.out.println("T(n) < 2*T(n-1) < 2^2*T(n-2) < ... < 2^n");
        System.out.println("Time Complexity: O(2^n) - EXPONENTIAL!");

        System.out.println("\n--- Exponential Growth Impact ---");
        System.out.println("n=10  -> ~2^10   = 1,024 calls");
        System.out.println("n=20  -> ~2^20   = 1,048,576 calls");
        System.out.println("n=30  -> ~2^30   = 1,073,741,824 calls (~1 billion)");
        System.out.println("n=40  -> ~2^40   = 1,099,511,627,776 calls (~1 trillion) - IMPRACTICAL");

        System.out.println("\n--- Comparison: Naive vs Optimized ---");
        int n = 35;

        // Naive approach counting
        callCount = 0;
        long naiveResult = naiveFibonacciWithCounting(n);
        long naiveCalls = callCount;

        // Optimized approach counting (always O(n))
        long optimizedCalls = n;
        long dpResult = dpFibonacci(n);

        System.out.println("fib(" + n + ") = " + naiveResult);
        System.out.println("Naive Approach:   " + naiveCalls + " function calls");
        System.out.println("Optimized (DP):   " + optimizedCalls + " iterations");
        System.out.println("Improvement:      " + (naiveCalls / optimizedCalls) + "x faster!");
    }

    // ============================================================================
    // SECTION 5: PRACTICAL EXAMPLES
    // ============================================================================

    /**
     * BUBBLE SORT - O(n²) Quadratic
     * Compare adjacent elements and swap if needed
     * Triangular loop pattern: outer n times, inner varies from 0 to n
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // Time Complexity: O(n²)
        // Space Complexity: O(1)
    }

    /**
     * BINARY SEARCH - O(log n) Logarithmic
     * Search in sorted array by dividing search space by 2 each time
     * Logarithmic loop pattern: i = i/2
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
        // Time Complexity: O(log n)
        // Space Complexity: O(1)
    }

    // ============================================================================
    // MAIN: COMPREHENSIVE DEMONSTRATION
    // ============================================================================

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("   TIME COMPLEXITY & ASYMPTOTIC NOTATIONS - FULL GUIDE");
        System.out.println("========================================================================");

        // SECTION 1: LINEAR SEARCH
        System.out.println("\n" + repeatString("=", 70));
        System.out.println("SECTION 1: LINEAR SEARCH");
        System.out.println(repeatString("=", 70));

        int[] arr = {5, 2, 8, 1, 9, 3};
        System.out.println("Array: " + java.util.Arrays.toString(arr));
        System.out.println("Search for 8: " + linearSearch(arr, 8));
        System.out.println("Search for 10: " + linearSearch(arr, 10));
        System.out.println("Time Complexity Analysis:");
        System.out.println("- Best Case: O(1)   [Element at index 0]");
        System.out.println("- Worst Case: O(n)  [Element not found or at end]");
        System.out.println("- Average Case: O(n) [Element somewhere in middle]");
        System.out.println("✓ Always consider WORST CASE for safety!");

        // SECTION 2: ASYMPTOTIC NOTATIONS & RULES
        System.out.println("\n" + repeatString("=", 70));
        System.out.println("SECTION 2: SIMPLIFICATION RULES");
        System.out.println(repeatString("=", 70));

        constantIgnoranceDemo();
        lowerTermsIgnoranceDemo();
        dominantTermDemo();
        orderOfGrowthDemo();

        // SECTION 3: LOOP PATTERNS
        System.out.println("\n" + repeatString("=", 70));
        System.out.println("SECTION 3: LOOP PATTERN ANALYSIS");
        System.out.println(repeatString("=", 70));

        int n = 8;
        System.out.println("Using n = " + n + " for all demonstrations\n");

        simpleLoopDemo(n);
        nestedLoopDemo(n);
        triangularLoopDemo(n);
        logarithmicLoopDemo(n);
        powerGrowthLoopDemo(n);
        generalTrickDemo();

        // SECTION 4: FIBONACCI COMPLEXITY
        System.out.println("\n" + repeatString("=", 70));
        System.out.println("SECTION 4: FIBONACCI - EXPONENTIAL COMPLEXITY");
        System.out.println(repeatString("=", 70));

        fibonacciComplexityDemo();

        // SECTION 5: PRACTICAL SORTING EXAMPLES
        System.out.println("\n" + repeatString("=", 70));
        System.out.println("SECTION 5: PRACTICAL EXAMPLES");
        System.out.println(repeatString("=", 70));

        System.out.println("\n--- BUBBLE SORT - O(n^2) ---");
        int[] bubbleArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before: " + java.util.Arrays.toString(bubbleArr));
        bubbleSort(bubbleArr);
        System.out.println("After:  " + java.util.Arrays.toString(bubbleArr));
        System.out.println("Complexity: O(n^2) - Quadratic");

        System.out.println("\n--- BINARY SEARCH - O(log n) ---");
        int[] sortedArr = {11, 12, 22, 25, 34, 64, 90};
        System.out.println("Array: " + java.util.Arrays.toString(sortedArr));
        System.out.println("Search for 25: " + binarySearch(sortedArr, 25));
        System.out.println("Search for 45: " + binarySearch(sortedArr, 45));
        System.out.println("Complexity: O(log n) - Logarithmic");

        // FINAL INSIGHTS
        System.out.println("\n" + repeatString("=", 70));
        System.out.println("KEY TAKEAWAYS");
        System.out.println(repeatString("=", 70));

        System.out.println("\n1. ALWAYS ANALYZE WORST CASE");
        System.out.println("   -> Provides guaranteed upper bound");
        System.out.println("   -> Safe for real-world systems");
        System.out.println("\n2. SIMPLIFICATION RULES");
        System.out.println("   -> Ignore constants (5n -> O(n))");
        System.out.println("   -> Ignore lower terms (n^3+n^2 -> O(n^3))");
        System.out.println("   -> Take dominant term");
        System.out.println("\n3. GROWTH ORDER (from best to worst)");
        System.out.println("   O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(n^3) < O(2^n)");
        System.out.println("\n4. LOOP PATTERNS");
        System.out.println("   -> Simple loop: O(n)");
        System.out.println("   -> Nested loop: O(n^2)");
        System.out.println("   -> Triangular: O(n^2)");
        System.out.println("   -> Logarithmic: O(log n)");
        System.out.println("   -> Power growth: O(log log n)");
        System.out.println("\n5. EXPONENTIAL IS DANGEROUS");
        System.out.println("   -> Naive Fibonacci: O(2^n) -> Unusable for n>40");
        System.out.println("   -> Use optimization: Dynamic Programming");
        System.out.println("   -> Can reduce to O(n) with memoization");
        System.out.println("\n6. INTERVIEW STRATEGY");
        System.out.println("   -> Identify loop pattern");
        System.out.println("   -> Write iteration sequence");
        System.out.println("   -> Simplify mathematically");
        System.out.println("   -> Explain reasoning clearly");
        System.out.println("\n[*] TIME COMPLEXITY = Foundation of DSA Mastery [*]");
    }
}














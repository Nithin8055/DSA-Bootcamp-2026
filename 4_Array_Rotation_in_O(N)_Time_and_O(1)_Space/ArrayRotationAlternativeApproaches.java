/**
 * ArrayRotationAlternativeApproaches.java
 *
 * Demonstrates alternative approaches to array rotation
 * to understand why the reverse algorithm is optimal
 */

public class ArrayRotationAlternativeApproaches {

    /**
     * APPROACH 1: Brute Force - Rotate one by one
     *
     * How it works:
     * - Move first element to end k times
     * - Each rotation: shift all elements
     *
     * Time Complexity: O(N * K) - Very inefficient!
     * Space Complexity: O(1)
     *
     * @param arr Array to rotate
     * @param k Positions to rotate
     */
    public static void rotateBruteForce(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        // Rotate k times
        for (int i = 0; i < k; i++) {
            // Move first element to end
            int first = arr[0];

            // Shift all elements left
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }

            // Place first element at end
            arr[n - 1] = first;
        }
    }

    /**
     * APPROACH 2: Using Extra Array
     *
     * How it works:
     * - Create temporary array
     * - Copy rotated elements
     * - Copy back to original
     *
     * Time Complexity: O(N) - Linear
     * Space Complexity: O(N) - Uses extra space ❌
     *
     * @param arr Array to rotate
     * @param k Positions to rotate
     */
    public static void rotateWithExtraArray(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;

        k = k % n;

        // STEP 1: Create temporary array
        int[] temp = new int[n];

        // STEP 2: Copy rotated elements
        // Element at index i goes to index (i - k + n) % n
        for (int i = 0; i < n; i++) {
            temp[(i - k + n) % n] = arr[i];
        }

        // STEP 3: Copy back to original
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * APPROACH 3: Alternative Extra Array Method
     *
     * How it works:
     * - Copy remaining elements first
     * - Then copy rotated elements
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N) - Extra array used ❌
     *
     * @param arr Array to rotate
     * @param k Positions to rotate
     */
    public static void rotateWithExtraArrayAlternative(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;

        k = k % n;

        int[] temp = new int[n];

        // Copy remaining elements [k, n-1] to beginning
        for (int i = k; i < n; i++) {
            temp[i - k] = arr[i];
        }

        // Copy first k elements to end
        for (int i = 0; i < k; i++) {
            temp[n - k + i] = arr[i];
        }

        // Copy back
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * APPROACH 4: Optimal - Reverse Algorithm (BEST)
     *
     * How it works:
     * - Reverse first k elements
     * - Reverse remaining elements
     * - Reverse entire array
     *
     * Time Complexity: O(N) - Linear ✓
     * Space Complexity: O(1) - No extra space ✓
     *
     * @param arr Array to rotate
     * @param k Positions to rotate
     */
    public static void rotateReverse(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) return;

        k = k % n;
        if (k == 0) return;

        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
        reverse(arr, 0, n - 1);
    }

    /**
     * Helper: Reverse subarray between indices i and j
     */
    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * Helper: Print array
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    /**
     * Helper: Copy array
     */
    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    /**
     * Comparison of all approaches
     */
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║  Array Rotation - Different Approaches Comparison       ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;

        System.out.println("Original Array: ");
        printArray(original);
        System.out.println("Rotate left by " + k + "\n");

        // APPROACH 1: Brute Force
        System.out.println("─────────────────────────────────────────────────────────");
        System.out.println("APPROACH 1: Brute Force (Rotate one by one)");
        System.out.println("─────────────────────────────────────────────────────────");
        int[] arr1 = copyArray(original);
        System.out.println("Before: ");
        printArray(arr1);

        long start1 = System.nanoTime();
        rotateBruteForce(arr1, k);
        long time1 = System.nanoTime() - start1;

        System.out.println("After: ");
        printArray(arr1);
        System.out.println("Time Complexity: O(N * K) = O(10 * 3) = O(30)");
        System.out.println("Space Complexity: O(1)");
        System.out.println("Execution time: " + time1 + " ns");
        System.out.println("Status: ❌ INEFFICIENT (too slow for large K)\n");

        // APPROACH 2: Extra Array (Method 1)
        System.out.println("─────────────────────────────────────────────────────────");
        System.out.println("APPROACH 2: Using Extra Array (Method 1)");
        System.out.println("─────────────────────────────────────────────────────────");
        int[] arr2 = copyArray(original);
        System.out.println("Before: ");
        printArray(arr2);

        long start2 = System.nanoTime();
        rotateWithExtraArray(arr2, k);
        long time2 = System.nanoTime() - start2;

        System.out.println("After: ");
        printArray(arr2);
        System.out.println("Time Complexity: O(N) = O(10)");
        System.out.println("Space Complexity: O(N) = O(10) ❌");
        System.out.println("Execution time: " + time2 + " ns");
        System.out.println("Status: ⚠️  OK but uses extra space\n");

        // APPROACH 3: Extra Array (Method 2)
        System.out.println("─────────────────────────────────────────────────────────");
        System.out.println("APPROACH 3: Using Extra Array (Method 2)");
        System.out.println("─────────────────────────────────────────────────────────");
        int[] arr3 = copyArray(original);
        System.out.println("Before: ");
        printArray(arr3);

        long start3 = System.nanoTime();
        rotateWithExtraArrayAlternative(arr3, k);
        long time3 = System.nanoTime() - start3;

        System.out.println("After: ");
        printArray(arr3);
        System.out.println("Time Complexity: O(N) = O(10)");
        System.out.println("Space Complexity: O(N) = O(10) ❌");
        System.out.println("Execution time: " + time3 + " ns");
        System.out.println("Status: ⚠️  OK but uses extra space\n");

        // APPROACH 4: Reverse Algorithm (OPTIMAL)
        System.out.println("─────────────────────────────────────────────────────────");
        System.out.println("APPROACH 4: Reverse Algorithm (OPTIMAL) ✓");
        System.out.println("─────────────────────────────────────────────────────────");
        int[] arr4 = copyArray(original);
        System.out.println("Before: ");
        printArray(arr4);

        long start4 = System.nanoTime();
        rotateReverse(arr4, k);
        long time4 = System.nanoTime() - start4;

        System.out.println("After: ");
        printArray(arr4);
        System.out.println("Time Complexity: O(N) = O(10) ✓");
        System.out.println("Space Complexity: O(1) ✓");
        System.out.println("Execution time: " + time4 + " ns");
        System.out.println("Status: ✅ OPTIMAL (best time and space!)\n");

        // Comparison Summary
        System.out.println("═════════════════════════════════════════════════════════");
        System.out.println("COMPARISON SUMMARY");
        System.out.println("═════════════════════════════════════════════════════════");
        System.out.println("Approach                    | Time      | Space   | Speed");
        System.out.println("────────────────────────────┼───────────┼─────────┼─────────");
        System.out.println("1. Brute Force              | O(N*K)    | O(1)    | Slow");
        System.out.println("2. Extra Array (Method 1)   | O(N)      | O(N)    | Fast");
        System.out.println("3. Extra Array (Method 2)   | O(N)      | O(N)    | Fast");
        System.out.println("4. Reverse Algorithm ✓      | O(N)      | O(1)    | Fastest");
        System.out.println("════════════════════════════════════════════════════════\n");

        System.out.println("KEY INSIGHTS:");
        System.out.println("• Approach 1: Too slow when K is large");
        System.out.println("• Approaches 2-3: Use extra space (not interview optimal)");
        System.out.println("• Approach 4: Perfect balance of time and space! 🏆");
        System.out.println("\nWHY REVERSE ALGORITHM WORKS:");
        System.out.println("1. Reversals can be done in-place without extra array");
        System.out.println("2. Mathematical property: (A'B')' = BA");
        System.out.println("3. Three reversals achieve desired rotation");
    }
}


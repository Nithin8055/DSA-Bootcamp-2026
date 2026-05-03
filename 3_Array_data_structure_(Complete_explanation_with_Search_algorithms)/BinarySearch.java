/**
 * BinarySearch.java - Demonstrates Binary Search algorithm
 *
 * What is Binary Search?
 * Binary Search is an optimized search algorithm that works ONLY on SORTED arrays.
 * It eliminates half of the remaining elements with each comparison.
 *
 * Key Requirement:
 * WARNING: ARRAY MUST BE SORTED! (ascending or descending)
 *
 * How it works:
 * 1. Find middle element
 * 2. Compare target with middle:
 *    - If equal: Found! Return index
 *    - If target < middle: Search left half
 *    - If target > middle: Search right half
 * 3. Repeat process on remaining half
 * 4. Continue until found or no elements left
 *
 * Advantages:
 * - Much faster than linear search
 * - O(log n) time complexity
 * - Efficient for large datasets
 *
 * Disadvantages:
 * - Array must be sorted
 * - Slightly more complex to implement
 *
 * Time Complexity:
 * - Best Case: O(1) - Element at middle position
 * - Average Case: O(log n)
 * - Worst Case: O(log n)
 *
 * Space Complexity: O(1) for iterative, O(log n) for recursive (call stack)
 *
 * Comparison with Linear Search:
 * For array size 1,000,000:
 * - Linear Search: Up to 1,000,000 comparisons
 * - Binary Search: Up to 20 comparisons (~50,000x faster!)
 */

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("=== BINARY SEARCH ALGORITHM ===\n");

        // Important: Array MUST be sorted for binary search
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        // Test Case 1: Element exists
        System.out.println("Test Case 1: Element exists in sorted array");
        System.out.println("Sorted Array: " + arrayToString(sortedArr));
        int target1 = 9;
        int result1 = binarySearch(sortedArr, target1);
        System.out.println("Search for: " + target1);
        System.out.println("Result: " + (result1 != -1 ? "Found at index " + result1 : "Not found"));
        System.out.println();

        // Test Case 2: Element at middle (Best case)
        System.out.println("Test Case 2: Element at middle position (Best Case - O(1))");
        int target2 = 11;
        System.out.println("Search for: " + target2);
        int result2 = binarySearch(sortedArr, target2);
        System.out.println("Result: " + (result2 != -1 ? "Found at index " + result2 : "Not found"));
        System.out.println();

        // Test Case 3: Element at beginning
        System.out.println("Test Case 3: Element at beginning");
        int target3 = 1;
        int result3 = binarySearch(sortedArr, target3);
        System.out.println("Search for: " + target3);
        System.out.println("Result: " + (result3 != -1 ? "Found at index " + result3 : "Not found"));
        System.out.println();

        // Test Case 4: Element at end
        System.out.println("Test Case 4: Element at end");
        int target4 = 19;
        int result4 = binarySearch(sortedArr, target4);
        System.out.println("Search for: " + target4);
        System.out.println("Result: " + (result4 != -1 ? "Found at index " + result4 : "Not found"));
        System.out.println();

        // Test Case 5: Element not found
        System.out.println("Test Case 5: Element not found");
        int target5 = 10;
        int result5 = binarySearch(sortedArr, target5);
        System.out.println("Search for: " + target5);
        System.out.println("Result: " + (result5 != -1 ? "Found at index " + result5 : "Not found (-1)"));
        System.out.println();

        // Detailed step-by-step execution
        System.out.println("Detailed Step-by-Step Execution:");
        System.out.println("Sorted Array: " + arrayToString(sortedArr));
        binarySearchDetailed(sortedArr, 7);
        System.out.println();

        // Test Case 6: Recursive binary search
        System.out.println("Test Case 6: Recursive Binary Search");
        int target6 = 13;
        int result6 = binarySearchRecursive(sortedArr, 0, sortedArr.length - 1, target6);
        System.out.println("Search for: " + target6);
        System.out.println("Result (Recursive): " + (result6 != -1 ? "Found at index " + result6 : "Not found"));
        System.out.println();

        // Comparison: Linear vs Binary Search
        System.out.println("Efficiency Comparison:");
        comparisonDemo();
    }

    /**
     * Binary Search - Iterative Implementation
     *
     * @param arr SORTED array to search (must be sorted!)
     * @param target Element to find
     * @return Index of target if found, -1 otherwise
     *
     * Algorithm:
     * 1. Initialize left = 0, right = arr.length - 1
     * 2. While left <= right:
     *    - Calculate mid = (left + right) / 2
     *    - If arr[mid] == target: return mid
     *    - If arr[mid] < target: left = mid + 1 (search right half)
     *    - If arr[mid] > target: right = mid - 1 (search left half)
     * 3. If loop exits: element not found, return -1
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // Continue while search space is valid
        while (left <= right) {
            // Calculate middle index (prevents overflow)
            int mid = left + (right - left) / 2;
            int midValue = arr[mid];

            // Check if target found
            if (midValue == target) {
                return mid;  // Found!
            }
            // If target is smaller, search left half
            else if (midValue > target) {
                right = mid - 1;
            }
            // If target is larger, search right half
            else {
                left = mid + 1;
            }
        }

        return -1;  // Not found
    }

    /**
     * Binary Search - Recursive Implementation
     *
     * @param arr SORTED array to search
     * @param left Left boundary index
     * @param right Right boundary index
     * @param target Element to find
     * @return Index of target if found, -1 otherwise
     */
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        // Base case: search space exhausted
        if (left > right) {
            return -1;
        }

        // Calculate middle
        int mid = left + (right - left) / 2;
        int midValue = arr[mid];

        // Check if found
        if (midValue == target) {
            return mid;
        }
        // Search left half
        else if (midValue > target) {
            return binarySearchRecursive(arr, left, mid - 1, target);
        }
        // Search right half
        else {
            return binarySearchRecursive(arr, mid + 1, right, target);
        }
    }

    /**
     * Binary Search with detailed step-by-step output
     */
    public static void binarySearchDetailed(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int step = 1;

        System.out.println("Searching for: " + target);
        System.out.println("\nStep-by-step execution:\n");

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = arr[mid];

            System.out.println("Step " + step + ":");
            System.out.println("  left = " + left + ", right = " + right);
            System.out.println("  mid = (" + left + " + " + right + ") / 2 = " + mid);
            System.out.println("  arr[" + mid + "] = " + midValue);

            if (midValue == target) {
                System.out.println("  ✓ MATCH FOUND!");
                System.out.println("\nTotal steps: " + step);
                return;
            } else if (midValue > target) {
                System.out.println("  " + midValue + " > " + target + " → Search LEFT half");
                right = mid - 1;
            } else {
                System.out.println("  " + midValue + " < " + target + " → Search RIGHT half");
                left = mid + 1;
            }

            System.out.println();
            step++;
        }

        System.out.println("Element not found after " + (step - 1) + " steps");
    }

    /**
     * Find first occurrence of target in sorted array
     * Useful when array has duplicates
     */
    public static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;  // Continue searching in left half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
     * Find last occurrence of target in sorted array
     */
    public static int findLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;  // Continue searching in right half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
     * Demonstrates comparison between Linear and Binary Search efficiency
     */
    public static void comparisonDemo() {
        System.out.println("\nLinear Search vs Binary Search");
        System.out.println("===============================\n");

        int[] sizes = {10, 100, 1000, 10000, 100000, 1000000};

        System.out.println("Array Size | Linear Search | Binary Search | Speedup");
        System.out.println("-----------|---------------|---------------|----------");

        for (int size : sizes) {
            // Worst case: element not found
            int linearOps = size;  // Check every element
            int binaryOps = (int) (Math.log(size) / Math.log(2)) + 1;  // log₂(n)
            double speedup = (double) linearOps / binaryOps;

            System.out.printf("%,10d | %,13d | %,13d | %7.1fx\n",
                size, linearOps, binaryOps, speedup);
        }

        System.out.println("\nConclusion: Binary Search is exponentially faster!");
    }

    // Utility method
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}


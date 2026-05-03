/**
 * Search in Rotated Array - Step-by-Step Walkthroughs
 *
 * This file provides detailed execution traces of the algorithm
 * showing exactly what happens at each step with visual representation.
 */

public class SearchInRotatedArrayWalkthrough {

    /**
     * Step-by-step visualization of the search process
     */
    public static int searchWithTrace(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        System.out.println("\n=== SEARCH TRACE ===");
        System.out.print("Array: ");
        printArray(arr);
        System.out.println("Target Key: " + key);
        System.out.println();

        // Step 1: Find the rotation point
        System.out.println("STEP 1: Finding Rotation Point");
        System.out.println("-------");
        int pivot = findRotationPointWithTrace(arr);
        System.out.println("Pivot Index: " + pivot);
        System.out.println("First sorted part: [" + 0 + " to " + (pivot - 1) + "]");
        System.out.println("Second sorted part: [" + pivot + " to " + (arr.length - 1) + "]");
        System.out.println();

        // Step 2: Search in first part
        System.out.println("STEP 2: Searching in First Sorted Part");
        System.out.println("-------");
        System.out.println("Searching in range [0 to " + (pivot - 1) + "]");
        int result = binarySearchWithTrace(arr, 0, pivot - 1, key);
        if (result != -1) {
            System.out.println("✓ Found at index: " + result);
            return result;
        }
        System.out.println("✗ Not found in first part");
        System.out.println();

        // Step 3: Search in second part
        System.out.println("STEP 3: Searching in Second Sorted Part");
        System.out.println("-------");
        System.out.println("Searching in range [" + pivot + " to " + (arr.length - 1) + "]");
        result = binarySearchWithTrace(arr, pivot, arr.length - 1, key);
        if (result != -1) {
            System.out.println("✓ Found at index: " + result);
            return result;
        }
        System.out.println("✗ Not found in second part");
        System.out.println();

        System.out.println("Element not found in array");
        return -1;
    }

    /**
     * Finding rotation point with detailed trace
     */
    private static int findRotationPointWithTrace(int[] arr) {
        int left = 0, right = arr.length - 1;
        int iteration = 0;

        // Check if array is not rotated
        if (arr[left] < arr[right]) {
            System.out.println("Array is not rotated (already sorted)");
            return 0;
        }

        while (left < right) {
            iteration++;
            int mid = left + (right - left) / 2;

            System.out.println("Iteration " + iteration + ":");
            System.out.println("  left=" + left + "(arr[" + left + "]=" + arr[left] + "), " +
                             "mid=" + mid + "(arr[" + mid + "]=" + arr[mid] + "), " +
                             "right=" + right + "(arr[" + right + "]=" + arr[right] + ")");

            // Check if mid is the rotation point
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                System.out.println("  → Found: arr[" + mid + "]=" + arr[mid] +
                                 " > arr[" + (mid + 1) + "]=" + arr[mid + 1]);
                System.out.println("  → Rotation point at index " + (mid + 1));
                return mid + 1;
            }

            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                System.out.println("  → Found: arr[" + mid + "]=" + arr[mid] +
                                 " < arr[" + (mid - 1) + "]=" + arr[mid - 1]);
                System.out.println("  → Rotation point at index " + mid);
                return mid;
            }

            // Decide which half to search
            if (arr[mid] >= arr[left]) {
                System.out.println("  → Left half is sorted, search right");
                left = mid + 1;
            } else {
                System.out.println("  → Right half is sorted, search left");
                right = mid - 1;
            }
            System.out.println();
        }

        System.out.println("Final pivot at index: " + left);
        return left;
    }

    /**
     * Binary search with detailed trace
     */
    private static int binarySearchWithTrace(int[] arr, int left, int right, int target) {
        int iteration = 0;

        while (left <= right) {
            iteration++;
            int mid = left + (right - left) / 2;

            System.out.println("  Iteration " + iteration + ":");
            System.out.println("    left=" + left + ", mid=" + mid + ", right=" + right);
            System.out.println("    Values: arr[" + left + "]=" + arr[left] + ", " +
                             "arr[" + mid + "]=" + arr[mid] + ", " +
                             "arr[" + right + "]=" + arr[right]);

            if (arr[mid] == target) {
                System.out.println("    ✓ FOUND: arr[" + mid + "] = " + arr[mid]);
                return mid;
            } else if (arr[mid] < target) {
                System.out.println("    → Target is larger, search right half");
                left = mid + 1;
            } else {
                System.out.println("    → Target is smaller, search left half");
                right = mid - 1;
            }
            System.out.println();
        }

        return -1;
    }

    /**
     * Utility: Print array
     */
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    /**
     * Detailed Explanation: Understanding the Algorithm
     */
    public static void explainAlgorithm() {
        String separator = new String(new char[60]).replace('\0', '=');
        System.out.println("\n" + separator);
        System.out.println("UNDERSTANDING SEARCH IN ROTATED SORTED ARRAY");
        System.out.println(separator);

        System.out.println("\n1. THE PROBLEM:");
        System.out.println("   - Given a sorted array that has been rotated");
        System.out.println("   - Need to find an element efficiently");
        System.out.println("   - Cannot use simple binary search directly");

        System.out.println("\n2. KEY INSIGHT:");
        System.out.println("   - Even in a rotated array, at least ONE half is always sorted");
        System.out.println("   - We can use this to guide our search");

        System.out.println("\n3. EXAMPLE:");
        System.out.println("   Original:  [1, 2, 3, 4, 5, 6, 7]");
        System.out.println("   Rotated:   [5, 6, 7, 1, 2, 3, 4]");
        System.out.println("              └─ sorted ─┘ └─ sorted ─┘");

        System.out.println("\n4. TWO-PART APPROACH:");
        System.out.println("   Part A: Find where the rotation happened (pivot)");
        System.out.println("   Part B: Apply binary search on appropriate half");

        System.out.println("\n5. WHY BINARY SEARCH?");
        System.out.println("   - Linear search: O(n) - check every element");
        System.out.println("   - Binary search: O(log n) - eliminate half elements each time");
        System.out.println("   - Example with 1000 elements:");
        System.out.println("     * Linear: ~500 checks on average");
        System.out.println("     * Binary: ~10 checks on average");

        System.out.println("\n6. FINDING THE PIVOT:");
        System.out.println("   The pivot is where the sorted order breaks.");
        System.out.println("   Algorithm:");
        System.out.println("   - Start with full array [left...right]");
        System.out.println("   - Calculate mid point");
        System.out.println("   - If arr[mid] > arr[mid+1], pivot is at mid+1");
        System.out.println("   - If arr[mid] < arr[mid-1], pivot is at mid");
        System.out.println("   - Otherwise, determine which half has the pivot");

        System.out.println("\n7. DECIDING WHICH HALF:");
        System.out.println("   Use this comparison: if (arr[mid] >= arr[left])");
        System.out.println("   - TRUE:  Left half is sorted → pivot is in right half");
        System.out.println("   - FALSE: Right half is sorted → pivot is in left half");

        System.out.println("\n8. TIME COMPLEXITY:");
        System.out.println("   - Finding pivot: O(log n)");
        System.out.println("   - Binary search: O(log n)");
        System.out.println("   - Total: O(log n)");
        System.out.println("   - Much better than O(n) linear search!");

        System.out.println("\n9. SPACE COMPLEXITY:");
        System.out.println("   - O(1) - only using a few variables");
        System.out.println("   - No extra data structures needed");
        System.out.println("   - Iterative approach (no recursion stack)");

        System.out.println("\n10. COMMON MISTAKES:");
        System.out.println("    - Forgetting to check for non-rotated arrays");
        System.out.println("    - Off-by-one errors in pivot boundaries");
        System.out.println("    - Not checking both halves properly");
        System.out.println("    - Using wrong comparison operators");

        System.out.println("\n" + separator + "\n");
    }

    /**
     * Main: Run all walkthroughs
     */
    public static void main(String[] args) {
        // Print explanation
        explainAlgorithm();

        // Walkthrough 1: Element found in first half
        System.out.println("\n--- WALKTHROUGH 1: Element in First Half ---");
        int[] arr1 = {9, 10, 12, 5, 6, 7, 8};
        searchWithTrace(arr1, 10);

        // Walkthrough 2: Element found in second half
        System.out.println("\n--- WALKTHROUGH 2: Element in Second Half ---");
        int[] arr2 = {9, 10, 12, 5, 6, 7, 8};
        searchWithTrace(arr2, 6);

        // Walkthrough 3: Element not found
        System.out.println("\n--- WALKTHROUGH 3: Element Not Found ---");
        int[] arr3 = {9, 10, 12, 5, 6, 7, 8};
        searchWithTrace(arr3, 99);

        // Walkthrough 4: No rotation
        System.out.println("\n--- WALKTHROUGH 4: Array Not Rotated ---");
        int[] arr4 = {5, 6, 7, 8, 9, 10, 12};
        searchWithTrace(arr4, 7);

        // Walkthrough 5: Single element
        System.out.println("\n--- WALKTHROUGH 5: Single Element ---");
        int[] arr5 = {42};
        searchWithTrace(arr5, 42);
    }
}




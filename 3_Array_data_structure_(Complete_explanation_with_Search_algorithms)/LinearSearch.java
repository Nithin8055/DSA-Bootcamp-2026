/**
 * LinearSearch.java - Demonstrates Linear Search algorithm
 *
 * What is Linear Search?
 * Linear Search checks each element sequentially from start to end until:
 * - The target element is found (return index)
 * - The entire array is traversed (return -1)
 *
 * Advantages:
 * - Works on both sorted and unsorted arrays
 * - Simple to understand and implement
 * - No preprocessing required
 *
 * Disadvantages:
 * - Slow for large arrays
 * - O(n) time complexity
 *
 * Time Complexity:
 * - Best Case: O(1) - Element at first position
 * - Average Case: O(n) - Element at middle
 * - Worst Case: O(n) - Element at last or not found
 *
 * Space Complexity: O(1) - Constant extra space
 */

public class LinearSearch {

    public static void main(String[] args) {
        System.out.println("=== LINEAR SEARCH ALGORITHM ===\n");

        // Test Case 1: Element exists in array
        System.out.println("Test Case 1: Element exists in array");
        int[] arr1 = {5, 2, 8, 1, 9, 3, 7};
        int target1 = 9;
        int result1 = linearSearch(arr1, target1);
        System.out.println("Array: " + arrayToString(arr1));
        System.out.println("Search for: " + target1);
        System.out.println("Result: " + (result1 != -1 ? "Found at index " + result1 : "Not found"));
        System.out.println();

        // Test Case 2: Element at first position (Best case)
        System.out.println("Test Case 2: Element at first position (Best Case - O(1))");
        int[] arr2 = {10, 20, 30, 40, 50};
        int target2 = 10;
        int result2 = linearSearch(arr2, target2);
        System.out.println("Array: " + arrayToString(arr2));
        System.out.println("Search for: " + target2);
        System.out.println("Result: Found at index " + result2);
        System.out.println();

        // Test Case 3: Element at last position (Worst case)
        System.out.println("Test Case 3: Element at last position (Worst Case - O(n))");
        int[] arr3 = {10, 20, 30, 40, 50};
        int target3 = 50;
        int result3 = linearSearch(arr3, target3);
        System.out.println("Array: " + arrayToString(arr3));
        System.out.println("Search for: " + target3);
        System.out.println("Result: Found at index " + result3);
        System.out.println();

        // Test Case 4: Element not found
        System.out.println("Test Case 4: Element not found");
        int[] arr4 = {1, 2, 3, 4, 5};
        int target4 = 100;
        int result4 = linearSearch(arr4, target4);
        System.out.println("Array: " + arrayToString(arr4));
        System.out.println("Search for: " + target4);
        System.out.println("Result: " + (result4 != -1 ? "Found at index " + result4 : "Not found (-1)"));
        System.out.println();

        // Test Case 5: Multiple occurrences (finds first)
        System.out.println("Test Case 5: Multiple occurrences (returns first)");
        int[] arr5 = {5, 2, 5, 4, 5, 3};
        int target5 = 5;
        int result5 = linearSearch(arr5, target5);
        System.out.println("Array: " + arrayToString(arr5));
        System.out.println("Search for: " + target5);
        System.out.println("Result: Found at index " + result5 + " (first occurrence)");
        System.out.println();

        // Demonstration: Detailed step-by-step execution
        System.out.println("Detailed Step-by-Step Execution:");
        linearSearchDetailed(arr1, target1);
    }

    /**
     * Linear Search - Simple Implementation
     *
     * @param arr The array to search
     * @param target The element to find
     * @return Index of target if found, -1 otherwise
     *
     * Algorithm:
     * 1. Start from index 0
     * 2. Compare each element with target
     * 3. If match found, return index immediately
     * 4. If array ends without finding, return -1
     */
    public static int linearSearch(int[] arr, int target) {
        // Time Complexity: O(n)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  // Found! Return index
            }
        }
        return -1;  // Not found
    }

    /**
     * Detailed Linear Search with step-by-step output
     * Shows every comparison made
     */
    public static void linearSearchDetailed(int[] arr, int target) {
        System.out.println("Array: " + arrayToString(arr));
        System.out.println("Searching for: " + target);
        System.out.println("\nStep-by-step comparison:");

        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            System.out.print("Step " + comparisons + ": Check arr[" + i + "] = " + arr[i]);

            if (arr[i] == target) {
                System.out.println(" ✓ Match found!");
                System.out.println("Total comparisons: " + comparisons);
                return;
            } else {
                System.out.println(" ✗ No match, continue");
            }
        }

        System.out.println("\nElement not found after " + comparisons + " comparisons");
    }

    /**
     * Find all occurrences of target element
     * @param arr The array to search
     * @param target The element to find
     * @return Array of all indices where target is found
     */
    public static int[] findAllOccurrences(int[] arr, int target) {
        // First count occurrences
        int count = 0;
        for (int value : arr) {
            if (value == target) {
                count++;
            }
        }

        // Create result array
        int[] result = new int[count];

        // Fill result array with indices
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                result[index++] = i;
            }
        }

        return result;
    }

    /**
     * Find last occurrence of target element
     * @param arr The array to search
     * @param target The element to find
     * @return Index of last occurrence, -1 if not found
     */
    public static int findLastOccurrence(int[] arr, int target) {
        // Search from end to beginning
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find element with maximum value
     */
    public static int findMax(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Find element with minimum value
     */
    public static int findMin(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Utility method to convert array to string
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


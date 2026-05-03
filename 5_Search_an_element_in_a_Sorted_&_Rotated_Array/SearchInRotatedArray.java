/**
 * Search in Sorted and Rotated Array - Complete Solution with Multiple Approaches
 *
 * Problem: Given a sorted and rotated array, find the index of a given element
 *
 * Example:
 * Original: [5, 6, 7, 8, 9, 10, 12]
 * Rotated:  [9, 10, 12, 5, 6, 7, 8]
 * Search for: 10 -> Output: 1
 */

public class SearchInRotatedArray {

    /**
     * Approach 1: Using Two Binary Searches (Optimal)
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * Strategy:
     * 1. First, find the rotation point (pivot)
     * 2. Then, apply binary search on the appropriate half
     */
    public static int searchOptimal(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Find the rotation point
        int pivot = findRotationPoint(arr);

        // Search in the first sorted part [0 to pivot-1]
        int result = binarySearch(arr, 0, pivot - 1, key);
        if (result != -1) {
            return result;
        }

        // If not found in first part, search in second part [pivot to end]
        return binarySearch(arr, pivot, arr.length - 1, key);
    }

    /**
     * Helper Method: Find the rotation point (pivot)
     *
     * The rotation point is where the sorted order breaks.
     * In [9, 10, 12, 5, 6, 7, 8], the pivot is at index 3 (element 5)
     *
     * Time Complexity: O(log n)
     */
    private static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        // Special case: array is not rotated
        if (arr[left] < arr[right]) {
            return 0;  // Entire array is sorted
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the rotation point
            // If element at mid is greater than element at mid+1
            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return mid + 1;  // Rotation point found
            }

            // If element at mid-1 is greater than element at mid
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid;  // Rotation point found
            }

            // Decide which half to search
            if (arr[mid] >= arr[left]) {
                // Left half is sorted, rotation is in right half
                left = mid + 1;
            } else {
                // Right half is sorted, rotation is in left half
                right = mid - 1;
            }
        }

        return left;
    }

    /**
     * Helper Method: Standard Binary Search
     *
     * Performs binary search in a sorted array
     *
     * Time Complexity: O(log n)
     */
    private static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;  // Found the element
            } else if (arr[mid] < target) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Target is in the left half
                right = mid - 1;
            }
        }

        return -1;  // Element not found
    }

    /**
     * Approach 2: Single Binary Search (Alternative Approach)
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * Strategy:
     * Instead of finding pivot first, determine which half is sorted
     * and check if target is in that half directly.
     */
    public static int searchSinglePass(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Found the element
            if (arr[mid] == key) {
                return mid;
            }

            // Determine which half is sorted
            if (arr[mid] >= arr[left]) {
                // Left half is sorted [left...mid]

                // Check if key is in the sorted left half
                if (key >= arr[left] && key < arr[mid]) {
                    // Key is in left half
                    right = mid - 1;
                } else {
                    // Key is in right half
                    left = mid + 1;
                }
            } else {
                // Right half is sorted [mid...right]

                // Check if key is in the sorted right half
                if (key > arr[mid] && key <= arr[right]) {
                    // Key is in right half
                    left = mid + 1;
                } else {
                    // Key is in left half
                    right = mid - 1;
                }
            }
        }

        return -1;  // Element not found
    }

    /**
     * Approach 3: Linear Search (Brute Force)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Simple but inefficient approach - useful for understanding the problem
     */
    public static int searchLinear(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;  // Element not found
    }

    /**
     * Utility Method: Print array
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
     * Main Method: Test all approaches with various test cases
     */
    public static void main(String[] args) {
        System.out.println("========== SEARCH IN SORTED AND ROTATED ARRAY ==========\n");

        // Test Case 1: Basic example
        System.out.println("--- Test Case 1: Basic Example ---");
        int[] arr1 = {9, 10, 12, 5, 6, 7, 8};
        int key1 = 10;
        System.out.print("Array: ");
        printArray(arr1);
        System.out.println("Search for: " + key1);
        System.out.println("Optimal Approach Result: " + searchOptimal(arr1, key1));
        System.out.println("Single Pass Result: " + searchSinglePass(arr1, key1));
        System.out.println("Linear Search Result: " + searchLinear(arr1, key1));
        System.out.println();

        // Test Case 2: Element in second half
        System.out.println("--- Test Case 2: Element in Second Half ---");
        int[] arr2 = {9, 10, 12, 5, 6, 7, 8};
        int key2 = 6;
        System.out.print("Array: ");
        printArray(arr2);
        System.out.println("Search for: " + key2);
        System.out.println("Optimal Approach Result: " + searchOptimal(arr2, key2));
        System.out.println("Single Pass Result: " + searchSinglePass(arr2, key2));
        System.out.println("Linear Search Result: " + searchLinear(arr2, key2));
        System.out.println();

        // Test Case 3: Element not found
        System.out.println("--- Test Case 3: Element Not Found ---");
        int[] arr3 = {9, 10, 12, 5, 6, 7, 8};
        int key3 = 15;
        System.out.print("Array: ");
        printArray(arr3);
        System.out.println("Search for: " + key3);
        System.out.println("Optimal Approach Result: " + searchOptimal(arr3, key3));
        System.out.println("Single Pass Result: " + searchSinglePass(arr3, key3));
        System.out.println("Linear Search Result: " + searchLinear(arr3, key3));
        System.out.println();

        // Test Case 4: No rotation (already sorted)
        System.out.println("--- Test Case 4: No Rotation (Already Sorted) ---");
        int[] arr4 = {5, 6, 7, 8, 9, 10, 12};
        int key4 = 8;
        System.out.print("Array: ");
        printArray(arr4);
        System.out.println("Search for: " + key4);
        System.out.println("Optimal Approach Result: " + searchOptimal(arr4, key4));
        System.out.println("Single Pass Result: " + searchSinglePass(arr4, key4));
        System.out.println("Linear Search Result: " + searchLinear(arr4, key4));
        System.out.println();

        // Test Case 5: Element at the beginning
        System.out.println("--- Test Case 5: Element at Beginning ---");
        int[] arr5 = {9, 10, 12, 5, 6, 7, 8};
        int key5 = 9;
        System.out.print("Array: ");
        printArray(arr5);
        System.out.println("Search for: " + key5);
        System.out.println("Optimal Approach Result: " + searchOptimal(arr5, key5));
        System.out.println("Single Pass Result: " + searchSinglePass(arr5, key5));
        System.out.println("Linear Search Result: " + searchLinear(arr5, key5));
        System.out.println();

        // Test Case 6: Element at the end
        System.out.println("--- Test Case 6: Element at End ---");
        int[] arr6 = {9, 10, 12, 5, 6, 7, 8};
        int key6 = 8;
        System.out.print("Array: ");
        printArray(arr6);
        System.out.println("Search for: " + key6);
        System.out.println("Optimal Approach Result: " + searchOptimal(arr6, key6));
        System.out.println("Single Pass Result: " + searchSinglePass(arr6, key6));
        System.out.println("Linear Search Result: " + searchLinear(arr6, key6));
        System.out.println();

        // Test Case 7: Single element
        System.out.println("--- Test Case 7: Single Element Array ---");
        int[] arr7 = {5};
        int key7 = 5;
        System.out.print("Array: ");
        printArray(arr7);
        System.out.println("Search for: " + key7);
        System.out.println("Optimal Approach Result: " + searchOptimal(arr7, key7));
        System.out.println("Single Pass Result: " + searchSinglePass(arr7, key7));
        System.out.println("Linear Search Result: " + searchLinear(arr7, key7));
        System.out.println();

        // Test Case 8: Two elements
        System.out.println("--- Test Case 8: Two Elements Array ---");
        int[] arr8 = {3, 1};
        int key8 = 3;
        System.out.print("Array: ");
        printArray(arr8);
        System.out.println("Search for: " + key8);
        System.out.println("Optimal Approach Result: " + searchOptimal(arr8, key8));
        System.out.println("Single Pass Result: " + searchSinglePass(arr8, key8));
        System.out.println("Linear Search Result: " + searchLinear(arr8, key8));
        System.out.println();
    }
}


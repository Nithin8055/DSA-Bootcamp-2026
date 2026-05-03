/**
 * Search in Rotated Array - Advanced Variations and Related Problems
 *
 * This file covers:
 * 1. Finding the minimum element in a rotated sorted array
 * 2. Counting the number of rotations
 * 3. Handling duplicates in rotated array
 * 4. Finding all occurrences
 */

public class RotatedArrayAdvanced {

    /**
     * Problem 1: Find Minimum Element in Rotated Sorted Array
     *
     * The minimum element is always at the rotation point.
     * Strategy: Use binary search to find the smallest element
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int left = 0, right = arr.length - 1;

        // If array is not rotated
        if (arr[left] <= arr[right]) {
            return arr[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the minimum
            // (smaller than both neighbors)
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }

            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }

            // Decide which half to search
            // The minimum is on the side that is NOT sorted
            if (arr[mid] > arr[right]) {
                // Right half is not sorted
                left = mid + 1;
            } else {
                // Left half is not sorted
                right = mid;
            }
        }

        return arr[left];
    }

    /**
     * Problem 2: Count Number of Rotations
     *
     * How many times was the array rotated?
     * Formula: Count of rotations = n - (index of minimum element)
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int countRotations(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int left = 0, right = arr.length - 1;
        int n = arr.length;

        // If array is not rotated
        if (arr[left] < arr[right]) {
            return 0;
        }

        // Find the minimum element's index
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If arr[mid] > arr[right], minimum is on right
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Minimum is on left or at mid
                right = mid;
            }
        }

        // left is now at the minimum position
        // Number of rotations = n - (index of minimum)
        // This tells us how many elements from the end moved to the beginning
        return (n - left) % n;
    }

    /**
     * Problem 3: Search in Rotated Array with Duplicates
     *
     * Difficulty: When arr[left] == arr[mid] == arr[right],
     * we cannot determine which half is sorted.
     * Solution: Shrink the search space from both ends
     *
     * Time Complexity: O(log n) average, O(n) worst case (with many duplicates)
     * Space Complexity: O(1)
     */
    public static int searchWithDuplicates(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            // Handle duplicates: shrink the search space
            // when endpoints and mid all have same value
            if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
                left++;
                right--;
            } else if (arr[mid] >= arr[left]) {
                // Left half is sorted
                if (key >= arr[left] && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (key > arr[mid] && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * Problem 4: Find All Occurrences of an Element
     *
     * Find the first and last occurrence of the element,
     * then all elements between them are duplicates.
     *
     * Time Complexity: O(log n + k) where k is the count of occurrences
     * Space Complexity: O(1)
     */
    public static int[] findAllOccurrences(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int first = findFirst(arr, key);
        if (first == -1) {
            return new int[0];  // Element not found
        }

        int last = findLast(arr, key);

        // Create result array with all indices
        int[] result = new int[last - first + 1];
        int index = 0;
        for (int i = first; i <= last; i++) {
            result[index++] = i;
        }

        return result;
    }

    /**
     * Helper: Find the first occurrence of key
     */
    private static int findFirst(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                result = mid;
                right = mid - 1;  // Continue searching in left half
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
     * Helper: Find the last occurrence of key
     */
    private static int findLast(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key) {
                result = mid;
                left = mid + 1;  // Continue searching in right half
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    /**
     * Problem 5: Reverse an array and then search
     *
     * Visualization of how rotation works:
     * Original: [1, 2, 3, 4, 5]
     * After 2 rotations: [4, 5, 1, 2, 3]
     *
     * We can reverse to understand: [3, 2, 1, 5, 4]
     */
    public static int[] rotateArray(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        k = k % arr.length;  // Handle k > n

        int[] rotated = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rotated[(i + k) % arr.length] = arr[i];
        }

        return rotated;
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
     * Main method: Test all advanced variations
     */
    public static void main(String[] args) {
        System.out.println("========== ADVANCED ROTATED ARRAY PROBLEMS ==========\n");

        // Problem 1: Find Minimum
        System.out.println("--- Problem 1: Find Minimum Element ---");
        int[] arr1 = {9, 10, 12, 5, 6, 7, 8};
        System.out.print("Array: ");
        printArray(arr1);
        System.out.println("Minimum Element: " + findMin(arr1));
        System.out.println();

        // Problem 2: Count Rotations
        System.out.println("--- Problem 2: Count Number of Rotations ---");
        int[] arr2 = {9, 10, 12, 5, 6, 7, 8};
        System.out.print("Array: ");
        printArray(arr2);
        System.out.println("Original Sorted Array: [5, 6, 7, 8, 9, 10, 12]");
        System.out.println("Number of Rotations: " + countRotations(arr2));
        System.out.println();

        // Problem 3: Search with Duplicates
        System.out.println("--- Problem 3: Search in Array with Duplicates ---");
        int[] arr3 = {5, 7, 7, 7, 7, 7, 7, 7, 9, 10, 12};
        System.out.print("Array: ");
        printArray(arr3);
        System.out.println("Search for 7: " + searchWithDuplicates(arr3, 7));
        System.out.println("Search for 5: " + searchWithDuplicates(arr3, 5));
        System.out.println("Search for 12: " + searchWithDuplicates(arr3, 12));
        System.out.println("Search for 15: " + searchWithDuplicates(arr3, 15));
        System.out.println();

        // Problem 4: Find All Occurrences
        System.out.println("--- Problem 4: Find All Occurrences ---");
        int[] arr4 = {5, 5, 5, 5, 6, 7, 8};
        System.out.print("Array: ");
        printArray(arr4);
        System.out.println("Search for 5:");
        int[] occurrences = findAllOccurrences(arr4, 5);
        System.out.print("Indices found: ");
        printArray(occurrences);
        System.out.println();

        // Problem 5: Understanding Rotation
        System.out.println("--- Problem 5: Array Rotation Visualization ---");
        int[] original = {1, 2, 3, 4, 5};
        System.out.print("Original Array: ");
        printArray(original);

        int[] rotated2 = rotateArray(original, 2);
        System.out.print("After 2 Rotations: ");
        printArray(rotated2);

        int[] rotated4 = rotateArray(original, 4);
        System.out.print("After 4 Rotations: ");
        printArray(rotated4);
        System.out.println();

        // Edge Case: Empty and Single Element
        System.out.println("--- Edge Cases ---");
        int[] singleElement = {42};
        System.out.print("Single Element Array: ");
        printArray(singleElement);
        System.out.println("Minimum: " + findMin(singleElement));
        System.out.println("Rotations: " + countRotations(singleElement));
    }
}

